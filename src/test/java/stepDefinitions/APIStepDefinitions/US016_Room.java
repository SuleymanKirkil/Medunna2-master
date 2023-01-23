package stepDefinitions.APIStepDefinitions;

import baseURLs.MedunnaBaseUrl;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.US016.US016_Rest;
import pojos.US016.US016_RoomPost;
import pojos.US016.US016_RoomPut;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import static utilities.ReusableMethods.generateToken1;


public class US016_Room extends MedunnaBaseUrl {
    Response response;

   @When("kullanici  {string} get request gonderir")
   public void kullaniciRequestGonderir(String endpoint) {
       RestAssured.basePath = endpoint;
       spec.pathParams("1", "api", "2", "rooms", "3", 203046);
       response = given().spec(spec).
               header("Authorization", "Bearer " + generateToken1("Defne", "3456780"))
               .when().get("/{1}/{2}/{3}");
       response.prettyPrint();


   }


   @Given("kullanici beklenen verileri {string}, {string},{string}, {string} and {string},{string},{string} olarak ayarlar.")
   public void kullaniciBeklenenVerileriAndOlarakAyarlar(String description, String price, String roomNumber, String roomType, String createdBy, String createdDate, String id) {

       US016_Rest actualData = response.as(US016_Rest.class);
       assertEquals(description, actualData.getDescription());
       assertEquals(Integer.parseInt(id), actualData.getId());
       assertEquals(Integer.parseInt(price), actualData.getPrice());
       assertEquals(Integer.parseInt(id), actualData.getId());


   }

   @Then("kullanici odalar icin status kodu {int} olarak ayarlar.")
   public void kullaniciOdalarIcinStatusKoduOlarakAyarlar(int expectedData) {

       int acutualStatusCode = response.getStatusCode();
       Assert.assertEquals(expectedData, acutualStatusCode);

   }

   @When("admin sends a Get request to {string}")
   public void adminSendsAGetRequestTo(String endpoint) {
       RestAssured.basePath = endpoint;
       response = RestAssured.given().
               header("Authorization", "Bearer " + generateToken1("Defne", "3456780")).contentType(ContentType.JSON)
               .when().get();
       response.prettyPrint();
   }

   @Then("Kullanici {string}, {string}{string}, {string}, {string} bilgilerini validate eder")
   public void kullaniciBilgileriniValidateEder(String id, String description, String price, String roomNumber, String roomType) {
       US016_Rest actualData = response.as(US016_Rest.class);
       assertEquals(Integer.parseInt(id), actualData.getId());
   }

   @When("admin sends a post request to")
   public void adminSendsAPostRequestTo() {
       //RestAssured.basePath = endpoint;
       Faker faker = new Faker();
       int number=faker.number().numberBetween(100,10000);
      US016_RoomPost postBody = new US016_RoomPost("Team50",null,null,333,10044,"DELUXE",false);
       System.out.println(postBody);

       response = RestAssured.given()
               .headers("Authorization",
                       "Bearer "+generateToken1("Defne", "3456780"),
                       "Content-Type",
                       ContentType.JSON,
                       "Accept",
                       ContentType.JSON).body(postBody).when().
               post("https://medunna.com/api/rooms");
       response.prettyPrint();
   }

   @Then("Kullanici {string}{string}, {string}, {string} bilgilerini validate eder")
   public void kullaniciBilgileriniValidateEder(String Description, String Price, String RoomType, String RoomNumber) {

       US016_RoomPut actualData = response.as(US016_RoomPut.class);
       System.out.println(actualData.getDescription());
       System.out.println(Description);

        assertEquals(Description, actualData.getDescription());
        assertEquals(Integer.parseInt(Price), actualData.getPrice());
       // assertEquals(RoomType, actualData.getRoomType());
       // assertEquals(RoomNumber, actualData.getRoomNumber());
   }

   @Given("Admin URL'e oda icin delete istegi gonderir")
   public void adminURLEOdaIcinDeleteIstegiGonderir() {

       //spec.pathParams("1", "api", "2", "rooms", "3", 203046);
       response = given().
               header("Authorization", "Bearer " + generateToken1("Defne", "3456780"))
               .when().delete("https://medunna.com/api/rooms/242964");
       response.prettyPrint();



   }

   @And("Kullanici response cod {int} oldugunu dogrular")
   public void kullaniciResponseCodOldugunuDogrular(int expectedData) {

       int acutualStatusCode = response.getStatusCode();
       Assert.assertEquals(expectedData, acutualStatusCode);

   }

   @Given("kullanici roomlar icin put request yapar")
   public void kullaniciRoomlarIcinPutRequestYapar() {

       /*
{
   "createdBy": "defne",
   "createdDate": "2022-08-28T12:11:17.197227Z",
   "id": 239482,
   "roomNumber": 10029,
   "roomType": "DELUXE",
   "status": false,
   "price": 333,
   "description": "Team50"
}
        */

      // RestAssured.basePath = endpoint;
       US016_RoomPut postBody = new US016_RoomPut();

       postBody.setDescription("++");
       postBody.setId(239497);
       postBody.setPrice(600);
       postBody.setRoomType("TWIN");
       postBody.setRoomNumber(1451);
       postBody.setCreatedBy("Defne");

       response = RestAssured.given()
               .headers("Authorization",
               "Bearer "+generateToken1("Defne", "3456780"),
               "Content-Type",
               ContentType.JSON,
               "Accept",
               ContentType.JSON).body(postBody).when().
             put("https://medunna.com/api/rooms");

       response.prettyPrint();
   }



}









