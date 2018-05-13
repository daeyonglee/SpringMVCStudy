package kr.or.kosta.springmvc.user.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import kr.or.kosta.springmvc.user.domain.Login;
import kr.or.kosta.springmvc.user.domain.User;
import kr.or.kosta.springmvc.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	Logger logger = Logger.getLogger(UserController.class);
	
	@Inject
	private UserService service;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void loginGET(@ModelAttribute("login")Login login) {
		
	}
	
	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public void loginPOST(Login login, HttpSession session, Model model) throws Exception {
		
		User user = service.login(login);
		if (user == null) {
			return;
		}
		
		model.addAttribute("user", user);
		
		if (login.isUseCookie()) {
			
			int amount = 60 * 60 * 24 * 7;
			
			Date sessionlimit = new Date(System.currentTimeMillis()+(1000*amount));
			
			service.keepLogin(user.getUno(), session.getId(), sessionlimit);
		}
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		Object obj = session.getAttribute("login");
		
		if (obj != null) {
			User user = (User)obj;
			
			session.removeAttribute("login");
			session.invalidate();
			
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			
			if (loginCookie != null) {
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				service.keepLogin(user.getUno(), session.getId(), new Date());
			}
		}
		
		return "user/logout";
	}
}
