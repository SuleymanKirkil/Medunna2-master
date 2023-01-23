package stepDefinitions.UIStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.MertPage;
import utilities.ConfigReader;

import static utilities.ReusableMethods.waitFor;

public class US024_US025 {
    MertPage mertPage = new MertPage();

    @Given("Kullanici sign-in butonuna tiklar")
    public void kullaniciSignInButonunaTiklar() {
        mertPage.accountMenu.click();
        mertPage.signInButton.click();
    }


    @Given("Kullanici gecerli bir {string} ile giris yapar")
    public void kullaniciGecerliBirIleGirisYapar(String hesap) {
        if (hesap.equalsIgnoreCase("hastaHesabi")) {
            mertPage.homeUsernameBox.sendKeys(ConfigReader.getProperty("patientUsername1"));
            mertPage.homePasswordBox.sendKeys(ConfigReader.getProperty("patientPassword1"));
            mertPage.signInButton2.click();
        }
        if (hesap.equalsIgnoreCase("adminHesabi")) {
            mertPage.homeUsernameBox.sendKeys(ConfigReader.getProperty("adminUsername"));
            mertPage.homePasswordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
            mertPage.signInButton2.click();
        }
        if (hesap.equalsIgnoreCase("doktorHesabi")) {
            mertPage.homeUsernameBox.sendKeys(ConfigReader.getProperty("doctorUsername"));
            mertPage.homePasswordBox.sendKeys(ConfigReader.getProperty("doctorPassword"));
            mertPage.signInButton2.click();
        }
        if (hesap.equalsIgnoreCase("staffHesabi")) {
            mertPage.homeUsernameBox.sendKeys(ConfigReader.getProperty("staffUsername"));
            mertPage.homePasswordBox.sendKeys(ConfigReader.getProperty("staffPassword"));
            mertPage.signInButton2.click();
        }

    }

    @And("Kullanici MyPages\\(Patient) butonuna tiklar")
    public void kullaniciMyPagesPatientButonunaTiklar() {
        mertPage.myPagesButton.click();
        waitFor(1);
    }

    @And("Kullanici MyAppointments butonuna tiklar")
    public void kullaniciMyAppointmentsButonunaTiklar() {
        mertPage.myAppointmentsButton.click();
    }

    @And("Kullanici MakeAnAppointment\\(Patient) butonuna tiklar")
    public void kullaniciMakeAnAppointmentPatientButonunaTiklar() {
        mertPage.makeAnAppointmentButton.click();
    }

    @Then("Kullanici randevunun tamamlandigi mesajini goruntuler")
    public void kullaniciRandevununTamamlandigiMesajiniGoruntuler() {
        Assert.assertTrue(mertPage.registrationSavedMessage.isDisplayed());
    }

    @And("Kullanici showInvoice butonuna tiklar")
    public void kullaniciShowInvoiceButonunaTiklar() {
        mertPage.showInvoiceButton.click();

    }

    @And("Kullanici goruntulemek istedigi test sonuclarindan birisini secer")
    public void kullaniciGoruntulemekIstedigiTestSonuclarindanBirisiniSecer() {
        mertPage.showTestButton.click();
    }

    @And("Kullanici sonuclari goruntule butonuna basar")
    public void kullaniciSonuclariGoruntuleButonunaBasar() {
        mertPage.viewResultsButton.click();
    }

    @And("Kullanici test sonuclari sayfasinda {string} bolumunun goruntulendigini dogrular")
    public void kullaniciTestSonuclariSayfasindaBolumununGoruntulendiginiDogrular(String column) {
        switch (column) {
            case "ID":
                Assert.assertTrue(mertPage.testResultsIDButton.isDisplayed());
                break;
            case "Name":
                Assert.assertTrue(mertPage.testResultsNameButton.isDisplayed());
                break;
            case "Default Min Value":
                Assert.assertTrue(mertPage.testResultsDefaultMinValueButton.isDisplayed());
                break;
            case "Default Max Value":
                Assert.assertTrue(mertPage.testResultsDefaultMaxValueButton.isDisplayed());
                break;
            case "Description":
                Assert.assertTrue(mertPage.testResultsDescriptionButton.isDisplayed());
                break;
            case "Date":
                Assert.assertTrue(mertPage.testResultsDateButton.isDisplayed());
                break;
            default:
                break;
        }
    }

    @And("Kullanici faturasinin gorutulenebildigini dogrular")
    public void kullaniciFaturasininGorutulenebildiginiDogrular() {
        Assert.assertTrue(mertPage.invoiceTableHeader.isDisplayed());
    }
}

