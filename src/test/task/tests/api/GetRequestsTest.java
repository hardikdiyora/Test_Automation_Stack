package task.tests.api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import java.util.List;

public class GetRequestsTest extends APITestBase {
    private String route_api;
    private static Response response;

    @BeforeMethod
    void setup_Route(){
        route_api = "/rest/v1";
    }

    @Test
    void verfityCountryPresent(){
        Log.info("Verify a certain country is present in response result");
        response = get(baseURI+route_api)
                .then()
                .statusCode(200)
                .extract().response();
        List<String> countries = response.path("name");
        Assert.assertTrue(countries.contains("India"));
    }
}
