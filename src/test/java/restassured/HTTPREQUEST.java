package restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTPREQUEST {

	@Test
	/*
	 * void getUser() { RestAssured.given()
	 * .when().get("http://localhost:5001/api/associates/details?sbrId=12345")
	 * .then().statusCode(200).body("id",equalTo(118)) .log().all(); }
	 */	void postUser()
	{
		HashMap data=new HashMap();
		data.put("name", "Sam");
		data.put("job", "QA");
		
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("http://localhost:5001/api/associates/details?sbrId=12345")
		.then()
		.statusCode(201)
		.log().all();
	}
}
