package stepDefinitions.APIStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.Us017.TestItemPojo;
import pojos.Us017.TestItemPost;
import utilities.ConfigReader;


import java.io.IOException;



import static io.restassured.RestAssured.given;

import static utilities.ReusableMethods.generateToken1;
import static org.junit.Assert.assertEquals;


public class US017_Api {
    Response response;
    TestItemPojo expectedData;
    TestItemPojo testItem = new TestItemPojo();
    TestItemPost testItems = new TestItemPost();


    @Given("admin given api {string}")
    public void adminGivenApi(String url) {

        RestAssured.baseURI = url;
        expectedData = new TestItemPojo("medunnat50", "2022-08-23T18:15:25.983593Z", 221948
                , "Frances", "Schultz", 4.00, "0", "5");
    }


    @Then("admin sends a Get request to {string}")
    public void adminSendsAGetRequestTo(String endpoint) {
        RestAssured.basePath = endpoint;


        response = given().
                header("Authorization", "Bearer " + generateToken1("medunnaT50", "1234560"))
                .when().get();
        response.prettyPrint();
    }


    @And("Validate the response")
    public void validateTheResponse() throws IOException {

        TestItemPojo actualData = response.as(TestItemPojo.class);

        response.then().assertThat()
                .statusCode(200);

        assertEquals(expectedData.getCreatedBy(), actualData.getCreatedBy());
        assertEquals(expectedData.getId(), actualData.getId());
        assertEquals(expectedData.getCreatedDate(), actualData.getCreatedDate());
        assertEquals(expectedData.getName(), actualData.getName());
        assertEquals(expectedData.getDefaultValMin(), actualData.getDefaultValMin());
        assertEquals(expectedData.getDescription(), actualData.getDescription());
        assertEquals(expectedData.getDefaultValMax(), actualData.getDefaultValMax());


    }

    @Given("Admin send the post request")
    public void adminSendThePostRequest() {


        testItems.setCreatedBy("medunna");
        testItems.setCreatedDate("2022-08-23T18:14:44.983593Z");
        testItems.setName("Harun");
        testItems.setDescription("kanTesti");

        testItems.setDefaultValMin("16");
        testItems.setDefaultValMax("50");


        response = given().headers(
                        "Authorization",
                        "Bearer " + generateToken1("medunnaT50", "1234560"),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when().body(testItems)
                .post("https://www.medunna.com/api/c-test-items/")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        response.prettyPrint();


    }

    @And("Admin post request validation yapar")
    public void adminPostRequestValidationYapar() {
        response.then().assertThat().statusCode(201);

    }

}












