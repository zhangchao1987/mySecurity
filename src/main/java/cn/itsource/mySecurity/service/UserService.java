package cn.itsource.mySecurity.service;

import cn.itsource.mySecurity.dto.UserDto;

public interface UserService {

	UserDto getUserByUserId(String userId);
}
