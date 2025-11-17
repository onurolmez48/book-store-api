package accountapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;

public class POST_User {

	@Test
	public void createUser() {
		RestAssured.baseURI = APIConstants.BASE_URI;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");

		String payload = "{\n" + "  \"userName\": \"onurolmez\",\n" + "  \"password\": \"Onurolmez1*\"\n" + "}";

		request.body(payload);

		Response response = request.when().post(APIConstants.POST_USER_ENDPOINT);

		System.out.println("Status Code: " + response.statusCode());
		System.out.println("Body: " + response.asString());

		Assertions.assertEquals(response.statusCode(), 201, "User creation failed!");
		Assertions.assertEquals(response.jsonPath().getString("username"), "onurolmez");
		Assertions.assertNotNull(response.jsonPath().getString("userID"), "userID is null!");
	}
}
