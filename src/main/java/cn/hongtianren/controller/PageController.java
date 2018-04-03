package cn.hongtianren.controller;

import java.sql.SQLException;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.hongtianren.entity.User;
import cn.hongtianren.service.UserService;
import cn.hongtianren.util.PasswordUtil;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@GetMapping("/page/**")
	public String page(HttpServletRequest request) {
		return request.getRequestURI().replaceAll("/page", "");
	}

	@PostMapping("/login")
	public String login(User user, RedirectAttributes attributes,HttpServletRequest request) {
		if (user.getUsername() == null) {
			return "login";
		}
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(),
				PasswordUtil.MD5(user.getPassword()));
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(usernamePasswordToken);
		} catch (Exception e) {
			logger.warn("用户不存在" + user.getUsername());
			attributes.addFlashAttribute("message", "用户名或密码不正确");
		}
		if (subject.isAuthenticated()) {
			User updateUser = new User();
			updateUser.setId(((User)subject.getPrincipal()).getId());
			updateUser.setLastLoginIp(request.getRemoteAddr());
			userService.updateUser(updateUser);
			return "redirect:/index";
		} else {
			usernamePasswordToken.clear();
			return "redirect:/login";
		}
	}

	@PostMapping("/register")
	public String register(User user, String validPassword, RedirectAttributes attributes) {
		if (!validPassword.equals(user.getPassword())) {
			attributes.addFlashAttribute("registerMessage", "密码不匹配");
			return "redirect:/register";
		}
		String phoneRegex = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
		if (!Pattern.matches(phoneRegex, user.getPhone())) {
			attributes.addFlashAttribute("registerMessage", "电话格式不正确");
			return "redirect:/register";
		}
		String emailRegex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		if (!Pattern.matches(emailRegex, user.getEmail())) {
			attributes.addFlashAttribute("registerMessage", "邮箱格式不正确");
			return "redirect:/register";
		}
		String result = "redirect:/register";
		try {
			userService.register(user);
			result =  "redirect:/index";
		} catch (SQLException e) {
			attributes.addFlashAttribute("registerMessage", "用户名已存在");
		}catch (Exception e) {
			attributes.addFlashAttribute("registerMessage", "注册失败，请检查注册信息是否正确");
		}
		return result;
	}

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/logout")
	public String logout(RedirectAttributes redirectAttributes) {
		// 使用权限管理工具进行用户的退出，跳出登录，给出提示信息
		SecurityUtils.getSubject().logout();
		redirectAttributes.addFlashAttribute("message", "您已安全退出");
		return "redirect:/login";
	}

	/**
	 * 首页
	 *
	 * @return
	 */
	@RequestMapping("/desktop")
	public String desktop() {
		return "desktop";
	}
}
