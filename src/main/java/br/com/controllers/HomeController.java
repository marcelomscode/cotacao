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

import br.com.model.Moeda;
import br.com.model.Propriedades;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	public Propriedades prop;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping
	public Moeda teste(@RequestParam("moeda") String moeda) throws JsonMappingException, JsonProcessingException {
		
	 Moeda getCurrency = getCurrency(moeda);

	 return getCurrency;
		
	}
	
	private Moeda getCurrency(String currency) throws JsonMappingException, JsonProcessingException {
	
	  ResponseEntity<Moeda> entity = restTemplate.getForEntity(prop.getUrl() + currency, Moeda.class); 
	  
	  return entity.getBody();
	}
	
	
	
	
}
