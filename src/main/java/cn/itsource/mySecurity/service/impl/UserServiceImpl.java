package cn.itsource.mySecurity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itsource.mySecurity.dao.UserMapper;
import cn.itsource.mySecurity.dto.UserDto;
import cn.itsource.mySecurity.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper;

	@Override
	public UserDto getUserByUserId(String userId) {
		return userMapper.getUserByUserId(userId);
	}

}
