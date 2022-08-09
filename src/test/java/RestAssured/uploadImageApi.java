package RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.io.File;

public class uploadImageApi {

	
	@Test
	public void UploadImageTest()
	{
	RestAssured.baseURI="https://petstore.swagger.io";
	Response reponse =given().header("Content-Type","multipart/form-data").formParam("additionalMetadata","test1").
	multiPart("file",new File("C:\\Software testing\\QAGuru\\anahitaArt.png"),"image/png").
	when().post("/v2/pet/9223372036854067000/uploadImage");
	
	System.out.println(reponse.asPrettyString());
	System.out.println(reponse.statusCode());
	}
}
