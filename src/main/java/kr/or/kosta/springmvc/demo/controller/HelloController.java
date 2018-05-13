package kr.or.kosta.springmvc.demo.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*
 * hello 요청 처리 세부컨트롤러
 * @author 이대용
 */
@Controller
@RequestMapping("/hello")
public class HelloController /* implements Controller */{

	@RequestMapping(value="/hello.do", method=RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		String message = "Spring MVC 테스트입니다";
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", message);
		mav.setViewName("hello");
		return mav;
	}
	
	@RequestMapping(value="/a", method=RequestMethod.GET)
	public String a(Model model) throws Exception {
		String message = "Spring MVC 테스트입니다2";
		
		model.addAttribute("message", message);
		
		return "hello";
	}
	
	@RequestMapping(value="/b", method=RequestMethod.GET)
	public String b(Model model) throws Exception {
		String message = "Spring MVC 테스트입니다3";
		
		model.addAttribute("message", message);
		
		return "hello";
	}
	
	@RequestMapping(value="/c", method=RequestMethod.GET)
	public String c() throws Exception {
		return "redirect:hello";
	}
	
	/* Ajax... */
	@RequestMapping(value="/d", method=RequestMethod.GET)
	public void d(HttpServletResponse response, PrintWriter out) throws Exception {
		response.setCharacterEncoding("text/html; charset=utf-8");
		out.print("Spring MVC 테스트입니다3");
	}
	
}
