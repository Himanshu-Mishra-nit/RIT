//
//package com.net.employee.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service
//public class SendALLService {
//
//
//	    @Autowired
//	    private JavaMailSender emailSender;
//
//	    public boolean sendSimpleMessage(String[] to, String subject, String text) {
//	         boolean flag=false;
//	    	System.out.println("sending..");
//	        SimpleMailMessage message = new SimpleMailMessage(); 
//	        message.setFrom("ourinterns07@gmail.com");
//	        message.setTo(to);
//	        message.setSubject(subject); 
//	        message.setText(text);
//	        emailSender.send(message);
//	        System.out.println("Successfulsent..message......");
//	        flag=true;
//	        return flag;
//	        
//	    }
//	}
//
