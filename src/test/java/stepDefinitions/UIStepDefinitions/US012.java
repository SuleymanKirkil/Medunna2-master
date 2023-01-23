package stepDefinitions.UIStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.AsimPage;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.ReusableMethods.waitFor;

public class US012 {
    AsimPage home = new AsimPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


    @Given("Doktor medunnaURl adresine gider")
    public void doktor_medunna_u_rl_adresine_gider() {

        Driver.getDriver().get(ConfigReader.getProperty("medunnaURL"));
    }
    @Then("Doktor account menuye tiklar")
    public void doktor_account_menuye_tiklar() {

        home.accountMenu.click();
    }
    @Then("Doktor sign in butonuna tiklar")
    public void doktor_sign_in_butonuna_tiklar() {

        home.signInButton.click();
    }
    @Then("Doktor kendi username ve sifresi ile giris yapar")
    public void doktor_kendi_username_ve_sifresi_ile_giris_yapar() {
        home.usernameBox.sendKeys(ConfigReader.getProperty("doctorUsername"));
        home.passwordBox.sendKeys(ConfigReader.getProperty("doctorPassword"));
        home.secondSignIn.click();
    }

    @Then("Doktor ekranin saginda gorunen edit butonuna tiklar")
    public void doktor_ekranin_saginda_gorunen_edit_butonuna_tiklar() {
        waitFor(1);
        home.editButton.click();
    }

    @Then("Doktor Request a test butonunun tiklanabilir oldugunu test eder")
    public void doktor_request_a_test_butonunun_tiklanabilir_oldugunu_test_eder() {
        Assert.assertTrue(home.requestTestButton.isEnabled());
    }

    @Then("Doktor Request A Test butonuna tiklar")
    public void doktor_request_a_test_butonuna_tiklar() {
        waitFor(2);
        home.requestTestButton.click();
        waitFor(5);

    }
    @Then("Doktor Glucose, Urea, Creatinine, Sodium, Potassium, Total protein, Albumin, Hemoglobin seceneklerinin oldugunu dogrular")
    public void doktor_glucose_urea_creatinine_sodium_potassium_total_protein_albumin_hemoglobin_seceneklerinin_oldugunu_dogrular() {
        Assert.assertTrue(home.glucoseCheckBox.isEnabled());
        Assert.assertTrue(home.ureaCheckBox.isEnabled());
        Assert.assertTrue(home.creatinineCheckBox.isEnabled());
        Assert.assertTrue(home.sodiumCheckBox.isEnabled());
        Assert.assertTrue(home.potassiumCheckBox.isEnabled());
        Assert.assertTrue(home.totalProteinCheckBox.isEnabled());
        Assert.assertTrue(home.albuminCheckBox.isEnabled());
        Assert.assertTrue(home.hemoglobinCheckBox.isEnabled());

        js.executeScript("arguments[0].click();",home.glucoseCheckBox);
        waitFor(2);
        js.executeScript("arguments[0].click();",home.ureaCheckBox);
        waitFor(2);
        js.executeScript("arguments[0].click();",home.creatinineCheckBox);
        waitFor(2);
        js.executeScript("arguments[0].click();",home.potassiumCheckBox);
        waitFor(2);
        js.executeScript("arguments[0].click();",home.totalProteinCheckBox);
        waitFor(2);
        js.executeScript("arguments[0].click();",home.albuminCheckBox);
        waitFor(2);
        js.executeScript("arguments[0].click();",home.hemoglobinCheckBox);
        waitFor(2);

        js.executeScript("arguments[0].scrollIntoView(true);", home.testSaveButton);
        js.executeScript("arguments[0].click();", home.testSaveButton);
    }
}
