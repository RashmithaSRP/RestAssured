package com.RestAPITest;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RequestWithNonBDD {
  @Test
  public void testSingleObject() {
	  Response res = RestAssured.get("https://api.restful-api.dev/objects/7");
	  System.out.println("status code is " +res.getStatusCode());
	  System.out.println("status line is "+res.getStatusLine());
	  System.out.println("*******response in text format*******");
	  System.out.println(res.asString());
	  System.out.println("*******response in JSON format*******");
	  System.out.println(res.asPrettyString());
	  
	  //validation
	  //status code validation
	  int statuscode=res.getStatusCode();
	  Assert.assertEquals(statuscode,200);
	  System.out.println("status code matched! status code is "+statuscode);
	  
	  //how to validate any json payload
	  //id should be 7
	  String id = res.jsonPath().getString("id");
	  System.out.println("id is " +id );
	  Assert.assertEquals(id,"7");
	  System.out.println("id matched");
	  //year:2019
	 int year=res.jsonPath().getInt("data.year");
	 Assert.assertEquals(year, 2019);
	 System.out.println("year is matched");
  }
	 
	 @Test
	 public void testForListOfObjects()
	  {
		  Response res=RestAssured.get("https://api.restful-api.dev/objects");
		  
		  //valiadation for status code
		  int code=res.getStatusCode();
		  	Assert.assertEquals(code,200);
		  	System.out.println("Status code matched: code is: "+code);
		  	
		  	//print response 
		  	System.out.println(res.asPrettyString());
		  	
		  // "color": "Cloudy White",-->3rd object
		  	String color=res.jsonPath().getString("data[2].color");
		  Assert.assertEquals(color,"Cloudy White");
		  System.out.println("Color matched!: color is: "+color);
		  
		  //get all ids from response and print it in console
		  List<String> allId=res.jsonPath().getList("id");
		  System.out.println("Total ids are: "+allId.size());
		  
		  for(String i:allId)
		  {
			  System.out.println(i);
			 /* if(i.equals("7"))
			  {
				  System.out.println("Id is found ....Test Pass!");
				  break;
			  }*/
		  }
	  }
}

