package com.devutil.examples.spring.primary.manual;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.devutil.examples.spring.primary.DefaultServiceImpl;
import com.devutil.examples.spring.primary.HelloComponent;
import com.devutil.examples.spring.primary.HelloService;
import com.devutil.examples.spring.primary.SpanishHelloComponent;
import com.devutil.examples.spring.primary.SpanishServiceImpl;

@SpringBootApplication
public class PrimaryManualConfigurationApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(PrimaryManualConfigurationApplication.class).web(WebApplicationType.NONE).run(args);
	}

	@Bean
	public HelloService defaultServiceImpl() {
		return new DefaultServiceImpl();
	}
	
	@Bean
	@Primary
	public HelloService spanishServiceImpl() {
		return new SpanishServiceImpl();
	}
	
	@Bean
	public HelloComponent helloComponent() {
		return new HelloComponent();
	}
	
	@Bean
	public SpanishHelloComponent spanishHelloComponent() {
		return new SpanishHelloComponent();
	}
	
	@Bean
	public CommandLineRunner runner(HelloComponent helloComponent, SpanishHelloComponent spanishHelloComponent) {
		return (args) -> {
			System.out.println("@Primary: " + helloComponent.sayHello("Carlos"));
			System.out.println("@Qualifier: " + spanishHelloComponent.sayHello("Carlos"));
		};
	}

}
