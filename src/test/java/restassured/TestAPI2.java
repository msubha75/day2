package restassured;


import io.restassured.http.ContentType; 

import io.restassured.RestAssured;
import io.restassured.response.Response; 
public class TestAPI2 {

	public static void main(String[] args) {
		RestAssured.baseURI="http://localhost:3000";
		
		Response response=RestAssured.given().contentType(ContentType.JSON).body("{ \"name\": \"Don Pandey\", \"email\": \"don.pandey@example.com\", \"age\": 30 }")
        .when()
        .post("/api/associates");
        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Body: " + response.getBody().asString());
        String id = response.jsonPath().getString("id");
        System.out.println("Created ID: " + id);

        // Validate if you want
        response.then().statusCode(201).log().all();
		
		

	}

}
