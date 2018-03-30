package cn.hongtianren.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.hongtianren.entity.User;

/**
 * 
 * @Description 用户信息
 * @author 谭震弘
 * @time 2018年3月30日
 * @version 1.0
 */
@Mapper
public interface UserMapper {
	
	/**
	 * 根据用户名获取用户信息
	 * @param username 用户表示
	 * @return
	 */
	User loadUserByUsername(@Param("username") String username);
	
	/**
	 * 根据用户名获取用户基本信息
	 * @param username 用户表示
	 * @return
	 */
	User loadUserBasicByUsername(@Param("username") String username);
}
