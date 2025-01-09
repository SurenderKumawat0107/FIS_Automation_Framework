package Automation.APIAutomation;


import io.restassured.RestAssured;
import io.restassured.response.Response;


public class CoinDeskAPI {


    public Response getCurrentPrice() {
        Response response = null;
        try {
            response = RestAssured.get("https://api.coindesk.com/v1/bpi/currentprice.json");
        } catch (Exception e) {
            System.err.println("An error occurred while sending GET request: " + e.getMessage());
        }
        return response;
    }

}
