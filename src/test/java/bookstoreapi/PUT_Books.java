package bookstoreapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.APIConstants;
import utils.APIGlobalVariables;
import utils.TokenManager;

public class PUT_Books extends BaseTest{

	@Test
	public void putBooks() {
		String token = TokenManager.getToken();
    
		Response response = RestAssured.given()
                .spec(requestSpec) 
                .header("Authorization", "Bearer " + token)
                .body("{\r\n" + "  \"userId\": \"d329e635-46f9-444a-b9c9-268cec46b4b2\",\r\n"
        				+ "  \"isbn\": \"9781593275846\"\r\n" + "}")
                .pathParam("ISBN", APIGlobalVariables.ISBN)
                .when()
                .put(APIConstants.PUT_BOOKS);
	
		Assertions.assertEquals(response.jsonPath().getString("userId"), APIGlobalVariables.USER_ID);
		Assertions.assertEquals(response.jsonPath().getString("user"), APIGlobalVariables.user);
	}
}
