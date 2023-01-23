package stepDefinitions.UIStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;
import pages.Defnepage;
import utilities.ConfigReader;
import utilities.Driver;

public class US003 {


    Defnepage defnepage = new Defnepage();
    Faker faker = new Faker();

    String password = "";
    String kucuk;
    String buyuk;
    String sayi;
    String ozel;



    @Given("kullanici {string} anasayfasinda")
    public void kullaniciAnasayfasinda(String arg0) {

        Driver.getDriver().get(ConfigReader.getProperty("medunnaURL"));


    }

    @Then("kullanici user sembolune basar")
    public void kullaniciUserSemboluneBasar() {

        defnepage.AccountMenu.click();
    }

    @And("kullanici register butonuna basar")
    public void kullaniciRegisterButonunaBasar() {

        defnepage.register.click();
    }

    @And("kucuk harf eklenince password strength kontrol eder")
    public void kucukHarfEklenincePasswordStrengthKontrolEder() throws InterruptedException {
        kucuk = faker.name().firstName().toLowerCase();
        defnepage.registerNewPassword.sendKeys(kucuk);

        String actualStrengthBar1 = defnepage.passwordStrength1.getAttribute("style");
        String actualStrengthBar2 = defnepage.passwordStrength2.getAttribute("style");
        String actualStrengthBar3 = defnepage.passwordStrength3.getAttribute("style");
        String actualStrengthBar4 = defnepage.passwordStrength4.getAttribute("style");
        String actualStrengthBar5 = defnepage.passwordStrength5.getAttribute("style");
        String expectedStrengthBar1 = "background-color: rgb(255, 0, 0);";
        String expectedStrengthBar2 = "background-color: rgb(221, 221, 221);";
        String expectedStrengthBar3 = "background-color: rgb(221, 221, 221);";
        String expectedStrengthBar4 = "background-color: rgb(221, 221, 221);";
        String expectedStrengthBar5 = "background-color: rgb(221, 221, 221);";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualStrengthBar1, expectedStrengthBar1);
        softAssert.assertEquals(actualStrengthBar2, expectedStrengthBar2);
        softAssert.assertEquals(actualStrengthBar3, expectedStrengthBar3);
        softAssert.assertEquals(actualStrengthBar4, expectedStrengthBar4);
        softAssert.assertEquals(actualStrengthBar5, expectedStrengthBar5);
        softAssert.assertAll();

