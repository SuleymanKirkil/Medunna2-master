package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MertPage {

    public MertPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href=\"/home\"]")
    public WebElement homeButton;

    @FindBy(xpath="//a[@href=\"/account/register\"]")
    public WebElement registerButton;

    @FindBy(xpath = "//li[@id=\"account-menu\"]")
    public WebElement accountMenu;

    @FindBy(xpath = "//a[@href=\"/login\"]")
    public WebElement signInButton;
    @FindBy(xpath = "//input[@name=\"username\"]")
    public WebElement homeUsernameBox;

    @FindBy(xpath = "//li[@id=\"admin-menu\"]")
    public WebElement administrationButton;

    @FindBy(xpath = "//a[@href=\"/admin/user-management\"]")
    public WebElement userManagementButton;

    @FindBy(xpath = "//input[@name=\"password\"]")
    public WebElement homePasswordBox;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement signInButton2;
    @FindBy(xpath = "//*[text()='Registration']")
    public WebElement registrationText;

    @FindBy(xpath = "//*[text()='Sign in']")
    public WebElement signInText;

    @FindBy(xpath = "//input[@id='ssn']")
    public WebElement ssnBox;

    @FindBy(xpath = "//*[text()='Your SSN is required.']")
    public WebElement ssnErrorMessage;

    @FindBy(xpath="//*[text()='Your SSN is invalid']")
    public WebElement ssnInvalidMessage;

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstNameBox;

    @FindBy(xpath = "//*[text()='Your FirstName is required.']")
    public WebElement firstNameErrorMessage;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastNameBox;

    @FindBy(xpath = "//*[text()='Your LastName is required.']")
    public WebElement lastNameErrorMessage;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameBox;

    @FindBy(xpath = "//*[text()='Your username is required.']")
    public WebElement usernameErrorMessage;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailBox;

    @FindBy(xpath = "//*[text()='Your email is required.']")
    public WebElement emailErrorMessage;

    @FindBy(xpath = "//*[text()='Your email is required to be at least 5 characters.']")
    public WebElement emailErrorMessage2;

    @FindBy(xpath="//*[text()='This field is invalid']")
    public WebElement emailInvalidMessage;

    @FindBy(xpath = "//div[@class='info jhi-item-count']")
    public WebElement usersResultMessage;

    @FindBy(xpath = "//input[@id='firstPassword']")
    public WebElement newPasswordBox;

    @FindBy(xpath = "//*[text()='Your password is required.']")
    public WebElement newPasswordErrorMessage;

    @FindBy(xpath = "//input[@id='secondPassword']")
    public WebElement newPasswordConfirmationBox;

    @FindBy(xpath = "//*[text()='Your confirmation password is required.']")
    public WebElement newPasswordConfirmationErrorMessage;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement finalRegisterButton;
    @FindBy(xpath = "//span[text()='MY PAGES(PATIENT)']")
    public WebElement myPagesButton;

    @FindBy(xpath = "//span[text()='My Appointments']")
    public WebElement myAppointmentsButton;

    @FindBy(xpath = "//span[text()='Make an Appointment']")
    public WebElement makeAnAppointmentButton;

    @FindBy(xpath = "//input[@id='phone']")
    public WebElement phoneBox;

    @FindBy(xpath = "//input[@id='appoDate']")
    public WebElement appointmentDateBox;

    @FindBy(xpath = "//*[text()='Phone number is required.']")
    public WebElement phoneNumberErrorMessage;

    @FindBy(xpath = "//span[text()='Send an Appointment Request']")
    public WebElement SendAndAppointmentRequestButton;

    @FindBy(xpath = "//*[.='Appointment registration saved!']")
    public WebElement registrationSavedMessage;

    @FindBy(xpath = "//a[@href=\"/tests/appointment/218419\"]")
    public WebElement showTestButton;

    @FindBy(xpath = "//a[@href=\"/patient-invoice-show/218419\"]")
    public WebElement showInvoiceButton;

    @FindBy(xpath = "//span[@class='d-none d-md-inline']")
    public WebElement viewResultsButton;

    @FindBy(xpath = "//*[text()='ID']")
    public WebElement testResultsIDButton;

    @FindBy(xpath = "//*[text()='Name']")
    public WebElement testResultsNameButton;

    @FindBy(xpath = "//tbody/tr/td[4]")
    public WebElement testResultsDefaultMinValueButton;

    @FindBy(xpath = "//tbody/tr/td[5]")
    public WebElement testResultsDefaultMaxValueButton;

    @FindBy(xpath = "//*[text()='Description']")
    public WebElement testResultsDescriptionButton;

    @FindBy(xpath = "//*[text()='Date']")
    public WebElement testResultsDateButton;

    @FindBy(xpath = "//th[text()='INVOICE']")
    public WebElement invoiceTableHeader;











}
