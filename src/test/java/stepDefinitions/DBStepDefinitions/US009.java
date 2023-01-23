package stepDefinitions.DBStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class US009 {
    List<Map<String, Object>> patientInfoTable;
    public static int newID;
    Connection connection;
    public static int check;

    @Given("User connects to DB")
    public void user_connects_to_db()
    {
        DBUtils.createConnection();
    }
    @When("User gets information from DB")
    public void user_gets_information_from_DB() {
        String query = "SELECT ssn, first_name, last_name, email FROM jhi_user WHERE EXISTS (SELECT * FROM patient WHERE patient.user_id = jhi_user.id)";
        patientInfoTable= DBUtils.getQueryResultMap(query);
        //System.out.println(patientInfoTable);
        System.out.println(patientInfoTable.size());

    }
    @Then("User verifies that patients exists in DB {string} {string} {string} {string}")
    public void user_verifies_that_patients_exists_in_db(String lastname, String firstname, String email, String ssn) {
        boolean flag=false;
        for (Map<String,Object> each : patientInfoTable ) {
            if (each.get("last_name").equals(lastname)&&
                    each.get("first_name").equals(firstname)&&
                    each.get("email").equals(email)&&
                    each.get("ssn").equals(ssn)) {
                flag=true;
                System.out.println(each);
            }
        }
        Assert.assertTrue(flag);
    }
    @Then("User closes the DB connection")
    public void user_closes_the_db_connection() {
        DBUtils.closeConnection();
    }
}
