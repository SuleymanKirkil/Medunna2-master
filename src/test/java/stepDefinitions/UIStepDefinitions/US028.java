package stepDefinitions.UIStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.GulPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.ReusableMethods.waitForVisibility;

public class US028 {
    GulPage gulPage = new GulPage();
    Faker faker=new Faker();
    String ıd ;

    @Then("Sag üst kösedeki ikona tiklar")
    public void sag_üst_kösedeki_ikona_tiklar() {
        gulPage.girisİkonu.click();

    }

    @Then("Sign In butonuna tiklar")
    public void sign_ın_butonuna_tiklar() {
        gulPage.signİn.click();

    }

    @Given("Admin adi ve sifresiyle siteye girer")
    public void admin_adi_ve_sifresiyle_siteye_girer() {
        gulPage.userNameKutusu.sendKeys(ConfigReader.getProperty("adminUsername"));
        gulPage.passwordKutusu.sendKeys(ConfigReader.getProperty("adminPassword"));
        gulPage.signİnButonu.click();

    }

    @Given("Items&Titles butonuna tiklar")
    public void ıtems_titles_butonuna_tiklar() {
        gulPage.Items.click();

    }

    @Given("Country secenegine tiklar")
    public void country_secenegine_tiklar() {
        gulPage.Country.click();

    }

    @Then("Create a new Country butonuna tiklar")
    public void create_a_new_country_butonuna_tiklar() {
        gulPage.CreateCountry.click();

    }

    @Then("Name kismina Ülke adini yazar")
    public void name_kismina_ülke_adini_yazar() {
        String country= Faker.instance().country().name();
        gulPage.Name.sendKeys(country);

    }

    @Then("Save butonuna tiklar")
    public void save_butonuna_tiklar() {
       gulPage.countrySave.click();

    }

    @Then("Admin yeni ülke olusturdugunu cikan yaziyla dogrular")
    public void admin_yeni_ülke_olusturdugunu_cikan_yaziyla_dogrular() {
        waitForVisibility(gulPage.createDogrulama,5);
        Assert.assertTrue(gulPage.createDogrulama.isDisplayed());
        //ReusableMethods.waitForVisibility(gulPage.alertList.get(0),10);
        //ıd=gulPage.alertList.get(0).getText().replaceAll("\\D","");
        //System.out.println(ıd);
    }

    @Then("Oluşturdugu ülkenin listede göründügünü test eder")
    public void oluşturdugu_ülkenin_listede_göründügünü_test_eder() {
        String ülke = "country";
        String actualAramaSonucStr = gulPage.newcountry.getText();
        Assert.assertTrue(actualAramaSonucStr.contains(ülke));

    }

    @Given("StateCity secenegine tiklar")
    public void statecitySecenegineTiklar() {
        gulPage.StateCity.click();

    }

    @Then("Create a new StateCity butonuna tiklar")
    public void create_a_new_state_city_butonuna_tiklar() {
        gulPage.CreatStateCity.click();


    }

    @Then("Acilan sayfada Name kismina eyalet veya şehrini yazar")
    public void acilan_sayfada_name_kismina_eyalet_veya_şehrini_yazar() {
        gulPage.StateName.sendKeys("State");


    }

    @Given("StateCity kismina olusturdugu ülkeyi yazar")
    public void stateCityKisminaOlusturduguÜlkeyiYazar() {
        gulPage.StateUlke.click();
        WebElement Angola = gulPage.StateUlke;
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", Angola);
    }

    @And("Save tusuna tiklar")
    public void saveTusunaTiklar() {
        gulPage.Statesave.click();
    }


    @And("Admin yeni StateCity olusturdugunu cikan yaziyla dogrular")
    public void adminYeniStateCityOlusturdugunuCikanYaziylaDogrular() {
        Assert.assertTrue(gulPage.olumsuzMesaj.isDisplayed());
    }

    @When("Delete butonuna basar")
    public void deleteButonunaBasar() {

        ReusableMethods.waitAndClick(gulPage.sondelete, 3);
    }

    @When("Cikan dogrulama ekranindan da Delete butonuna basar")
    public void cikan_dogrulama_ekranindan_da_delete_butonuna_basar() {
        gulPage.deleteConfirm.click();


    }
    @When("Ülkenin silindiginden emin olur")
    public void ülkenin_silindiginden_emin_olur() {
        Assert.assertTrue(gulPage.silindi.isDisplayed());

    }

}

