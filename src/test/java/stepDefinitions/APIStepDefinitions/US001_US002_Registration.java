package stepDefinitions.APIStepDefinitions;

import baseURLs.MedunnaBaseUrl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pages.MertPage;

import pojos.Us001.US001_US002_RegistrationPojo;
import utilities.ConfigReader;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static utilities.JSUtils.moveToElementJS;
import static utilities.ReusableMethods.*;


public class US001_US002_Registration extends MedunnaBaseUrl {
    MertPage mertPage = new MertPage();
    US001_US002_RegistrationPojo[] users;
    US001_US002_RegistrationPojo expectedData;
    US001_US002_RegistrationPojo actualData;
    ObjectMapper obj = new ObjectMapper();
    Faker faker = new Faker();

    Response response;
    int UIcounter;

    int APIcounter;

    @Given("Kullanici medunna ana sayfasina admin hesabi ile giris yapar")
    public void kullaniciMedunnaAnaSayfasinaAdminHesabiIleGirisYapar() {
        adminLogin();
    }

    @Given("Kullanici user management sayfasina gider")
    public void kullaniciUserManagementSayfasinaGider() {
        waitFor(2);
        mertPage.administrationButton.click();
        waitFor(2);
        mertPage.userManagementButton.click();

    }

    @Then("Kullanici toplam kullanici sayisini elde eder")
    public void kullaniciToplamKullaniciSayisiniEldeEder() {
        moveToElementJS(mertPage.usersResultMessage);
        UIcounter = Integer.parseInt(mertPage.usersResultMessage.getText().substring(18, 22));

    }

    @Given("Kullanici API ile get request olusturarak tum kayitli kullanicilarin bilgilerini alir")
    public void kullaniciAPIIleGetRequestOlusturarakTumKayitliKullanicilarinBilgileriniAlir() {
        response = given().headers("Authorization", "Bearer " + generateToken(), "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON).when().get(ConfigReader.getProperty("users_endpoint"));
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
    }

    @Then("Kullanici get request ile gelen cevabi kaydeder ve toplam kullanici sayisini kaydeder")
    public void kullaniciGetRequestIleGelenCevabiKaydederVeToplamKullaniciSayisiniKaydeder() {
        try {
            users = obj.readValue(response.asString(), US001_US002_RegistrationPojo[].class);
            System.out.println(users.length);
            APIcounter = users.length;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @And("Kullanici beklenen kullanici sayisi ile gercekte olan kullanici sayisini karsilastir")
    public void kullaniciBeklenenKullaniciSayisiIleGercekteOlanKullaniciSayisiniKarsilastir() {
        assertEquals(UIcounter, APIcounter);

    }

    @Given("Kullanici kayit etmek istedigi kullanicinin bilgilerini olusturur")
    public void kullaniciKayitEtmekIstedigiKullanicininBilgileriniOlusturur() {
        String ssn = faker.idNumber().ssnValid();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String username = faker.name().username();
        String email = faker.internet().emailAddress();


        expectedData = new US001_US002_RegistrationPojo(ssn, firstName, lastName, username, email);

    }

    @Given("Kullanici API ile post request olusturarak yeni bir kullanici kayit eder")
    public void kullaniciAPIIlePostRequestOlusturarakYeniBirKullaniciKayitEder() {
        setUp();
        spec.pathParams("first", "api", "second", "users");
        response = given().spec(spec).headers("Authorization", "Bearer "+generateToken(),
                "Content-Type",ContentType.JSON, "Accept", ContentType.JSON)
                .body(expectedData).when().post("/{first}/{second}");

    }


    @Then("Kullanici API ile gelen cevabi kaydeder ve alinan cevap ile beklenen cevabi karsilastirir")
    public void kullaniciAPIIleGelenCevabiKaydederVeAlinanCevapIleBeklenenCevabiKarsilastirir() {

        actualData = response.as(US001_US002_RegistrationPojo.class);

        assertEquals(expectedData.getSsn(), actualData.getSsn());
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getLogin(), actualData.getLogin());
        assertEquals(expectedData.getEmail(), actualData.getEmail());


    }

    @And("Kullanici sistemde kayitli oldugunu bildigi bir {string} in response icerisinde oldugunu dogrular")
    public void kullaniciSistemdeKayitliOldugunuBildigiBirInResponseIcerisindeOldugunuDogrular(String username) {
        response.then().assertThat().body("login", hasItem(username));
    }

    @And("Kullanici sistemde kayitli oldugunu bildigi bir {string} adresinin response icerisinde oldugunu dogrular")
    public void kullaniciSistemdeKayitliOldugunuBildigiBirAdresininResponseIcerisindeOldugunuDogrular(String email) {
        response.then().assertThat().body("email", hasItem(email));
    }

}
