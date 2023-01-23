package stepDefinitions.APIStepDefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Us007.US007_Appointment;


import java.io.IOException;

import static io.restassured.RestAssured.given;
import static utilities.ReusableMethods.generateToken1;


public class US007 {
    Response response;
    US007_Appointment[] appointments;

    @Given("Kullanici randevu bilgilerini get request eder")
    public void kullaniciRandevuBilgileriniGetRequestEder() {

        RestAssured.baseURI = "https://medunna.com";
        RestAssured.basePath = "/api/appointments/patient/181316";
        response = given().
                header("Authorization", "Bearer " + generateToken1("HastaTeam50", "m.team50"))
                .when().get();
        response.prettyPrint();
    }

    @When("Kullanici gelen randevu bilgilerini deserialize eder")
    public void kullaniciGelenRandevuBilgileriniDeserializeEder() throws IOException {
        ObjectMapper obj = new ObjectMapper();

        appointments = obj.readValue(response.asString(), US007_Appointment[].class);
        System.out.println("appointments lenght : " + appointments.length);
    }


    @Then("Kullanici {string} , {string} , {string} , {string} , {string} bilgilerini Validate eder")
    public void kullaniciBilgileriniValidateEder(String patient_id, String firstname, String lastname, String phone, String email) {
        for (int i = 0; i < appointments.length; i++) {

            if (appointments[i].getPatient() != null)
                System.out.println(appointments[i].getPatient().getId());
            System.out.println(appointments[i].getPatient().getFirstName());
            System.out.println(appointments[i].getPatient().getLastName());
            System.out.println(appointments[i].getPatient().getPhone());
            System.out.println(appointments[i].getPatient().getEmail());
        }

        Assert.assertEquals(Integer.parseInt(patient_id), appointments[1].getPatient().getId());
        Assert.assertEquals(firstname, appointments[1].getPatient().getFirstName());
        Assert.assertEquals(lastname, appointments[1].getPatient().getLastName());
        Assert.assertEquals(phone, appointments[1].getPatient().getPhone());
        Assert.assertEquals(email, appointments[1].getPatient().getEmail());

    }

}