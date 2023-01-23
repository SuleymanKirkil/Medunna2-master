package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EdaPage {
    public EdaPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //US007
    @FindBy(xpath = "//li[@id='entity-menu']")
    public WebElement myPagesPatient;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    public WebElement makeAnAppointmentButonu;

    @FindBy(xpath = "//section[@id='appointment']")
    public WebElement makeAnAppointmentBolumuGorunurlugu;


    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstNameMakeAnAppointment;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastNameMakeAnAppointment;

    @FindBy(xpath = "//input[@id='ssn']")
    public WebElement ssnMakeAnAppointment;


    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailMakeAnAppointment;

    @FindBy(xpath = "//input[@id='phone']")
    public WebElement phoneMakeAnAppointment;

    @FindBy(xpath = "//input[@id='appoDate']")
    public WebElement appointmentDateTimeMakeAnAppointment;

    @FindBy(xpath = "//button[@id='register-submit']")
    public WebElement sendAnAppointmentRequestButonu;


    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement popUpAppointmentRegistrationSaved;


    @FindBy(xpath = "//*[text()='Appointment date can not be past date!']")
    public WebElement appointmentDateCanNotBePastDate;

//US026

    @FindBy(xpath = "//a[@href='/contact']")
    public WebElement contactButonu;

    @FindBy(xpath = "//textarea[@id='message']")
    public WebElement messageKutusuContactPortal;


    @FindBy(xpath = "//*[text()='Name is required.']")
    public WebElement nameIsRequiredYazisi;

    @FindBy(xpath = "//*[text()='Your email is required.']")
    public WebElement yourEmailIsRequiredYazisi;

    @FindBy(xpath = "//*[text()='This field is required.']")
    public WebElement thisFieldIsRequiredYazisi;

    @FindBy (xpath = "//*[contains(text(),'Your message has been received')]")
    public WebElement successfullySendingMessageText;

    //US027
    @FindBy(xpath = "//div[@class='app-container']")
    public WebElement adminSayfasininGorunurlugu;

    @FindBy(xpath = "//li[@class='dropdown nav-item']")
    public WebElement itemsTitlesButonu;

    @FindBy(xpath = "(//a[@href='/c-message'])[1]")
    public WebElement messagesButonu;

    @FindBy(xpath = "//div[@id='app-view-container']")
    public WebElement messagesPortalininGorunurlugu;

    @FindBy(xpath = "(//span[@class='d-none d-md-inline'])[1]")
    public WebElement viewButonu;

    @FindBy(xpath = "//div[@class='col-md-8']")
    public WebElement messageBilgilerininGorunurlugu;

    @FindBy(xpath = "//a[@id='jh-create-entity']")
    public WebElement createAnewMessageButonu;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement nameMetinKutusu;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailMetinKutusu;

    @FindBy(xpath = "//input[@name='subject']")
    public WebElement subjectMetinKutusu;

    @FindBy(xpath = "//input[@name='message']")
    public WebElement messageMetinKutusu;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement saveButonu;

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement islemBasariliPopUp;

    @FindBy(xpath = "(//th[@class='hand'])[1]")
    public WebElement idButonu;

    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[1]")
    public WebElement editButonu1;

    @FindBy(xpath = "(//a[@class='btn btn-danger btn-sm'])[1]")
    public WebElement deleteButonu;

    @FindBy(xpath = "//button[@id='jhi-confirm-delete-cMessage']")
    public WebElement deleteButonuPopUp;


    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement deleteIslemiOnayPopUp;


    @FindBy (xpath = "//*[contains(text(),'A new Message is created with identifier')]")
    public WebElement successfullyCreatedANewMessageText;

    @FindBy (xpath = "//*[contains(text(),'A Message is updated with identifier')]")
    public WebElement succesfullyUpdatedMessageText;

    @FindBy (xpath = "//*[contains(text(),'A Message is deleted with identifier')]")
    public WebElement succesfullyDeletedMessageText;
}
