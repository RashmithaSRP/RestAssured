package com.APIScenarios;

import org.testng.annotations.Test;

import com.TestPojo.Authenticatepojo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationWithDeserialization {
  @Test(priority=1)
  public void testSerialization() throws JsonProcessingException {
		  Authenticatepojo data=new Authenticatepojo();
		  data.setUsername("priyanka");
		  data.setPassword("password123");
		  
		  ObjectMapper obj=new ObjectMapper();
		  
		 String json= obj.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		  
		 System.out.println(json);	  
	  }
	  @Test(priority=2)
	  public void testDeserialization() throws JsonMappingException, JsonProcessingException
	  {
		  String json="{\n"
		  		+ "  \"username\" : \"admin\",\n"
		  		+ "  \"password\" : \"password123\"\n"
		  		+ "}";
		  
		  ObjectMapper obj=new ObjectMapper();
		  Authenticatepojo auth=obj.readValue(json,Authenticatepojo.class);
		  
		  System.out.println(auth.getUsername());
		  System.out.println(auth.getPassword());
		  
		  
		  
	  }
	  
  }

