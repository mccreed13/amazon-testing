package api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseAPITest {
    private static final String BASE_URL_POS = "https://petstore.swagger.io/v2";


    @BeforeClass
    static void setUp() {
        RestAssured.baseURI = BASE_URL_POS;
    }
}
