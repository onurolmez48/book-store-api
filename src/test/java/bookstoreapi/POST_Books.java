package bookstoreapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;
import utils.APIGlobalVariables;

public class POST_Books {

	@Test
	public void addListOfBooks() {
		RestAssured.baseURI = APIConstants.BASE_URI;
		RequestSpecification request = RestAssured.given().header("Authorization",
				"Bearer " + APIGlobalVariables.TOKEN);
		;
		request.header("Content-Type", "application/json");
		String payload = "{\r\n" + "  \"userId\": \"d329e635-46f9-444a-b9c9-268cec46b4b2\",\r\n"
				+ "  \"collectionOfIsbns\": [\r\n" + "    {\r\n" + "      \"isbn\": \"9781593277574\"\r\n" + "    }\r\n"
				+ "  ]\r\n" + "}";

		request.body(payload);

		Response response = request.when().post("BookStore/v1/Books");

		response.prettyPrint();

		Assertions.assertEquals(response.statusCode(), 201);
	}
}
