package com.RestAPITest;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.TestPojo.Authenticatepojo;

import io.restassured.response.Response;

public class WaysToRequestPayload {
  @Test
  public void createTokenWithHashmap() {
	  HashMap<String, Object> data=new HashMap<String, Object>();
	  data.put("username", "admin");
	  data.put("password", "password123");
	  
	   Response res = given()
	  .header("Content-Type","application/json")
	  .body(data)
	  .when().post("https://restful-booker.herokuapp.com/auth") ;
	   
	 //get the response in console
		res.then().log().body();
		
		
	  //status 
		int code=res.getStatusCode();
		Assert.assertEquals(code,200);
		System.out.println("Status code is: "+code);
		
		//get the token
		String token = res.jsonPath().getString("token");
		System.out.println("token value is " + token);
	  
  }
  @Test
  public void createTokenUsingPOJO()
  {
	  Authenticatepojo auth=new Authenticatepojo();
	  auth.setUsername("admin");
	  auth.setPassword("password123");
	  
	Response res=given()
	  .header("Content-Type","application/json")
	  .body(auth)
	  
	  .when().post("https://restful-booker.herokuapp.com/auth");
	  
	//get the response
	res.then().log().body();
	
	
	//to get the status code
	System.out.println(res.getStatusCode());
	
	//to get the token
	String tokenvalue=res.jsonPath().getString("token");
	
	System.out.println("Generated token is: "+tokenvalue);
	
  }
}
