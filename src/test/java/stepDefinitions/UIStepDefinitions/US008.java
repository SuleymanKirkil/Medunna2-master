package stepDefinitions.UIStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.Defnepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

import static utilities.ReusableMethods.waitFor;

public class US008 {

    Defnepage defnepage=new Defnepage();


    @Given("kullanici  medunnaURl adresine gider")
    public void kullaniciMedunnaURlAdresineGider() {

        Driver.getDriver().get(ConfigReader.getProperty("medunnaURL"));
    }

    @And("Kullanıcı {string}menusune  tiklar")
    public void kullanıcıMenusuneTiklar(String arg0) {

        defnepage.AccountMenu.click();
         waitFor(3);
    }

    @And("Kullanıcı {string} butonuna tiklar")
    public void kullanıcıButonunaTiklar(String arg0) {

        defnepage.SingIN.click();
        waitFor(3);
    }

    @And("Kullanıcı  username ve passwordu girer")
    public void kullanıcıUsernameVePassworduGirer() {


        defnepage.UserName.sendKeys(ConfigReader.getProperty("username"));
        defnepage.Password.sendKeys(ConfigReader.getProperty("password"));
        waitFor(3);
    }

    @And("Kullanıcı {string} kutusuna tiklar")
    public void kullanıcıKutusunaTiklar(String arg0) {
        defnepage.SingIN2.click();
        waitFor(3);

    }

    @And("Kullanıcı basari ile giris yapildigini dogrular")
    public void kullanıcıBasariIleGirisYapildiginiDogrular() {

        Assert.assertTrue(defnepage.WelcomeMedunna.isDisplayed());
        waitFor(3);
    }

    @And("Kullanıcı Account Pagede ki Account menusune tiklar")
    public void kullanıcıAccountPagedeKiAccountMenusuneTiklar() {

        defnepage.AdminDefne.click();
        waitFor(3);
    }

    @Then("Kullanıcı {string} a tıklar.")
    public void kullanıcıATıklar(String Password2) {

        defnepage.Password2.click();
        waitFor(3);
    }


    @And("Kullanıcı {string} kısmına yenı password girer")
    public void kullanıcıKısmınaYenıPasswordGirer(String currentPassword) throws InterruptedException {

        defnepage.CurrentPassword.sendKeys(currentPassword);
        Thread.sleep(2000);
        
    }

    @And("Kullanıcı new passworda  {string}   girer.")
    public void kullanıcıNewPasswordaGirer(String newPassword) throws InterruptedException {

        defnepage.NewPassword.sendKeys(newPassword);
        Thread.sleep(2000);

    }

    @And("Kullanıcı confimation passworda {string} girer")
    public void kullanıcıConfimationPasswordaGirer(String  confirmationPassword ) throws InterruptedException {

        defnepage.ConfirmPassword.sendKeys( confirmationPassword );
        Thread.sleep(2000);

    }

    @And("kullanıcı  {string} e tiklar.")
    public void kullanıcıETiklar(String arg0) {

        defnepage.Save.click();
        waitFor(3);
        
    }

    @And("Kullanıcı {string} yazisini dogrular.")
    public void kullanıcıYazisiniDogrular(String arg0) throws InterruptedException {

       Assert.assertTrue( defnepage.passwordChangedText.isDisplayed());
        Thread.sleep(2000);

    }

    @And("Kullanıcı New Password kismini temizler.")
    public void kullanıcıNewPasswordKisminiTemizler() {

        defnepage.NewPassword.clear();

    }

    @And("Kullanıcı new password kismina  {string}  gonderir")
    public void kullanıcıNewPasswordKisminaGonderir(String newpassword) {

        defnepage.NewPassword.sendKeys(newpassword);

    }

    @And("Kullanıcı strenght barin tek tik oldugunu dogrular")
    public void kullanıcıStrenghtBarinTekTikOldugunuDogrular() {

        Assert.assertTrue(defnepage.passwordStrength1.isDisplayed());

    }

    @And("Kullanıcı new password kismina kucuk harf {string} ekler")
    public void kullanıcıNewPasswordKisminaKucukHarfEkler(String  addcharacter) {

        defnepage.NewPassword.sendKeys( addcharacter);

    }

    @And("Kullanıcı strenght barin iki tik oldugunu dogrular")
    public void kullanıcıStrenghtBarinIkiTikOldugunuDogrular() {

        Assert.assertTrue(defnepage.passwordStrength2.isDisplayed());
    }

    @And("Kullanıcı new password kismina buyuk harf {string} ekler")
    public void kullanıcıNewPasswordKisminaBuyukHarfEkler(String addcharacter) {

        defnepage.NewPassword.sendKeys( addcharacter);
    }

    @And("kullanici strenght barin dort tik oldugunu dogrular.")
    public void kullaniciStrenghtBarinDortTikOldugunuDogrular() {

        Assert.assertTrue(defnepage.passwordStrength4.isDisplayed());
    }

    @And("kullanici new password kismina rakam {string} ekler.")
    public void kullaniciNewPasswordKisminaRakamEkler(String addcharacter) {

        defnepage.NewPassword.sendKeys( addcharacter);
    }

    @And("kullanici strenght barin bes tik oldugunu dogrular.")
    public void kullaniciStrenghtBarinBesTikOldugunuDogrular() {

        Assert.assertTrue(defnepage.passwordStrength5.isDisplayed());
    }

    @And("kullanici new password kismina ozel karakter {string} ekler.")
    public void kullaniciNewPasswordKisminaOzelKarakterEkler(String addcharacter) {

        defnepage.NewPassword.sendKeys( addcharacter);
    }

    @And("kullanici new password kismina yeni karaketer {string} ekler.")
    public void kullaniciNewPasswordKisminaYeniKaraketerEkler(String addcharacter) {

        defnepage.NewPassword.sendKeys( addcharacter);
    }

    @And("kullanici Confirmation Password kismini temizler")
    public void kullaniciConfirmationPasswordKisminiTemizler() {

        defnepage.CurrentPassword.clear();
    }

    @Then("kullanıcı mesaj kutusundaki başarı mesajını bir BUG olarak görür.")
    public void kullanıcıMesajKutusundakiBaşarıMesajınıBirBUGOlarakGörür() throws InterruptedException, IOException {

        String expectedResult="Password changed!";
        String actualResult=defnepage.passwordChangedText.getText();
        Assert.assertEquals(expectedResult,actualResult);
        ReusableMethods.getScreenshot("password changed");
        Thread.sleep(4000);
    }

    @And("user verifies the success message on the toast container box")
    public void userVerifiesTheSuccessMessageOnTheToastContainerBox() throws InterruptedException {
        String expectedResult="Password changed!";
        String actualResult=defnepage.passwordChangedText.getText();
        Assert.assertEquals(expectedResult,actualResult);
        Thread.sleep(4000);
    }


    /*@Then("kullanici driveri kapatır.")
    public void kullaniciDriveriKapatır() {
        Driver.closeDriver();*/
    }












    
    
