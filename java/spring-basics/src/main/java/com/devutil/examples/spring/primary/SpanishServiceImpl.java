package com.devutil.examples.spring.primary;

import org.springframework.stereotype.Service;

@Service
public class SpanishServiceImpl implements HelloService {

	@Override
	public String sayHello() {
		return "Hola";
	}
	
}
