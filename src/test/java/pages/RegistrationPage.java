package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegistrationPage {

    public RegistrationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Registration']")
    public WebElement registrationText;

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

    @FindBy(xpath = "//input[@id='firstPassword']")
    public WebElement newPasswordBox;

    @FindBy(xpath = "//*[text()='Your password is required.']")
    public WebElement newPasswordErrorMessage;

    @FindBy(xpath = "//input[@id='secondPassword']")
    public WebElement newPasswordConfirmationBox;

    @FindBy(xpath = "//*[text()='Your confirmation password is required.']")
    public WebElement newPasswordConfirmationErrorMessage;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement registerButton;


}
