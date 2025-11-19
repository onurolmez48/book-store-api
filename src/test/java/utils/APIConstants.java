package utils;

public class APIConstants {

	public static final String BASE_URI = "https://demoqa.com/";

	public static final String POST_USER_ENDPOINT = "Account/v1/User";
	public static final String POST_GENERET_TOKEN_ENDPOINT = "Account/v1/GenerateToken";
	public static final String POST_AUTHORIZED = "Account/v1/Authorized";
	public static final String GET_USER = "Account/v1/User/{UUID}";
	public static final String DELETE_USER = "Account/v1/User/{UUID}";

	public static final String BOOKS = "BookStore/v1/Books";
	public static final String BOOK = "BookStore/v1/Book";
	public static final String PUT_BOOKS = "BookStore/v1/Books/{ISBN}";
}
