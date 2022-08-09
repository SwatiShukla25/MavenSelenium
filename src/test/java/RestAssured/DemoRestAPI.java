package RestAssured;

import io.restassured.RestAssured;



import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.path.json.JsonPath;

public class DemoRestAPI {
	long Petid ;
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "https://petstore.swagger.io/";
	}

	@Test
	public void restApi()
{
		Response response = given().header("accept", "application/xml").when()
				.get("/v2/pet/findByStatus?status=pending");

		// System.out.println(response.asString());
		
		JsonPath  extractor =response.jsonPath();
		String Name =extractor.get("name");
		//int ID=extractor.getString(id);
		
		
		//System.out.println(response.prettyPrint());
		//Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.contentType(), "application/xml");
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
		
		Petid = response.path("id");
		System.out.println(Petid);
		

	}

	@Test(dependsOnMethods = {"postPets"})
	public void PutPets() {
		String json = "{" + "  \"id\": "+Petid+"," + "  \"category\": {" + "    \"id\": 0,"
				+ "    \"name\": \"string\"\r\n" + "  },\r\n" + "  \"name\": \"doggie001\",\r\n"
				+ "  \"photoUrls\": [\r\n" + "    \"string\"\r\n" + "  ],\r\n" + "  \"tags\": [\r\n" + "    {\r\n"
				+ "      \"id\": 0,\r\n" + "      \"name\": \"string\"\r\n" + "    }\r\n" + "  ],\r\n"
				+ "  \"status\": \"available\"\r\n" + "}";

		System.out.println(json);
		Response response = given().header("accept", "application/json").header("Content-Type", "application/json")
				.body(json).when().put("/v2/pet");

		System.out.println(response.prettyPrint());
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.contentType(), "application/json");
	}
	
	@Test(dependsOnMethods = {"PutPets"})
	public void deletePets()
	{
		Response response = given().header("accept", "application/json")
				.when().delete("/v2/pet/"+Petid);

		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.contentType(), "application/json");

	}
@Test(dependsOnMethods = {"postPets"})
public void postUpdate()
{
	Response response = given().header("accept"," application/json").header("Content-Type", "application/x-www-form-urlencoded").
			formParam("name", "tipsi").formParam("status", "pending")
			.when().post("/v2/pet/"+Petid);
	
	System.out.println(response.asPrettyString());
	Assert.assertEquals(response.statusCode(), 200);
	Assert.assertEquals(response.contentType(), "application/json");
	
}
}
