package com.vencedorpiorfilme.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VencedorPiorFilmeControllerTest {

	@Autowired
	public WebApplicationContext context;
	
	private MockMvc mvc;
		
	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void testGetIntervalo() throws Exception{
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
		String url = "/vencedores/getintervalo"; 
		this.mvc.perform(get(url))
		.andExpect(status().isOk());
	}
	
	@Test
	public void testGetVencedorAno() throws Exception{
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
		String url = "/vencedores/getvencedorano/2018"; 
		this.mvc.perform(get(url))
		.andExpect(status().isOk());
	}
	
	@Test
	public void testGetIndicadosAno() throws Exception{
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
		String url = "/vencedores/getindicadosano/2019"; 
		this.mvc.perform(get(url))
		.andExpect(status().isOk());
	}
	
	@Test
	public void testPost() throws Exception{
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
		String url = "/vencedores/post"; 
		this.mvc.perform(post(url)
			.contentType(MediaType.APPLICATION_JSON)
			.content(" {\"year\": 2020,\"title\": \"OutroTeste\",\"studios\": \"Universal Pictures\",\"producers\": \"Teste\",\"winner\": \"yes\"}"))
		.andExpect(status().isOk());
	}
	
	@Test
	public void testPut() throws Exception{
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
		String url = "/vencedores/put"; 
		this.mvc.perform(put(url)
			.contentType(MediaType.APPLICATION_JSON)
			.content(" {\"id\": 207,\"year\": 2020,\"title\": \"OutroTeste\",\"studios\": \"Universal Pictures\",\"producers\": \"Teste\",\"winner\": \"yes\"}"))
		.andExpect(status().isOk());
	}
	
	
}
