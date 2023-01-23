package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SumeyraPage {
    public SumeyraPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@data-icon='user']")
    public WebElement kullaniciIkonu;

    @FindBy(xpath = "//span[ .='Sign in']")
    public WebElement signInButonu;

    @FindBy(xpath ="//span[.='Remember me']")
    public WebElement rememberMeYaziElementi;

    @FindBy(linkText = "Did you forget your password?")
    public WebElement forgetPassWordYaziElementi;

    @FindBy(linkText= "Register a new account")
    public WebElement DHAccountYetBox;

    @FindBy(xpath = "//span[.='Cancel']")
    public WebElement cancelButonu;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameBox;

    @FindBy (xpath = "//input[@name='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement secondSigInButton;

    @FindBy(xpath= "//span[.='Medunna  Team 50']")
    public WebElement kullaniciIsmiYaziElementi;

    @FindBy(xpath = "//a[@href='#appointment'][1]")
    public WebElement makeAppointmentButton;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstnameBox;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastnameBox;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement ssnNumberBox;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailBox;

    @FindBy(id = "phone")
    public WebElement phoneBox;

    @FindBy(xpath = "//span[text()='Send an Appointment Request']")
    public WebElement sendRequestButton;

    @FindBy(xpath = "//*[.='Your FirstName is required.']")
    public WebElement firstnameRequiredMessage;

    @FindBy(xpath = "//*[.='Your LastName is required.']")
    public WebElement lastnameRequiredMessage;

    @FindBy(xpath = "//*[.='Your SSN is required.']")
    public WebElement ssnRequiredMessage;

    @FindBy(xpath = "//*[.='Your email is required.']")
    public WebElement emailRequiredMessage;

    @FindBy(xpath = "//*[.='Phone number is required.']")
    public WebElement phoneRequiredMessage;

    @FindBy(xpath = "//*[.='Phone number is invalid']")
    public WebElement phoneInvalidMessage;

    @FindBy(xpath = "//*[.='Appointment registration saved!']")
    public WebElement registrationSavedMessage;

    @FindBy(xpath = "//input[@name='username']")
    public  WebElement patientUsernameBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement patientPasswordBox;

    @FindBy(xpath = "//*[.='MY PAGES(PATIENT)'][1]")
    public WebElement myPagesPatientButton;

    @FindBy(xpath = "//*[.='My Appointments'][1]")
    public WebElement myAppointmentButton;

    @FindBy(xpath = "//h2[@id='appointment-heading']")
    public WebElement appoinmentsPage;

    @FindBy (id = "appoDate")
    public WebElement appoDate;

    @FindBy(xpath = "//*[@data-icon='th-list']")
    public WebElement itemsTitelsiconu;

    @FindBy(xpath = "//*[@data-icon='glasses']")
    public WebElement TestItemButonu;

    @FindBy(xpath = "//*[.='Create a new Test Item']")
    public WebElement createTestItemButonu;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement nameBox;

    @FindBy(xpath = "//input[@name='description']")
    public WebElement descriptionBox;

    @FindBy(xpath = "//input[@name='price']")
    public WebElement priceBox;

    @FindBy(xpath = "//input[@name='createdDate']")
    public WebElement createDateBox;

    @FindBy(id = "save-entity")
    public WebElement saveButonu;

    @FindBy(xpath = "//*[.='A new Test Item is created with identifier']")
    public WebElement testItemCreatedMessage;

    @FindBy(xpath = "//input[@name='defaultValMin']")
    public WebElement minValueBox;

    @FindBy(xpath = "//input[@name='defaultValMax']")
    public WebElement maxValueBox;

    @FindBy(xpath = "//tr[1]//td[1]")
    public WebElement idNo;

    @FindBy(xpath = "//tr[1]//td[7]")
    public WebElement createdDateCell;

    @FindBy (xpath = "(//a[@class='btn btn-info btn-sm'])[1]")
    public WebElement viewButonu;

    @FindBy (xpath = "(//span[text()='Test Item'])[2]")
    public WebElement viewSayfa;

    @FindBy (xpath = "//span[text()='Edit']")
    public WebElement editButonu;

    @FindBy (xpath = "(//span[text()='Delete'])[1]")
    public WebElement deleteButonu;

    @FindBy (xpath = "(//div/button[@type='button'])[3]")
    public WebElement delete2;

    @FindBy (xpath = "//div[@class='Toastify__toast-body']")
    public WebElement popUpMessage;




}
