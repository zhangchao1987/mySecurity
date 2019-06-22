package cn.itsource.mySecurity.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.itsource.mySecurity.dto.UserDto;
@Mapper
public interface UserMapper {
	UserDto getUserByUserId(String userId);
}
