package stepDefinitions.DBStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;

import static utilities.DBUtils.closeConnection;
import static utilities.DBUtils.executeQuery;

public class US007 {


    @Given("Kullanici DB ile baglanti kurar")
    public void kullanici_db_ile_baglanti_kurar() {

        DBUtils.createStaffConnection();
    }

    @When("Kullanici randevu bilgilerini alir")
    public void kullaniciRandevuBilgileriniAlir() {
        String query="select*from patient";
        executeQuery(query);
    }

    @Then("Kullanici randevu bilgilerini validate eder")
    public void kullanici_randevu_bilgilerini_validate_eder() {
        List<Object> allFirstNameColumnData = DBUtils.getColumnData("select * from patient","first_name");
        System.out.println("FirstName : "+allFirstNameColumnData);
        Assert.assertTrue(allFirstNameColumnData.contains("yeniFirstName"));

        List<Object> allLastNameColumnData = DBUtils.getColumnData("select * from patient","last_name");
        System.out.println("LastName : "+allLastNameColumnData);
        Assert.assertTrue(allLastNameColumnData.contains("yeniLastName"));

        List<Object> allPhoneColumnData = DBUtils.getColumnData("select * from patient","phone");
        System.out.println("phone : "+allPhoneColumnData);
        Assert.assertTrue(allPhoneColumnData.contains("555-222-4563"));

        List<Object> allEmailColumnData = DBUtils.getColumnData("select * from patient","email");
        System.out.println("email : "+allEmailColumnData);
        Assert.assertTrue(allEmailColumnData.contains("yeni4@gmail.com"));
    }

    @Then("Kullanici DB baglantisini kapatir")
    public void kullanici_db_baglantisini_kapatir() {
        closeConnection();
    }

}
