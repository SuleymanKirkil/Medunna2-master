
package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class GulPage {
    public GulPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement girisİkonu;

    @FindBy(xpath = "//a[span='Sign in']")
    public WebElement signİn;


    @FindBy(xpath = "//input[@name='username']")
    public WebElement userNameKutusu;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signİnButonu;

    @FindBy(xpath = "//*[text()='MY PAGES']")
    public WebElement myPagesButon;

    @FindBy(xpath = "//*[contains(text(),'My Inpatients')]")
    public WebElement MyInpatıentsButonu;

    @FindBy(xpath = "//*[.='ID']")
    public WebElement id;

    @FindBy(xpath = "//*[.='Start Date']")
    public WebElement startDate;

    @FindBy(xpath = "//*[.='End Date']")
    public WebElement endDate;

    @FindBy(xpath = "//*[.='Description']")
    public WebElement description;

    @FindBy(xpath = "//*[.='Created Date']")
    public WebElement createdDate;

    @FindBy(xpath = "(//table//tr//th)[7]")
    public WebElement room;

    @FindBy(xpath = "//*[.='Appointment']")
    public WebElement appointment;

    @FindBy(xpath = "//*[.='Patient']")
    public WebElement patient;

    @FindBy(xpath = "(//*[@class='btn btn-primary btn-sm'])")
    public WebElement edit;

    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement save;
    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement alertMessage;

    @FindBy(xpath = "//div[text()='The In Patient is updated with identifier 164897']")
    public WebElement alertSuccessMessage;

    @FindBy(xpath = "//select[@name='room.id']")
    public WebElement Room;

    @FindBy(xpath = "(//table//tr//th)[4]")
    public WebElement status;

    @FindBy(xpath = "//select[@id='in-patient-status']")
    public WebElement Status;


    @FindBy(xpath = "//span[.='Items&Titles']")
    public WebElement Items;

    @FindBy(xpath = "//span[.='Country']")
    public WebElement Country;

    @FindBy(xpath = "//a[@id='jh-create-entity']")
    public WebElement CreateCountry;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement Name;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement countrySave;

    @FindBy(xpath = "//a[.='222192']")
    public WebElement newcountry;

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement createDogrulama;


    @FindBy(xpath = "//*[text()='State/City'][1]")
    public WebElement StateCity;

    @FindBy(xpath = "//*[text()='Create a new State/City']")
    public WebElement CreatStateCity;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement StateName;

    @FindBy(xpath = "//select[@name='state.id']")
    public WebElement StateUlke;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement Statesave;

    @FindBy(xpath = "//div[@role='alert']")
    public List<WebElement> alertList;


    @FindBy(xpath = "//tbody//tr[last()]/td[4]/div/a[3]")
    public WebElement sondelete;

    @FindBy(xpath = "//button[@id='jhi-confirm-delete-country']//span[contains(text(),'Delete')]")
    public WebElement deleteConfirm;


    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement silindi;


    @FindBy(xpath = "//div[@role='alert']")
    public WebElement olumsuzMesaj;
}