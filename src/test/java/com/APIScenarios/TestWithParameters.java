package com.APIScenarios;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class TestWithParameters {
  @Test
  public void testQueryPathParameters() {
	  Response res = given()
			  .pathParam("path","/objects")
			  .queryParam("id",3)
			  .queryParam("id",5)
			  .queryParam("id",10)
			  .when().get("https://api.restful-api.dev/{path}");
	  res.then().log().body();
	  //get all ids
	  List<String> allid = res.jsonPath().getList("id");
	  for(String i:allid)
	  {
		  System.out.println(i);
	  }
	  
			  
  }
}
