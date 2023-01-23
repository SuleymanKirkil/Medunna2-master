package stepDefinitions.UIStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.EnesPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.*;

public class US009 {
    EnesPage enesPage = new EnesPage();

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    @Given("Kullanici medunnaURL adresine gider")
    public void kullanici_medunna_url_adresine_gider() {

        Driver.getDriver().get(ConfigReader.getProperty("medunnaURL"));
    }

    @Then("Kullanici ikonuna tiklar")
    public void kullanici_ikonuna_tiklar() {
        enesPage.accountMenuButton.click();


    }

    @Then("Kullanici sign in butonuna tiklar")
    public void kullanici_sign_in_butonuna_tiklar() {
        enesPage.signinButton.click();

    }

    @Then("Kullanici gecerli bir username girer")
    public void kullanici_gecerli_bir_username_girer() {
        enesPage.signinUsernameTextBox.sendKeys(ConfigReader.getProperty("staffUsername"));

    }

    @Then("Kullanici gecerli bir password girer")
    public void kullanici_gecerli_bir_password_girer() {
        enesPage.signinPasswordTextBox.sendKeys(ConfigReader.getProperty("staffPassword"));

    }

    @Then("Kullanici sign in buttonuna tiklar")
    public void kullanici_sign_in_buttonuna_tiklar() {

        enesPage.signinPageSigninButton.click();
    }

    @Then("Kullanici mypages butonuna tiklar")
    public void kullanici_mypages_butonuna_tiklar() {
        enesPage.myPagesButton.click();

    }

    @Then("Kullanici Personel sayfasinda oldugunu dogrular")
    public void kullanici_personel_sayfasinda_oldugunu_dogrular() {

        assertTrue(enesPage.searchPatientButton.isDisplayed());


    }

    @And("Kullanici Search Patient butonuna tiklar")
    public void kullaniciSearchPatientButonunaTiklar() {
        enesPage.searchPatientButton.click();
    }

    @Then("Kullanici hasta bilgi sayfasinda oldugunu dogrular")
    public void kullanici_hasta_bilgi_sayfasinda_oldugunu_dogrular() {

        enesPage.searchPatientPageSearchBox.isDisplayed();
    }

    @Then("Kullanici hasta bilgilerini gorebildigini dogrular")
    public void kullanici_hasta_bilgilerini_gorebildigini_dogrular() {

        Assert.assertFalse(enesPage.patientTableAllCellsList.isEmpty());

    }



    @And("Kullanici {string} SSN Numaralı hasta icin arama yapar")
    public void kullaniciSSNNumaralıHastaIcinAramaYapar(String PatientSSN) {
        enesPage.searchPatientPageSearchBox.sendKeys(PatientSSN + Keys.ENTER);

    }


    @Then("Kullanici Edit butonuna tiklar")
    public void kullaniciEditButonunaTiklar() throws InterruptedException {

        Actions actions = new Actions(Driver.getDriver());
        actions.
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                perform();
        Thread.sleep(2000);
        enesPage.patientEditButton.click();

    }


    @And("Kullanici Create Or Edit a Patient sayfasinda oldugunu dogrular")
    public void kullaniciCreateOrEditAPatientSayfasindaOldugunuDogrular() {
        String expectedBaslık = "Create or edit a Patient";
        String actualBaslık = enesPage.createAndEditBaslık.getText();
        Assert.assertEquals("Create or edit Patient Sayfasinda degilsiniz", expectedBaslık, actualBaslık);
    }

    @And("Kullanici {int} sn bekler")
    public void kullaniciSnBekler(int beklemeSuresi) {

        ReusableMethods.waitFor(beklemeSuresi);
    }

