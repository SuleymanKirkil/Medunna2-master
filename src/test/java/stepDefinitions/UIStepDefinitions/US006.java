package stepDefinitions.UIStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.NevalPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US006 {

    NevalPage medunnaPage = new NevalPage();

    @Then("kullanici signin butonuna tiklar")
    public void kullanici_signin_butonuna_tiklar() {
        medunnaPage.profilResmi.click();
        medunnaPage.signInButonu.click();

    }


    @Then("kullanici gecerli {string} ve {string}ile giris yapar")
    public void kullaniciGecerliVeIleGirisYapar(String username, String password) {
        medunnaPage.userNameKutusu.sendKeys(ConfigReader.getProperty(username));
        medunnaPage.passwordKutusu.sendKeys(ConfigReader.getProperty(password));
        medunnaPage.signinButonu2.click();
    }

    @And("kullanici  settings ' e tiklar")
    public void kullaniciSettingsETiklar() {
        medunnaPage.profilResmi.click();
        medunnaPage.settings.click();
        String actualFirstNameText = medunnaPage.settingsFirstNameKutusu.getAttribute("value");
        String actualLastNameText = medunnaPage.settingsLastnameKutusu.getAttribute("value");
        String actualEmailText = medunnaPage.settingsEmailKutusu.getAttribute("value");
        System.out.println("actualFirstNameText = " + actualFirstNameText);
        System.out.println("actualLastNameText = " + actualLastNameText);
        System.out.println("actualEmailText = " + actualEmailText);
    }


    @And("firstName lastName ve email kutularının görünülebilirliğini test eder")
    public void firstnameLastNameVeEmailKutularınınGörünülebilirliğiniTestEder() {
        Assert.assertTrue(medunnaPage.settingsFirstNameKutusu.isDisplayed());
        Assert.assertTrue(medunnaPage.settingsLastnameKutusu.isDisplayed());
        Assert.assertTrue(medunnaPage.settingsEmailKutusu.isDisplayed());

    }


    @And("Kullanici  Firstname secenegini güncelleyebilmeli")
    public void kullaniciFirstnameSeceneginiGüncelleyebilmeli() {
        medunnaPage.settingsFirstNameKutusu.clear();
        medunnaPage.settingsFirstNameKutusu.sendKeys(ConfigReader.getProperty("passFirstName"));
    }

    @And("Kullanici  Lastname secenegini güncelleyebilmeli")
    public void kullaniciLastnameSeceneginiGüncelleyebilmeli() {
        medunnaPage.settingsLastnameKutusu.clear();
        medunnaPage.settingsLastnameKutusu.sendKeys(ConfigReader.getProperty("passLastname"));
    }


    @And("Kullanici  Email secenegini güncelleyebilmeli")
    public void kullaniciEmailSeceneginiGüncelleyebilmeli() {
        medunnaPage.settingsEmailKutusu.clear();
        medunnaPage.settingsEmailKutusu.sendKeys(ConfigReader.getProperty("passemail"));
    }

    @And("Kullanici  save butonuna basar")
    public void kullaniciSaveButonunaBasar() {
        medunnaPage.saveButonu.click();
    }


    @And("Kullanici Settings saved yazisinin ciktigini gorur")
    public void kullaniciSettingsSavedYazisininCiktiginiGorur() {
        medunnaPage.guncellemeBsarılıYazisi.isDisplayed();
    }

    @And("Kullanici {int} saniye bekler")
    public void kullaniciSaniyeBekler(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("Sayfati kapatir")
    public void sayfatiKapatir() {
        Driver.closeDriver();
    }

    @And("Kullanici  {string} secenegini güncelleyebilmeli")
    public void kullaniciSeceneginiGüncelleyebilmeli(String email) {
        medunnaPage.settingsEmailKutusu.clear();
        medunnaPage.settingsEmailKutusu.sendKeys(ConfigReader.getProperty(email));

    }

    @And("Kullanıcı bilgilerinin register olurken ki ile aynı oldugunu test eder")
    public void kullanıcıBilgilerininRegisterOlurkenKiIleAynıOldugunuTestEder() {
        String actualFirstNameText = medunnaPage.settingsFirstNameKutusu.getAttribute("value");
        String actualLastNameText = medunnaPage.settingsLastnameKutusu.getAttribute("value");
        String actualEmailText = medunnaPage.settingsEmailKutusu.getAttribute("value");
        System.out.println("actualFirstNameText = " + actualFirstNameText);
        System.out.println("actualLastNameText = " + actualLastNameText);
        System.out.println("actualEmailText = " + actualEmailText);
        Assert.assertEquals(ConfigReader.getProperty("registerFirstname"), actualFirstNameText);
        Assert.assertEquals(ConfigReader.getProperty("registerLastName"), actualLastNameText);
        Assert.assertEquals(ConfigReader.getProperty("registerEmail"), actualEmailText);

    }

    @And("Kullanici  {string}girer")
    public void kullaniciGirer(String yanlısFirtname) {
        medunnaPage.settingsFirstNameKutusu.clear();
        medunnaPage.settingsFirstNameKutusu.sendKeys(ConfigReader.getProperty(yanlısFirtname));

    }


    @And("Kullanici Your first name is required yazısının cıktıgını gorur")
    public void kullaniciYourFirstNameIsRequiredYazısınınCıktıgınıGorur() {
        medunnaPage.adınızGerekliYazisi.isDisplayed();
    }
}
