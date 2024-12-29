package com.APIScenarios;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Authentication {
  @Test(priority=1)
public void testBasicAuthenticaton() {
		  Response res=given()
				  		.auth().basic("postman","password")
		  
		                 .when().get("https://postman-echo.com/basic-auth");
		 
		  
		  res.then().log().body();
	  
  }
  @Test(priority=2)
  public void testdigestAuthenticaton() {
  		  Response res=given()
  				  		.auth().digest("postman","password")
  		  
  		                 .when().get("https://postman-echo.com/basic-auth");
  		 
  		  
  		  res.then().log().body();
  	  
    }
  @Test(priority=3)
  public void testBearerToken() {
		  Response res=given()
				  		.headers("Authorization","Bearer 12345")
		                 .when().get("https://postman-echo.com");
		 
		  
		  res.then().log().body();
	  
}
  @Test(priority=3)
  public void testOAuth() {
		  Response res=given()
				  		.headers("Authorization","Bearer 30112024")
		                 .when().get("https://postman-echo.com");
		  res.then().log().body();
	  
}
}
