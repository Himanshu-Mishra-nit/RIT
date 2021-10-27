package com.employee11.controller;

import com.employee11.model.EmailRequest;
import com.employee11.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EmailController {
	
	@Autowired
	private SendEmailService sendEmailSerivce;
	//api to send email
	@RequestMapping(value="/sendemail",method=RequestMethod.POST)
	 public  ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
		 
		boolean ans = this.sendEmailSerivce.sendSimpleMessage(request.getTo(),request.getSubject(),request.getText());
		if(ans)
		{	
		     return ResponseEntity.ok("Email is sent successfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body( "Email Not sent..");
		}
		}

}
