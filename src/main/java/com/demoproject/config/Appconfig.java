package com.demoproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demoproject.dto.BeanCreationWitoutNoArgConstructor;

@Configuration
public class Appconfig {
	
	@Bean
	public BeanCreationWitoutNoArgConstructor getBean() {
		return new BeanCreationWitoutNoArgConstructor("John","HYd");
	}
}
