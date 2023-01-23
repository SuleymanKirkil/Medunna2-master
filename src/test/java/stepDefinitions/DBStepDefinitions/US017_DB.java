package stepDefinitions.DBStepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.*;
import java.util.List;


public class US017_DB {



    @Given("Admin database ile baglanti kurar")
    public void admin_database_ile_baglanti_kurar()throws SQLException {
     DBUtils.createConnection();



    }

    @When("Admin query tanimlar ve testItems olusturdugunu DB ile kontrol eder")
    public void adminQueryTanimlarVetestItemsOlusturdugunuDBIleKontrolEder() {

        String query = "select * from c_test_item";
        List<Object> list = DBUtils.getColumnData(query, "name");
        System.out.println(list + "\n");

        String expectedData = "Harun";
        System.out.println(expectedData);
        System.out.println(list.contains(expectedData));

        Assert.assertTrue(list.contains(expectedData));

    }



    @And("Admin DB'i kapatir")
    public void adminDBIKapatir() {
        DBUtils.closeConnection();

    }



}

