package stepDefinitions.UIStepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.AsimPage;
import utilities.Driver;

import static utilities.ReusableMethods.waitFor;

public class US013 {
    AsimPage doktor = new AsimPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    @Then("Doktor Show Test Result butonuna tiklar")
    public void doktor_show_test_result_butonuna_tiklar() {
    doktor.showTestResults.click();
    }
    @Then("Doktor hastanin View Result butonuna tiklar")
    public void doktor_hastanin_view_result_butonuna_tiklar() {
    doktor.viewResultsButton.click();
    waitFor(2);
    }
    @Then("Doktor id, name, default max value, defaut min value, test, description ve date bilgilerinin gorundugunu test eder")
    public void doktor_id_name_default_max_value_defaut_min_value_test_description_ve_date_bilgilerinin_gorundugunu_test_eder() {
        Assert.assertTrue(doktor.id.isEnabled());
        Assert.assertTrue(doktor.name.isEnabled());
        Assert.assertTrue(doktor.result.isDisplayed());
        Assert.assertTrue(doktor.defaultMinValue.isDisplayed());
        Assert.assertTrue(doktor.defaultMaxValue.isDisplayed());
        Assert.assertTrue(doktor.test.isDisplayed());
        Assert.assertTrue(doktor.description.isDisplayed());
        Assert.assertTrue(doktor.date.isDisplayed());
    }
    @Then("Doktor Request Inpatient butonuna tiklar")
    public void doktor_request_inpatient_butonuna_tiklar() {

        waitFor(5);
        js.executeScript("arguments[0].click();",doktor.requestInpatient);
    }
    @Then("Doktor A new in Patient is created with identifier yazisini goruntuler")
    public void doktor_a_new_in_patient_is_created_with_identifier_yazisini_goruntuler() {
    Assert.assertTrue(doktor.newInpatientIsCreatedText.isDisplayed());
    }

}
