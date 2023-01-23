package stepDefinitions.UIStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AsimPage;
import pages.EdaPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

import static utilities.ReusableMethods.waitFor;

public class US027 {
    EdaPage messagePage = new EdaPage();
    AsimPage home = new AsimPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
    @Given("Admin medunnaUrl anasayfasina gider")
    public void admin_medunna_url_anasayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaURL"));
    }

    @And("Admin adminUsername ve adminPassword ile siteye giris yapar")
    public void adminAdminUsernameVeAdminPasswordIleSiteyeGirisYapar() {
        home.accountMenu.click();
        home.signInButton.click();
        home.usernameBox.sendKeys("medunnaT50");
        home.passwordBox.sendKeys("1234560");
        home.secondSignIn.click();
    }

    @Given("Admin admin sayfasinin gorunurlugunu test eder")
    public void admin_admin_sayfasinin_gorunurlugunu_test_eder() {
        Assert.assertTrue(messagePage.adminSayfasininGorunurlugu.isDisplayed());

    }

    @Given("Admin Items&Titles butonuna tiklar")
    public void admin_ıtems_titles_butonuna_tiklar() {
        //wait.until(ExpectedConditions.elementToBeClickable(messagePage.itemsTitlesButonu));
       waitFor(2);
        messagePage.itemsTitlesButonu.click();

    }

    @Given("Admin Messages butonuna tiklar")
    public void admin_messages_butonuna_tiklar() {
        //wait.until(ExpectedConditions.elementToBeClickable(messagePage.messagesButonu));
       waitFor(2);
        messagePage.messagesButonu.click();

    }

    @Then("Admin Messages portalına basarili bir sekilde gecis yapildigini test eder")
    public void admin_messages_portalına_basarili_bir_sekilde_gecis_yapildigini_test_eder() {
        //wait.until(ExpectedConditions.visibilityOf(messagePage.messagesPortalininGorunurlugu));
       waitFor(2);
        Assert.assertTrue(messagePage.messagesPortalininGorunurlugu.isDisplayed());
    }

    @Then("Admin View butonuna tiklar")
    public void admin_view_butonuna_tiklar() {
       // wait.until(ExpectedConditions.elementToBeClickable(messagePage.viewButonu));
       waitFor(2);
        messagePage.viewButonu.click();
    }

    @Then("Admin tüm mesajları, yazarlarını ve e-postalarını görüntüleyebildigini test eder")
    public void admin_tüm_mesajları_yazarlarını_ve_e_postalarını_görüntüleyebildigini_test_eder() {
        Assert.assertTrue(messagePage.messageBilgilerininGorunurlugu.isDisplayed());
    }

    @Then("Admin cikis yapar")
    public void admin_cikis_yapar() {
        Driver.closeDriver();
    }

    @And("Admin Create a new Message butonuna tiklar")
    public void adminCreateANewMessageButonunaTiklar() {
        messagePage.createAnewMessageButonu.click();
    }

    @And("Admin {string}, {string}, {string}, {string} metin kutularini doldurur")
    public void adminMetinKutulariniDoldurur(String Name, String Email, String Subject, String Message) {
        messagePage.nameMetinKutusu.sendKeys(Name);
        messagePage.emailMetinKutusu.sendKeys(Email);
        messagePage.subjectMetinKutusu.sendKeys(Subject);
        messagePage.messageMetinKutusu.sendKeys(Message);
    }

    @And("Admin mesaj olusturabilmek veya guncelleyebilmek icin save tusuna tiklar")
    public void adminMesajOlusturabilmekVeyaGuncelleyebilmekIcinSaveTusunaTiklar() {
        js.executeScript("arguments[0].click();", messagePage.saveButonu);

    }
    @Then("Admin mesajin basarili bir sekilde olusturuldugunu test eder")
    public void adminMesajinBasariliBirSekildeOlusturuldugunuTestEder() {
        //wait.until(ExpectedConditions.visibilityOf(messagePage.islemBasariliPopUp));
        waitFor(2);
        Assert.assertTrue(messagePage.successfullyCreatedANewMessageText.isDisplayed());
    }

    @And("Admin ID butonuna tiklar")
    public void adminIDButonunaTiklar() {
        messagePage.idButonu.click();

    }

    @And("Admin Edit butonuna tiklar")
    public void adminEditButonunaTiklar() {
        //wait.until(ExpectedConditions.elementToBeClickable(messagePage.editButonu1));
        waitFor(2);
        messagePage.editButonu1.click();
    }

    @And("Admin {string}, {string}, {string}, {string} metin kutularini gunceller")
    public void adminMetinKutulariniGunceller(String Name, String Email, String Subject, String Message) {

       // wait.until(ExpectedConditions.visibilityOf( messagePage.nameMetinKutusu));
       waitFor(2);
        messagePage.nameMetinKutusu.clear();

        messagePage.nameMetinKutusu.sendKeys(Name);

        messagePage.emailMetinKutusu.clear();

        messagePage.emailMetinKutusu.sendKeys(Email);

        messagePage.subjectMetinKutusu.clear();

        messagePage.subjectMetinKutusu.sendKeys(Subject);

        messagePage.messageMetinKutusu.clear();

        messagePage.messageMetinKutusu.sendKeys(Message);

    }

    @And("Admin mesajin basarili bir sekilde guncellendigini test eder")
    public void adminMesajinBasariliBirSekildeGuncellendiginiTestEder() {
        waitFor(2);
        Assert.assertTrue(messagePage.succesfullyUpdatedMessageText.isDisplayed());
    }

    @And("Admin Delete butonuna tiklar")
    public void adminDeleteButonunaTiklar() {
       messagePage.deleteButonu.click();

    }

    @And("Admin Delete popup'a tiklar")
    public void adminDeletePopupATiklar() {
       // wait.until(ExpectedConditions.elementToBeClickable(messagePage.deleteButonuPopUp));
       waitFor(2);
        messagePage.deleteButonuPopUp.click();
    }

    @And("Admin cikan pop up ile delete isleminin gerceklestigini dogrular")
    public void adminCikanPopUpIleDeleteIslemininGerceklestiginiDogrular() {
        waitFor(2);
        Assert.assertTrue(messagePage.succesfullyDeletedMessageText.isDisplayed());
    }



}
