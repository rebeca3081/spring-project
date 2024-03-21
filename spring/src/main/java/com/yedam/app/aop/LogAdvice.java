package com.yedam.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j // log 인터페이스
@Aspect //  AOP설정 : point cut + advice의 결합
@Component // 빈등록
public class LogAdvice {
	
	// 포인트 컷 정하기
	@Pointcut("execution(* com.yedam.app.emp..*Impl.*(..))")
	public void allpointcut() {}
	
	// point cut정하기(로그 찍을 메소드)
	// 리턴타입 패키지명.메소드명(인수)
	@Before("allpointcut()")
	public void logBefore(JoinPoint jp) {
		// log.info("[log before]");
		System.out.println("[log before]");
		
		String name = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println(name + " : ");
		
		if(args != null) {
			for(Object arg : args) {
				System.out.println(arg);
			}
		}
	}
}
