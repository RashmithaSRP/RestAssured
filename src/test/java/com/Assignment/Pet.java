package com.Assignment;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Pet {
	Long id;
  @Test(priority=1)
  public void testpetbystatus() {
	  Response res = given()
	 . pathParam("path","findByStatus")
	  .queryParam("status","available")
	  .when().get("https://petstore.swagger.io/v2/pet/{path}");
	  res.then().log().body();
	  int code = res.getStatusCode();
	  System.out.println("status code is"+code); 
  }  
  @Test(priority=2)
  public void addNewPetTOStore(){
	  tags tag=new tags();
	  tag.setId(0);
	  tag.setName("string");
	  
	  category cdata=new category();
	  cdata.setId(0);
	  cdata.setName("String");
	 
	  petStore data=new petStore();
	  data.setId(0);
	  data.setC(cdata);
	  data.setName("TOMMY");
	  data.setT(tag);
	  data.setStatus("available");
	  
	  Response res = given()
	  .header("accept","application/json")
	  .header("Content-Type","application/json")
	  .body(data)
	  .when().post("https://petstore.swagger.io/v2/pet");
	  res.then().log().body();
	  
	  int code = res.getStatusCode();
	  System.out.println("status code is"+code); 
	  
	  id=res.jsonPath().getLong("id");
		 System.out.println("id is: "+id);
  }
  
  @Test(priority=3)
  public void findPet(){
	   Response res = given()
	  .header("accept","application/json")
	  .when().get("https://petstore.swagger.io/v2/pet/"+id);
	   res.then().log().body();  
	   int code = res.getStatusCode();
	   System.out.println("status code is"+code);
  }
  
  
  
  
  
  
  
  
  

  
  
  
  
  
  
  
  
  
  
  
  
  
  @Test(priority=4,enabled=false)
  public void updateExistingPet(){
	  tags tag=new tags();
	  tag.setId(0);
	  tag.setName("string");
	  category cdata=new category();
	  cdata.setId(0);
	  cdata.setName("String"); 
	  petStore data=new petStore();
	  data.setId(1);
	  data.setC(cdata);
	  data.setName("SIMBA");
	  data.setT(tag);
	  data.setStatus("available");
	  Response res = given()
	  .header("accept","application/json")
	  .header("Content-Type","application/json")
	  .body(data)
	  .when().put("https://petstore.swagger.io/v2/pet");
	  res.then().log().body();
	  int code = res.getStatusCode();
	  System.out.println("status code is"+code); 
  }
  
  
  
  
  
  @Test(priority=5,enabled=false)
  public void deletePet(){
	  Response res = given()
	  .header("accept","application/json")
	  .when().delete("https://petstore.swagger.io/v2/pet/"+id);
	  int code = res.getStatusCode();
	  System.out.println("status code is"+code); 
  }
  }
  
     
	    
	  
	  
  
