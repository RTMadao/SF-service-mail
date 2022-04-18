package com.salcedoFawcett.services.mailService;

import com.salcedoFawcett.services.mailService.domain.model.SetNewUserPasswordMessage;
import com.salcedoFawcett.services.mailService.domain.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;
import java.io.IOException;

@SpringBootTest
class MailServiceApplicationTests {

	@Autowired
	private EmailService emailService;

	@Test
	void sendNewUserPasswordEmail() throws MessagingException, IOException {
		SetNewUserPasswordMessage msg = new SetNewUserPasswordMessage("Cambio contraseña Usuario nuevo - Salcedo & Fawcett","mariisa.1803@gmail.com","Maria Fawcett","https://www.google.com/");
		emailService.sendmail(msg);
	}

}
