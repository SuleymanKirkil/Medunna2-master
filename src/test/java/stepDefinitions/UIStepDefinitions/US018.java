package stepDefinitions.UIStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.AsimPage;
import pojos.Us010.Physician;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.DBUtils.createConnection;
import static utilities.DBUtils.getColumnData;
import static utilities.ReusableMethods.*;

public class US018 {
    AsimPage admin = new AsimPage();
    static Faker faker = new Faker();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Actions action = new Actions(Driver.getDriver());
    Random num = new Random();
    public static String fakeFirstName = faker.name().firstName();
    static String fakeLastName = faker.name().lastName();
    static String fakeAdress = faker.address().fullAddress();
    static String fakePhoneNum = faker.phoneNumber().subscriberNumber(3) +"-"+ faker.phoneNumber().subscriberNumber(3) +"-"+ faker.phoneNumber().subscriberNumber(4);
    Response response;
    String specificDocQuery;
    List<Object> idList;
    List<Object> firstnameList;
    List<Object> lastnameList;
    List<Object> phoneList;
    List<Object> specialityList;


    @Given("Admin medunnaURl adresine gider")
    public void adminMedunnaURlAdresineGider() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaURL"));
    }

    @Then("Admin account menu altinda bulunan sign in kismindan giris yapar")
    public void adminAccountMenuAltindaBulunanSignInKismindanGirisYapar() {
        admin.accountMenu.click();
        waitFor(1);
        admin.signInButton.click();
        waitFor(1);
        admin.usernameBox.sendKeys(ConfigReader.getProperty("adminUsername"));
        waitFor(1);
        admin.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        waitFor(1);
        admin.secondSignIn.click();
        waitFor(1);

    }


    @And("Admin Items&Titles menusunden Physician butonuna tiklar")
    public void adminItemsTitlesMenusundenPhysicianButonunaTiklar() {
        admin.itemsAndTitlesMenu.click();
        waitFor(1);
        admin.physicianOption.click();
        waitFor(2);
    }

    @And("Admin Create a new Physician butonuna tiklar")
    public void adminCreateANewPhysicianButonunaTiklar() {
        admin.createANewPhysicianButton.click();
    }

    @Then("Admin use search checkbox isaretler")
    public void adminUseSearchCheckboxIsaretler() {
        admin.useSearchCheckBox.click();
        waitFor(1);
    }

    @And("Admin {string} kismina ilgili physician ssn girer")
    public void adminKisminaIlgiliPhysicianSsnGirer(String ssn) {
        admin.ssnTextBox.sendKeys(ssn);
        waitFor(1);
    }

    @Then("Admin search user butonuna tiklar")
    public void adminSearchUserButonunaTiklar() {
        admin.searchUserButton.click();
        waitForVisibility(admin.userFoundText, 8);
    }

    @And("Admin user found with search SSN yazisini goruntuler")
    public void adminUserFoundWithSearchSSNYazisiniGoruntuler() {
        Assert.assertTrue(admin.userFoundText.isDisplayed());
    }

    @And("firstname bolumune yeni isim gonderir")
    public void firstnameBolumuneYeniIsimGonderir() {
        waitFor(3);
        admin.firstNameTextBox.clear();
        admin.firstNameTextBox.sendKeys(fakeFirstName);
    }

    @Then("lastname bolumune yeni lastname gonderir")
    public void lastnameBolumuneYeniLastnameGonderir() {
        admin.lastNameTextBox.clear();
        admin.lastNameTextBox.sendKeys(fakeLastName);
    }

    @And("birth date bolumune yeni birth date gonderir")
    public void birthDateBolumuneYeniBirthDateGonderir() {
        admin.birthDateTextBox.sendKeys("04281992");
    }

    @And("phone bolumune yeni birth phone gonderir")
    public void phoneBolumuneYeniBirthPhoneGonderir() {
        if (admin.phoneTextBox.getText() != null) {
            admin.phoneTextBox.clear();
        }

        admin.phoneTextBox.sendKeys(fakePhoneNum);
    }

    @And("adress bolumune yeni adress gonderir")
    public void adressBolumuneYeniAdressGonderir() {
        if (admin.adressTextBox.getText() != null) {
            admin.adressTextBox.clear();
            admin.adressTextBox.sendKeys(fakeAdress);
            waitFor(2);
        }
    }

    @And("Admin id'ye gore sirala butonuna tiklar")
    public void adminIdYeGoreSiralaButonunaTiklar() {
        waitForClickablity(admin.idSiralamaButonu,10);
        js.executeScript("arguments[0].click();",admin.idSiralamaButonu);
        waitFor(3);
    }

    @And("Uzmanlik alanini farkli bir bolum ile degistirir")
    public void uzmanlikAlaniniFarkliBirBolumIleDegistirirVeKaydetButonuaTiklar() {
        Select select = new Select(admin.specialityMenu);
        select.selectByVisibleText("Dermatology");
        //num.nextInt(15)
        waitFor(5);
    }

    @And("Admin doktor icin yeni bir profil fotosu secer")
    public void doktorIcinYeniBirProfilFotosuSecipKaydeder() {
        js.executeScript("scroll(0, 900);");
        waitFor(2);
        js.executeScript("arguments[0].click();", admin.dosyaSecButonu);
        waitFor(6);
        String path = System.getProperty("user.home") + "\\Desktop\\Doktor1.jpg";
        admin.dosyaSecButonu.sendKeys(path);
        waitFor(2);
    }

    @And("Admin user bolumunden yeni bir user secer")
    public void adminUserBolumundenYeniBirUserSecerVeKaydeder() {
        Select select = new Select(admin.userList);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        select.selectByVisibleText("kullaniciasim2:888-13-8888");
        waitFor(2);
    }

    @And("Admin exam fee bolumune yeni bir deger girer")
    public void adminExamFeeBolumuneYeniBirDegerGirerVeKaydeder() {
        admin.examFeeTextBox.clear();
        waitFor(2);
        int examFee = num.nextInt(1000);
        admin.examFeeTextBox.sendKeys(String.valueOf(examFee));
        waitFor(3);
    }

    @And("Admin {string} nolu sayfaya gider")
    public void adminNoluSayfayaGider(String gidilecekSayfaNo) {
        WebElement sayfaNoButton = Driver.getDriver().findElement(By.xpath("//*[text()='" + gidilecekSayfaNo + "']"));
        js.executeScript("arguments[0].click();", sayfaNoButton);
    }

    @Then("Admin id {string} doktora ait edit butonuna tiklar")
    public void adminIdDoktoraAitEditButonunaTiklar(String id) {
        if (id.equals("210106")) {
            js.executeScript("arguments[0].click();", admin.edit210106PhysicianButton);
        } else if (id.equals("202940")) {
            js.executeScript("arguments[0].click();", admin.edit202940PhysicianButton);
        }
    }

    @Then("Admin {int} nolu sayfada bulunan idsi {int} olan doktora ait edit butonuna tiklar")
    public void adminNoluSayfadaBulunanIdsiOlanDoktoraAitEditButonunaTiklar(int sayfaNo, int id) {
        WebElement editButton =
                Driver.
                        getDriver().
                        findElement(
                                By.xpath
                        ("//a[@href='/physician/" + id + "/edit?page=" + sayfaNo + "&sort=id,desc']"));

        waitForClickablity(editButton,10);
        js.executeScript("arguments[0].click();",editButton);

    }

    @Then("{string} idli Bilgilerin degistini goruntuler")
    public void idliBilgilerinDegistiniGoruntuler(String id) {
        WebElement dogrulamaMesaji = Driver.getDriver().findElement(By.xpath("//*[text()='A Physician is updated with identifier " + id + "']"));
        ReusableMethods.waitForVisibility(dogrulamaMesaji, 10);
        Assert.assertTrue(dogrulamaMesaji.isDisplayed());
    }

    @Then("Admin tum doktorlarin bilgilerinin goruntulendigini dogrular")
    public void adminTumDoktorlarinBilgilerininGoruntulendiginiDogrular() {
        for (int i = 1; i <= 17; i++) {
            List<WebElement> infoList = Driver.getDriver().findElements(By.xpath("//tr//td[" + i + "]"));
            for (WebElement w : infoList) {
                Assert.assertTrue(w.isDisplayed());
            }
        }
    }

    @Then("Bilgileri kaydeder")
    public void bilgileriKaydeder() {
        js.executeScript("arguments[0].scrollIntoView(true)", admin.saveButton);
        waitFor(2);
        js.executeScript("arguments[0].click();", admin.saveButton);
    }

    @And("Admin id {string} doktora ait delete butonuna tiklar")
    public void adminIdDoktoraAitDeleteButonunaTiklar(String id) {
        WebElement deleteButton =
                Driver.getDriver().
                        findElement
                                (By.xpath("//a[@href='/physician/" + id + "/delete?page=1&sort=id,desc']"));
        js.executeScript("arguments[0].click();", deleteButton);
    }

    @Then("Admin gelen uyarida delete tusuna tiklar")
    public void adminGelenUyaridaDeleteTusunaTiklar() {
        admin.confirmDelete.click();
    }
    @When("admin asim sends a Get request to {string}")
    public void adminSendsAGetRequestTo(String endpoint) {
        RestAssured.basePath = endpoint;
        response = RestAssured.given().
                header("Authorization", "Bearer " + generateToken1("medunnaT50", "1234560"))
                .when().get();
        response.prettyPrint();
    }

    @Given("admin asim given api {string}")
    public void adminAsimGivenApi(String url) {
        RestAssured.baseURI = url;
    }

    @Then("Admin asim {string}, {string}, {string}, {string}, {string}, {string} bilgilerini validate eder")
    public void adminAsimBilgileriniValidateEder(String id, String firstName, String lastName, String phone,
                                                 String adress, String speciality) {
        firstName = US018.fakeFirstName;
        lastName = US018.fakeLastName;
        adress = US018.fakeAdress;
        phone = US018.fakePhoneNum;

        Physician actualData = response.as(Physician.class);
        assertEquals(Integer.parseInt(id), actualData.getId());
        assertEquals(firstName, actualData.getFirstName());
        assertEquals(lastName, actualData.getLastName());
        assertEquals(phone, actualData.getPhone());
        assertEquals(adress, actualData.getAdress());
        assertEquals(speciality, actualData.getSpeciality());
    }
    @Given("Admin database ile baglanti kurar")
    public void admin_database_ile_baglanti_kurar() throws SQLException {
        createConnection();
    }

    @Then("Admin query tanimlar")
    public void admin_query_tanimlar() {
        specificDocQuery = "select id,first_name,last_name,phone,adress,speciality from public.physician";
    }

    @Then("Admin DB ile doktor bilgilerini {string}, {string}{string}, {string}, {string} dogrular")
    public void admin_db_ile_doktor_bilgilerini_dogrular(String id, String firstName, String lastName, String phone,
                                                         String speciality) {
        firstName = US018.fakeFirstName;
        lastName = US018.fakeLastName;
        phone = US018.fakePhoneNum;

        idList = getColumnData(specificDocQuery, "id");
        List<String> strIdList = idList.stream()
                .map(Object::toString).toList();

        firstnameList = getColumnData(specificDocQuery, "first_name");

        lastnameList = getColumnData(specificDocQuery, "last_name");

        phoneList = getColumnData(specificDocQuery, "phone");

        specialityList = getColumnData(specificDocQuery, "speciality");

        assertTrue(strIdList.contains(id));
        assertTrue(firstnameList.contains(firstName));
        assertTrue(lastnameList.contains(lastName));
        assertTrue(phoneList.contains(phone));
        assertTrue(specialityList.contains(speciality));

    }
}
