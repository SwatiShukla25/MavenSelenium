package RestAssured.POJOClass.Users;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class UserData {


	
	@BeforeClass
	public void setUp()
	{
		RestAssured.baseURI="https://reqres.in/api/";
	}
	
	@Test
	public void postFromPOJO()
	{
		User user = new User();
				String[] str = {"user1","user2","user3"};
				for(int i=0;i<str.length;i++)
				{
					System.out.println("Index:"+" "+i);
					
					user.setName(str[i]);
					user.setJob("QA");
					
					Response response = given().header("Content-Type","application/json").body(user).when().post("/users").then().statusCode(201).extract().response();
					User user1 =response.getBody().as(User.class);
					System.out.println("ID id:"+" "+user1.getId());
					response.body().prettyPrint();
				}
	}
	
	@Test
	public void getFromPojo()
	{
		Response response=given().queryParam("page", "2").when().get("/users/");
		System.out.println("Response: \n:"+ response.asString());
		UserDataNew user = response.getBody().as(UserDataNew.class);
		System.out.println("Total:"+ " "+user.getTotal());
		
		Support support = user.getSupport();
		
		System.out.println("Support Text: \n: "+ support.getText());
		System.out.println("Support URL: \n:"+ support.getUrl());
		List<Datum> data = user.getData();
		System.out.println("Data size:" + data.size());

		for(int i=2;i<data.size();i++)
		{
			System.out.println("Index: \n:"+ i);
			System.out.println("ID: \n:"+ data.get(i).getId());
		if (data.get(i).getId()==10){
			System.out.println(data.get(i).getEmail());
			System.out.println(data.get(i).getFirstName());
			System.out.println(data.get(i).getLastName());
			System.out.println(data.get(i).getAvatar());
		break;
		}
		response.asPrettyString();
		}
	}

}
