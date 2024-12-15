package api.core.v1;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompletedTransactionsTest extends BaseTest {

    private static final String COMPLETED_TRANSACTIONS_ENDPOINT = "/completedTransactions";
    private static final String ROLE_PARAM = "role";
    private static final String ROLE_COMPANY = "COMPANY";

    @Test
    public void testGetCompletedTransactionsWithoutRole() {
        Response response = sendGetRequest(COMPLETED_TRANSACTIONS_ENDPOINT);

        Assert.assertEquals(response.statusCode(), 200, "Expected status code is 200");
//       The list is empty, but in other case at least this verification could be:
//       Assert.assertTrue(response.jsonPath().getList("entities").size() > 0, "Transactions list should not be empty");
    }

    @Test
    public void testGetCompletedTransactionsWithCompanyRole() {
        Response response = sendGetRequestWithQueryParam(COMPLETED_TRANSACTIONS_ENDPOINT, ROLE_PARAM, ROLE_COMPANY);

        Assert.assertEquals(response.statusCode(), 200, "Expected status code is 200");
//       The list is empty, but in other case at least this verification could be:
//        Assert.assertTrue(response.jsonPath().getList("entities").stream()
//                        .allMatch(entity -> CHARGER_ID.equals(((Map<String, Object>) entity).get("charger.chargerId"))),
//                "All transactions should belong to the specified charger ID");
    }
}
