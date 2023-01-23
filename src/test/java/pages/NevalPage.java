package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class NevalPage {
    public NevalPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='account-menu']")
    public WebElement profilResmi;

    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement signInButonu;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement userNameKutusu;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signinButonu2;

    @FindBy(xpath = "//span[text()='Settings']")
    public WebElement settings;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement settingsFirstNameKutusu;


    @FindBy(xpath = "//*[@placeholder='Your last name']")
    public WebElement settingsLastnameKutusu;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement settingsEmailKutusu;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement saveButonu;
    @FindBy(xpath = "//*[text()='Settings saved!']")
    public WebElement guncellemeBsarılıYazisi;

    @FindBy(xpath = "//div[text()='Your first name is required.']")
    public WebElement adınızGerekliYazisi;

    @FindBy(xpath = "//span[text()='Items&Titles']")
    public WebElement itemsTitles;
    @FindBy(xpath = "//span[normalize-space()='Patients']")
    public WebElement patients;

    @FindBy(xpath = "//*[text()='Create a new Patient']")
    public WebElement createNewPatient;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement createFirstname;

    @FindBy(xpath = "//select[@name='bloodGroup']")
    public WebElement kanGrubuDropDown;

    @FindBy(xpath = "//select[@name='gender']")
    public WebElement gender;

    @FindBy(xpath = "//select[@name='cstate.id']")
    public WebElement StateCity;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement save;
    //*[@role='alert']
    @FindBy(xpath = "//div[contains(text()'A new Patient is created')]")
    public WebElement successMessage;
    //div[contains(text()'A new Patient is created')]

    @FindBy(xpath = "(//*[text()='Patients'])[1]")
    public WebElement patientsListesi;

    @FindBy(xpath = "//select[@name='country.id']")
    public WebElement countryDropDown;


    @FindBy(xpath = "//span[normalize-space()='ID']")
    public WebElement idTık;

    @FindBy(xpath = "(//*[@class='btn btn-link btn-sm'])[1]")
    public WebElement enSonid;

    @FindBy(xpath = "//*[@class='col-md-8']")
    public WebElement patientBilgiTablosu;
    //*[@class='jh-entity-details']//dt
    //*[@class='jh-entity-details']//dd
    @FindBy(xpath = "//*[@class='jh-entity-details']//dt")
    public List<WebElement> patientbilgiler;

    @FindBy(xpath = "//*[text()='Sign out']")
    public WebElement signOut;

    @FindBy(xpath = "(//*[text()='Edit'])[1]")
    public WebElement edit;

    @FindBy(xpath = "//input[@id='patient-firstName']")
    public WebElement editFirstname;

    @FindBy(xpath = "//input[@id='patient-lastName']")
    public WebElement editLastName;

    @FindBy(xpath = "//*[@id='save-entity']")
    public WebElement editSave;



    @FindBy(xpath = "(//*[text()='View'])[1]")
    public  WebElement view;

    //    "//tbody/tr[1]/td[3]"
    @FindBy(xpath = "//*[text()='NEVAL'])[1]")
    public  WebElement guncellemeisim;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement editGuncellemeBasarili;

    @FindBy(xpath = "//span[text()='Appointment']")
    public  WebElement appointment;

    @FindBy(xpath = "//span[text()='Create a new Appointment']")
    public  WebElement createNewAppointment;

    @FindBy(xpath = "//input[@id='appointment-startDate']")
    public  WebElement startDateTime;

    @FindBy(xpath = "//input[@id='appointment-endDate']")
    public WebElement endDateTime;

    @FindBy(xpath = "//select[@id='appointment-status']")
    public  WebElement status;

    @FindBy(xpath = "//select[@id='appointment-physician']")
    public  WebElement physician;

    @FindBy(xpath = "//*[text()='Patient']")
    public  WebElement patient;

    @FindBy(xpath = "//div[@role='alert']")
    public  WebElement atamaBasarili;

    @FindBy(xpath = "(//*[text()='Delete'])[1]")
    public  WebElement herhangiDelete;

    @FindBy(xpath = "(//*[@class='btn btn-link btn-sm'])[1]")
    public  WebElement herhangiId;

    @FindBy(xpath = "(//button[@type='button'])[4]")
    public  WebElement delete2;
    @FindBy(xpath = "//*[@role='alert']")
    //*[@role='alert']
    public WebElement alert;

    @FindBy(xpath = "//tbody/tr[1]/td")
    public List<WebElement> satır;


    @FindBy(xpath = "//*[text()='Internal server error.']")
    public WebElement serverErrorHatasi;


}
