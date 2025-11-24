package accountapi;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;
import utils.APIGlobalVariables;

public class DELETE_User {

	@Test
	public void deleteUser() {
		RestAssured.baseURI = APIConstants.BASE_URI;

		RequestSpecification request = RestAssured.given();

		request.header("Authorization", "Bearer " + APIGlobalVariables.TOKEN);

		request.pathParam("UUID", APIGlobalVariables.USER_ID);

		Response response = request.when().get(APIConstants.DELETE_USER);

		System.out.println(response.statusCode());
		response.prettyPrint();
		List<Object> books = response.jsonPath().getList("books");
		Assertions.assertTrue(books.isEmpty());
		Assertions.assertEquals(0, books.size());
	}
}
