package com.bean.aop.impl;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bean.aop.service.EmailService;
import com.bean.aop.util.EmailProperties;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Autowired
	Properties properties;
	
	@Override
	public void sendEmail() {
		
		System.out.println(properties.containsKey("email"));
		System.out.println(properties.getProperty("email")+"\n"+properties.getProperty("to.email")+" "+properties.getProperty("subject")+" "+properties.getProperty("body"));
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(properties.getProperty("email"), properties.getProperty("to.email"));
	        msg.setSubject(properties.getProperty("subject"));
	        msg.setText(properties.getProperty("body"));
	        javaMailSender.send(msg);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
