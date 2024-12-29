package com.Assignment;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Assignment2 {
	@Test(priority=1)
	public void Hashmap() {
		  HashMap<String, Object> data=new HashMap<String, Object>();
		  data.put("name", "Apple MacBook max");
		  data.put("data.year", 2024);
		  data.put("data.price", 1999.99);
		  data.put("data.CPUmodel", "Intel Core i10");
		  data.put("Harddisksize", "2 TB");
		  
		   Response res = given()
				   .header("Content-Type","application/json")
				   .body(data)
		  .when().post("https://api.restful-api.dev/objects") ;
		   
		 //get the response in console
			res.then().log().body();
			
			int code=res.getStatusCode();
			Assert.assertEquals(code,200);
			System.out.println("Status code is: "+code);
	}	
	@Test(priority=2)
	  public void POJO()
	  {
		 data details=new data();
		 details.setYear(2024);
		 details.setPrice(1999.99);
		 details.setCPUmodel("core i10");
		 details.setHarddisksize("2 TB");
				 
		  pojosetup info=new pojosetup();
		  info.setName("Apple MacBook max");
		  info.setD(details);
		  
		Response res=given()
		  .header("Content-Type","application/json")
		  .body(info)
		  .when().post("https://api.restful-api.dev/objects");
		  
		//get the response
		res.then().log().body();
		
}
}