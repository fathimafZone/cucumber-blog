package stepdefs;

import io.cucumber.java8.En;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.CoreMatchers.equalTo;

public class Assertions implements En {

    public static ValidatableResponse validatableResponse;

    public Assertions() {

        Then("^I should get a successful response with status code (\\d+)$", (Integer statusCode) -> {

            validatableResponse = Steps.response.then().statusCode(statusCode);
            Attachment.reportGeneration(Steps.requestSpecification, Steps.response);

        });

        And("^user id should be (\\d+)$", (Integer id) -> {

            validatableResponse.body("data.id", equalTo(id));

        });

        And("^user first name should be \"([^\"]*)\" and last name should be \"([^\"]*)\"$", (String fName, String lName) -> {

            validatableResponse.body("data.first_name", equalTo(fName));
            validatableResponse.body("data.last_name", equalTo(lName));

        });

    }

}
