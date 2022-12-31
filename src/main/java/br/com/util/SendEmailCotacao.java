package br.com.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.model.EmailCfg;
import br.com.model.Feedback;
import br.com.model.Moeda;

@Component
public class SendEmailCotacao {
	
	@Autowired
	public EmailCfg emailCfg;
	
	@PostMapping
	public void sendEmail(Moeda moeda, Feedback feed, String emailPara) {
		
		feed.setEmail("marcelomscode@hotmail.com");

		
		//Create mail sender
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(this.emailCfg.getHost());
		mailSender.setPort(this.emailCfg.getPort());
		mailSender.setUsername(this.emailCfg.getUsername());
		mailSender.setPassword(this.emailCfg.getPassword());
		
		
		//Create a mail sender
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(feed.getEmail());
		mailMessage.setTo(emailPara);
		mailMessage.setSubject("Cotação de " + moeda.getEURBRL().getCode());
		mailMessage.setText("A cotação da Moeda "+ moeda.getEURBRL().getCode() + " está no valor de: " + moeda.getEURBRL().getBid());
		
		//Send email
		mailSender.send(mailMessage);
		
	}
	
	
}
