package bookstoreapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;
import utils.APIGlobalVariables;

public class DELETE_Books {

	@Test
	public void deleteAllBooks() {
		RestAssured.baseURI = APIConstants.BASE_URI;
		RequestSpecification request = RestAssured.given()
				.header("Authorization", "Bearer " + APIGlobalVariables.TOKEN)
				.contentType("application/json")
				.queryParam("UserId", APIGlobalVariables.USER_ID);
		
		Response response =		request.when()
				.delete(APIConstants.BOOKS);
		
		response.prettyPrint();
		Assertions.assertEquals(response.statusCode(), 204);
	}
}
