package restassured;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestAPI {

	public static void main(String[] args) {
		/*
		 * RestAssured.baseURI = "https://fake-json-api.mock.beeceptor.com";
		 * RequestSpecification httpRequest = RestAssured.given();
		 */
		String LOGIN_ENDPOINT = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/login";
		String requestBody = "{\"username\":\"june2025.subha@tekarch.com\",\"password\":\"Admin123\"}";

		Response loginResponse = RestAssured.given().contentType(ContentType.JSON).body(requestBody)
				.post(LOGIN_ENDPOINT);

		String token = loginResponse.jsonPath().getString("[0].token");
		System.out.println(token);

		String GET_DATA_ENDPOINT = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/getdata";
		Map<String, String> headersMap = new HashMap<String, String>();
		headersMap.put("Token", token);
		Response getDataResponse = RestAssured.given()
								.headers(headersMap)
								.get(GET_DATA_ENDPOINT);
		
		System.out.println(getDataResponse.asPrettyString());
		
		

	}
}
