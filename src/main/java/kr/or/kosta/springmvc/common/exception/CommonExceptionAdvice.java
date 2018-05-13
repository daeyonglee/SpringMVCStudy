package kr.or.kosta.springmvc.common.exception;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionAdvice {

	private static final Logger logger = Logger.getLogger(CommonExceptionAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public ModelAndView common(Exception e) {
		
		ModelAndView mav = new ModelAndView();
		logger.warn(e.toString());
		mav.setViewName("error_common");
		mav.addObject("exception", e);
		
		return mav;
	}
}
