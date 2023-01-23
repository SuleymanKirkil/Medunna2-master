package stepDefinitions.APIStepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.US027.US027_MessagesGet;
import pojos.US027.US027_MessagesPost;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.ReusableMethods.generateToken1;

public class US027 {

    Response response;

    US027_MessagesPost messagesPost=new US027_MessagesPost();
    US027_MessagesGet messagesGet=new US027_MessagesGet();

    @Given("Admin mesajlar bilgileri icin post request yapar")
    public void admin_mesajlar_bilgileri_icin_post_request_yapar() {

        messagesPost.setName("medunna50");
        messagesPost.setEmail("medunna50@gmail.com");
        messagesPost.setSubject("hayat");
        messagesPost.setMessage("hayat guzeldir");


       response = given().headers(
                       "Authorization",
                       "Bearer " + generateToken1("medunnaT50","1234560"),
                       "Content-Type",
                       ContentType.JSON,
                       "Accept",
                       ContentType.JSON)
               .when().body(messagesPost)
               .post("https://www.medunna.com/api/c-messages")
               .then()
               .contentType(ContentType.JSON)
               .extract()
               .response();
       response.prettyPrint();

    }

    @Then("Admin post request Validation yapar")
    public void admin_post_request_Validation_yapar() {

      JsonPath json = response.jsonPath();

      assertEquals(messagesPost.getName(), json.getString("name"));

      assertEquals(messagesPost.getEmail(), json.getString("email"));

      assertEquals(messagesPost.getSubject(), json.getString("subject"));
      assertEquals(messagesPost.getMessage(), json.getString("message"));


    //   response.then().assertThat().statusCode(201);
    //   response.then().assertThat().
    //           body("name", equalTo("medunna50")).
    //           body("email",equalTo("medunna50@gmail.com")).
    //           body("subject",equalTo("hayat")).
    //           body("message", equalTo("hayat guzeldir"));

    }


    @Given("Admin mesaj bilgileri icin get request yapar")
    public void adminMesajBilgileriIcinGetRequestYapar() {
        RestAssured.baseURI = "https://medunna.com";
        RestAssured.basePath = "/api/c-messages/235517";
        response = given().
                header("Authorization", "Bearer " + generateToken1("medunnaT50","1234560"))
                .when().get();
        response.prettyPrint();
    }

    @When("Admin gelen mesaj bilgilerini deserialize eder")
    public void adminGelenMesajBilgileriniDeserializeEder() throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();

        messagesGet= obj.readValue(response.asString(), US027_MessagesGet.class);

    }

  // @Then("Admin mesaj bilgilerini validate eder")
  // public void adminMesajBilgileriniValidateEder() {
  //     Assert.assertEquals("medunna50", messagesGet.getName());
  //     Assert.assertEquals(Integer.parseInt("217334"), messagesGet.getId());
  //     Assert.assertEquals("medunna50@gmail.com", messagesGet.getEmail());
  //     Assert.assertEquals("hayat", messagesGet.getSubject());
  //     Assert.assertEquals("hayat guzeldir", messagesGet.getMessage());


  // }

    @Then("Admin {string}, {string}, {string}, {string}, {string} bilgilerini validate eder")
    public void adminBilgileriniValidateEder(String email, String id, String message, String name, String subject) {


        assertEquals(name, messagesGet.getName());
        assertEquals(Integer.parseInt(id), messagesGet.getId());
        assertEquals(email, messagesGet.getEmail());
        assertEquals(subject, messagesGet.getSubject());
        assertEquals(message, messagesGet.getMessage());





    }
}
