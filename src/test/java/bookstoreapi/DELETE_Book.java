package bookstoreapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;
import utils.APIGlobalVariables;

public class DELETE_Book {

	@Test
	public void deleteOneBook() {
		RestAssured.baseURI = APIConstants.BASE_URI;
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + APIGlobalVariables.TOKEN)
				.contentType("application/json")
				.body("{\r\n"
						+ "  \"isbn\": \"9781593275846\",\r\n"
						+ "  \"userId\": \"d329e635-46f9-444a-b9c9-268cec46b4b2\"\r\n"
						+ "}");
		Response response =		request.when()
				.delete(APIConstants.BOOK);
		
		response.prettyPrint();
		Assertions.assertEquals(response.statusCode(), 204);
	}
}
