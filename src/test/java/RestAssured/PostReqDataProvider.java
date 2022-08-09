package RestAssured;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class PostReqDataProvider {
	
	
	@BeforeClass
	public void setUp()
	{
		RestAssured.baseURI="https://petstore.swagger.io";
	}
	
	@Test
	public void postRequest()
	{
		
		String json = "{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		
		System.out.println(json);
		Response response = given().header("accept", "application/json").header("Content-Type", "application/json")
				.body(json).when().post("/v2/pet");
	}
	
	
		
	

}
