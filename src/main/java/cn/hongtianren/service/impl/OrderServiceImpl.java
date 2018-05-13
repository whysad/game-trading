package cn.hongtianren.service.impl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hongtianren.entity.Order;
import cn.hongtianren.entity.User;
import cn.hongtianren.mapper.OrderMapper;
import cn.hongtianren.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	private static Logger logger = LoggerFactory.getLogger(OrderService.class);
	
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public List<Order> getList() {
		if (SecurityUtils.getSubject().hasRole("ROLE_ADMIN")) {
			logger.info("this is admin.");
			return orderMapper.getList();
		}else{
			return orderMapper.getListByUser(((User)SecurityUtils.getSubject().getPrincipal()).getId());
		}
	}

}
