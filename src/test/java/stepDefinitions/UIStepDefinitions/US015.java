package stepDefinitions.UIStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.NevalPage;
import utilities.ConfigReader;
import utilities.Driver;

import utilities.ReusableMethods;
import utilities.WriteToTxt;

import java.util.ArrayList;
import java.util.List;

public class US015 {
    NevalPage medunnaPage = new NevalPage();
    Actions actions;

    @Given("EA Kullanici Sag ust kosede bulunan icona tiklar")
    public void ea_kullanici_sag_ust_kosede_bulunan_icona_tiklar() {

    }

    @Given("Kullanici Sign-in butonuna tiklar")
    public void kullanici_sign_in_butonuna_tiklar() {
        medunnaPage.profilResmi.click();
        medunnaPage.signInButonu.click();

    }

    @Given("Kullanici Admin Username girer")
    public void kullanici_admin_username_girer() {
        medunnaPage.userNameKutusu.sendKeys(ConfigReader.getProperty("adminUsername"));


    }

    @Given("Kullanici Admin Password girer")
    public void kullanici_admin_password_girer() {
        medunnaPage.passwordKutusu.sendKeys(ConfigReader.getProperty("adminPassword"));

    }

    @Given("Kullanici ikinci Sign-in butonuna tiklar")
    public void kullanici_ikinci_sign_in_butonuna_tiklar() {
        medunnaPage.signinButonu2.click();

    }

    @And("Kullanici items&Titles bolumune tiklar")
    public void kullaniciItemsTitlesBolumuneTiklar() {
        medunnaPage.itemsTitles.click();
    }

    @Given("Kullanici Patient bolumune tiklar")
    public void kullanici_patient_bolumune_tiklar() {
        //   WebElement dropDownMenu= Driver.getDriver().findElement(By.xpath("//*[@class='dropdown show nav-item']"));
        //   Select select=new Select(dropDownMenu);
        medunnaPage.patient.click();


    }

    @Given("Kullanici acilan Patient sayfasindan Create or edit a Patient kutusuna tiklar")
    public void kullanici_acilan_patient_sayfasindan_create_or_edit_a_patient_kutusuna_tiklar() {
        medunnaPage.createNewPatient.click();
    }

    @Given("Kullanici hasta kaydi olusturabilmek icin gerekli olan First Name,Last Name, Birt Date, Email, Phone, Gender, Blood Group, Adress,Description, User, Country, StateCity bolumlere veri girisi yapar")
    public void kullanici_hasta_kaydi_olusturabilmek_icin_gerekli_olan_first_name_last_name_birt_date_email_phone_gender_blood_group_adress_description_user_country_state_city_bolumlere_veri_girisi_yapar() {
        actions = new Actions(Driver.getDriver());
        medunnaPage.createFirstname.click();
        Faker faker = new Faker();

        actions.sendKeys("John").sendKeys(Keys.TAB).
                sendKeys("Wick").sendKeys(Keys.TAB).
                sendKeys("10121997").sendKeys(Keys.TAB).sendKeys("0600").sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).
                sendKeys("847-009-7653").sendKeys(Keys.TAB).perform();
        Select select = new Select(medunnaPage.gender);
        select.selectByVisibleText("FEMALE");
        Select select2 = new Select(medunnaPage.kanGrubuDropDown);
        select2.selectByVisibleText("AB+");//faker.address().fullAddress()
        actions.sendKeys(Keys.TAB).sendKeys("Apt. 729 984 Cory Flat, Lake Lorenborough, MN 33972").sendKeys(Keys.TAB).
                sendKeys("flu").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
        Select select4 = new Select(medunnaPage.countryDropDown);
        select4.selectByVisibleText("USA");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    Select select3 = new Select(medunnaPage.StateCity);
    select3.selectByVisibleText("California");
     //  WriteToTxt.pasitionWriteText(medunnaPage.editFirstname.getAttribute("value"));
     //  WriteToTxt.pasitionWriteText(medunnaPage.editLastName.getAttribute("value"));
     //  WriteToTxt.pasitionWriteText(medunnaPage.settingsEmailKutusu.getAttribute("value"));

