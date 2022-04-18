package com.salcedoFawcett.services.mailService.domain.service;

import com.salcedoFawcett.services.mailService.client.SecurityClient;
import com.salcedoFawcett.services.mailService.client.UserClient;
import com.salcedoFawcett.services.mailService.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Service
public class EmailService {

    @Autowired
    private UserClient userClient;

    @Autowired
    private SecurityClient securityClient;

    @Autowired
    private JavaMailSender mailSender;

    public void sendmail(Message message) throws AddressException, MessagingException, IOException {
        EmailStructure emailData = new EmailStructure();
        emailData.setEmailData(message);
        MimeMessage msg = mailSender.createMimeMessage();
        MimeMessageHelper email = new MimeMessageHelper(msg, true);

        email.setTo(emailData.getTo());
        email.setFrom(emailData.getFrom());
        email.setSubject(emailData.getSubject());
        email.setText(emailData.getMsg(), true);

        try {
            mailSender.send(msg);
        }
        catch (Exception error){
            System.out.println(error);
        }
    }

    public void sendNewUserChangePasswordEmail(String username) throws MessagingException, IOException {
        SecureUser user = userClient.getUserByusername(username).getBody();
        String token = securityClient.generateToken(username).getBody();
        SetNewUserPasswordMessage msg = new SetNewUserPasswordMessage("Cambio contraseña Usuario nuevo - Salcedo & Fawcett",user.getEmail(),user.getName(),"https://localhost:8080/change-password/new-user/"+user.getId()+"/"+token);
        this.sendmail(msg);
    }

    public void sendChangePasswordEmail(String username) throws MessagingException, IOException {
        SecureUser user = userClient.getUserByusername(username).getBody();
        String token = securityClient.generateToken(username).getBody();
        ChangePasswordMessage msg = new ChangePasswordMessage("Cambio contraseña Usuario nuevo - Salcedo & Fawcett",user.getEmail(),user.getName(),"https://localhost:8080/change-password/new-user/"+user.getId()+"/"+token);
        this.sendmail(msg);
    }
}
