package com.emails.contatoemail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin // permite requisições do Angular
public class EmailController {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/send")
    public String sendMail(@RequestBody EmailRequest request) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(request.getEmail());
            message.setTo("dsilvajeverson@gmail.com");
            message.setSubject(request.getAssunto());
            message.setText(
                    "Nome: " + request.getNome() + "\n" +
                            "Email: " + request.getEmail() + "\n\n" +
                            request.getMensagem()
            );
            mailSender.send(message);
            return "OK";
        } catch (Exception e) {
            return "Erro ao enviar e-mail: " + e.getMessage();
        }
    }
}