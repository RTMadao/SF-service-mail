package com.salcedoFawcett.services.mailService.domain.service;

import com.salcedoFawcett.services.mailService.client.ParameterClient;
import com.salcedoFawcett.services.mailService.client.CustomerClient;
import com.salcedoFawcett.services.mailService.client.SecurityClient;
import com.salcedoFawcett.services.mailService.client.UserClient;
import com.salcedoFawcett.services.mailService.domain.model.*;
import com.salcedoFawcett.services.mailService.domain.model.message.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class EmailService {

    @Autowired
    private UserClient userClient;
    @Autowired
    private CustomerClient customerClient;
    @Autowired
    private ParameterClient parameterClient;
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
        if (message.isAttachment()) {
            FileSystemResource attachedFile = new FileSystemResource(new File(message.getAttachmentPath()));
            email.addAttachment(message.getFileName(), attachedFile);
        }

        try {
            mailSender.send(msg);
            new File(message.getAttachmentPath()).delete();
        }
        catch (Exception error){
            System.out.println(error);
        }
    }

    public void sendNewUserChangePasswordEmail(String username) throws MessagingException, IOException {
        SecureUser user = userClient.getUserByusername(username).getBody();
        String token = securityClient.generateToken(username).getBody();
        SetNewUserPasswordMessage msg = new SetNewUserPasswordMessage("Cambio contraseña Usuario nuevo - Salcedo & Fawcett",user.getEmail(),user.getName(),"http://localhost:8080/change-password/new-user/"+user.getId()+"/"+token);
        this.sendmail(msg);
    }

    public void sendElectronicDocument(ElectronicDocumentEmailInfo info) throws MessagingException, IOException {
        ElectronicDocumentMessage msg = new ElectronicDocumentMessage(info.getDocumentType()+" - Salcedo & Fawcett",info.getCustomerEmailContact(),info);
        this.sendmail(msg);
    }

    public void sendChangePasswordEmail(String username) throws MessagingException, IOException {
        SecureUser user = userClient.getUserByusername(username).getBody();
        String token = securityClient.generateToken(username).getBody();
        ChangePasswordMessage msg = new ChangePasswordMessage("Cambio contraseña Usuario - Salcedo & Fawcett",user.getEmail(),user.getName(),"http://localhost:8080/change-password/new-user/"+user.getId()+"/"+token);
        this.sendmail(msg);
    }

    public void sendEconomicProposalEmail(EconomicProposal proposal) throws MessagingException, IOException {
        Customer customer = customerClient.getCustomerPartyById(proposal.getCustomerId()).getBody();
        Contact contact = parameterClient.getContactDataById(proposal.getCustomerContactId()).getBody();
        customer.getPartyIdentification().setDocumentTypeName(parameterClient.getIdentificationDocumentTypeNameById(customer.getPartyIdentification().getPartyIdentificationSchemeName()).getBody());
        EconomicProposalMessage msg = new EconomicProposalMessage("Propuesta Económica - "+customer.getRegistrationName(),contact.getElectronicMail(),proposal,customer,contact);
        this.sendmail(msg);
    }
}
