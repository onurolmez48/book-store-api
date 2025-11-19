package accountapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;

public class POST_GenerateToken {

	@Test
	public void generateToken() {
		RestAssured.baseURI = APIConstants.BASE_URI;

		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");

		String payload = "{\r\n" + "  \"userName\": \"onurolmez\",\r\n" + "  \"password\": \"Onurolmez1*\"\r\n" + "}";
		request.body(payload);

		Response response = request.when().post(APIConstants.POST_GENERET_TOKEN_ENDPOINT);

		response.prettyPrint();

		Assertions.assertEquals(response.statusCode(), 200);
		Assertions.assertEquals(response.jsonPath().getString("status"), "Success");
		Assertions.assertEquals(response.jsonPath().getString("result"), "User authorized successfully.");
	}
}
