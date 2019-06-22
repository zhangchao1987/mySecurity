package cn.itsource.mySecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.itsource.mySecurity.dto.UserDto;
import cn.itsource.mySecurity.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	@RequestMapping("getUserByUserId")
	public UserDto getUserByUserId(){
		String userId = "ex-zhangchao005";
		return userService.getUserByUserId(userId );
	}
}
