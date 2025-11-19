package bookstoreapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;
import utils.APIGlobalVariables;

public class GET_OneBook {

	@Test
	public void getOneBook() {
		RestAssured.baseURI = APIConstants.BASE_URI;
		RequestSpecification request = RestAssured.given();
		request.queryParam("ISBN", APIGlobalVariables.ISBN);

		Response response = request.when().get(APIConstants.BOOK);

		response.prettyPrint();

		Assertions.assertEquals(response.statusCode(), 200);
		Assertions.assertEquals(response.jsonPath().getString("isbn"), APIGlobalVariables.ISBN);
	}
}
