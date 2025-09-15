package restassured;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.stream.Collectors;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestAPI3 {

	public static void main(String... args) {
		String request = readFile("createAssociate.json");
		request = request.replace("tempSbrID", generateSbrID());
		System.out.println(request);

		RestAssured.baseURI = "http://localhost:3000";
		Response response = RestAssured.given().contentType(ContentType.JSON).body(request).post("/api/associates");
		System.out.println(response.asString());
		//String firstName = response.jsonPath().get("$.data.firstName");
		//System.out.println(firstName);

	}

	public static String readFile(String fileName) {
		InputStream inputStream = TestAPI.class.getClassLoader().getResourceAsStream(fileName);
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			return reader.lines().collect(Collectors.joining("\n"));
		} catch (Exception e) {
			throw new RuntimeException("Error reading resource file: " + fileName, e);
		}
	}

	public static String generateSbrID() {
		return String.valueOf(100000 + (new Random()).nextInt(900000)); // ensures it's always 6 digits
	}

}
