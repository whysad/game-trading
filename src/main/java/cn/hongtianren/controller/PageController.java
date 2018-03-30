package cn.hongtianren.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.hongtianren.entity.User;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register(){
		return "register";
	}
	
	@GetMapping("/page/{url}")
	public String page(@PathVariable("url") String url){
		return url;
	}
	
	@PostMapping("/login")
	public String login(User user, RedirectAttributes attributes) {
		if (user.getUsername() == null) {
			return "login";
		}
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(),
				user.getPassword());
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(usernamePasswordToken);
		} catch (Exception e) {
			logger.warn("用户不存在" + user.getUsername());
			attributes.addFlashAttribute("message", "用户名或密码不正确");
		}
		if (subject.isAuthenticated()) {
			return "redirect:/page/index";
		} else {
			usernamePasswordToken.clear();
			return "redirect:/login";
		}
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
