package base;

import org.junit.jupiter.api.BeforeAll;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;

public class BaseTest {

	protected static RequestSpecification requestSpec;

	@BeforeAll
	public static void setUp() {
		RestAssured.baseURI = APIConstants.BASE_URI;

		requestSpec = new RequestSpecBuilder().setBaseUri(APIConstants.BASE_URI).setContentType("application/json")
				.build();
	}
}
