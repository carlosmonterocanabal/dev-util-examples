package com.devutil.examples.spring.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SpanishHelloComponent {

	@Autowired
	@Qualifier("spanishServiceImpl")
	private HelloService service;
	
	public String sayHello(String name) {
		return service.sayHello() + " " + name;
	}
	
}
