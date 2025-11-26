package accountapi;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.APIConstants;
import utils.TokenManager;

public class DELETE_User extends BaseTest {

	@Test
	public void deleteUser() {
		String token = TokenManager.getToken();
        String userId = "d329e635-46f9-444a-b9c9-268cec46b4b2";

        Response response = RestAssured.given()
                .spec(requestSpec) 
                .header("Authorization", "Bearer " + token)
                .pathParam("UUID", userId)
                .when()
                .delete(APIConstants.DELETE_USER);
                
		List<Object> books = response.jsonPath().getList("books");
		Assertions.assertTrue(books.isEmpty());
		Assertions.assertEquals(0, books.size());
	}
}
