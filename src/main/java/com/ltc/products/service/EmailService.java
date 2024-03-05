package com.ltc.products.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;



    public void sendEmail(){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("togrul.baghirli@gmail.com");
        msg.setFrom("baghirli.togrul@gmail.com");
        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");
        javaMailSender.send(msg);
    }
}
