package com.devutil.examples.spring.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class DefaultServiceImpl implements HelloService {

	@Override
	public String sayHello() {
		return "Hello";
	}

}
