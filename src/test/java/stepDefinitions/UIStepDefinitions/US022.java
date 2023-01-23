package stepDefinitions.UIStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import pages.EnesPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class US022 {



        EnesPage enesPage = new EnesPage();
        US021 us021=new US021();


        @And("Kullanici SSN textbox'in Enable oldugunu dogrular")
        public void kullaniciSSNTextboxInEnableOldugunuDogrular () {

            Assert.assertTrue(enesPage.searchPatientPageSearchBox.isEnabled());
        }

        @And("Kullanici aranan SSN ile gelen hasta SNN'inini dogrular")
        public void kullaniciArananSSNIleGelenHastaSNNIniniDogrular () {
            System.out.println(enesPage.ssnDogrulama.getText());
            String expectedSSN = "212-34-1907";
            Assert.assertTrue(enesPage.ssnDogrulama.getText().equals(expectedSSN));
        }

        @And("Kullanici {string} bilgisine gore  {string} olan randevu icin Show Test butonuna tiklar")
        public void kullaniciBilgisineGoreOlanRandevuIcinShowTestButonunaTiklar (String header, String data){
            int rowIndex = 0;

            for (WebElement each : enesPage.indexeGoreSutunListi(enesPage.sutunIndexiDondur(header))
            ) {
                if (each.getText().equalsIgnoreCase(data)) {
                    break;
                } else {
                    rowIndex++;
                }

            }
            System.out.println(rowIndex);
            enesPage.showTestButonList.get(rowIndex).click();


        }

        @Then("Kullanici View Result butonuna tiklar")
        public void kullaniciViewResultButonunaTiklar () {

            enesPage.viewResultsButon.click();

        }

        @Then("Kullanici testlerin goruldugunu dogrular")
        public void kullaniciTestlerinGoruldugunuDogrular () {
            Assert.assertFalse(enesPage.testList.isEmpty());
        }

        @And("Kullanici {string} bilgisine gore  {string} olan randevu icin Edit Butonuna tiklar")
        public void kullaniciBilgisineGoreOlanRandevuIcinEditButonunaTiklar (String header, String data){

            int rowIndex = 0;

            for (WebElement each : enesPage.indexeGoreSutunListi(enesPage.sutunIndexiDondur(header))
            ) {
                if (each.getText().equalsIgnoreCase(data)) {
                    break;
                } else {
                    rowIndex++;
                }

            }
            System.out.println(rowIndex);
            enesPage.testResultEditList.get(rowIndex).click();
        }

        @And("Kullanici ID,Date, Result, Description gorebilmelidir")
        public void kullaniciIDDateResultDescriptionGorebilmelidir () {

            Assert.assertTrue(enesPage.testResultIDTextBox.isDisplayed());
            Assert.assertTrue(enesPage.testResultDateTextBox.isDisplayed());
            Assert.assertTrue(enesPage.testResultResultTextBox.isDisplayed());
            Assert.assertTrue(enesPage.testResultDescriptionTextBox.isDisplayed());
        }

        @And("Kullanici ID,Date, Result, Description guncelleyebilmelidr")
        public void kullaniciIDDateResultDescriptionGuncelleyebilmelidr () {
            SoftAssert softAssert = new SoftAssert();
            enesPage.testResultResultTextBox.sendKeys("Staff tarafindan Guncellendi");
            enesPage.testResultDescriptionTextBox.sendKeys("Staff tarafindan Guncellendi");
            softAssert.assertTrue(enesPage.testResultIDTextBox.isEnabled());
            softAssert.assertTrue(enesPage.testResultDateTextBox.isEnabled());
            softAssert.assertTrue(enesPage.testResultResultTextBox.isEnabled());
            softAssert.assertTrue(enesPage.testResultDescriptionTextBox.isEnabled());
            softAssert.assertAll();
        }

        @And("Kullanici test result sayfasinda save butonuna tiklar")
        public void kullaniciTestResultSayfasindaSaveButonunaTiklar () {

            us021.clickWithJS(enesPage.testResultSaveButonu);
        }




    }

