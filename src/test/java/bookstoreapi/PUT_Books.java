package bookstoreapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;
import utils.APIGlobalVariables;

public class PUT_Books {

	@Test
	public void putBooks() {
		RestAssured.baseURI = APIConstants.BASE_URI;
		RequestSpecification request = RestAssured.given().header("Authorization",
				"Bearer " + APIGlobalVariables.TOKEN);

		request.header("Content-Type", "application/json");
		request.pathParam("ISBN", APIGlobalVariables.ISBN);
		request.body("{\r\n" + "  \"userId\": \"d329e635-46f9-444a-b9c9-268cec46b4b2\",\r\n"
				+ "  \"isbn\": \"9781593275846\"\r\n" + "}");

		Response response = request.when().put(APIConstants.PUT_BOOKS);

		response.prettyPrint();
		Assertions.assertEquals(response.jsonPath().getString("userId"), APIGlobalVariables.USER_ID);
		Assertions.assertEquals(response.jsonPath().getString("user"), APIGlobalVariables.user);
	}
}
