package bookstoreapi;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;

public class GET_AllBooks {

	@Test
	public void getAllBooks() {

		RestAssured.baseURI = APIConstants.BASE_URI;

		RequestSpecification request = RestAssured.given();

		Response response = request.when().get("/BookStore/v1/Books");

		response.prettyPeek();
	}
}
