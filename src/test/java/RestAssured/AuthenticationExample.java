package RestAssured;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class AuthenticationExample {

	@BeforeClass
	public void setUp()
	{
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath="/api";
		
	}
	
	@Test
	public void authentication()
	{
		
	}
}
