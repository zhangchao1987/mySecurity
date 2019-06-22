package cn.itsource.mySecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.itsource.mySecurity.annotation.SMPermission;
import cn.itsource.mySecurity.annotation.UserLoginToken;

@RestController
public class HelloController {

	@RequestMapping("/hello")
	@UserLoginToken
	public String hello() {
		return "hello";
	}
	@RequestMapping("/getMenu")
	@SMPermission(value="allMenu",required=true)
	public String getMenu(){
		System.out.println("getMenu");
		return "menu";
	}
	
	public static void main(String[] args) {
		HelloController h = new HelloController();
		
	}
}
