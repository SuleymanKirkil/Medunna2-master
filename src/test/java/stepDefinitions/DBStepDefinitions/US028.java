package stepDefinitions.DBStepDefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;

public class US028 {

        @Given("Kullanici connection olusturur")
        public void kullanici_connection_olusturur() {
            DBUtils.createConnection();
        }
        @Given("Kullanici ulke sutunundaki verileri alir ve dogrular")
        public void kullanici_ulke_sutunundaki_verileri_alir() {
           // List<Object> list = DBUtils.getColumnData("Select * from country ", "name");
            //System.out.println(list);
            //Assert.assertTrue(list.contains("Bremen"));


            List<Object> allMessageColumnData = DBUtils.getColumnData("select * public.country","name");
            System.out.println("list");
            Assert.assertTrue(allMessageColumnData.toString().contains("Bremen"));



        }
    }
