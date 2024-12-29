package com.APIScenarios;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertFalse;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class HeadersCookiesValidation {
  @Test(priority=1)
  public void testHeaders() {
	  Response res = given()
			  .when().get("https://www.google.com");
	  res.then().log().headers();
	  
	  String expectedheader="text/html; charset=ISO-8859-1";
	  String actheader=res.getHeader("Content-Type");
	  Assert.assertEquals(actheader,expectedheader,"test case fail");
	  System.out.println("test case pass"); 
  }
  @Test(priority=2)
  public void testCookies()
  {
	  Response res = given()
			  .when().get("https://www.google.com");
	  res.then().log().cookies();
	  String expectedcookies="AZ6Zc-WE5hMUOXsHcCCBD70z3G2vaGODbs9jgdj20r2zp8CLQlx_zTNTuA";
	  String actcookis=res.getCookie("AEC");
	  assertFalse(actcookis.contains(expectedcookies), "test case fail");
	  System.out.println("test case pass");
  }
  
}
