package cn.hongtianren.service;
import java.sql.SQLException;

import cn.hongtianren.entity.User;

public interface UserService {
	
	/**
	 * 会员注册
	 * @param user 会员信息
	 * @return 注册是否成功
	 * @throws Exception 
	 */
	boolean register(User user) throws Exception;
	
	/**
	 * 会员信息修改
	 * @param user 会员信息
	 */
	void updateUser(User user);
	
	/**
	 * 添加员工
	 * @param user
	 * @throws SQLException 
	 */
	void create(User user,int role) throws SQLException;
}
