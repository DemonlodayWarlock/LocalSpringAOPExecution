package com.hwei.learning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hwei.learning.service.ChangeService;

public class MyMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {	
		ApplicationContext newContext = new ClassPathXmlApplicationContext("spring.xml");
		//ShapeService service = newContext.getBean("shapeService",ShapeService.class);
		//System.out.println(service.getCircle().getName());
		//System.out.println(service.getTriangle().getName());
		
		ChangeService changeService = newContext.getBean("changeService",ChangeService.class);
		@SuppressWarnings("unused")
		int value = changeService.addBook(0, "100RMB");
		//System.out.println(value);
		

	}

}
