package stepDefinitions.UIStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pages.EnesPage;
import utilities.Driver;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static utilities.ReusableMethods.waitFor;

public class US021 {
    Actions actions = new Actions(Driver.getDriver());
    EnesPage enesPage22 = new EnesPage();
    Select select;
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(60));
    LocalDate trh = LocalDate.now();
    LocalDateTime tarihSaat = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");
    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/YY");
    DateTimeFormatter formatterSaat = DateTimeFormatter.ofPattern("h:mm");
    String guncelTarih = tarihSaat.format(formatter);
    String guncelTarihinBirGunSonrasi = tarihSaat.plusDays(1).format(formatter);
    String expectedGuncelTarih = tarihSaat.format(formatter2);
    String expectedGuncelTarihinBirGunSonrasi = tarihSaat.plusDays(1).format(formatter2);


    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }


    @And("Kullanici Show Appointment Butonuna tiklar")
    public void kullaniciShowAppointmentButonunaTiklar() throws InterruptedException {
       /* Thread.sleep(1000);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(enesPage22.showAppointmentsButonu,Keys.ARROW_RIGHT);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(-500,0)");
        //Assert.assertTrue(enesPage22.showAppointmentsButonu.isEnabled());
        //enesPage22.showAppointmentsButonu.click();*/
        clickWithJS(enesPage22.showAppointmentsButonu);

    }


    @And("Kullanici {string} bilgisine gore  {string} olan randevusunun testine tiklar")
    public void kullaniciBilgisineGoreOlanRandevusununTestineTiklar(String header, String data) {

        int rowIndex = 0;

        for (WebElement each : enesPage22.indexeGoreSutunListi(enesPage22.sutunIndexiDondur(header))
        ) {
            if (each.getText().equalsIgnoreCase(data)) {
                break;
            } else {
                rowIndex++;
            }

        }
        enesPage22.showTestButonList.get(rowIndex).click();


    }

    @And("Kullanici {string} bilgisine gore  {string} olan randevu icin Edit butonuna tiklar")
    public void kullaniciBilgisineGoreOlanRandevuIcinEditButonunaTiklar(String header, String data) {
        int rowIndex = 0;

        for (WebElement each : enesPage22.indexeGoreSutunListi(enesPage22.sutunIndexiDondur(header))
        ) {
            if (each.getText().equalsIgnoreCase(data)) {
                break;
            } else {
                rowIndex++;
            }

        }
        System.out.println(rowIndex);
        enesPage22.editTestButonList.get(rowIndex).click();
    }

    @Then("Kullanici randevu saatini gunceller")
    public void kullaniciRandevuSaatiniGunceller() throws InterruptedException {

        enesPage22.startDateTextBox.sendKeys(guncelTarih);
        enesPage22.endDateTextBox.sendKeys(guncelTarihinBirGunSonrasi);

    }

    @Then("Kullanici guncellenen randevulari dogrular")
    public void kullaniciGuncellenenRandevulariDogrular() {
        String actualStringStartdate = enesPage22.actualStartDate.getText();
        String actualStringEnddate = enesPage22.actualEndDate.getText();

        Assert.assertTrue(actualStringStartdate.contains(expectedGuncelTarih));
        Assert.assertTrue(actualStringEnddate.contains(expectedGuncelTarihinBirGunSonrasi));

    }

    @And("Kullanici Status menusunu UNAPPROVED yapar")
    public void kullaniciStatusMenusunuUNAPPROVEDYapar() {
        Select select = new Select(enesPage22.statusDropDownMenu);
        select.selectByVisibleText("UNAPPROVED");

    }

    @And("Kullanici Status durumunun UNAPPROVED oldugunu dogrular")
    public void kullaniciStatusDurumununUNAPPROVEDOldugunuDogrular() {
        String expectedStatus = "UNAPPROVED";
        System.out.println(enesPage22.actualStatus);

        Assert.assertEquals(expectedStatus, enesPage22.actualStatus.getText());

    }

    @Then("Kullanici Status menusunu PENDING yapar")
    public void kullaniciStatusMenusunuPENDINGYapar() {
        Select select = new Select(enesPage22.statusDropDownMenu);
        select.selectByVisibleText("PENDING");

    }

    @And("Kullanici Status durumunun PENDING oldugunu dogrular")
    public void kullaniciStatusDurumununPENDINGOldugunuDogrular() {
        String expectedStatus = "PENDING";
        System.out.println(enesPage22.actualStatus.getText());

        Assert.assertEquals(expectedStatus, enesPage22.actualStatus.getText());

    }

    @Then("Kullanici Status menusunu CANCELLED yapar")
    public void kullaniciStatusMenusunuCANCELLEDYapar() {
        Select select = new Select(enesPage22.statusDropDownMenu);
        select.selectByVisibleText("CANCELLED");
    }

    @And("Kullanici Status durumunun CANCELLED oldugunu dogrular")
    public void kullaniciStatusDurumununCANCELLEDOldugunuDogrular() {
        String expectedStatus = "CANCELLED";
        System.out.println(enesPage22.actualStatus.getText());

        Assert.assertEquals(expectedStatus, enesPage22.actualStatus.getText());
    }

    @Then("Kullanici Status menusunde COMPLETED unclickable olmalidir")
    public void kullaniciStatusMenusunuCOMPLETEDUnclickableOlmalidir() {
        Select select = new Select(enesPage22.statusDropDownMenu);
        List<WebElement> dropDownList = select.getOptions();
        for (WebElement each : dropDownList
        ) {
            if (each.getText().equals("COMPLETED")) {
                Assert.assertFalse(each.isEnabled());
            }
        }


    }

    @And("Kullanici sayfayi asagi indirir")
    public void kullaniciSayfayiAsagiIndirir() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,1500)");

        /*actions.
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                perform();*/


    }

    @And("Kullanici Anamnesis textbox'in isEnable oldugunu dogrular")
    public void kullaniciAnamnesisTextboxInIsEnableOldugunuDogrular() {

        enesPage22.anemnesisTextBox.sendKeys("Bu kısım STAFF tarafindan dolduruldu ");
        Assert.assertFalse(enesPage22.anemnesisTextBox.isEnabled());
    }

    @And("Kullanici Treatment textbox'in isEnable oldugunu dogrular")
    public void kullaniciTreatmentTextboxInIsEnableOldugunuDogrular() {

        Assert.assertFalse(enesPage22.treatmentTextBox.isEnabled());
    }

    @And("Kullanici Diagnosis textbox'in isEnable oldugunu dogrular")
    public void kullaniciDiagnosisTextboxInIsEnableOldugunuDogrular() {
        Assert.assertFalse(enesPage22.diagnosisTextBox.isEnabled());
    }

    @And("Kullanici Anamnesis, Treatment, Diagnosis textbox'in isEnable olmadıgını dogrular")
    public void kullaniciAnamnesisTreatmentDiagnosisTextboxInIsEnableOlmadıgınıDogrular() {
        SoftAssert softAssert = new SoftAssert();
        enesPage22.anemnesisTextBox.sendKeys("Bu kısım STAFF tarafindan dolduruldu ");
        enesPage22.treatmentTextBox.sendKeys("Bu kısım STAFF tarafindan dolduruldu ");
        enesPage22.diagnosisTextBox.sendKeys("Bu kısım STAFF tarafindan dolduruldu ");
        softAssert.assertFalse(enesPage22.anemnesisTextBox.isEnabled());
        softAssert.assertFalse(enesPage22.treatmentTextBox.isEnabled());
        softAssert.assertFalse(enesPage22.diagnosisTextBox.isEnabled());
        softAssert.assertAll();
    }

    @Then("Kullanici Physician secer")
    public void kullaniciPhysicianSecer() throws InterruptedException {
        select = new Select(enesPage22.selectPhysicianBox);
        //waitFor(60);
        //actions.sendKeys(Keys.F5);
        //waitFor(50);
        //Driver.getDriver().navigate().refresh();
        //waitFor(5);


        String doctor = "211041:Doktor Jorge Jesus:DERMATOLOGY";

        clickWithJS(enesPage22.selectPhysicianBox);



        List<WebElement> doktorListesi;

        do {waitFor(5);
            doktorListesi = select.getOptions();
            System.out.println("Size:"+doktorListesi.size());

        }
        while (doktorListesi.size()<2);

        for (WebElement each : doktorListesi
        ) {
            if (each.getText().equals(doctor)) {
                each.click();
            }

        }

    }


    @And("Kullanici sectigi doktoru dogrular")
    public void kullaniciSectigiDoktoruDogrular() {
        String expectedDoctor="Doktor Jorge";
        System.out.println(enesPage22.selectPhysicianKontrol.getText());


        Assert.assertTrue(enesPage22.selectPhysicianKontrol.getText().equals(expectedDoctor));
    }
}









