package utilities;

import pojos.Us010.Appointment;
import pojos.Us010.Physician;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadTxt {
    public static List<String> getSSNIDs() {
        List<String> list = new ArrayList<>();


        try {

            //identify file location
            FileReader fileReader = new FileReader(ConfigReader.getProperty("database_registrant_data"));

            //Read the records of the file in given location
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();//856-45-6789,

            while (line != null) {

                String ssn = line.split(",")[0];
                list.add(ssn);

                line = br.readLine();

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return list;
    }


    public static List<String> getAPISSNIDs() {
        List<String> list = new ArrayList<>();


        try {

            //identify file location
            FileReader fileReader = new FileReader(ConfigReader.getProperty("api_all_registrant_data"));

            //Read the records of the file in given location
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();//856-45-6789,

            while (line != null) {

                String ssn = line.split(",")[2];
                list.add(ssn);

                line = br.readLine();

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return list;
    }

    public static List<Object> returnPhysicianIDsList(String filePath) {
        List<Object> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Physician physician = new Physician();
                physician.setId(Integer.parseInt(line.split(",")[0]));
                sb.append(System.lineSeparator());
                line = br.readLine();

//                System.out.println(i++);

                all.add(physician.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }


    public static List<String> returnPhysicianName(String filePath) {
        List<String> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Physician physician = new Physician();
                physician.setFirstName(line.split(",")[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();

//                System.out.println(i++);

                all.add(physician.getFirstName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }
    public static List<Object> returnAppointmentIDsList(String filePath) {
        List<Object> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Appointment appointment = new Appointment();
                appointment.setId(Integer.parseInt(line.split(",")[0]));
                sb.append(System.lineSeparator());
                line = br.readLine();
                all.add(appointment.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    public static List<Object> returnAppointmentStartDateList(String filePath) {
        List<Object> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Appointment appointment = new Appointment();
                appointment.setStartDate(line.split(",")[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();
                all.add(appointment.getStartDate());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    public static List<Object> returnAppointmentEndDateList(String filePath) {
        List<Object> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Appointment appointment = new Appointment();
                appointment.setEndDate(line.split(",")[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();
                all.add(appointment.getEndDate());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    public static List<Object> returnAppointmentStatusList(String filePath) {
        List<Object> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Appointment appointment = new Appointment();
                appointment.setStatus(line.split(",")[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();
                all.add(appointment.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

}