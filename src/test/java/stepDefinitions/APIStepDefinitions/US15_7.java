package stepDefinitions.APIStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import pojos.Us015.PatientsPojo;

import static org.junit.Assert.assertEquals;
import static utilities.ReusableMethods.generateToken1;

public class US15_7 {
    static Response response;


    @Given("adminn given api {string}")
    public void adminnGivenApi(String url) {
        RestAssured.baseURI=url;
    }

    @When("admin send a Get request to {string}")
    public void adminSendAGetRequestTo(String endpoint) {
        RestAssured.basePath=endpoint;
        response = RestAssured.given().
                header("Authorization", "Bearer " + generateToken1("medunnaT50", "1234560"))
                .when().get();
        response.prettyPrint();
    }

    @Then("Kullanici {string}, {string}{string}, {string}, {string}, {string} bilgilerini validate eder")
    public void kullaniciBilgileriniValidateEder(String id, String firstName, String lastName, String phone, String adress, String description) {
        PatientsPojo actualData = response.as(PatientsPojo.class);
        assertEquals(Integer.parseInt(id),actualData.getId());
        assertEquals(firstName,actualData.getFirstName());
        assertEquals(lastName,actualData.getLastName());
        assertEquals(phone,actualData.getPhone());
        assertEquals(adress,actualData.getAdress());
        assertEquals(description,actualData.getDescription()
        );
    }


    // response= ReusableMethods.generateToken(),
    //         ConfigReader.getProperty("patientsEndPoint")+"/"+
    //                 ReadToTxt.readLastLinePatientList("src/test/resources/TestData/pasitionId.txt", 1);

}
