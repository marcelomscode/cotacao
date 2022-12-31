package br.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.model.Feedback;
import br.com.model.Moeda;
import br.com.model.Propriedades;
import br.com.util.SendEmailCotacao;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	SendEmailCotacao sendEmail;
	
	@Autowired
	public Propriedades prop;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping
	public Moeda teste(@RequestParam("moeda") String moeda, @RequestParam("emailPara") String emailPara) throws JsonMappingException, JsonProcessingException {
	
		Moeda m = getCurrency(moeda);
		
		Feedback feed = new Feedback();
		feed.setEmail("marcelomscode@gmail.com");
		sendEmail.sendEmail(m,feed, emailPara);
		
	 return m;
		
	}
	
	private Moeda getCurrency(String currency) throws JsonMappingException, JsonProcessingException {
	
	  ResponseEntity<Moeda> entity = restTemplate.getForEntity(prop.getUrl() + currency, Moeda.class); 
	  
	  return entity.getBody();
	}
	
	
	
	
	
	
	
}
