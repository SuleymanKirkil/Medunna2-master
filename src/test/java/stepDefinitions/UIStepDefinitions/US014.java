package stepDefinitions.UIStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.GulPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.ReusableMethods.waitFor;

public class US014 {

    GulPage gulPage = new GulPage();


    @Given("Doktor medunna.com'a gider")
    public void doktor_medunna_com_a_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaURL"));
    }

    @Then("Anasayfada giriş ikonuna tıklar")
    public void anasayfada_giriş_ikonuna_tıklar() {
        gulPage.girisİkonu.click();
    }

    @Then("Sign in seçeneğine tıklar")
    public void sign_in_seçeneğine_tıklar() {
        gulPage.signİn.click();
    }

    @Then("Geçerli bir username girer")
    public void geçerli_bir_username_girer() {
        gulPage.userNameKutusu.sendKeys(ConfigReader.getProperty("doktoruserName"));
    }

    @Given("Geçerli bir şifre girer")
    public void geçerli_bir_şifre_girer() {
        gulPage.passwordKutusu.sendKeys(ConfigReader.getProperty("doktorpassword"));
    }

    @Given("Signin butonuna tıklar")
    public void signin_butonuna_tıklar() {
        gulPage.signİnButonu.click();
    }

    @Then("MY PAGES menüsüne tıklar")
    public void my_pages_menüsüne_tıklar() {
        gulPage.myPagesButon.click();
    }

    @Then("My Inpatients sekmesini secer")
    public void my_ınpatients_sekmesini_secer() {
        gulPage.MyInpatıentsButonu.click();
    }

    @Then("Çıkan sayfada \"ID, start and end dates, description, created date appointment id, status, room and patient\" bilgilerinin görünürlüğünü test eder\"")
    public void çıkan_sayfada_ıd_start_and_end_dates_description_created_date_appointment_id_status_room_and_patient_bilgilerinin_görünürlüğünü_test_eder() {
        Assert.assertTrue(gulPage.id.isDisplayed());
        Assert.assertTrue(gulPage.startDate.isDisplayed());
        Assert.assertTrue(gulPage.endDate.isDisplayed());
        Assert.assertTrue(gulPage.description.isDisplayed());
        Assert.assertTrue(gulPage.createdDate.isDisplayed());
        Assert.assertTrue(gulPage.appointment.isDisplayed());
        Assert.assertTrue(gulPage.patient.isDisplayed());
        Assert.assertTrue(gulPage.room.isDisplayed());
        Assert.assertTrue(gulPage.status.isDisplayed());
        waitFor(5);

    }

    @Then("Çıkan sayfada {string}butonuna tıklar")
    public void çıkanSayfadaButonunaTıklar(String edit) {
        gulPage.edit.click();
    }

    @Given("Sayfa kapatılır")
    public void sayfa_kapatılır() {

    }

    @Then("Status menüsünden <DISCHARGED> sekmesi seçilerek {string} tuşuna basılır, <DISCHARGED> yazısı görüntülenir")
    public void statusMenüsündenDISCHARGEDSekmesiSeçilerekTuşunaBasılırDISCHARGEDYazısıGörüntülenir(String arg0) {
        waitFor(5);
        Actions action = new Actions(Driver.getDriver());
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        String messagee = gulPage.alertMessage.getText();
        String expectedData="The In Patient is updated with identifier 181490";
        Select select = new Select(gulPage.status);
        select.selectByVisibleText("DISCHARGED");
        gulPage.save.click();
        Assert.assertEquals(expectedData,messagee);


    }
    @Then("Status menüsünden <UNAPPROVED> sekmesi seçilerek {string} tuşuna basılır, <UNAPPROVED> yazısı görüntülenir")
    public void statusMenüsündenUNAPPROVEDSekmesiSeçilerekTuşunaBasılırUNAPPROVEDYazısıGörüntülenir(String save) {
        ReusableMethods.waitFor(5);
        Select select = new Select(gulPage.Status);
        select.selectByIndex(0);
        gulPage.save.click();
        waitFor(2);
        String messagee = gulPage.alertMessage.getText();
        String expectedData="The In Patient is updated with identifier 181490";
        Assert.assertEquals(expectedData,messagee);
    }

    @Then("Status menüsünden <STAYING> sekmesi seçilerek {string} tuşuna basılır, <STAYING> yazısı görüntülenir")
    public void statusMenüsündenSTAYINSekmesiSeçilerekTuşunaBasılırSTAYINGYazısıGörüntülenir(String save) {
        ReusableMethods.waitFor(5);
        Select select = new Select(gulPage.Status);
        select.selectByIndex(1);
        gulPage.save.click();
        String messagee = gulPage.alertMessage.getText();
        String expectedData="The In Patient is updated with identifier 181490";
        Assert.assertEquals(expectedData,messagee);
    }

    @Given("Status menüsünden <CANCELLED> sekmesi seçilerek {string} tuşuna basılır, <CANCELLED> yazısı görüntülenir")
    public void statusMenüsündenCANCELLEDSekmesiSeçilerekTuşunaBasılırCANCELLEDYazısıGörüntülenir(String save) {
        ReusableMethods.waitFor(5);
        Select select = new Select(gulPage.status);
        select.selectByIndex(3);
        String messagee = gulPage.alertMessage.getText();
        String expectedData="The In Patient is updated with identifier 181490";
        Assert.assertEquals(expectedData,messagee);
       // Assert.assertEquals(messagee, (ConfigReader.getProperty("message")));
    }

    @Then("Room menüsünden herhangi bir oda seçip Save tuşuna basar")
    public void roomMenüsündenHerhangiBirOdaSeçipSaveTuşunaBasar() {

        Actions action = new Actions(Driver.getDriver());
        action.sendKeys(Keys.PAGE_DOWN).perform();
        // Select select = new Select(gulPage.status);
        // select.selectByVisibleText("STAYING");
        Select  select = new Select(gulPage.Room);
        select.selectByVisibleText("Room");

    }

    @Given("Değişikliğin yapıldığından emin olur")
    public void değişikliğinYapıldığındanEminOlur() {
        String messagee2 = gulPage.alertSuccessMessage.getText();
        Assert.assertEquals(messagee2, ConfigReader.getProperty("alertSuccessMessage"));

    }


}