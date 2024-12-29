package com.RestAPITest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RequestWithBDD {
  @Test
  public void testSingleObject() {
	  Response res = given()
	  .when().get("https://api.restful-api.dev/objects/7");
	  res.then().log().body();
	  
	  int statuscode = res.getStatusCode();
	  Assert.assertEquals(statuscode,200);
	  System.out.println("status code is "+ statuscode);
	  
	  //price:1849.99
	  double price = res.jsonPath().getDouble("data.price");
	  Assert.assertEquals(price, 1849.99);
	  System.out.println("price is "+ price);
	  
  }
}
