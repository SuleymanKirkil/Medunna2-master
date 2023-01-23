package stepDefinitions.DBStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.ConfigReader;
import utilities.DBUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utilities.DBUtils.createConnection;

public class US_016_RoomDb {



        @And("Odalar tablosunda oda bilgisini {string},{string},{string},{string},{string}kontrol eder")
        public void odalarTablosundaOdaBilgisiniKontrolEder(String roomID, String roomNumber, String roomType, String statusRooms, String descriptionRooms) {


            String query = "select * from room;";
            List<String> roomSorgu = DBUtils.getColumnNames(query);

            System.out.println(roomSorgu);

            List<Object> roomIDList = DBUtils.getColumnData(query, "id");
            List<Object> roomNumberList = DBUtils.getColumnData(query, "room_number");
            List<Object> roomTypeList = DBUtils.getColumnData(query, "room_type");
            List<Object> statusRoomsList = DBUtils.getColumnData(query, "status");
            List<Object> descriptionRoomsList = DBUtils.getColumnData(query, "description");

            System.out.println(roomIDList);
            System.out.println(roomNumberList);
            System.out.println(roomTypeList);
            System.out.println(statusRoomsList);
            System.out.println(descriptionRoomsList);


            int expectedId = Integer.parseInt(ConfigReader.getProperty("roomID"));
            List<Object> idList = new ArrayList<>(expectedId);
            //System.out.println(expectedIdList);
            Assert.assertTrue(roomIDList.containsAll(idList));


            int ecpectedRoomNumber = Integer.parseInt(ConfigReader.getProperty("roomNumber"));
            List<Object> expectedNumberList = new ArrayList<>(ecpectedRoomNumber);
            Assert.assertTrue(roomNumberList.containsAll(expectedNumberList));


            List<Object> ecpectedRoomType = new ArrayList<>(Collections.singleton(ConfigReader.getProperty("roomType")));
            System.out.println(ecpectedRoomType);
            Assert.assertTrue(roomTypeList.containsAll(ecpectedRoomType));


            List<Object> ecpectedStatusRooms = new ArrayList<>();
            ecpectedStatusRooms.add(false);
            System.out.println(ecpectedStatusRooms);
            Assert.assertTrue(statusRoomsList.containsAll(ecpectedStatusRooms));


            List<Object> ecpectedDescriptionRooms = new ArrayList<>(Collections.singleton(ConfigReader.getProperty("descriptionRooms")));
            Assert.assertTrue(descriptionRoomsList.containsAll(ecpectedDescriptionRooms));


        }


}
