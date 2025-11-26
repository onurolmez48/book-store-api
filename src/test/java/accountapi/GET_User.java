package accountapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.APIConstants;
import utils.TokenManager;

public class GET_User extends BaseTest{

	@Test
	public void getUser() {
        String token = TokenManager.getToken();
        String userId = "d329e635-46f9-444a-b9c9-268cec46b4b2";

        Response response = RestAssured.given()
                .spec(requestSpec) 
                .header("Authorization", "Bearer " + token)
                .pathParam("UUID", userId)
                .when()
                .get(APIConstants.GET_USER);

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("onurolmez", response.jsonPath().getString("username"));

	}
}
