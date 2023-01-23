package stepDefinitions.UIStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.MertPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static utilities.ReusableMethods.waitFor;

public class US001_US002 {

    MertPage mertPage = new MertPage();
    Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());
    LocalDateTime datetime= LocalDateTime.now();
    DateTimeFormatter DTformatter = DateTimeFormatter.ofPattern("mm-dd-yyyy");

    @Given("Kullanici medunna ana sayfasina gider")
    public void kullanici_medunna_ana_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaURL"));
    }

    @Given("Kullanici register butonuna tiklar")
    public void kullanici_register_butonuna_tiklar() {
        mertPage.accountMenu.click();
        mertPage.registerButton.click();
        Assert.assertEquals("Registration", mertPage.registrationText.getText());
    }


    @And("Kullanici klavyede tab tusuna basar")
    public void kullanici_klavyede_tab_tusuna_basar() {

        actions.sendKeys((Keys.TAB)).perform();
    }

    @Then("Kullanici sayfayi kapatir")
    public void kullanici_sayfayi_kapatir() {
        Driver.closeDriver();

    }

    @Given("Kullanici {string} yazi kutucuguna tiklar")
    public void kullaniciYaziKutucugunaTiklar(String str) {
        switch (str) {
            case "SSN":
                actions.doubleClick(mertPage.ssnBox);
                actions.sendKeys((Keys.DELETE)).perform();
                break;
            case "First Name":
                actions.doubleClick(mertPage.firstNameBox);
                actions.sendKeys((Keys.DELETE)).perform();
                break;
            case "Last Name":
                actions.doubleClick(mertPage.lastNameBox);
                actions.sendKeys((Keys.DELETE)).perform();
                break;
            case "Username":
                actions.doubleClick(mertPage.usernameBox);
                actions.sendKeys((Keys.DELETE)).perform();
                break;
            case "Email":
                actions.doubleClick(mertPage.emailBox);
                actions.keyDown(Keys.LEFT_CONTROL);
                actions.sendKeys("a");
                actions.keyUp(Keys.LEFT_CONTROL);
                actions.sendKeys((Keys.DELETE)).perform();
                break;
            case "Phone Number":
                actions.doubleClick(mertPage.phoneBox);
                actions.sendKeys((Keys.DELETE)).perform();
                break;
            case "Appointment DateTime":
                actions.doubleClick(mertPage.appointmentDateBox);
                actions.sendKeys((Keys.DELETE)).perform();
                break;
            default:
                break;
        }
    }

    @And("Kullanici gecerli bir {string} girer")
    public void kullaniciGecerliBirGirer(String str) {
        switch (str) {
            case "SSN":
                String ssn = faker.idNumber().ssnValid();
                mertPage.ssnBox.sendKeys(ssn);
                break;
            case "First Name":
                String firstname = faker.name().firstName();
                mertPage.firstNameBox.sendKeys(firstname);
                break;
            case "Last Name":
                String lastname = faker.name().lastName();
                mertPage.lastNameBox.sendKeys(lastname);
                break;
            case "Username":
                String username = faker.name().username();
                mertPage.usernameBox.sendKeys(username);
                break;
            case "Email":
                String email = faker.internet().emailAddress();
                mertPage.emailBox.sendKeys(email);
                break;
            case "Phone Number":
                String phoneNumber = ("5005005050");
                mertPage.phoneBox.sendKeys(phoneNumber);
                break;
            case "Appointment DateTime":
                String appointmentDate = DTformatter.format(datetime.plusDays(2));
                mertPage.appointmentDateBox.sendKeys(appointmentDate);
                break;
            default:
                break;
        }
    }

    @And("Kullanici {string} girisi gerekli uyarisi almaz")
    public void kullaniciGirisiGerekliUyarisiAlmaz(String str) {
        switch (str) {
            case "SSN":
                try {
                    Assert.assertFalse(mertPage.ssnErrorMessage.isDisplayed());
                } catch (Exception NoSuchElementException) {
                    Assert.assertTrue(true);
                }
                break;
            case "First Name":
                try {
                    Assert.assertFalse(mertPage.firstNameErrorMessage.isDisplayed());
                } catch (Exception NoSuchElementException) {
                    Assert.assertTrue(true);
                }
                break;
            case "Last Name":
                try {
                    Assert.assertFalse(mertPage.lastNameErrorMessage.isDisplayed());
                } catch (Exception NoSuchElementException) {
                    Assert.assertTrue(true);
                }
                break;
            case "Username":
                try {
                    Assert.assertFalse(mertPage.usernameErrorMessage.isDisplayed());
                } catch (Exception NoSuchElementException) {
                    Assert.assertTrue(true);
                }
                break;
            case "Email":
                try {
                    Assert.assertFalse(mertPage.emailErrorMessage.isDisplayed());
                } catch (Exception NoSuchElementException) {
                    Assert.assertTrue(true);
                }
                break;
            case "Phone Number":
                try {
                    Assert.assertFalse(mertPage.phoneNumberErrorMessage.isDisplayed());
                } catch (Exception NoSuchElementException) {
                    Assert.assertTrue(true);
                }
                break;
            default:
                break;
        }
    }

    @And("Kullanici {string} girisi gerekli uyarisi alir")
    public void kullaniciGirisiGerekliUyarisiAlir(String str) {
        switch (str) {
            case "SSN":
                Assert.assertTrue(mertPage.ssnErrorMessage.isDisplayed());
                break;
            case "First Name":
                Assert.assertTrue(mertPage.firstNameErrorMessage.isDisplayed());
                break;
            case "Last Name":
                Assert.assertTrue(mertPage.lastNameErrorMessage.isDisplayed());
                break;
            case "Username":
                Assert.assertTrue(mertPage.usernameErrorMessage.isDisplayed());
                break;
            case "Email":
                Assert.assertTrue(mertPage.emailErrorMessage.isDisplayed());
                break;
            default:
                break;
        }
    }

    @And("Kullanici hatali {string} girisi uyarisi alir")
    public void kullaniciHataliGirisiUyarisiAlir(String str) {
        switch (str) {
            case "SSN":
                try {
                    Assert.assertTrue(mertPage.ssnInvalidMessage.isDisplayed());
                } catch (Exception NoSuchElementException) {
                    Assert.fail();
                }
                break;
            case "Email":
                try {
                    Assert.assertTrue(mertPage.emailInvalidMessage.isDisplayed());
                } catch (Exception NoSuchElementException) {
                    Assert.fail();
                }
                break;
            default:
                break;
        }
    }

    @And("Kullanici hatali {string} girisi uyarisi almaz")
    public void kullaniciHataliGirisiUyarisiAlmaz(String str) {
        switch (str) {
            case "SSN":
                try {
                    Assert.assertFalse(mertPage.ssnInvalidMessage.isDisplayed());
                } catch (Exception NoSuchElementException) {
                    Assert.assertTrue(true);
                }
                break;
            case "Email":
                try {
                    Assert.assertFalse(mertPage.emailInvalidMessage.isDisplayed());
                } catch (Exception NoSuchElementException) {
                    Assert.assertTrue(true);
                }
                break;
            default:
                break;
        }
    }


    @And("Kullanici bes karakterden az bir mail girer")
    public void kullaniciBesKarakterdenAzBirMailGirer() {
        mertPage.emailBox.sendKeys("a@b.");
    }

    @And("Kullanici {string} den sonra {string} bulunmayan bir mail girer")
    public void kullaniciDenSonraBulunmayanBirMailGirer(String str1, String str2) {
        mertPage.emailBox.sendKeys("user"+str2+"gmail"+str1+"com");
    }

    @And("Kullanici {string} ile {string} arasında karakter bulunmayan bir mail girer")
    public void kullaniciIleArasındaKarakterBulunmayanBirMailGirer(String str1, String str2) {
        mertPage.emailBox.sendKeys("user"+str1+str2+"com");
    }

    @And("Kullanici {string} ile {string} arasında ozel karakter bulunan bir mail girer")
    public void kullaniciIleArasındaOzelKarakterBulunanBirMailGirer(String str1, String str2) {
        mertPage.emailBox.sendKeys("user"+str1+"!gmail"+str2+"com");
    }

    @And("Kullanici {string} dan sonra ozel karakter iceren bir mail girer")
    public void kullaniciDanSonraOzelKarakterIcerenBirMailGirer(String str) {
        mertPage.emailBox.sendKeys("user@"+"gmail"+str+"!com");
    }

}