     //  System.out.println(ReadToTxt.readLastLinePatientList("src/test/resources/TestData/pasitionId.txt", 1));


    }

    @Given("Kullanici Save butonun tiklar")
    public void kullanici_save_butonun_tiklar() {
        medunnaPage.save.click();
    }

    @Given("Kullanici Yeni Hasta olusturuldugunu alert mesaji ile dogrular")
    public void kullanici_yeni_hasta_olusturuldugunu_alert_mesaji_ile_dogrular() {
        Assert.assertTrue(medunnaPage.patients.isDisplayed());
    }

    @Given("kullanici signout tusuna basar")
    public void kullanici_signout_tusuna_basar() {
medunnaPage.signOut.click();
    }
    @Given("Kullanici Created Date bolumune tiklar")
    public void kullanici_created_date_bolumune_tiklar() {

    }

    @Given("Kullanici ilk sirada gelen hastanin id numarasina tiklar")
    public void kullanici_ilk_sirada_gelen_hastanin_id_numarasina_tiklar() {
        medunnaPage.idTık.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        medunnaPage.enSonid.click();
        //  JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //  js.executeScript("window.scrollBy(0,500)");
        //  try {
        //      Thread.sleep(2000);
        //  } catch (InterruptedException e) {
        //      e.printStackTrace();
        //  }
        //  medunnaPage.sonSayfaGec.click();
        //  actions.click(medunnaPage.sonSayfaGec);
    }

    @Given("Kullanici SSN, First Name, Last Name, Birth Date, Phone, Gender, Blood Group,Address,Description, Created Date, User, Country and stateCity bilgilerinin gorunurlugunu test eder")
    public void kullanici_ssn_first_name_last_name_birth_date_phone_gender_blood_group_address_description_created_date_user_country_and_state_city_bilgilerinin_gorunurlugunu_test_eder() {
        Assert.assertTrue(medunnaPage.patientBilgiTablosu.isDisplayed());
        System.out.println("Hasta Bilgileri");

        List<String> bilgiler = new ArrayList<>();
        for (int i = 0; i < medunnaPage.patientbilgiler.size(); i++) {
            bilgiler.add(medunnaPage.patientbilgiler.get(i).getText());
        }
        System.out.println(bilgiler);
        Assert.assertTrue(bilgiler.contains("SSN"));
        Assert.assertTrue(bilgiler.contains("First Name"));
        Assert.assertTrue(bilgiler.contains("Last Name"));
        Assert.assertTrue(bilgiler.contains("Birth Date"));
        Assert.assertTrue(bilgiler.contains("Phone"));
        Assert.assertTrue(bilgiler.contains("Blood Group"));
        Assert.assertTrue(bilgiler.contains("Address"));
        Assert.assertTrue(bilgiler.contains("Description"));
        Assert.assertTrue(bilgiler.contains("Created Date"));
        Assert.assertTrue(bilgiler.contains("User"));
        Assert.assertTrue(bilgiler.contains("Country"));
        Assert.assertTrue(bilgiler.contains("State/City"));
    }
    @Given("Kullanici edit butonuna tiklar")
    public void kullanici_edit_butonuna_tiklar() throws InterruptedException {
        ReusableMethods.jsClick(medunnaPage.edit);
        //     ReusableMethods.waitForClickablility(medunnaPage.edit,5);
        // // asagidaki sign in butonu gorununceye kadar js ile scrool yapalim
        // JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
        // WebElement editsave= Driver.getDriver().findElement(By.xpath("//*[@id='save-entity']"));
        // Thread.sleep(3000);
        //  jse.executeScript("arguments[0].scrollIntoView(true);",editsave);
        // sign in butonuna js ile click yapalim
        // jse.executeScript("arguments[0].click();",editsave);


        //  Driver.getDriver().switchTo().alert().accept();


    }

    @Given("Kullanici Acilan sayfada  SSN, First Name, Last Name, Birth Date, Phone, Gender, Blood Group, Address, Description, Created Date, User, Country and stateCity gibi bilgilerden bazilarinda degisiklik yapar")
    public void kullanici_acilan_sayfada_ssn_first_name_last_name_birth_date_phone_gender_blood_group_address_description_created_date_user_country_and_state_city_gibi_bilgilerden_bazilarinda_degisiklik_yapar() throws InterruptedException {
        // Select select4 = new Select(medunnaPage.countryDropDown);
        // select4.selectByVisibleText("US");
        // Select select3 = new Select(medunnaPage.StateCity);
        // select3.selectByVisibleText("California");
        medunnaPage.editFirstname.clear();
        medunnaPage.editFirstname.sendKeys("John");
        //   Thread.sleep(10000);


        //  actions.click(medunnaPage.editSave).perform();


        //  js.executeScript("window.scrollBy(0,500)");

    }

    @And("Kullanici EditSave butonun tiklar")
    public void kullaniciEditSaveButonunTiklar() {
        ReusableMethods.waitForClickablity(medunnaPage.editSave, 10);
        ReusableMethods.jsClick(medunnaPage.editSave);


    }

    @Given("Kullanici hasta bilgilerinin guncellendigi dogrulanir")
    public void kullanici_hasta_bilgilerinin_guncellendigi_dogrulanir() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        medunnaPage.idTık.click();
        String guncellenmisIsım="";
        for (int i = 0; i < medunnaPage.satır.size(); i++) {
            guncellenmisIsım=medunnaPage.satır.get(2).getText();


        }
        System.out.println("guncellenmisIsim = " + guncellenmisIsım);
    }

    @Given("kullanici gerekli alanlari doldurur")
    public void kullanici_gerekli_alanlari_doldurur() {
        Actions actions;
        actions = new Actions(Driver.getDriver());
        medunnaPage.createFirstname.click();
        Faker faker = new Faker();

        actions.sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).
                sendKeys("10121997").sendKeys(Keys.TAB).sendKeys("0600").sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).
                sendKeys("847-009-7653").sendKeys(Keys.TAB).perform();
        Select select = new Select(medunnaPage.gender);
        select.selectByVisibleText("FEMALE");
        Select select2 = new Select(medunnaPage.kanGrubuDropDown);
        select2.selectByVisibleText("AB+");
        actions.sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB).
                sendKeys("flu").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }

    @And("kullanici country ve state alanlarini bos bırakir")
    public void kullaniciCountryVeStateAlanlariniBosBırakir() {
    }





    @Then("kullanici created uyarisinin cikdıgını test eder")
    public void kullaniciCreatedUyarisininCikdıgınıTestEder() {
        Assert.assertTrue(medunnaPage.successMessage.isDisplayed());
    }

    @And("Kullanici patient sayfasının cıktıgını test eder")
    public void kullaniciPatientSayfasınınCıktıgınıTestEder() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(medunnaPage.patients.isDisplayed());
    }
    @Given("herhangi bir hastanin deleted butonuna basar")
    public void herhangi_bir_hastanin_deleted_butonuna_basar() {
        medunnaPage.herhangiDelete.click();
        medunnaPage.delete2.click();
    }

    @And("herhangi bir hastanın silinemedigini dogrular")
    public void herhangiBirHastanınSilinemediginiDogrular() {
        Assert.assertTrue(medunnaPage.herhangiId.isDisplayed());
    }
    @And("Delete butonuna tıkla")
    public void deleteButonunaTıkla() {
        ReusableMethods.jsClick(medunnaPage.herhangiDelete);
    }

    @And("İkinci delete butonuna tıkla")
    public void ikinciDeleteButonunaTıkla() {ReusableMethods.jsClick(medunnaPage.delete2);
    }

    @And("Silinip silinmediğini test et")
    public void silinipSilinmediğiniTestEt() {medunnaPage.serverErrorHatasi.isDisplayed(); }

}




