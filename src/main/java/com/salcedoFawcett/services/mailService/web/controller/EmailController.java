package com.salcedoFawcett.services.mailService.web.controller;

import com.salcedoFawcett.services.mailService.domain.model.EconomicProposal;
import com.salcedoFawcett.services.mailService.domain.model.ElectronicDocumentEmailInfo;
import com.salcedoFawcett.services.mailService.domain.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("new_user/change_password/{username}")
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

    @PostMapping("electronic_document")
    public ResponseEntity sendElectronicDocument(@RequestBody ElectronicDocumentEmailInfo info){

        try {
            emailService.sendElectronicDocument(info);
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

    @PostMapping("/send/economical_proposal/to_client")
    public ResponseEntity sendEconomicProposalEmail(@RequestBody  EconomicProposal proposal){
        try {
            emailService.sendEconomicProposalEmail(proposal);
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
