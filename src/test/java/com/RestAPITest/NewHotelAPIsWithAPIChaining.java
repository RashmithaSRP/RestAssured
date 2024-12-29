package com.RestAPITest;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.TestPojo.Authenticatepojo;
import com.TestPojo.BookingDates;
import com.TestPojo.CreateBookingpojo;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NewHotelAPIsWithAPIChaining {
	int id;
	String tokenvalue;
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
	  BookingDates dates=new BookingDates();
	  dates.setCheckin("2024-11-30");
	  dates.setCheckout("2024-11-31");
	  
	  CreateBookingpojo data=new CreateBookingpojo();
	  data.setFirstname("Rash");
	  data.setLastname("mitha");
	  data.setTotalprice(9999);
	  data.setDepositpaid(false);
	  data.setBookingdates(dates);
	  data.setAdditionalneeds("lunch");
	  
	  Response res=given()
			  .header("Content-Type","application/json")
			  .body(data)
			  .when().post("https://restful-booker.herokuapp.com/booking");
			//get the log in console
			res.then().log().body();
				//bookingid
			int id=res.jsonPath().getInt("bookingid");
			 System.out.println("Booking id is: "+id);
  }
			 
	@Test(priority=3)
	public void createToken()
	{
		//Request payload
		 Authenticatepojo auth=new Authenticatepojo();
		  auth.setUsername("admin");
		  auth.setPassword("password123");
		  
		 Response res = given()
		.header("Content-Type","application/json")
		.body(auth)
		.when().post("https://restful-booker.herokuapp.com/auth");
		 
		 //status code
		 int code = res.getStatusCode();
		 Assert.assertEquals(code, 200);
		 System.out.println("status cose is" + code);
		 
		 //get the log
		res.then().log().all();
		////get only header
		//res.then().log().headers();
	//get only cookies
		//res.then().log().cookies();
		//get only body
		//res.then().log().body();
		
		String tokenvalue = res.jsonPath().getString("token");
		System.out.println("generated token is "+ tokenvalue);
	}
		
	@Test(priority=4)
	//partial update
		public void partialUpdate()
		{
			//Request payload
		BookingDates dates=new BookingDates();
		  dates.setCheckin("2024-11-30");
		  dates.setCheckout("2024-11-31");
		  
		  CreateBookingpojo data=new CreateBookingpojo();
		  data.setFirstname("Rashmitha");
		  data.setLastname("karre");
		
		  Response res=given()
				  .header("Content-Type","application/json")
				  .header("Accept","application/json")
				  .header("Cookie","token="+tokenvalue)
				  .body(data)
				  .when().patch("https://restful-booker.herokuapp.com/booking/"+id);
				  
				  //status code
				  int code=res.getStatusCode();
				  Assert.assertEquals(code,200);
				  System.out.println("status code is: "+code);
				  
				  //get the body
				  res.then().log().body();
		}
		
		

	}
 	  
	  
  
  
	  
  
