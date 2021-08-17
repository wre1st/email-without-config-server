package com.bean.aop.proxy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmailAspect {

	@Autowired 
	Properties properties;

	@Before("execution(public void sendEmail())")
	public void d(JoinPoint joinPoint) {
		System.out.println("proxy called");
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
