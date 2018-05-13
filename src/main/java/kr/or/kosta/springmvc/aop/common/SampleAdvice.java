package kr.or.kosta.springmvc.aop.common;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SampleAdvice {

	private static final Logger logger = Logger.getLogger(SampleAdvice.class);
	
	@Before("execution(* kr.or.kosta.springmvc.aop.service..*.*(..))")
	public void startLog(JoinPoint jp) {
		logger.info("-------------------------------------");
		logger.info("-------------------------------------");
		logger.info(Arrays.toString(jp.getArgs()));
	}
	
	@Around("execution(* kr.or.kosta.springmvc.aop.service..*.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		
		long startTime = System.currentTimeMillis();
		logger.info(Arrays.toString(pjp.getArgs()));
		
		Object result = pjp.proceed();
		
		long endTime = System.currentTimeMillis();
		logger.info(pjp.getSignature().getName()+" : "+(endTime - startTime));
		logger.info("===================================================");
		
		return result;
		
	}
}
