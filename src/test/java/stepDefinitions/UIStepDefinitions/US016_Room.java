package stepDefinitions.UIStepDefinitions;

import baseURLs.MedunnaBaseUrl;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Defnepage;
import pojos.US016.US016_RoomPost;
import utilities.Driver;

import java.time.Duration;



import static org.junit.Assert.assertTrue;
import static utilities.ReusableMethods.waitFor;

public class US016_Room extends MedunnaBaseUrl {

    Defnepage defnepage = new Defnepage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    US016_RoomPost us016 = new US016_RoomPost();

    static Faker faker = new Faker();

    //US016 room;
    Response response;
    //US016_RoomPost roomPost;
    int roomNum = 0;
    int price = 0;
    String roomClass, roomStatus;
    static String createdDate = "";
    //String query = "";


    @And("kullanici Click on Items&Titles")
    public void kullaniciClickOnItemsTitles() {
        defnepage.itemsTitlesDropdown.click();

    }

    @And("kullanici acilan drop down menusunden room kismina tiklar.")
    public void kullaniciAcilanDropDownMenusundenRoomKisminaTiklar() {

        defnepage.roomDropdown.click();
    }

    @When("kullanici Create a new Room buttonuna tiklar")
    public void kullaniciCreateANewRoomButtonunaTiklar() {

        defnepage.createANewRoomButton.click();
    }

    @Then("kullanici {string} sayfasinda olgunu dogrular")
    public void kullaniciSayfasindaOlgunuDogrular(String arg0) {
        defnepage.createOrEditARoomHeading.isDisplayed();
    }

    @Given("kullanici oda numarasini girer")
    public void kullaniciOdaNumarasiniGirer() {

        roomNum = faker.number().numberBetween(100, 300);
        defnepage.roomNumberTextBox.sendKeys(String.valueOf(roomNum));
    }

    @And("kullanici statusu ayarlayabilmeli")
    public void kullaniciStatusuAyarlayabilmeli() {
        defnepage.statusCheckBox.click();
        assertTrue(defnepage.statusCheckBox.isSelected());
    }

    @And("kullanici fiyat girer")
    public void kullaniciFiyatGirer() {
        price = faker.number().numberBetween(100, 500);
        defnepage.priceTextBox.sendKeys(String.valueOf(price));
    }

    @And("kullanici {string} tarihini girer.")
    public void kullaniciTarihiniGirer(String arg0) {

        defnepage.createdDateTextBox.sendKeys("19/08/2022");


    }

    @When("kullanici save buttonuna tiklar")
    public void kullaniciSaveButtonunaTiklar() {

        waitFor(3);
        js.executeScript("arguments[0].click();", defnepage.SaveRoom);

    }

    @Then("kullanici {string} yazisini goruntuleyebilmeli")
    public void kullaniciYazisiniGoruntuleyebilmeli(String arg0) {

        defnepage.roomcreatedtoastcontainer.isDisplayed();
    }


    @Given("kullanici , oda numarası alanını boş bırakir  ve entera tiklar.")
    public void kullaniciOdaNumarasıAlanınıBoşBırakirVeEnteraTiklar() {
        defnepage.roomNumberTextBox.sendKeys("" + Keys.ENTER);
        waitFor(3);
    }

    @And("kullanici {string} ifadesini iki kez görmelidir.")
    public void kullaniciIfadesiniIkiKezGörmelidir(String arg0) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(defnepage.invalidFeedbacks1));
        Assert.assertTrue(defnepage.invalidFeedbacks1.isDisplayed());
        Assert.assertTrue(defnepage.invalidFeedbacks2.isDisplayed());

    }

    @And("kullanici, oda tipi dropdown menüsüne tıklar.")
    public void kullaniciOdaTipiDropdownMenüsüneTıklar() {

        defnepage.roomTypeSelect.click();
    }

    @And("Kullanici {string}, {string}, {string}, {string} ve {string} seceneklerini gormeli")
//oda secneklerı gorme tıklayor hangısını ıstersek secıyoruz vısıbıty ıle
    public void kullaniciVeSecenekleriniGormeli(String roomTypeSelect, String arg1, String arg2, String arg3, String arg4) {
        waitFor(3);
        Select select = new Select(defnepage.roomTypeSelect);
        select.selectByVisibleText(roomTypeSelect);
        roomClass = roomTypeSelect;
        us016.setRoomType(roomTypeSelect);


    }

    @And("kullanici odanın mevcut durumunu ayarlayabilmeli.")
    public void kullaniciOdanınMevcutDurumunuAyarlayabilmeli() {
        defnepage.statusCheckBox.click();
        Assert.assertTrue(defnepage.statusCheckBox.isSelected());
    }

    @Given("kullanici room sayfasinda")
    public void kullaniciRoomSayfasinda() {
        Driver.getDriver().navigate().back();
        Assert.assertTrue(defnepage.roomsHeading.isDisplayed());
        waitFor(3);
    }

    @And("kullanici  ayni tur odalari gorebilmeli")
    public void kullaniciAyniTurOdalariGorebilmeli() {
        waitFor(2);
        Assert.assertEquals(20, defnepage.allRows.size());
        System.out.println(defnepage.allRows.size());
    }

    @And("kullanici aciklama kisminda  {string} bilgisini tanimladi")
    //
    public void kullaniciAciklamaKismindaBilgisiniTanimladi(String descriptionTextBox) {
        waitFor(3);
        if (descriptionTextBox.contains("+")) {
            descriptionTextBox = roomNum + " - " + "This is a " + roomStatus + " " + roomClass + " room with " + price + " CAD .";
            defnepage.descriptionTextBox.sendKeys(descriptionTextBox);
        } else {
            descriptionTextBox = "";
            return;
        }
        us016.setDescription(descriptionTextBox);
    }


    @And("kullanici {string} mesajını görmeli.")
    public void kullaniciMesajınıGörmeli(String arg0) {
        Assert.assertTrue(defnepage.roomcreatedtoastcontainer.isDisplayed());
    }

    @And("kullanici son oluşturulan oda için {string} düğmesine tıklar.")
    public void kullaniciSonOluşturulanOdaIçinDüğmesineTıklar(String arg0) {
        js.executeScript("arguments[0].click();", defnepage.deleteRoom);


    }

    @And("kullanici sime islemini onaylar.")
    public void kullaniciSimeIsleminiOnaylar() {

        js.executeScript("arguments[0].click();", defnepage.deleteConfirm);
    }

    @Then("kullanici {string} yazisini gorebilmeli.")
    public void kullaniciYazisiniGorebilmeli(String arg0) {
        Assert.assertTrue(defnepage.deleteToastContanier.isDisplayed());

    }


    @And("kullanici  odalari duzenleyebilmek icin {string} e tıklayabimeli")
    public void kullaniciOdalariDuzenleyebilmekIcinETıklayabimeli(String arg0) {

        js.executeScript("arguments[0].click();", defnepage.editElements);


    }


}




