package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class EnesPage {
    public EnesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement accountMenuButton;

    @FindBy(xpath = "//a[@id='login-item']")
    public WebElement signinButton;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement signinUsernameTextBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement signinPasswordTextBox;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement signinPageSigninButton;

    @FindBy(xpath = "//span[text()='MY PAGES']")
    public WebElement myPagesButton;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[1]")
    public WebElement searchPatientButton;

    @FindBy(xpath = "//input[@class='form-control']")
    public WebElement searchPatientPageSearchBox;

    @FindBy(xpath = "//td")
    public List<WebElement> patientTableAllCellsList;

    @FindBy(xpath = "(//a[@class='btn btn-warning btn-sm'])[1]")
    public WebElement patientEditButton;

    @FindBy(xpath = "//span[ .='Create or edit a Patient']")
    public WebElement createAndEditBaslık;

    @FindBy(xpath = "//span[.='Save']")
    public WebElement saveButonu;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement descriptionTextBox;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstNameTextBox;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastNameTextBox;

    @FindBy(xpath = "//input[@name='birthDate']")
    public WebElement birthDateTextBox;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phoneTextBox;

    @FindBy(xpath = "//select[@name='gender']")
    public WebElement genderDropDownTextBox;

    @FindBy(xpath = "//select[@name='bloodGroup']")
    public WebElement bloodGroupDropDownTextBox;

    @FindBy(xpath = "//input[@name='adress']")
    public WebElement adressTextBox;

    @FindBy(xpath = "//th[1]//th")
    public List<WebElement> baslikTablosu;

    @FindBy(xpath = "//tr//td[3]")
    public WebElement tabloFirstName;

    @FindBy(xpath = "//tr//td[4]")
    public WebElement tabloLastName;

    @FindBy(xpath = "//tr//td[6]")
    public WebElement tabloPhoneNum;

    @FindBy(xpath = "//tr//td[7]")
    public WebElement tabloMailAdress;

    @FindBy(xpath = "//tr//td[8]")
    public WebElement tabloGender;

    @FindBy(xpath = "//tr//td[9]")
    public WebElement tabloBloodGroup;

    @FindBy(xpath = "//tbody//tr[1]//td")
    public List<WebElement> hastaBilgileriTablosu;

    @FindBy(xpath = "//span[.='Show Appointments']")
    public WebElement showAppointmentsButonu;

    @FindBy(xpath = "//tr//td[1]")
    public List<WebElement> randevuIDList;

    @FindBy(xpath = "//span[text()='Show Tests']")
    public List<WebElement> showTestButonList;

    @FindBy(xpath = "//span[text()='Edit']")
    public List<WebElement> editTestButonList;

    @FindBy(xpath = "//thead//th")
    public List<WebElement> randevuHeadersList;

    public int sutunIndexiDondur(String istenenHeader) {

        int sutunIndex = 0;

        for (int i = 0; i < randevuHeadersList.size(); i++) {
            if (randevuHeadersList.get(i).getText().equalsIgnoreCase(istenenHeader)) {
                sutunIndex = i;
                break;

            }
        }
        return sutunIndex;
    }

    public List<WebElement> indexeGoreSutunListi(int istenenSutunIndexi) {
        return Driver.getDriver().findElements(By.xpath("//tr//td[" + (istenenSutunIndexi + 1) + "]"));

    }

    @FindBy(xpath = "//input[@name='startDate']")
    public WebElement startDateTextBox;

    @FindBy(xpath = "//input[@name='endDate']")
    public WebElement endDateTextBox;

    @FindBy(xpath = "//tbody//tr[1]//td[2]//span")
    public WebElement actualStartDate;

    @FindBy(xpath = "//tbody//tr[1]//td[3]//span")
    public WebElement actualEndDate;

    @FindBy(xpath = "//select[@name='status']")
    public WebElement statusDropDownMenu;

    @FindBy(xpath = "//tbody//tr[1]//td[4]//span")
    public WebElement actualStatus;

    @FindBy(xpath = "//textarea[@name='anamnesis']")
    public WebElement anemnesisTextBox;

    @FindBy(xpath = "//textarea[@name='treatment']")
    public WebElement treatmentTextBox;

    @FindBy(xpath = "//textarea[@name='diagnosis']")
    public WebElement diagnosisTextBox;

    @FindBy(xpath = "//tbody//tr[1]//td[2]")
    public WebElement ssnDogrulama;

    @FindBy(xpath = "//span[text()='View Results']")
    public WebElement viewResultsButon;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> testList;

    @FindBy(xpath = "//span[text()='Edit']")
    public List<WebElement> testResultEditList;

    @FindBy(xpath = "//input[@name='id']")
    public WebElement testResultIDTextBox;

    @FindBy(xpath = "//input[@name='date']")
    public WebElement testResultDateTextBox;

    @FindBy(xpath = "//input[@name='result']")
    public WebElement testResultResultTextBox;

    @FindBy(xpath = "//input[@name='description']")
    public WebElement testResultDescriptionTextBox;

    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement testResultSaveButonu;

    @FindBy(xpath = "//select[@id='appointment-physician']")
    public WebElement selectPhysicianBox;

    @FindBy(xpath = "//tbody//tr[1]//td[11]")
    public WebElement selectPhysicianKontrol;




}



