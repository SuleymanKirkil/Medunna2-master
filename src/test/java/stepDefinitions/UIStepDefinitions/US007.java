package stepDefinitions.UIStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.AsimPage;
import pages.EdaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static utilities.ReusableMethods.waitFor;

public class US007 {
    EdaPage makeAnAppointmentPage = new EdaPage();
    AsimPage home = new AsimPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Given("Kullanici medunnaURl anasayfasina gider")
    public void kullanici_medunna_u_rl_anasayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaURL"));

    }

    @Given("Kullanici gecerli hastaUsername ve hastaPassword ile siteye giris yapar")
    public void kullanici_gecerli_hasta_username_ve_hasta_password_ile_siteye_giris_yapar() {
        home.accountMenu.click();
        home.signInButton.click();
        home.usernameBox.sendKeys("HastaTeam50");
        home.passwordBox.sendKeys("m.team50");
        home.secondSignIn.click();
    }
    @And("Kullanici MakeAnAppointment butonuna tiklar")
    public void kullaniciMakeAnAppointmentButonunaTiklar() {
        waitFor(2);
        home.myPages.click();
        waitFor(2);
        makeAnAppointmentPage.makeAnAppointmentButonu.click();
        waitFor(2);
    }
    @Then("Kullanici MakeAnAppointment bolumunun gorunurlugunu test eder")
    public void kullaniciMakeAnAppointmentBolumununGorunurlugunuTestEder() {
        Assert.assertTrue(makeAnAppointmentPage.makeAnAppointmentBolumuGorunurlugu.isDisplayed());
    }
    @Then("Kullanici {string} bilgilerini doldurur")
    public void kullanici_bilgilerini_doldurur(String Phone) {
        makeAnAppointmentPage.phoneMakeAnAppointment.sendKeys(Phone);

    }

    @Then("Kullanici guncel bir tarih secer")
    public void kullanici_guncel_bir_tarih_secer() {
        LocalDateTime istenilenTarih = LocalDateTime.now();
        DateTimeFormatter tarihFormati = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String guncelTarih = istenilenTarih.format(tarihFormati);
        System.out.println("guncelTarih = " + guncelTarih);
        makeAnAppointmentPage.appointmentDateTimeMakeAnAppointment.sendKeys(guncelTarih);

    }

    @Then("Kullanici Send an Appointment Request butonuna tiklar")
    public void kullanici_send_an_appointment_request_butonuna_tiklar() {
        js.executeScript("arguments[0].click();", makeAnAppointmentPage.sendAnAppointmentRequestButonu);
        waitFor(2);

    }

    @Then("Kullanici gecerli bir tarih sectigini cikan popup ile dogrular")
    public void kullanici_gecerli_bir_tarih_sectigini_cikan_popup_ile_dogrular() {
        Assert.assertTrue(makeAnAppointmentPage.popUpAppointmentRegistrationSaved.isDisplayed());

    }

    @And("Kullanici gelecek bir tarih secer")
    public void kullaniciGelecekBirTarihSecer() {
        LocalDateTime istenilenTarih = LocalDateTime.now().plusDays(2);
        DateTimeFormatter tarihFormati = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String gelecekTarih = istenilenTarih.format(tarihFormati);
        System.out.println("gelecekTarih = " + gelecekTarih);
        makeAnAppointmentPage.appointmentDateTimeMakeAnAppointment.sendKeys(gelecekTarih);
    }

    @And("Kullanici gecmis bir tarih secer")
    public void kullaniciGecmisBirTarihSecer() {
        LocalDateTime istenilenTarih = LocalDateTime.now().minusDays(2);
        DateTimeFormatter tarihFormati = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String gecmisTarih = istenilenTarih.format(tarihFormati);
        System.out.println("gecmisTarih = " + gecmisTarih);
        makeAnAppointmentPage.appointmentDateTimeMakeAnAppointment.sendKeys(gecmisTarih);
        ReusableMethods.waitFor(2);
    }

    @And("Kullanici gecerli bir tarih secmedigini Appointment date can not be past date! yazisi ile dogrular")
    public void kullaniciGecerliBirTarihSecmediginiAppointmentDateCanNotBePastDateYazisiIleDogrular() {
        Assert.assertTrue(makeAnAppointmentPage.appointmentDateCanNotBePastDate.isDisplayed());
    }

    @Then("Kullanici {string} secer ve tarih sirasinin formata uygun seklinde oldugunu test eder")
    public void kullaniciSecerVeTarihSirasininFormataUygunSeklindeOldugunuTestEder(String date) {
        makeAnAppointmentPage.appointmentDateTimeMakeAnAppointment.sendKeys(date);
        date = ReusableMethods.stringDateFormat(date);
        System.out.println("date = " + date);
        String medunnaFormat = makeAnAppointmentPage.appointmentDateTimeMakeAnAppointment.getAttribute("value");
        System.out.println(makeAnAppointmentPage.appointmentDateTimeMakeAnAppointment.getAttribute("value"));

        Assert.assertEquals(medunnaFormat, date);
    }

}
