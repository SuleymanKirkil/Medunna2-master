package stepDefinitions.APIStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import pojos.Us009.PatientPojo;
import utilities.ConfigReader;
import utilities.JsonUtil;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class US_009_Api
{

    /*
    {
        "createdBy": "anonymousUser",
        "createdDate": "2021-12-16T16:34:24.652207Z",
        "id": 2551,
        "firstName": "Doctor",
        "lastName": "Doctor",
        "birthDate": null,
        "phone": "222-333-2322",
        "gender": "MALE",
        "bloodGroup": "ABnegative",
        "adress": null,
        "email": "doctor@email.com",
        "description": null,
        "user": {
            "createdBy": "anonymousUser",
            "createdDate": "2021-12-14T10:38:26.705059Z",
            "id": 2001,
            "login": "doctor",
            "firstName": "Doctor",
            "lastName": "Doctor",
            "email": "doctore@email.com",
            "activated": true,
            "langKey": "en",
            "imageUrl": null,
            "resetDate": null,
            "ssn": "234-55-3432"
        },
        "appointments": null,
        "inPatients": null,
        "country": {
            "id": 1201,
            "name": "Türkye"
        },
        "cstate": {
            "id": 1262,
            "name": "Hawaii",
            "country": {
                "id": 1201,
                "name": "Türkye"
            }
        }
    }



     */

    RequestSpecification spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("medunnaURL")).build();
    Response response;
    PatientPojo patient;

    @Given("User sets the path params to read patient info")
    public void user_sets_the_path_params_to_read_patient_info() {

        spec.pathParams("first","api","second","patients");

    }

    @When("User send get request for patient info and get response")
    public void user_send_get_request_for_patient_info_and_get_response() {

        //response = given().headers("Authorization","Bearer "+generateToken(ConfigReader.getProperty("adminUsername"), ConfigReader.getProperty("adminPassword")),
        //        "Content-Type", ContentType.JSON,"Accept",ContentType.JSON).when()
        //        .get(ConfigReader.getProperty("patients_endpoint"));




    }
    @Then("User validates patient info {string} {string} {string} {string} .")
    public void user_validates_patient_info(String firstname, String lastname, String email, String ssn) {

        response.then().assertThat().statusCode(200);
        patient = JsonUtil.convertJsonToJavaObject(response.asString(),PatientPojo.class);

        Assert.assertEquals(patient.getFirstName(),firstname);
        Assert.assertEquals(patient.getLastName(),lastname);
        Assert.assertEquals(patient.getEmail(),email);
        Assert.assertEquals(patient.getUser().getSsn(), ssn);


    }

    @When("User send get request for {string} numbered patient info and get response")
    public void userSendGetRequestForNumberedPatientInfoAndGetResponse(String id) {

        response=given()
                .headers(
                        "Authorization",
                        "Bearer "+ generateTokenStepDef(),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON
                )
                .when()
                .get("https://medunna.com/api/patients/" + id);

        response.prettyPrint();

    }

    public static String generateTokenStepDef(){

        RequestSpecification spec;
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("medunnaURL")).build();

        spec.pathParams("first", "api", "second", "authenticate");

        //Set the expected data

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("username", "medunnaT50");
        expectedData.put("password", "1234560");
        expectedData.put("rememberMe","true" );

        //Send the Post request and get the data
        Response response = given().spec(spec).contentType(ContentType.JSON).
                body(expectedData).when().post("/{first}/{second}");

        // response.prettyPrint();
        JsonPath json = response.jsonPath();



        return json.getString("id_token");

    }
}
