package stepDefinitions.DBStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;

import static utilities.DBUtils.closeConnection;
import static utilities.DBUtils.executeQuery;

public class US027 {
    @Given("Admin 27 database ile baglanti kurar")
    public void admin_database_ile_baglanti_kurar() {
        DBUtils.createConnection();
    }

    @When("Admin mesaj bilgilerini alir")
    public void admin_mesaj_bilgilerini_alir() {
        String query="select*from cmessage";
        executeQuery(query);
    }
    @Then("Admin mesaj bilgilerini validate eder")
    public void admin_mesaj_bilgilerini_validate_eder() {
        List<Object> allIdColumnData = DBUtils.getColumnData("select * from cmessage","id");
        System.out.println("id : "+allIdColumnData);
        Assert.assertTrue(allIdColumnData.toString().contains("235517"));

        List<Object> allNameColumnData = DBUtils.getColumnData("select * from cmessage","name");
        System.out.println("name : "+allNameColumnData);
        Assert.assertTrue(allNameColumnData.contains("medunna50"));

        List<Object> allEmailColumnData = DBUtils.getColumnData("select * from cmessage","email");
        System.out.println("email : "+allEmailColumnData);
        Assert.assertTrue(allEmailColumnData.contains("medunna50@gmail.com"));

        List<Object> allSubjectColumnData = DBUtils.getColumnData("select * from cmessage","subject");
        System.out.println("subject : "+allSubjectColumnData);
        Assert.assertTrue(allSubjectColumnData.contains("hayat"));

        List<Object> allMessageColumnData = DBUtils.getColumnData("select * from cmessage","message");
        System.out.println("message : "+allMessageColumnData);
        Assert.assertTrue(allMessageColumnData.contains("hayat guzeldir"));
    }

    @Then("Admin database baglantisini kapatir")
    public void admin_database_baglantisini_kapatir() {
       closeConnection();
    }

}
