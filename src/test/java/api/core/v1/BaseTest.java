package api.core.v1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    protected static final String BASE_URL = "https://api.v1.dev.chargelab.io/core/v1";
    protected static final String AUTH_TOKEN = "9TGJS4KHBOA1ZRNDOLGGFHWFPIO:8ec4bb01c9dcd5a7aec724a4e561e25a70f86db10b75bb13eebdac3eee7bff86";
    protected static final String AUTH_HEADER = "Authorization";
    protected static final String AUTH_HEADER_VALUE = "x-auth " + AUTH_TOKEN;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    protected Response sendGetRequest(String endpoint) {
        return RestAssured.given()
                .header(AUTH_HEADER, AUTH_HEADER_VALUE)
                .when()
                .get(endpoint);
    }

    protected Response sendGetRequestWithQueryParam(String endpoint, String paramKey, String paramValue) {
        return RestAssured.given()
                .header(AUTH_HEADER, AUTH_HEADER_VALUE)
                .queryParam(paramKey, paramValue)
                .when()
                .get(endpoint);
    }
}
