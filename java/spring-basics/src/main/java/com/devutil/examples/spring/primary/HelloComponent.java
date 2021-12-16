package com.devutil.examples.spring.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloComponent {

	@Autowired
	private HelloService service;
	
	public String sayHello(String name) {
		return service.sayHello() + " " + name;
	}
	
}
