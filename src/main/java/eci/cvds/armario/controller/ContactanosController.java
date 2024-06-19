package eci.cvds.armario.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
@RestController
public class ContactanosController {

    private final JavaMailSender emailSender;

    public EmailController(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @PostMapping("/sendEmail")
    public void sendEmail(@RequestBody String recipientEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("my.gmail@gmail.com");
        message.setTo(recipientEmail);
        message.setSubject("Correo personalizado");
        message.setText("Este es el cuerpo del correo personalizado.");
        emailSender.send(message);
    }
}