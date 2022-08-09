package RestAssured;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetRequestDataProvider {

	@BeforeClass
	public void setUp()
	{
		RestAssured.baseURI="https://petstore.swagger.io/";
		
	}
	@Test(dataProvider = "TestData")
	public void getRequest(String status)
	{
		Response response = given().header("accept","application/json").when().get("v2/pet/findByStatus?status=+status");
		System.out.println(response.asPrettyString());
		
	}
	
	
@DataProvider(name="TestData")
public Object[][] testData()
{
	Object[][] obj = new Object [][]
			{
		
		{"sold"},
		{"pending"},
		{"available"}
			};
	return obj;
	
}
}	
