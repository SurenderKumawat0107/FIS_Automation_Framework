package Automation;

import Automation.APIAutomation.CoinDeskAPI;
import Automation.APIAutomation.ResponseValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CoinDeskAPITest {


    @Test
    public void testBpiEndPoint() {
        CoinDeskAPI coinDeskAPI = new CoinDeskAPI();

        Response response = null;
        try {
            // Send the GET request and get the response
            response = coinDeskAPI.getCurrentPrice();

            // If response is null, throw an exception
            if (response == null) {
                throw new RuntimeException("Response is null, GET request failed.");
            }
                Assert.assertEquals(response.getStatusCode(), 200, "Status Code is not 200");

                // Verify that the response contains the 3 BPIs (USD, GBP, EUR)
                Assert.assertTrue(ResponseValidator.validateBPIKeys(response), "BPIs (USD, GBP, EUR) are not present in the response");

                // Verify that the GBP description is "British Pound Sterling"
                Assert.assertTrue(ResponseValidator.validateGBPDescription(response), "GBP description is not correct");



        } catch (RuntimeException e) {
            System.err.println("Test failed: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error occurred: " + e.getMessage());
        }

    }

}
