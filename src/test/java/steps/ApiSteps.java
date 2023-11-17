package steps;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.MainConfig;
import enums.Codes;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import pojo.error.CurrentErrorResponseBody;
import pojo.responce.CurrentResponseBody;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ApiSteps {

    private final MainConfig config = ConfigFactory.create(MainConfig.class, System.getenv());
    private final SoftAssertions softAssertions = new SoftAssertions();
    private Response response;
    private RequestSpecification requestSpecification;

    @ParameterType(".*")
    public Codes code(String code) {
        return Codes.valueOf(code);
    }

    @Given("Get request specification")
    public void getRequestSpec() {
        RestAssured.baseURI = config.url();
        requestSpecification = RestAssured
                .given()
                .contentType("application/json")
                .accept("*/*");
    }

    @When("Send request {string} with parameter {string}")
    public void sendRequestToEndpointCurrentWithQueryParameter(String endpoint, String query) throws URISyntaxException {
        response = requestSpecification.when().get(new URI(endpoint + "?access_key=" + config.accessKey() + "&query=" + query));
    }

    @When("Send request {string} with parameters {string}, {string}")
    public void sendRequestToEndpointCurrentWithAccessQueryUnitParameters(String endpoint, String accessKey, String query) throws URISyntaxException {
        response = requestSpecification.when().get(new URI(endpoint + "?access_key=" + accessKey + "&query=" + query));
    }


    @Then("Check response {string},{string},{string}")
    public void verifyResponseData(String name, String country, String utcOffset) throws JsonProcessingException, ParseException {
        response = response.then().statusCode(200).extract().response();
        ObjectMapper mapper = new ObjectMapper();
        CurrentResponseBody myResponse = mapper.readValue(response.asString(), CurrentResponseBody.class);

        Date timePoint = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date localtime = dateFormat.parse(myResponse.getLocation().getLocaltime());

        softAssertions.assertThat(myResponse.getRequest().getType()).isEqualTo("City");
        softAssertions.assertThat(myResponse.getRequest().getLanguage()).isEqualTo("en");

        softAssertions.assertThat(myResponse.getLocation().getName()).isEqualTo(name);
        softAssertions.assertThat(myResponse.getLocation().getCountry()).isEqualTo(country);
        softAssertions.assertThat(myResponse.getLocation().getUtcOffset()).isEqualTo(utcOffset);
        softAssertions.assertThat(dateFormat.format(localtime)).isEqualTo(dateFormat.format(timePoint));
        softAssertions.assertAll();
    }

    @Then("Check error body {code},{string}")
    public void checkErrorBodyParameters(Codes code, String info) throws JsonProcessingException {
        response = response.then().statusCode(200).extract().response();
        ObjectMapper mapper = new ObjectMapper();
        CurrentErrorResponseBody myResponse = mapper.readValue(response.asString(), CurrentErrorResponseBody.class);

        softAssertions.assertThat(myResponse.isSuccess()).isFalse();

        softAssertions.assertThat(myResponse.getError().getCode()).isEqualTo(code.getValue());
        softAssertions.assertThat(myResponse.getError().getType()).isEqualTo(code.getType());
        softAssertions.assertThat(myResponse.getError().getInfo()).isEqualTo(info);
        softAssertions.assertAll();
    }
}
