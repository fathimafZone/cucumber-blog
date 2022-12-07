package stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java8.En;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.After;

import static io.restassured.RestAssured.given;

public class Steps implements En {

    public static RequestSpecification requestSpecification;
    public static Response response;

    public Steps() {

        When("^I click search users$", () -> {

            response = requestSpecification.when().get("https://reqres.in/api/users");
            response.prettyPrint();

        });

        Given("^I want to search for user id (\\d+)$", (Integer userId) -> {

            requestSpecification = given().pathParam("id", userId);

        });

        When("^I click search user$", () -> {

            response = requestSpecification.when().get("https://reqres.in/api/users/{id}");
            response.prettyPrint();

        });

    }

}
