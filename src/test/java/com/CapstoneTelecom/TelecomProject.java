package com.CapstoneTelecom;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TelecomProject {
	String token;
	String logintoken;
	String mailid="rashmithakarre27@gmail.com";
	String contactid;
	String contactfirstname;
	String contactemail;
  @Test(priority=1)
  public void addNewUser() {
		  HashMap<String, Object> data=new HashMap<String, Object>();
		  data.put("firstName","Rashmitha");
		  data.put("lastName","Karre");
		  data.put("email",mailid);
		  data.put("password","test123");
		    
		   Response res = given()
				   .header("accept","application/json")
					  .header("Content-Type","application/json")
					  .body(data)
		  .when().post("https://thinking-tester-contact-list.herokuapp.com/users");
		  
			res.then().log().body();
			
		  //status 
			int code=res.getStatusCode();
			Assert.assertEquals(code,201);
			System.out.println("Status code is: "+code);
			
			System.out.println(res.getStatusLine());
			
			//get the token
			  token=res.jsonPath().getString("token");
			System.out.println("token value is "+token);  
	  }
  
  @Test(priority=2)
  public void getUser() {
	  Response res = given()
			  .header("Authorization","Bearer "+token)
			  .header("accept","application/json")
			  .header("Content-Type","application/json")
			  
		         .when().get("https://thinking-tester-contact-list.herokuapp.com/users/me");
	  res.then().log().body();
		    
		    int code = res.getStatusCode();
		    Assert.assertEquals(code,200);
		    System.out.println("status code is"+ code);
		    System.out.println(res.getStatusLine());
  }
  @Test(priority=3)
  public void updateUser() {
	  HashMap<String, Object> data1=new HashMap<String, Object>();
	  data1.put("firstName","Rashmi");
	  data1.put("lastName","chikoti");
	  data1.put("email", mailid);
	  data1.put("password", "test1234");
	  
	  Response res = given()
			  .header("Authorization","Bearer "+token)
			   .header("accept","application/json")
				  .header("Content-Type","application/json")
				  .body(data1)
	  .when().patch("https://thinking-tester-contact-list.herokuapp.com/users/me");
	  
		res.then().log().body();
		
	  //status 
		int code=res.getStatusCode();
		Assert.assertEquals(code,200);
		System.out.println("Status code is: "+code);
		
		System.out.println(res.getStatusLine());
  }
	@Test(priority=4)
		  public void loginUser() {
				  HashMap<String, Object> data2=new HashMap<String, Object>();
				  data2.put("email",mailid);
				  data2.put("password","test1234");
				    
				   Response res = given()
						   .header("Authorization","Bearer "+token)
						   .header("accept","application/json")
							  .header("Content-Type","application/json")
							  .body(data2)
				  .when().post("https://thinking-tester-contact-list.herokuapp.com/users/login");
				  
					res.then().log().body();
					
				  //status 
					int code=res.getStatusCode();
					Assert.assertEquals(code,200);
					System.out.println("Status code is: "+code);
					System.out.println(res.getStatusLine());
					
					System.out.println(res.getStatusLine());
					logintoken=res.jsonPath().getString("token");
					System.out.println("token value is "+logintoken);
			  }
	@Test(priority=5)
	public void addContact()
	{
		  addContact a=new addContact();
		  a.setFirstName("Pradhyun");
		   a.setLastName("karre"); 
		   a.setBirthdate("2023-11-16");
		   a.setEmail(mailid);
		   a.setPhone("9492972926");
		   a.setStreet1("pJR Enclave");
		   a.setStreet2("Apartment vsp nilayam");
		   a.setCity("Hyderabad");
		   a.setStateProvince("Telangana");
		   a.setPostalCode("506001");
		   a.setCountry("India");
		   Response res = given()
				   .header("Authorization","Bearer "+logintoken)
				   .header("accept","application/json")
					  .header("Content-Type","application/json")
					  .body(a)
		  .when().post("https://thinking-tester-contact-list.herokuapp.com/contacts");
		  
			res.then().log().body();
			
		  //status 
			int code=res.getStatusCode();
			Assert.assertEquals(code,201);
			System.out.println("Status code is: "+code);
			System.out.println(res.getStatusLine());
			
			contactid=res.jsonPath().getString("_id");
			System.out.println("Booking id is: "+contactid);
			
	  }
	@Test(priority=6)
	public void getContactList(){
		Response res = given()
				.header("Authorization","Bearer "+logintoken)
				   .header("accept","application/json")
					  .header("Content-Type","application/json")
		         .when().get("https://thinking-tester-contact-list.herokuapp.com/contacts");
		    
		    //status code
		    int code = res.getStatusCode();
		    Assert.assertEquals(code,200 );
		    System.out.println("status code is"+ code);
		    System.out.println(res.getStatusLine());
		    
		  //print json body in console
		  res.then().log().body();	
	}
	@Test(priority=7)
	public void getContact() {
		Response res = given()
				.header("Authorization","Bearer "+logintoken)
				   .header("accept","application/json")
					  .header("Content-Type","application/json")
		         .when().get("https://thinking-tester-contact-list.herokuapp.com/contacts/");
		    
		    //status code
		    int code = res.getStatusCode();
		    Assert.assertEquals(code,200 );
		    System.out.println("status code is"+ code);
		    System.out.println(res.getStatusLine());
		    
		  //print json body in console
		  res.then().log().body();	
	}
	@Test(priority=8)
	public void updateContact() {
		 addContact a1=new addContact();
		  a1.setFirstName("surya");
		   a1.setLastName("chikoti"); 
		   a1.setBirthdate("1993-09-12");
		   a1.setEmail(mailid);
		   a1.setPhone("8500091836");
		   a1.setStreet1("pJR road 2");
		   a1.setStreet2("vsp ramya nilayam");
		   a1.setCity("secunderabad");
		   a1.setStateProvince("Telangana");
		   a1.setPostalCode("500050");
		   a1.setCountry("India");
		   Response res = given()
					  .header("Authorization","Bearer "+logintoken)
					   .header("accept","application/json")
						  .header("Content-Type","application/json")
						  .body(a1)
			  .when().put("https://thinking-tester-contact-list.herokuapp.com/contacts/"+contactid);
			  
				res.then().log().body();
				
			  //status 
				int code=res.getStatusCode();
				Assert.assertEquals(code,200);
				System.out.println("Status code is: "+code);
				
				System.out.println(res.getStatusLine());

				contactemail=res.jsonPath().getString("email");
				System.out.println("email id is: "+contactemail);		
		  }
	@Test(priority=9)
	public void partialUpdateContact()
	{
		  HashMap<String, Object> data3=new HashMap<String, Object>();
		  data3.put("firstName","suryatej");
		  
		  Response res = given()
				   .header("Authorization","Bearer "+logintoken)
				   .header("accept","application/json")
					  .header("Content-Type","application/json")
					  .body(data3)
		  .when().patch("https://thinking-tester-contact-list.herokuapp.com/contacts/"+contactid);
		  
			res.then().log().body();

			int code=res.getStatusCode();
			Assert.assertEquals(code,200);
			System.out.println("Status code is: "+code);
			System.out.println(res.getStatusLine());
			contactfirstname=res.jsonPath().getString("firstName");
			System.out.println("First name is: "+contactfirstname);				
	}
	
	@Test(priority=10)
	public void logOutUser() {
		Response res = given()
				.header("Authorization","Bearer "+logintoken)
				   .header("accept","application/json")
					  .header("Content-Type","application/json")
		         .when().post("https://thinking-tester-contact-list.herokuapp.com/users/logout");
		    
		    //status code
		    int code = res.getStatusCode();
		    Assert.assertEquals(code,200);
		    System.out.println("status code is"+ code);
		    System.out.println(res.getStatusLine());
		    
		  //print json body in console
		  res.then().log().body();	
	}
	
		
		
	}
	  

	  
 

