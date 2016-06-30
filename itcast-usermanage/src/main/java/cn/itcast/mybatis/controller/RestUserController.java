package cn.itcast.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.mybatis.pojo.User;
import cn.itcast.mybatis.service.NewUserService;

@RequestMapping("restful/user")
@Controller
public class RestUserController {
	@Autowired
	private NewUserService newUserService;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<User> queryUserById(@PathVariable("id") Long id) {
		try {
			User user = this.newUserService.queryUserById(id);
			if (user == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
			// 404
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 500
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	// id=7&age=20&name=007
	public ResponseEntity<Void> saveUser(User user) {
		try {
			this.newUserService.saveUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	// id=7&age=200&name=20
	public ResponseEntity<Void> updateUser(User user) {
		try {
			this.newUserService.updateUser(user);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	// 选中post body: id=7&_method=delete
	public ResponseEntity<Void> deleteUser(@RequestParam(value = "id", defaultValue = "0") Long id) {
		try {
			if (id.intValue() == 0) {
				// 请求参数有误
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			this.newUserService.deleteUserById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}

}
