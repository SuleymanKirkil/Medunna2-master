package stepDefinitions.UIStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.SumeyraPage;
import pojos.Us017.TestItemPojo;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static io.restassured.RestAssured.given;
import static utilities.ReusableMethods.generateToken1;


public class US017 {
    Faker faker = new Faker();
    Response response;

    SumeyraPage sumeyraPage = new SumeyraPage();

    @Given("Admin olarak giris yapar")
    public void admin_olarak_giris_yapar() {
        sumeyraPage.kullaniciIkonu.click();
        sumeyraPage.signInButonu.click();
        sumeyraPage.usernameBox.sendKeys("medunnaT50");
        sumeyraPage.passwordBox.sendKeys("1234560");
        sumeyraPage.secondSigInButton.click();


    }

    @Given("Admin headers bolumunden ItemsTitles'a tiklar")
    public void admin_headers_bolumunden_ıtems_titles_a_tiklar() {
        sumeyraPage.itemsTitelsiconu.click();

    }

    @Given("Admin TestItem secenegine tiklar")
    public void admin_test_ıtem_secenegine_tiklar() {
        sumeyraPage.TestItemButonu.click();

    }

    @Given("Admin Create a new Test Item  butonuna tıkla")
    public void admin_create_a_new_test_ıtem_butonuna_tıkla() {
        sumeyraPage.createTestItemButonu.click();

    }

    @Given("Admin formdaki ilgili bölümleri valid degerlerle doldurur")
    public void admin_formdaki_ilgili_bölümleri_valid_degerlerle_doldurur() throws InterruptedException {
        Actions actions = new Actions(Driver.getDriver());
        actions.click(sumeyraPage.nameBox)
                .sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(faker.number().digit()).sendKeys(Keys.TAB)
                .sendKeys(faker.number().digit()).sendKeys(Keys.TAB)
                .sendKeys(faker.number().digit()).perform();
        Thread.sleep(5000);


    }

    @Given("Admin Save butonuna tiklar")
    public void admin_save_butonuna_tiklar() {
        sumeyraPage.saveButonu.submit();

    }

    @Given("Olusturulan item'in Test Items sayfasinda yer aldigini dogrular")
    public void olusturulan_item_in_test_ıtems_sayfasinda_yer_aldigini_dogrular() {
        String create = "A new Test Item is created with identifier";
        sumeyraPage.popUpMessage.getText().contains(create);

    }

    @Given("Admin olusturulan item icin Edit butonuna tiklar")
    public void admin_olusturulan_item_için_edit_butonuna_tiklar() {
        sumeyraPage.editButonu.click();

    }

    @Given("Admin Item sayfasida price bir degerini degistirir")
    public void admin_ıtem_sayfasida_herhangi_bir_degeri_degistirir() throws InterruptedException {
        sumeyraPage.priceBox.sendKeys(faker.number().digit());
        Thread.sleep(5000);

    }

    @Given("Admin A Test Item is updated mesaji goruntulendigini dogrular")
    public void admin_a_test_ıtem_is_updated_mesaji_goruntulendigini_dogrular() {
        String upDate = "A Test Item is updated";
        sumeyraPage.popUpMessage.getText().contains(upDate);
    }


    @Given("Admin olusturulan Item icin View butonuna tiklar")
        public void admin_olusturulan_ıtem_icin_view_butonuna_tiklar () {
        sumeyraPage.viewButonu.click();

        }
    @Given("Olusturulan Item icin Test Item degerlerinin göruntulendigini dogrular")
        public void olusturulan_ıtem_icin_test_ıtem_degerlerinin_göruntulendigini_dogrular () {
       Driver.getDriver().getCurrentUrl().contains("test-item");

        Assert.assertTrue(sumeyraPage.viewSayfa.isDisplayed());

        }


    @And("Admin olusturulan Item icin Delete butonuna tiklar")
    public void adminOlusturulanItemIcinDeleteButonunaTiklar() {
        sumeyraPage.deleteButonu.click();
        sumeyraPage.delete2.click();

    }

    @And("Test Item is deleted mesajinin goruntulendigini dogrular")
    public void testItemIsDeletedMesajininGoruntulendiginiDogrular() {
        String deleted = "Test Item is deleted";
        String metin=sumeyraPage.popUpMessage.getText();
        sumeyraPage.popUpMessage.getText().contains(deleted);

    }






    }