        Thread.sleep(1000);
        System.out.println("kucuk eklenmiş: " + kucuk);


    }

    @And("buyuk harf eklenince password strength kontrol eder")
    public void buyukHarfEklenincePasswordStrengthKontrolEder() throws InterruptedException {

        buyuk = faker.name().firstName().toUpperCase();
        defnepage.registerNewPassword.sendKeys(buyuk);

        String actualStrengthBar1 = defnepage.passwordStrength1.getAttribute("style");
        String actualStrengthBar2 = defnepage.passwordStrength2.getAttribute("style");
        String actualStrengthBar3 = defnepage.passwordStrength3.getAttribute("style");
        String actualStrengthBar4 = defnepage.passwordStrength4.getAttribute("style");
        String actualStrengthBar5 = defnepage.passwordStrength5.getAttribute("style");
        String expectedStrengthBar1 = "background-color: rgb(255, 153, 0);";
        String expectedStrengthBar2 = "background-color: rgb(255, 153, 0);";
        String expectedStrengthBar3 = "background-color: rgb(221, 221, 221);";
        String expectedStrengthBar4 = "background-color: rgb(221, 221, 221);";
        String expectedStrengthBar5 = "background-color: rgb(221, 221, 221);";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualStrengthBar1, expectedStrengthBar1);
        softAssert.assertEquals(actualStrengthBar2, expectedStrengthBar2);
        softAssert.assertEquals(actualStrengthBar3, expectedStrengthBar3);
        softAssert.assertEquals(actualStrengthBar4, expectedStrengthBar4);
        softAssert.assertEquals(actualStrengthBar5, expectedStrengthBar5);
        softAssert.assertAll();

        Thread.sleep(1000);
        System.out.println("Büyük eklenmiş: " + kucuk + buyuk);
    }

    @And("sayi eklenince password strength kontrol eder")
    public void sayiEklenincePasswordStrengthKontrolEder() throws InterruptedException {

        sayi = "999";
        defnepage.registerNewPassword.sendKeys(sayi);

        String actualStrengthBar1 = defnepage.passwordStrength1.getAttribute("style");
        String actualStrengthBar2 = defnepage.passwordStrength2.getAttribute("style");
        String actualStrengthBar3 = defnepage.passwordStrength3.getAttribute("style");
        String actualStrengthBar4 = defnepage.passwordStrength4.getAttribute("style");
        String actualStrengthBar5 = defnepage.passwordStrength5.getAttribute("style");
        String expectedStrengthBar1 = "background-color: rgb(153, 255, 0);";
        String expectedStrengthBar2 = "background-color: rgb(153, 255, 0);";
        String expectedStrengthBar3 = "background-color: rgb(153, 255, 0);";
        String expectedStrengthBar4 = "background-color: rgb(153, 255, 0);";
        String expectedStrengthBar5 = "background-color: rgb(221, 221, 221);";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualStrengthBar1, expectedStrengthBar1);
        softAssert.assertEquals(actualStrengthBar2, expectedStrengthBar2);
        softAssert.assertEquals(actualStrengthBar3, expectedStrengthBar3);
        softAssert.assertEquals(actualStrengthBar4, expectedStrengthBar4);
        softAssert.assertEquals(actualStrengthBar5, expectedStrengthBar5);
        softAssert.assertAll();

        Thread.sleep(1000);
        System.out.println("Sayı eklenmiş: " + kucuk + buyuk + sayi);
    }




    @And("ozel karakter password strength kontrol eder")
    public void ozelKarakterPasswordStrengthKontrolEder() {

        ozel = "!";
        defnepage.registerNewPassword.sendKeys(ozel);

        String actualStrengthBar1 = defnepage.passwordStrength1.getAttribute("style");
        String actualStrengthBar2 = defnepage.passwordStrength2.getAttribute("style");
        String actualStrengthBar3 = defnepage.passwordStrength3.getAttribute("style");
        String actualStrengthBar4 = defnepage.passwordStrength4.getAttribute("style");
        String actualStrengthBar5 = defnepage.passwordStrength5.getAttribute("style");
        String expectedStrengthBar1 = "background-color: rgb(153, 255, 0);";
        String expectedStrengthBar2 = "background-color: rgb(153, 255, 0);";
        String expectedStrengthBar3 = "background-color: rgb(153, 255, 0);";
        String expectedStrengthBar4 = "background-color: rgb(153, 255, 0);";
        String expectedStrengthBar5 = "background-color: rgb(221, 221, 221);";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualStrengthBar1, expectedStrengthBar1);
        softAssert.assertEquals(actualStrengthBar2, expectedStrengthBar2);
        softAssert.assertEquals(actualStrengthBar3, expectedStrengthBar3);
        softAssert.assertEquals(actualStrengthBar4, expectedStrengthBar4);
        softAssert.assertEquals(actualStrengthBar5, expectedStrengthBar5);
        //softAssert.assertAll();

        System.out.println("Özel eklenmiş: " + kucuk + buyuk + sayi + ozel);
    }



    @And("password uzunlugu en az {int} oldugunu kontrol eder")
    public void passwordUzunluguEnAzOldugunuKontrolEder(int expectedPasswordLength) {

        password = kucuk + buyuk + sayi + ozel;
        System.out.println("Son hal: " + password);
        int actualPasswordLength = password.length();
        System.out.println(actualPasswordLength);
        Assert.assertTrue(actualPasswordLength >= expectedPasswordLength);
    }

    @And("kucuk harf {string} eklenince password strength kontrol eder")

        public void kucukHarfEklenincePasswordStrengthKontrolEder(String kucukHarf) throws InterruptedException {
            kucuk = kucukHarf;
            password += kucuk;
            defnepage.registerNewPassword.sendKeys(kucuk);

        String actualStrengthBar1 = defnepage.passwordStrength1.getAttribute("style");
        String actualStrengthBar2 = defnepage.passwordStrength2.getAttribute("style");
        String actualStrengthBar3 = defnepage.passwordStrength3.getAttribute("style");
        String actualStrengthBar4 = defnepage.passwordStrength4.getAttribute("style");
        String actualStrengthBar5 = defnepage.passwordStrength5.getAttribute("style");
        String expectedStrengthBar1 = "background-color: rgb(153, 255, 0);";
        String expectedStrengthBar2 = "background-color: rgb(153, 255, 0);";
        String expectedStrengthBar3 = "background-color: rgb(153, 255, 0);";
        String expectedStrengthBar4 = "background-color: rgb(153, 255, 0);";
        String expectedStrengthBar5 = "background-color: rgb(221, 221, 221);";

            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(actualStrengthBar1, expectedStrengthBar1);
            softAssert.assertEquals(actualStrengthBar2, expectedStrengthBar2);
            softAssert.assertEquals(actualStrengthBar3, expectedStrengthBar3);
            softAssert.assertEquals(actualStrengthBar4, expectedStrengthBar4);
            softAssert.assertEquals(actualStrengthBar5, expectedStrengthBar5);
            //softAssert.assertAll();

            Thread.sleep(1000);
            System.out.println("kucuk eklenmiş: " + password);
    }


    //Scenariou outline ile yap
    //D, DD,DDD, DDDD, DDDDD, DDDDDD, DDDDDDD
    //9, 99, 999, 9999, 99999, 999999, 9999999
    //-, --, ---, ----, -----, ------, -------
    //Aşağıdaki durumlar için if else ile yap durumları kontrol et daha dinamik olur

        /*
        1. durum
        dA5-

        2. durum
        ddAA55-

        3. durum
       dddDDD5-

        4. durum
        ddddDDD5-

        Bu 5 durum yeterli

         */



    @And("buyuk harf {string} eklenince password strength kontrol eder")
    public void buyukHarfEklenincePasswordStrengthKontrolEder(String buyukHarf) {

        buyuk = buyukHarf;
        password += buyuk;
        defnepage.registerNewPassword.sendKeys(buyuk);

        String actualStrengthBar1 = defnepage.passwordStrength1.getAttribute("style");
        String actualStrengthBar2 = defnepage.passwordStrength2.getAttribute("style");
        String actualStrengthBar3 = defnepage.passwordStrength3.getAttribute("style");
        String actualStrengthBar4 = defnepage.passwordStrength4.getAttribute("style");
        String actualStrengthBar5 = defnepage.passwordStrength5.getAttribute("style");

        SoftAssert softAssert = new SoftAssert();

        if (password.length() < 7) {
            String expectedStrengthBar1 = "background-color: rgb(255, 0, 0);";
            String expectedStrengthBar2 = "background-color: rgb(221, 221, 221);";
            String expectedStrengthBar3 = "background-color: rgb(221, 221, 221);";
            String expectedStrengthBar4 = "background-color: rgb(221, 221, 221);";
            String expectedStrengthBar5 = "background-color: rgb(221, 221, 221);";

            softAssert.assertEquals(actualStrengthBar1, expectedStrengthBar1);
            softAssert.assertEquals(actualStrengthBar2, expectedStrengthBar2);
            softAssert.assertEquals(actualStrengthBar3, expectedStrengthBar3);
            softAssert.assertEquals(actualStrengthBar4, expectedStrengthBar4);
            softAssert.assertEquals(actualStrengthBar5, expectedStrengthBar5);
            softAssert.assertTrue(password.length() < 7);

        } else if (password.length() >= 7) {
            String expectedStrengthBar1 = "background-color: rgb(255, 0, 0);";
            String expectedStrengthBar2 = "background-color: rgb(221, 221, 221);";
            String expectedStrengthBar3 = "background-color: rgb(221, 221, 221);";
            String expectedStrengthBar4 = "background-color: rgb(221, 221, 221);";
            String expectedStrengthBar5 = "background-color: rgb(221, 221, 221);";

            softAssert.assertEquals(actualStrengthBar1, expectedStrengthBar1);
            softAssert.assertEquals(actualStrengthBar2, expectedStrengthBar2);
            softAssert.assertEquals(actualStrengthBar3, expectedStrengthBar3);
            softAssert.assertEquals(actualStrengthBar4, expectedStrengthBar4);
            softAssert.assertEquals(actualStrengthBar5, expectedStrengthBar5);
            softAssert.assertTrue(password.length() >= 7);

        }
    }

  @And("{string} eklenince password strength kontrol eder")
    public void eklenincePasswordStrengthKontrolEder(String sayi) {

      sayi = sayi;
      password += sayi;
      defnepage.registerNewPassword.sendKeys(sayi);

      String actualStrengthBar1 = defnepage.passwordStrength1.getAttribute("style");
      String actualStrengthBar2 = defnepage.passwordStrength2.getAttribute("style");
      String actualStrengthBar3 = defnepage.passwordStrength3.getAttribute("style");
      String actualStrengthBar4 = defnepage.passwordStrength4.getAttribute("style");
      String actualStrengthBar5 = defnepage.passwordStrength5.getAttribute("style");

      SoftAssert softAssert = new SoftAssert();

      if (password.length() < 7) {
          String expectedStrengthBar1 = "background-color: rgb(255, 0, 0);";
          String expectedStrengthBar2 = "background-color: rgb(221, 221, 221);";
          String expectedStrengthBar3 = "background-color: rgb(221, 221, 221);";
          String expectedStrengthBar4 = "background-color: rgb(221, 221, 221);";
          String expectedStrengthBar5 = "background-color: rgb(221, 221, 221);";

          softAssert.assertEquals(actualStrengthBar1, expectedStrengthBar1);
          softAssert.assertEquals(actualStrengthBar2, expectedStrengthBar2);
          softAssert.assertEquals(actualStrengthBar3, expectedStrengthBar3);
          softAssert.assertEquals(actualStrengthBar4, expectedStrengthBar4);
          softAssert.assertEquals(actualStrengthBar5, expectedStrengthBar5);
          softAssert.assertTrue(password.length() < 7);

      } else if (password.length() >= 7) {
          String expectedStrengthBar1 = "background-color: rgb(255, 0, 0);";
          String expectedStrengthBar2 = "background-color: rgb(221, 221, 221);";
          String expectedStrengthBar3 = "background-color: rgb(221, 221, 221);";
          String expectedStrengthBar4 = "background-color: rgb(221, 221, 221);";
          String expectedStrengthBar5 = "background-color: rgb(221, 221, 221);";

          softAssert.assertEquals(actualStrengthBar1, expectedStrengthBar1);
          softAssert.assertEquals(actualStrengthBar2, expectedStrengthBar2);
          softAssert.assertEquals(actualStrengthBar3, expectedStrengthBar3);
          softAssert.assertEquals(actualStrengthBar4, expectedStrengthBar4);
          softAssert.assertEquals(actualStrengthBar5, expectedStrengthBar5);
          softAssert.assertTrue(password.length() >= 7);

      }
    }

    @And("ozel karakter {string} password strength kontrol eder")
    public void ozelKarakterPasswordStrengthKontrolEder(String ozelKarakter) {

        ozelKarakter = ozelKarakter;
        password += ozelKarakter;
        defnepage.registerNewPassword.sendKeys(ozelKarakter);

        String actualStrengthBar1 = defnepage.passwordStrength1.getAttribute("style");
        String actualStrengthBar2 = defnepage.passwordStrength2.getAttribute("style");
        String actualStrengthBar3 = defnepage.passwordStrength3.getAttribute("style");
        String actualStrengthBar4 = defnepage.passwordStrength4.getAttribute("style");
        String actualStrengthBar5 = defnepage.passwordStrength5.getAttribute("style");

        SoftAssert softAssert = new SoftAssert();

        if (password.length() < 7) {
            String expectedStrengthBar1 = "background-color: rgb(255, 0, 0);";
            String expectedStrengthBar2 = "background-color: rgb(221, 221, 221);";
            String expectedStrengthBar3 = "background-color: rgb(221, 221, 221);";
            String expectedStrengthBar4 = "background-color: rgb(221, 221, 221);";
            String expectedStrengthBar5 = "background-color: rgb(221, 221, 221);";

            softAssert.assertEquals(actualStrengthBar1, expectedStrengthBar1);
            softAssert.assertEquals(actualStrengthBar2, expectedStrengthBar2);
            softAssert.assertEquals(actualStrengthBar3, expectedStrengthBar3);
            softAssert.assertEquals(actualStrengthBar4, expectedStrengthBar4);
            softAssert.assertEquals(actualStrengthBar5, expectedStrengthBar5);
            softAssert.assertTrue(password.length() < 7);

        } else if (password.length() >= 7) {
            String expectedStrengthBar1 = "background-color: rgb(255, 0, 0);";
            String expectedStrengthBar2 = "background-color: rgb(221, 221, 221);";
            String expectedStrengthBar3 = "background-color: rgb(221, 221, 221);";
            String expectedStrengthBar4 = "background-color: rgb(221, 221, 221);";
            String expectedStrengthBar5 = "background-color: rgb(221, 221, 221);";

            softAssert.assertEquals(actualStrengthBar1, expectedStrengthBar1);
            softAssert.assertEquals(actualStrengthBar2, expectedStrengthBar2);
            softAssert.assertEquals(actualStrengthBar3, expectedStrengthBar3);
            softAssert.assertEquals(actualStrengthBar4, expectedStrengthBar4);
            softAssert.assertEquals(actualStrengthBar5, expectedStrengthBar5);
            softAssert.assertTrue(password.length() >= 7);

        }
    }
}
