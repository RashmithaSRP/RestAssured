package com.RestAPITest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestHotelAPIs {
  @Test(priority=1)
  public void getBookingIds(){
	    Response res = given()
	         .when().get("https://restful-booker.herokuapp.com/booking");
	    
	    //status code
	    int code = res.getStatusCode();
	    Assert.assertEquals(code,200 );
	    System.out.println("status code is"+ code);
	    
	  //print json body in console
	  res.then().log().body();
  }
  
  
  @Test(priority=2)
  public void createNewBooking()
  {
	  Response res=given()
			  .header("Content-Type","application/json")
			  .body("{\n"
			  		+ "    \"firstname\" : \"Priyanka\",\n"
			  		+ "    \"lastname\" : \"Nigade\",\n"
			  		+ "    \"totalprice\" : 8888,\n"
			  		+ "    \"depositpaid\" : true,\n"
			  		+ "    \"bookingdates\" : {\n"
			  		+ "        \"checkin\" : \"2024-11-25\",\n"
			  		+ "        \"checkout\" : \"2024-11-26\"\n"
			  		+ "    },\n"
			  		+ "    \"additionalneeds\" : \"Breakfast\"\n"
			  		+ "}")
			  
			  .when().post("https://restful-booker.herokuapp.com/booking");
			//get the log in console
			res.then().log().body();
			
			
			//bookingid
			int id=res.jsonPath().getInt("bookingid");
			 System.out.println("Booking id is: "+id);
			 
			 
		  
	  
	  
	  
	  
  }
  
	  
  
}
