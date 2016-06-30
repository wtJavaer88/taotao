package com.taotao.manage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.service.ApiService;
import com.taotao.manage.mapper.ItemMapper;
import com.taotao.manage.pojo.Item;
import com.taotao.manage.pojo.ItemDesc;
import com.taotao.manage.pojo.ItemParamItem;

@Service
public class ItemService extends BaseService<Item> {

	@Autowired
	private ItemDescService itemDescService;

	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private ItemParamItemService itemParamItemService;
	@Value("${TAOTAO_WEB_URL}")
	private String TAOTAO_WEB_URL;
	@Autowired
	private ApiService apiService;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	private final ObjectMapper MAPPER = new ObjectMapper();

	public void saveItem(Item item, String desc, String itemParams) {
		// 设置初始数据
		item.setStatus(1);

		item.setId(null);// 强制设置id为null

		super.save(item);

		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setItemId(item.getId());
		itemDesc.setItemDesc(desc);
		// 保存描述数据
		this.itemDescService.save(itemDesc);

		// 保存规格参数数据
		ItemParamItem itemParamItem = new ItemParamItem();
		itemParamItem.setItemId(item.getId());
		itemParamItem.setParamData(itemParams);
		this.itemParamItemService.save(itemParamItem);

		sendMsg(item.getId(), "insert");
	}

	public PageInfo<Item> queryPageList(Integer page, Integer rows) {
		Example example = new Example(Item.class);
		example.setOrderByClause("updated DESC");
		example.createCriteria().andNotEqualTo("status", 3);
		// 设置分页参数
		PageHelper.startPage(page, rows);

		List<Item> list = this.itemMapper.selectByExample(example);
		return new PageInfo<Item>(list);
	}

	public void updateItem(Item item, String desc, String itemParams) {
		// 强制设置不能修改的字段为null
		item.setStatus(null);
		item.setCreated(null);
		super.updateSelective(item);

		// 修改商品描述数据
		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setItemId(item.getId());
		itemDesc.setItemDesc(desc);
		this.itemDescService.updateSelective(itemDesc);

		// 修改商品规格参数数据
		this.itemParamItemService.updateItemParamItem(item.getId(), itemParams);
		// try {
		// // 通知其它系统，该商品已经更新
		// String url = TAOTAO_WEB_URL + "/item/cache/" + item.getId() +
		// ".html";
		// this.apiService.doPost(url, null);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		sendMsg(item.getId(), "update");

	}

	private void sendMsg(Long id, String type) {
		try {
			Map<String, Object> msg = new HashMap<>();
			msg.put("itemId", id);
			msg.put("type", type);
			msg.put("date", System.currentTimeMillis());
			rabbitTemplate.convertAndSend("item." + type, MAPPER.writeValueAsString(msg));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 批量逻辑删除
	 * 
	 * @param clazz
	 * @param property
	 * @param values
	 * @return
	 */
	public Integer updateByIds(List<Object> values) {
		Example example = new Example(Item.class);
		example.createCriteria().andIn("id", values);
		Item item = new Item();
		item.setStatus(3);
		return itemMapper.updateByExampleSelective(item, example);
	}
}
