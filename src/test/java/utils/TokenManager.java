package utils;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TokenManager {

	public static String getToken() {
		Map<String, String> body = new HashMap<>();
		body.put("userName", "onurolmez"); 
		body.put("password", "Onurolmez1*");

		return RestAssured.given().contentType(ContentType.JSON).body(body).when()
				.post(APIConstants.POST_GENERET_TOKEN_ENDPOINT).jsonPath().getString("token");
	}
}
