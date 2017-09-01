package com.hwei.learning.aspect;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyAspect {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LogManager.getLogger(MyAspect.class); 
	
	/*@Pointcut("target(com.hwei.learning.service.ChangeService)") 
	//@Pointcut("args(..)&&within(com.hwei.learning.service.ChangeService)") 
	//@Pointcut("@target(org.springframework.stereotype.Service)")
	//@Pointcut("execution(* com.hwei.learning.service.ChangeService.addBook(..))")
	public void dummyMethod() {
		
	}
	
	@Before(value="dummyMethod()")
	public void addAdvice(JoinPoint joinPoint) {
		logger.info("JoinClassName:"+joinPoint.getTarget().getClass().getName()+",JoinPoint:"+joinPoint.getSignature().getName()+","+parseArgument(joinPoint));	
	}
	
	
	@AfterReturning(pointcut="execution(public int addBook(..))",returning="returnInt")
	public void afterMethod(JoinPoint joinPoint,Object returnInt) {
		System.out.println("Input arguments:"+parseArgument(joinPoint));
		System.out.println("Output value:"+returnInt);	
	}
	
	@AfterThrowing(pointcut="args(..)",throwing="ex")
	public void afterThrown(Exception ex) {
		System.out.println("Exception message:"+ex.getMessage());
		
	}*/
	
	//@Around("args(..)&&within(com.hwei.learning.service.ChangeService)")
	@Around("@annotation(com.hwei.learning.aspect.LogRequired)")
	public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
		Object object=null;
		try {
			System.out.println("Before:"+parseArgument(proceedingJoinPoint));
			object = proceedingJoinPoint.proceed();
			System.out.println("After:"+object);
		} catch (Throwable e) {
			System.out.println("Throwing:"+e.getMessage());
		}
		
		System.out.println("Finally!");
		
		return object;
		
	}
	
	
	private String parseArgument(JoinPoint joinPoint) {
		
		StringBuilder builder = new StringBuilder();
		builder.append("Arguments:(");
		Object[] points = joinPoint.getArgs();
		for(Object object:points) {
			builder.append(object.toString()+",");	
		}
		builder.deleteCharAt(builder.length() - 1);
		builder.append(")");
		return builder.toString();	
	}

}
