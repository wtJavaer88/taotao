package com.taotao.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taotao.common.bean.ItemCatResult;
import com.taotao.manage.pojo.ItemCat;
import com.taotao.manage.service.ItemCatService;

@RequestMapping("item/cat")
@Controller
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;

	// private static final ObjectMapper MAPPER = new ObjectMapper();

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ItemCat>> queryItemCatListByParentId(
			@RequestParam(value = "id", defaultValue = "0") Long parentId) {
		try {
			// List<ItemCat> list =
			// this.itemCatService.queryItemCatListByParentId(parentId);
			ItemCat record = new ItemCat();
			record.setParentId(parentId);
			List<ItemCat> list = this.itemCatService.queryListByWhere(record);
			if (null == list || list.isEmpty()) {
				// 资源不存在
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
			return ResponseEntity.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 500
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}

	// 加Converter前
	// @RequestMapping(value = "all", method = RequestMethod.GET, produces =
	// "text/html;charset=UTF-8")
	// public ResponseEntity<String> queryItemCatAll() {
	// String json;
	// try {
	// json = MAPPER.writeValueAsString(this.itemCatService.queryAllToTree());
	// return ResponseEntity.ok("category.getDataService(" + json + ");");
	// } catch (JsonProcessingException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// // 500
	// return
	// ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	// }
	// 加Converter后
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public ResponseEntity<ItemCatResult> queryItemCatAll() {
		return ResponseEntity.ok(this.itemCatService.queryAllToTree());
	}

}
