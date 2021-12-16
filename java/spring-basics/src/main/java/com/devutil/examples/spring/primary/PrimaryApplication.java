package com.devutil.examples.spring.primary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

import com.devutil.examples.spring.primary.manual.PrimaryManualConfigurationApplication;

@SpringBootApplication
@ComponentScan(excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = PrimaryManualConfigurationApplication.class))
public class PrimaryApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(PrimaryApplication.class).web(WebApplicationType.NONE).run(args);
	}

	@Bean
	public CommandLineRunner runner(HelloComponent helloComponent, SpanishHelloComponent spanishHelloComponent) {
		return (args) -> {
			System.out.println("@Primary: " + helloComponent.sayHello("Carlos"));
			System.out.println("@Qualifier: " + spanishHelloComponent.sayHello("Carlos"));
		};
	}

}