    @Then("Kullanici Description kismini siler")
    public void kullaniciDescriptionKisminiSiler() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,800)");

        enesPage.descriptionTextBox.clear();
    }


    @And("Kullanici Save butonuna tiklar")
    public void kullaniciSaveButonunaTiklar() {


        clickWithJS(enesPage.saveButonu);

    }


    @Then("Kullanici A Patient is updated with identifier yazısını gorur")
    public void kullaniciAPatientIsUpdatedWithIdentifierYazısınıGorur() {


    }


    @And("Kullanici Description kisminin bos oldugunu dogrular")
    public void kullaniciDescriptionKismininBosOldugunuDogrular() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,800)");
        assertTrue(enesPage.descriptionTextBox.getText().isEmpty());
    }

    @And("Kullanici firstname lastname birthday email phone gender bloodgroup bilgilerini duzenler ve kaydeder")
    public void kullaniciFirstnameLastnameBirthdayEmailPhoneGenderBloodgroupBilgileriniDüzenlerVeKaydeder() throws InterruptedException {

        Actions actions = new Actions(Driver.getDriver());
        Select selectBlood = new Select(enesPage.bloodGroupDropDownTextBox);
        Select selectGender = new Select(enesPage.genderDropDownTextBox);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


        String expectedFirstName = "Osayi";
        String expectedLastName = "Samuel";
        String expectedMailAdress = "OsayiSamuel@gmail.com";
        String expectedBirthDate = "25.05.1992";
        String expectedPhone = "5467892456";
        String expectedGender = "MALE";
        String expectedBloodGroup = "B+";

        enesPage.firstNameTextBox.clear();
        enesPage.firstNameTextBox.sendKeys(expectedFirstName);

        enesPage.lastNameTextBox.clear();
        enesPage.lastNameTextBox.sendKeys(expectedLastName);

        enesPage.birthDateTextBox.sendKeys(expectedBirthDate);
        Thread.sleep(1);
        actions.sendKeys(Keys.TAB).sendKeys("05").sendKeys("30").perform();
        js.executeScript("window.scrollBy(0,500)");

        enesPage.emailTextBox.clear();
        enesPage.emailTextBox.sendKeys(expectedMailAdress);

        enesPage.phoneTextBox.clear();
        enesPage.phoneTextBox.sendKeys(expectedPhone);

        selectGender.selectByVisibleText(expectedGender);
        selectBlood.selectByVisibleText(expectedBloodGroup);

        ReusableMethods.waitFor(2);
        js.executeScript("window.scrollBy(0,500)");

        clickWithJS(enesPage.saveButonu);
        ReusableMethods.waitFor(3);
    }

    @Then("Kullanici yaptıgı degisiklikleri dogrular")
    public void kullaniciYaptıgıDegisiklikleriDogrular() {
        String expectedFirstName = "Osayi";
        String expectedLastName = "Samuel";
        String expectedMailAdress = "OsayiSamuel@gmail.com";
        String expectedBirthDate = "25.05.1992";
        String expectedPhone = "5467892456";
        String expectedGender = "MALE";
        String expectedBloodGroup = "B+";


        String actualFirstName = enesPage.tabloFirstName.getText();
        assertEquals(expectedFirstName, actualFirstName);

        String actualLastName = enesPage.tabloLastName.getText();
        assertEquals(expectedLastName, actualLastName);

        String actualMailAdress = enesPage.tabloMailAdress.getText();
        assertEquals(expectedMailAdress, actualMailAdress);

        String actualPhone = enesPage.tabloPhoneNum.getText();
        assertEquals(expectedPhone, actualPhone);

        String actualGender = enesPage.tabloGender.getText();
        assertEquals(expectedGender, actualGender);

        String actualBloodGroup = enesPage.tabloBloodGroup.getText();
        assertEquals(expectedBloodGroup, actualBloodGroup);


    }

    @Then("Kullanici hasta bilgilerinin oldugunu kontrol eder")
    public void kullaniciHastaBilgilerininOldugunuKontrolEder() {
        assertFalse(enesPage.hastaBilgileriTablosu.isEmpty());

    }


}







