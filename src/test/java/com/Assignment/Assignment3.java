package com.Assignment;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Assignment3 {
	  @Test(priority=1)
	  public void testOAuth() {
			  Response res=given()
					  		.headers("Authorization","Bearer 30112024")
			                 .when().get("https://postman-echo.com");
			  res.then().log().body();
		  
  }
}
