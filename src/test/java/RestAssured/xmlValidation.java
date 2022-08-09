package RestAssured;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

public class xmlValidation {
	
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "https://petstore.swagger.io/";
	}
@Test
public void postPets() {

	String json = "{" + "  \"id\": 0," + "  \"category\": {" + "    \"id\": 0,"
			+ "    \"name\": \"PetCat\"" + "  }," + "  \"name\": \"Cat\"," + "  \"photoUrls\": ["
			+ "    \"string\"" + "  ]," + "  \"tags\": [" + "    {" + "      \"id\": 0,"
			+ "      \"name\": \"Tag1\"" + "    }" + "  ]," + "  \"status\": \"available\"" + "}";

	System.out.println(json);
	Response response = given().header("accept", "application/xml").header("Content-Type", "application/json")
			.body(json).when().post("/v2/pet");

	System.out.println(response.asPrettyString());
	Assert.assertEquals(response.statusCode(), 200);
	Assert.assertEquals(response.contentType(), "application/xml");
	
	response.then().body("Pet.name", equalTo( "Cat")).body("Pet.category.name", equalTo("PetCat")).and().body("Pet.status", equalTo("available"))
	.body("Pet.category.id[0]", equalTo("0"));
	
	response.then().body(matchesXsdInClasspath("pets.xsd"));
	}
}
