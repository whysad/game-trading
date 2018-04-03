package cn.hongtianren.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.hongtianren.entity.User;
import cn.hongtianren.mapper.UserMapper;

public class AuthorizationInterceptor implements HandlerInterceptor {
	
	private UserMapper userMapper;

	public AuthorizationInterceptor(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String backend = request.getParameter("backend");
		if (backend != null) {
			User user = userMapper.loadUserBasicByUsername(backend);
			SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
