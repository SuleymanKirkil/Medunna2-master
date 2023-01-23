package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RecepPage {
    public RecepPage() {  PageFactory.initElements(Driver.getDriver(),this);  }


    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement accountMenu;

    @FindBy(xpath = "//a[@id='login-item']")
    public WebElement accountSignIn;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordBox;

    @FindBy(xpath ="//button[@type='submit']")
    public WebElement submitSignIn;

    @FindBy(xpath ="//span[text()='MY PAGES(PATIENT)']")
    public WebElement patientMyPageButton;

    @FindBy(xpath ="//span[text()='Make an Appointment']")
    public WebElement patientMakeAnAppointmentButton;

    @FindBy(xpath ="//span[text()='My Appointments']")
    public WebElement patientMyAppointmentButton;

    @FindBy(xpath ="//input[@name='phone']")
    public WebElement patientPhoneTextBox;

    @FindBy(xpath ="//input[@name='appoDate']")
    public WebElement patientDateTextBox;

    @FindBy(xpath = "//span[text()='Send an Appointment Request']")
    public WebElement patientSendRequestButton;

    @FindBy(xpath ="//tr//td[1]")
    public WebElement patientappointmentIDList;

    @FindBy(xpath ="//span[text()='MY PAGES']")
    public WebElement staffMyPageButton;

    @FindBy(xpath ="//span[text()='Search Patient']")
    public WebElement staffSearchPatientButton;

    @FindBy(xpath ="//input[@class='form-control']")
    public WebElement staffPatientSSNTextBox;

    @FindBy(xpath ="//a[@class='btn btn-warning btn-sm']")
    public WebElement staffShowAppointmentsButton;

    @FindBy(xpath ="//tr//td[1]")
    public WebElement staffAppointmentList;

    @FindBy(xpath ="//tr//td[13]//a[@class='btn btn-warning btn-sm']")
    public WebElement staffAppointmentEditButtonList;

    @FindBy(xpath ="//input[@name='startDate']")
    public WebElement startDateTime;

    @FindBy(xpath ="//input[@name='endDate']")
    public WebElement endDateTime;
    @FindBy(xpath ="//select[@id='appointment-status']")
    public WebElement staffAppointmentStatusSelect;

    @FindBy(xpath ="//select[@id='appointment-physician']")
    public WebElement staffAppointmentDoctorSelect;

    @FindBy(xpath ="//button[@type='submit']")
    public WebElement staffCreateAppointmentSaveButton;

    @FindBy(xpath ="//span[text()='MY PAGES']")
    public WebElement doctorMyPageButton;

    @FindBy(xpath ="//span[text()='My Appointments']")
    public WebElement doctorMyAppointmentPageButton;

    @FindBy(xpath ="//tr//td[1]")
    public WebElement doctorAppointmentsList;

    @FindBy(xpath ="//tr//td[13]//div")
    public WebElement doctorAppointmentsEditButtonList;

    @FindBy(xpath ="//a[@class='btn btn-success btn-sm']")
    public WebElement doctorRequestATestButton;

    @FindBy(xpath ="//input[@name='132000']")
    public WebElement doctorcccsTestCheckBox;

    @FindBy(xpath ="//input[@name='1402']")
    public WebElement doctorUreaTestCheckBox;

    @FindBy(xpath ="//input[@name='132770']")
    public WebElement doctorgshTestCheckBox;

    @FindBy(xpath ="//button[@type='submit']")
    public WebElement doctorTestSaveButton;

    @FindBy(xpath ="//select[@name='status']")
    public WebElement doctorStatusSelect;

    @FindBy(xpath ="//span[text()='Save']")
    public WebElement doctorCreateAppointmentSaveButton;

    @FindBy(xpath ="//option[@value='154299']")
    public WebElement doctorOptionVisibility;

    @FindBy(xpath ="//textarea[@name='anamnesis']")
    public WebElement doctorCreateAppointmentAnamnesis;

    @FindBy(xpath ="//textarea[@name='treatment']")
    public WebElement doctorCreateAppointmentTreatment;

    @FindBy(xpath ="//textarea[@name='diagnosis']")
    public WebElement doctorCreateAppointmentDiagnosis;

    @FindBy(xpath ="//tr//td[1]")
    public WebElement staffAppointmentListCreateInvoice;

    // //tr[Listin elementi +1 olacak şekilde yaz]//td[13]//a[@class='btn btn-success btn-sm'] invoice olusturmak icin step icerisinde bu locate kullanılacak ve dinamik yapılacak

    @FindBy(xpath ="//a[@class='btn btn-danger btn-sm']")
    public WebElement staffAppointmentCreateInvoiceButton;

    @FindBy(xpath ="//button[@type='submit']")
    public WebElement staffCreateInvoiceSaveButton;

    // //tr[Listin elementi +1 olacak şekilde yaz]//td[13]//a[@class='btn btn-success btn-sm'] aynı locate ile invoice butonuna tıklanacak

    @FindBy(xpath ="//a[@class='btn btn-success btn-sm']")
    public WebElement staffShowInvoiceButton;

    @FindBy(xpath ="//th[text()='INVOICE']")
    public WebElement staffInvoiceIsDisplayed;











}
