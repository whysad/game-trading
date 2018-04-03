package cn.hongtianren.service.impl;

import java.sql.SQLException;
import java.util.Date;



import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hongtianren.entity.User;
import cn.hongtianren.mapper.UserMapper;
import cn.hongtianren.service.UserService;
import cn.hongtianren.util.Constant;
import cn.hongtianren.util.PasswordUtil;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@Transactional
	@Override
	public boolean register(User user) throws SQLException{
		user.setPassword(PasswordUtil.MD5(user.getPassword()));
		Date date = new Date();
		user.setCreateTime(date);
		user.setUpdateTime(date);
		Subject subject = SecurityUtils.getSubject();
			//注册
			userMapper.register(user);
			//设置默认角色
			userMapper.setUpRole(user.getId(),Constant.DEFAULT_ROLE);
		if(subject.isAuthenticated()){
			subject.logout();
		}
		subject.login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));
		return true;
		
	}

	@Override
	public void updateUser(User user) {
		Date date = new Date();
		user.setLastLoginDate(date);
		user.setUpdateTime(date);
		userMapper.update(user);
	}

	@Override
	@Transactional
	public void create(User user, int role) throws SQLException {
		user.setPassword(PasswordUtil.MD5(user.getPassword()));
		Date date = new Date();
		user.setCreateTime(date);
		user.setUpdateTime(date);
		//注册
		userMapper.register(user);
		//设置角色
		userMapper.setUpRole(user.getId(),role);
	}

}
