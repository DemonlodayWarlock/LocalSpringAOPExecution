package com.hwei.learning.service;

import com.hwei.learning.aspect.LogRequired;


//@Service("bookService")
public class ChangeService {
	
	@LogRequired
	public int addBook(int id, String value)  {
		//throw new IOException();
		
		return id+234;
		
				
	}

}
