package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class AsimPage {
    public AsimPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement accountMenu;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[1]")
    public WebElement signInButton;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    public WebElement registerButton;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement secondSignIn;

    @FindBy(xpath = "(//a[@class='d-flex align-items-center dropdown-toggle nav-link'])[1]")
    public WebElement myPages;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[1]")
    public WebElement myAppointments;

    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[2]")
    public WebElement editButton;

    @FindBy(xpath = "//h2//span")
    public WebElement createOrEditAnAppointmentText;

    @FindBy(xpath = "//*[text()='Request A Test']")
    public WebElement requestTestButton;

    @FindBy(xpath = "//input[@name='129700']")
    public WebElement glucoseCheckBox;

    @FindBy(xpath = "//input[@name='1402']")
    public WebElement ureaCheckBox;

    @FindBy(xpath = "//input[@name='1403']")
    public WebElement creatinineCheckBox;

    @FindBy(xpath = "//input[@name='1404']")
    public WebElement sodiumCheckBox;

    @FindBy(xpath = "//input[@name='1405']")
    public WebElement potassiumCheckBox;

    @FindBy(xpath = "//input[@name='1406']")
    public WebElement totalProteinCheckBox;

    @FindBy(xpath = "//input[@name='1407']")
    public WebElement albuminCheckBox;

    @FindBy(xpath = "//input[@name='1408']")
    public WebElement hemoglobinCheckBox;

    @FindBy(xpath = "//*[.='Show Test Results']")
    public WebElement showTestResults;

    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement testSaveButton;

    @FindBy(xpath = "(//a[@class='btn btn-info btn-sm'])[2]")
    public WebElement viewResultsButton;

    @FindBy(xpath = "//thead//tr//th[1]")
    public WebElement id;

    @FindBy(xpath = "//thead//tr//th[2]")
    public WebElement name;

    @FindBy(xpath = "//thead//tr//th[3]")
    public WebElement result;

    @FindBy(xpath = "//thead//tr//th[4]")
    public WebElement defaultMinValue;

    @FindBy(xpath = "//thead//tr//th[5]")
    public WebElement defaultMaxValue;

    @FindBy(xpath = "//thead//tr//th[6]")
    public WebElement test;

    @FindBy(xpath = "//thead//tr//th[7]")
    public WebElement description;

    @FindBy(xpath = "//thead//tr//th[8]")
    public WebElement date;

    @FindBy(xpath = "//*[.='Request Inpatient']")
    public WebElement requestInpatient;

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement newInpatientIsCreatedText;

    @FindBy(xpath = "(//a[@class='d-flex align-items-center dropdown-toggle nav-link'])[1]")
    public WebElement itemsAndTitlesMenu;

    @FindBy(xpath = "(//a[@href=\"/physician\"])[1]")
    public WebElement physicianOption;

    @FindBy(xpath = "//a[@id='jh-create-entity']")
    public WebElement createANewPhysicianButton;

    @FindBy(xpath = "//input[@name='useSSNSearch']")
    public WebElement useSearchCheckBox;

    @FindBy(xpath = "//input[@name='searchSSN']")
    public WebElement ssnTextBox;

    @FindBy(xpath = "//*[.='Search User']")
    public WebElement searchUserButton;

    @FindBy(xpath = "//*[text()='User found with search SSN']")
    public WebElement userFoundText;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstNameTextBox;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastNameTextBox;

    @FindBy(xpath = "//input[@name='birthDate']")
    public WebElement birthDateTextBox;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phoneTextBox;

    @FindBy(xpath = "//input[@name='adress']")
    public WebElement adressTextBox;

    @FindBy(xpath = "//input[@name='examFee']")
    public WebElement examFeeTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[.='ID']")
    public WebElement idSiralamaButonu;

    @FindBy(xpath = "//a[@href='/physician/202940/edit?page=1&sort=id,desc']")
    public WebElement edit202940PhysicianButton;

    @FindBy(xpath = "//a[@href='/physician/210106/edit?page=1&sort=id,desc']")
    public WebElement edit210106PhysicianButton;

    @FindBy(xpath = "//select[@id='physician-speciality']")
    public WebElement specialityMenu;

    @FindBy(xpath = "//input[@id='file_image']")
    public WebElement dosyaSecButonu;

    @FindBy(xpath = "//select[@id='physician-user']")
    public WebElement userList;

    @FindBy(xpath = "//button[@id='jhi-confirm-delete-physician']")
    public WebElement confirmDelete;

}
