package cn.hongtianren.service;
import cn.hongtianren.entity.User;

public interface UserService {
	
	/**
	 * 会员注册
	 * @param user 会员信息
	 * @return 注册是否成功
	 */
	boolean register(User user);
}
