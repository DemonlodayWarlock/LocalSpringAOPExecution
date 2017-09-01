package com.hwei.learning.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	@Before("dummyMethod()")
	public void listAdvice(JoinPoint joinPoint) {
		
		System.out.println("Signature:"+joinPoint.getSignature().getName());
		System.out.println("ClassName:"+joinPoint.getTarget().getClass().getName());	
	}
	
	@Pointcut("execution( * com.hwei.learning.model.Circle.get*(..))")
	public void dummyMethod() {}

}
