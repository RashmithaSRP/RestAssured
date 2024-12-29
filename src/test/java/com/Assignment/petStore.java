package com.Assignment;

import org.testng.annotations.Test;

public class petStore {
	/*	  "id": 111,
		  "category": {
		  "id": 0,
		  "name": "string"
		  },
		  "name": "doggie",
		  "photoUrls": [
		  "string"
		  ],
		  "tags": [
		  {
		  "id":0,
		  "name": "string"
		  }
		  ],
		  "status": "available"
		  }*/
	  private int id;
	  private category c;//
	  private String name;
	  private tags t;//
	  private String status;
	  public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public category getC() {
		return c;
	}
	public void setC(category c) {
		this.c = c;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public tags getT() {
		return t;
	}
	public void setT(tags t) {
		this.t = t;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
	