package api.core.v1;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class ChargersTest extends BaseTest {
    private static final String CHARGERS_ENDPOINT = "/chargers/";
    private static final String VALID_CHARGER_ID = "bbc17e61-ac93-4efa-899c-c1f3467cb0ef";
    private static final String INVALID_CHARGER_ID = "invalid-charger-id";

    @Test
    public void testGetChargerDetailsWithValidId() {
        Response response = sendGetRequest(CHARGERS_ENDPOINT + VALID_CHARGER_ID);

        Assert.assertEquals(response.statusCode(), 200, "Expected status code is 200");

        Assert.assertEquals(response.jsonPath().getString("chargerId"), VALID_CHARGER_ID, "Charger ID should match");

        // TODO To investigate which specific data to expect
        Assert.assertNotNull(response.jsonPath().getString("name"), "Charger name should not be null");
        Assert.assertNotNull(response.jsonPath().getString("type"), "Charger type should not be null");
        Assert.assertNotNull(response.jsonPath().getString("model"), "Charger model should not be null");

        Map<String, Object> location = response.jsonPath().getMap("location");
        Assert.assertNotNull(location.get("name"), "Location name should not be null");
        Assert.assertNotNull(location.get("latitude"), "Location latitude should not be null");
        Assert.assertNotNull(location.get("longitude"), "Location longitude should not be null");

        List<Map<String, Object>> ports = response.jsonPath().getList("ports");
        Assert.assertFalse(ports.isEmpty(), "Charger should have at least one port");
        for (Map<String, Object> port : ports) {
            Assert.assertNotNull(port.get("portId"), "Port ID should not be null");
            Assert.assertNotNull(port.get("status"), "Port status should not be null");
            Assert.assertNotNull(port.get("maxPowerKilowatts"), "Port max power should not be null");
        }

        Map<String, Object> pricing = response.jsonPath().getMap("currentPrice");
        Assert.assertNotNull(pricing.get("currency"), "Currency should not be null");
        Assert.assertNotNull(pricing.get("unitPrice"), "Unit price should not be null");
    }

    @Test
    public void testGetChargerDetailsWithInvalidId() {
        Response response = sendGetRequest(CHARGERS_ENDPOINT + INVALID_CHARGER_ID);

        Assert.assertEquals(response.statusCode(), 404, "Expected status code is 404");
    }
}
