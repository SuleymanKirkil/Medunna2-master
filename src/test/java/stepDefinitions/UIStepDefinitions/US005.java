package stepDefinitions.UIStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.SumeyraPage;
import utilities.ConfigReader;

public class US005 {
    SumeyraPage sumeyraPage=new SumeyraPage();


    @Given("kullanici Make an Appointment kutusuna tiklar")
    public void kullanici_make_an_appointment_kutusuna_tiklar() {
    sumeyraPage.makeAppointmentButton.click();
    }
    @Given("kullanici Make an Appointment sayfasinda Firstname,Lastname,SSN,Email, ve Phone bolumlerini bos birakir")
    public void kullanici_make_an_appointment_sayfasinda_firsname_lastname_ssn_email_ve_phone_bolumlerini_bos_birakir() {
        sumeyraPage.firstnameBox.sendKeys(" ");
        sumeyraPage.lastnameBox.sendKeys(" ");
        sumeyraPage.ssnNumberBox.sendKeys(" ");
        sumeyraPage.emailBox.sendKeys("test");
        sumeyraPage.phoneBox.sendKeys("123");
        sumeyraPage.appoDate.sendKeys(" ");

    }

    @Given("ilgili bolumler icin xxxx is required hata mesaji aldigini dogrular")
    public void ilgili_bolumler_icin_xxxx_is_required_hata_mesaji_aldigini_dogrular() {
        Assert.assertTrue(sumeyraPage.firstnameRequiredMessage.isDisplayed());
        Assert.assertTrue(sumeyraPage.lastnameRequiredMessage.isDisplayed());
        Assert.assertTrue(sumeyraPage.ssnRequiredMessage.isDisplayed());
        Assert.assertTrue(sumeyraPage.emailRequiredMessage.isDisplayed());
        Assert.assertTrue(sumeyraPage.phoneRequiredMessage.isDisplayed());


    }


    @Given("kullanici Make an Appointment sayfasinda Firstname,Lastname,SSN,Email bolumlerine gecerli degerler girer")
    public void kullanici_make_an_appointment_sayfasinda_firstname_lastname_ssn_email_bolumlerine_gecerli_degerler_girer() {
        sumeyraPage.firstnameBox.sendKeys(ConfigReader.getProperty("patientFirstname"));
        sumeyraPage.lastnameBox.sendKeys(ConfigReader.getProperty("patientLastname"));
        sumeyraPage.ssnNumberBox.sendKeys(ConfigReader.getProperty("patientSSN"));
        sumeyraPage.emailBox.sendKeys(ConfigReader.getProperty("patientEmail"));


    }
    @Given("Phone bolumune ucuncu ve altinci rakamdan sonra - olmayan ve ya on rakamli olmayan bir deger gir")
    public void phone_bolumune_ucuncu_ve_altinci_rakamdan_sonra_olmayan_ve_ya_on_rakamli_olmayan_bir_deger_gir() {
        sumeyraPage.phoneBox.sendKeys(ConfigReader.getProperty("patientInvalidPhone"));
        sumeyraPage.appoDate.sendKeys(" ");

    }


    @Given("Phone number is invalid hata mesaji gozuktugunu dogrular")
    public void phone_number_is_invalid_hata_mesaji_gozuktugunu_dogrular() {
        Assert.assertTrue(sumeyraPage.phoneInvalidMessage.isDisplayed());

    }

    @Given("kullanici Make an Appointment sayfasinda Firstname,Lastname,SSN,Email ve Phone bolumlerine gecerli degerler girer")
    public void kullanici_make_an_appointment_sayfasinda_firstname_lastname_ssn_email_ve_phone_bolumlerine_gecerli_degerler_girer() throws InterruptedException {
        sumeyraPage.firstnameBox.sendKeys(ConfigReader.getProperty("patientFirstname"));
        sumeyraPage.lastnameBox.sendKeys(ConfigReader.getProperty("patientLastname"));
        sumeyraPage.ssnNumberBox.sendKeys(ConfigReader.getProperty("patientSSN"));
        sumeyraPage.emailBox.sendKeys(ConfigReader.getProperty("patientEmail"));
        sumeyraPage.phoneBox.sendKeys("111-444-5687");
        sumeyraPage.appoDate.sendKeys("17.08.2028");
    }

    @Given("Send an Appointment Request butonuna tiklar")
    public void send_an_appointment_request_butonuna_tiklar() {
        sumeyraPage.sendRequestButton.submit();


    }

    @Given("Appointment registration saved! mesajı goruntulendigini dogrula")
    public void mesaji_goruntulendigini_dogrula (){
        Assert.assertTrue(sumeyraPage.registrationSavedMessage.isDisplayed());

    }

    @And("kullanici hasta hesabi ile giris yapar")
    public void kullaniciHastaHesabiIleGirisYapar() {
        sumeyraPage.usernameBox.sendKeys("HastaHarun1");
        sumeyraPage.passwordBox.sendKeys("h.hasta50");
        sumeyraPage.secondSigInButton.click();

    }

    @And("MY PAGES\\(PATIENTS) butonuna tiklar")
    public void myPAGESPATIENTSButonunaTiklar() {
        sumeyraPage.myPagesPatientButton.click();

    }

    @And("My Appointments secenegine tiklar")
    public void myAppointmentsSecenegineTiklar() {
        sumeyraPage.myAppointmentButton.click();

    }

    @And("Appoinments sayfasindan randevulari görüntüler")
    public void appoinmentsSayfasindanRandevulariGörüntüler() {
        Assert.assertTrue(sumeyraPage.appoinmentsPage.isDisplayed());
    }
}

