package stepDefinitions.UIStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.EdaPage;
import utilities.Driver;

import java.time.Duration;

import static utilities.ReusableMethods.waitFor;

public class US026 {
    EdaPage messagePage = new EdaPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

    @Given("Kullanici CONTACT butonuna tiklar")
    public void kullanici_contact_butonuna_tiklar() {
        messagePage.contactButonu.click();

    }

    @Given("Kullanici {string}, {string}, {string}, {string} metin kutularini doldurur")
    public void kullanici_metin_kutularini_doldurur(String Name, String Email, String Subject, String Message) {
      actions.sendKeys(Keys.PAGE_DOWN).perform();

        messagePage.nameMetinKutusu.sendKeys(Name);
        messagePage.emailMetinKutusu.sendKeys(Email);
        messagePage.subjectMetinKutusu.sendKeys(Subject);
        messagePage.messageKutusuContactPortal.sendKeys(Message);
    }

    @Given("Kullanici Send butonuna tiklar")
    public void kullanici_send_butonuna_tiklar() {
        js.executeScript("arguments[0].click();", messagePage.saveButonu);
       

    }

    @Then("Kullanici bilgilerin basarili bir sekilde gonderildigini dogrular")
    public void kullanici_bilgilerin_basarili_bir_sekilde_gonderildigini_dogrular() {
       // wait.until(ExpectedConditions.visibilityOf(messagePage.islemBasariliPopUp));
       waitFor(2);
        Assert.assertTrue(messagePage.successfullySendingMessageText.isDisplayed());

    }

    @And("Kullanıcı Message kutusunu bos birakir.{string}, {string}, {string} kutularina gecerli bilgiler girer")
    public void kullanıcıMessageKutusunuBosBirakirKutularinaGecerliBilgilerGirer(String Name, String Email, String Subject) {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
       // wait.until(ExpectedConditions.visibilityOf(messagePage.nameMetinKutusu));
       waitFor(2);
        messagePage.nameMetinKutusu.sendKeys(Name);
        messagePage.emailMetinKutusu.sendKeys(Email);
        messagePage.subjectMetinKutusu.sendKeys(Subject);

    }

    @And("Kullanıcı Name kutusunu bos birakir. {string}, {string}, {string} bölümlerine gecerli bilgiler girer")
    public void kullanıcıNameKutusunuBosBirakirBölümlerineGecerliBilgilerGirer(String Email, String Subject, String Message) {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //wait.until(ExpectedConditions.visibilityOf(messagePage.emailMetinKutusu));
        waitFor(2);
        messagePage.emailMetinKutusu.sendKeys(Email);
        messagePage.subjectMetinKutusu.sendKeys(Subject);
        messagePage.messageKutusuContactPortal.sendKeys(Message);
    }

    @And("Kullanici Name kutusunu doldurmadan istek gonderemeyecegini dogrular")
    public void kullaniciNameKutusunuDoldurmadanIstekGonderemeyeceginiDogrular() {
        Assert.assertTrue(messagePage.nameIsRequiredYazisi.isDisplayed());

    }

    @And("Kullanıcı Email kutusunu bos birakir. {string}, {string}, {string} bölümlerine gecerli bilgiler girer")
    public void kullanıcıEmailKutusunuBosBirakirBölümlerineGecerliBilgilerGirer(String Name, String Subject, String Message) {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //wait.until(ExpectedConditions.visibilityOf(messagePage.nameMetinKutusu));
        waitFor(2);
        messagePage.nameMetinKutusu.sendKeys(Name);
        messagePage.subjectMetinKutusu.sendKeys(Subject);
        messagePage.messageKutusuContactPortal.sendKeys(Message);

    }

    @And("Kullanici Email kutusunu doldurmadan istek gonderemeyecegini dogrular")
    public void kullaniciEmailKutusunuDoldurmadanIstekGonderemeyeceginiDogrular() {
        Assert.assertTrue(messagePage.yourEmailIsRequiredYazisi.isDisplayed());

    }

    @And("Kullanıcı Subject kutusunu bos birakir. {string}, {string}, {string} bölümlerine gecerli bilgiler girer")
    public void kullanıcıSubjectKutusunuBosBirakirBölümlerineGecerliBilgilerGirer(String Name, String Email, String Message) {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
       // wait.until(ExpectedConditions.visibilityOf(messagePage.nameMetinKutusu));
        waitFor(2);
        messagePage.nameMetinKutusu.sendKeys(Name);
        messagePage.emailMetinKutusu.sendKeys(Email);
        messagePage.messageKutusuContactPortal.sendKeys(Message);
    }

    @And("Kullanici Subject kutusunu doldurmadan istek gonderemeyecegini dogrular")
    public void kullaniciSubjectKutusunuDoldurmadanIstekGonderemeyeceginiDogrular() {
        Assert.assertTrue(messagePage.thisFieldIsRequiredYazisi.isDisplayed());
    }
}
