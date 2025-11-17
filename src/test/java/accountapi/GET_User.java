package accountapi;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;

public class GET_User {

	@Test
	public void getUser() {
		RestAssured.baseURI = APIConstants.BASE_URI;
		RequestSpecification request = RestAssured.given();
		request.pathParam("UUID", "d329e635-46f9-444a-b9c9-268cec46b4b2");

		Response response = request.when().get(APIConstants.GET_USER);

		System.out.println(response.asString());

	}
}
