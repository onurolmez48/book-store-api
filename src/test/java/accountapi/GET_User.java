package accountapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;
import utils.APIGlobalVariables;

public class GET_User {

	@Test
	public void getUser() {
		RestAssured.baseURI = APIConstants.BASE_URI;

		RequestSpecification request = RestAssured.given().header("Authorization",
				"Bearer " + APIGlobalVariables.TOKEN);

		request.pathParam("UUID", APIGlobalVariables.USER_ID);

		Response response = request.when().get(APIConstants.GET_USER);

		response.prettyPrint();

		Assertions.assertEquals(response.statusCode(), 200);
		Assertions.assertEquals(response.jsonPath().getString("username"), APIGlobalVariables.user);
		Assertions.assertEquals(response.jsonPath().getString("userId"), APIGlobalVariables.USER_ID);

	}
}
