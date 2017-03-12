package com.pongpat.assignment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RunWith(SpringRunner.class)
@Configuration
@EnableWebMvc
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TodoListApplicationTests {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	//addTaskToList
	public void testA() {
		//build a json object
		String taskBody = "{\"subject\": \"task_test\",\"detail\": \"test_detail\",\"status\": \"PENDING\"}";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);      
		
		HttpEntity<String> request = new HttpEntity<String>(taskBody,headers);
		ResponseEntity<String> response = this.restTemplate.exchange("http://localhost:8080/todo/api/tasks", HttpMethod.POST, request, String.class);
		
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertNotNull(response.getBody());
		
	}
	
	@Test
	//editTask
	public void testB() throws IOException, URISyntaxException {
		//build a json object
		String taskBody = "{\"subject\": \"task_test\",\"detail\": \"test_detail\",\"status\": \"DONE\"}";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);      
		
		HttpEntity<String> request = new HttpEntity<String>(taskBody,headers);
		
		ResponseEntity<String> response = this.restTemplate.exchange("http://localhost:8080/todo/api/tasks/1", HttpMethod.PUT, request, String.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		
	}
	
	@Test
	//getTask
	public void testC() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);      
		
		HttpEntity<String> request = new HttpEntity<String>(headers);
		ResponseEntity<String> response = this.restTemplate.exchange("http://localhost:8080/todo/api/tasks/1", HttpMethod.GET, request, String.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		
	}
	
	@Test
	//deleteTask
	public void testD() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);      
		
		HttpEntity<String> request = new HttpEntity<String>(headers);
		ResponseEntity<String> response = this.restTemplate.exchange("http://localhost:8080/todo/api/tasks/1", HttpMethod.DELETE, request, String.class);
		
		assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
		
	}

}
