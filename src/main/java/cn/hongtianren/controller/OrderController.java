package cn.hongtianren.controller;

import java.util.Collections;
import java.util.Optional;

import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.hongtianren.entity.User;
import cn.hongtianren.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping
	public Object getList() {
		return Optional.ofNullable(orderService.getList()).orElse(Collections.EMPTY_LIST);
	}
}
