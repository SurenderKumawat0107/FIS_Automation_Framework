package Automation.APIAutomation;

import io.restassured.response.Response;

public class ResponseValidator {


    public static boolean validateBPIKeys(Response response){

        String responseString = response.body().asString();
        return responseString.contains("\"USD\"") && responseString.contains("\"GBP\"") && responseString.contains("\"EUR\"");
    }

    public static boolean validateGBPDescription(Response response){

        String gbpDescription = response.jsonPath().getString("bpi.GBP.description");

        return "British Pound Sterling".equals(gbpDescription);
    }
}
