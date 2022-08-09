package RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SchemaValidation {

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
		Response response = given().header("accept", "application/json").header("Content-Type", "application/json")
				.body(json).when().post("/v2/pet");

		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.contentType(), "application/json");
		response.then().body("category.id",equalTo (0)).body("name", equalTo("Cat")).body("tags[0].id", equalTo(0)).body("tags[0].name", equalTo("Tag1"))
		.and().body("status", equalTo("available"));
		response.then().body(matchesJsonSchemaInClasspath("petjsonscheme.json"));
	}
}
