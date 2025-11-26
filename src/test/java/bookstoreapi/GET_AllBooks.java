package bookstoreapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.APIConstants;

public class GET_AllBooks extends BaseTest{

	@Test
	public void getAllBooks() {
        Response response = RestAssured.given()
                .spec(requestSpec) 
                .when()
                .get(APIConstants.BOOKS);

		Assertions.assertEquals(response.statusCode(), 200);
	}
}
