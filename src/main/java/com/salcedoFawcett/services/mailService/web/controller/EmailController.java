package com.salcedoFawcett.services.mailService.web.controller;

import com.salcedoFawcett.services.mailService.client.UserClient;
import com.salcedoFawcett.services.mailService.domain.model.ChangePasswordMessage;
import com.salcedoFawcett.services.mailService.domain.model.SecureUser;
import com.salcedoFawcett.services.mailService.domain.model.SetNewUserPasswordMessage;
import com.salcedoFawcett.services.mailService.domain.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/change_password/new_user/{username}")
    public ResponseEntity sendNewUserChangePasswordEmail(@PathVariable("username") String username){

        try {
            emailService.sendNewUserChangePasswordEmail(username);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (MessagingException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/change_password/{username}")
    public ResponseEntity sendChangePasswordEmail(@PathVariable("username") String username){
        try {
            emailService.sendChangePasswordEmail(username);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (MessagingException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}
