package utilities;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import static baseURLs.MedunnaBaseUrl.setUp;
import static baseURLs.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;


public class
ReusableMethods {
    public static void adminLogin() {
        HomePage homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("medunnaURL"));
        homePage.accountMenu.click();
        waitFor(1);
        homePage.signInButton.click();
        homePage.usernameBox.sendKeys(ConfigReader.getProperty("adminUsername"));
        homePage.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        homePage.signInButton2.click();
    }

    public static void doctorLogin() {
        HomePage homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("medunnaURL"));
        homePage.accountMenu.click();
        waitFor(1);
        homePage.signInButton.click();
        homePage.usernameBox.sendKeys(ConfigReader.getProperty("doctorUsername"));
        homePage.passwordBox.sendKeys(ConfigReader.getProperty("doctorPassword"));
        homePage.signInButton2.click();
    }

    public static void staffLogin() {
        HomePage homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("medunnaURL"));
        homePage.accountMenu.click();
        waitFor(1);
        homePage.signInButton.click();
        homePage.usernameBox.sendKeys(ConfigReader.getProperty("staffUsername"));
        homePage.passwordBox.sendKeys(ConfigReader.getProperty("staffPassword"));
        homePage.signInButton2.click();
    }

    public static void customerLogin() {
        HomePage homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("medunnaURL"));
        homePage.accountMenu.click();
        waitFor(1);
        homePage.signInButton.click();
        homePage.usernameBox.sendKeys(ConfigReader.getProperty("customerLogin"));
        homePage.passwordBox.sendKeys(ConfigReader.getProperty("customerPassword"));
        homePage.signInButton2.click();
    }

    public static String generateToken() {
        setUp();
        spec.pathParams("first", "api", "second", "authenticate");

        Map<String, Object> data = new HashMap<>();
        data.put("password", ConfigReader.getProperty("adminPassword"));
        data.put("rememberMe", true);
        data.put("username", ConfigReader.getProperty("adminUsername"));


        Response response = given().spec(spec).contentType(ContentType.JSON).body(data).when().post("/{first}/{second}");
        response.prettyPrint();
        JsonPath json = response.jsonPath();

        return json.getString("id_token");

    }

    public static String generateToken1(String username, String password) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", username);
        map.put("password", password);
        map.put("rememberme", true);

        String endPoint = "https://www.medunna.com/api/authenticate";

        Response response = given().contentType(ContentType.JSON).body(map).when().post(endPoint);

        JsonPath token = response.jsonPath();

        return token.getString("id_token");
    }

    //==============Hard Wait==============
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getScreenshot(String name) throws IOException {
//        THIS METHOD TAKES SCREENSHOT AND STORE IN /test-output FOLDER
//        NAME OF THE SCREEN IS BASED ON THE CURRENT TIME
//        SO THAN WE CAN HAVE UNIQUE NAME
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot. SAME IS IN THE HOOKS
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "target/Screenshots" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }


    public static String stringDateFormat(String date) {
        String day = date.substring(0, 2);
        String month = date.substring(3, 5);
        String year = date.substring(6);

        String formatDateString = year + "-" + month + "-" + day;

        return formatDateString;

        // buraya gelen  gun ay yil gg.aa.yyyy
        // 2030-01-01  yıl ay gun olmalı

    }

    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }

    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForClickablity(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();",element);
    }

    public static void waitAndClick(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        jsClick(element);
    }
}
