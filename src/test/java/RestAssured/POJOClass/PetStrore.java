package RestAssured.POJOClass;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PetStrore {
	
		@BeforeClass
		public void setUp() {
			RestAssured.baseURI = "https://petstore.swagger.io/";
		}

		@Test
		public void restApi()
		{
			PetStroreTest petData = new PetStroreTest();
			petData.setId(0);
			petData.setName("Cat");
			petData.setStatus("available");
			
			Category category = new Category();
			category.setId(100);
			category.setName("cat1");
			petData.setCategory(category);
			
			Tag tag =new Tag();
			tag.setId(1000);
			tag.setName("Tag1");
			
			Tag tag1 = new Tag();
			tag1.setId(1001);
			tag1.setName("Tag2");
			
			List<Tag> tags=new ArrayList<>();
			tags.add(tag);
			tags.add(tag1);
			//petData.setTags(tags);
			
			List<String>photo = new ArrayList<>();
			photo.add("url1");
			photo.add("url2");
			
			petData.setPhotoUrls(photo);
			

		Response response = given().header("accept", "application/json").header("Content-Type", "application/json")
				.body(petData).when().post("/v2/pet");

		System.out.println(response.asPrettyString());
		
		PetStroreTest petResponse = response.body().as(PetStroreTest.class);
		System.out.println(petResponse.getName());
		System.out.println(petResponse.getId());
		
		Assert.assertEquals(petResponse.getStatus(), "available");
		Assert.assertEquals(petResponse.getName(), "Cat");
}
}