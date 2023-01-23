package stepDefinitions.UIStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.SumeyraPage;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.ReusableMethods.waitFor;

public class US004 {
    SumeyraPage sumeyraPage=new SumeyraPage();


    @Given("kulanici medunnaURL adresine gider")
    public void kulanici_medunna_url_adresine_gider() {
            Driver.getDriver().get(ConfigReader.getProperty("medunnaURL"));
    }
    @Then("kullanici ikonuna tiklar")
    public void kullanici_ikonuna_tiklar() {
        waitFor(3);
        sumeyraPage.kullaniciIkonu.click();

    }

    @Then("kullanici Sign in butonuna tiklar")
    public void kullanici_sign_in_butonuna_tiklar() {
        sumeyraPage.signInButonu.click();

    }
    @Then("kullanici giris sayfasi ekraninda Did you forget password? secenegi oldugunu dogrular")
    public void kullanici_giris_sayfasi_ekraninda_did_you_forget_password_secenegi_oldugunu_dogrular() {
        Assert.assertTrue(sumeyraPage.forgetPassWordYaziElementi.isDisplayed());

    }
    @Then("kullanici giris sayfasi ekraninda You don't have an account yet? Register a new account secenegi oldugunu test eder")
    public void kullanici_giris_sayfasi_ekraninda_you_don_t_have_an_account_yet_register_a_new_account_secenegi_oldugunu_test_eder() {
        Assert.assertTrue(sumeyraPage.DHAccountYetBox.isDisplayed());

    }
    @Then("kullanici giris sayfasi ekraninda Cancel butonu oldugunu test eder")
    public void kullanici_giris_sayfasi_ekraninda_cancel_butonu_oldugunu_test_eder() {
        Assert.assertTrue(sumeyraPage.cancelButonu.isDisplayed());

    }
    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {

        Driver.closeDriver();



    }

    @Then("kullanici gecerli bir username girer")
    public void kullanici_gecerli_bir_username_girer() {
        sumeyraPage.usernameBox.sendKeys(ConfigReader.getProperty("adminUsername"));

    }
    @Then("kulanici gecerli bir password girer")
    public void kulanici_gecerli_bir_password_girer() {
        sumeyraPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));

    }
    @Then("kullanici Sign in kutusuna tiklar")
    public void kullanici_sign_in_kutusuna_tiklar() {
        waitFor(3);
        sumeyraPage.secondSigInButton.click();

    }
    @Then("sayfada kullanici adinin yazdigini dogrular")
    public void sayfada_kullanici_adinin_yazdigini_dogrular() {
        Assert.assertTrue(sumeyraPage.kullaniciIsmiYaziElementi.isDisplayed());

    }



}

