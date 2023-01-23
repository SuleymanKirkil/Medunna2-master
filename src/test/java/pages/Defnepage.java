package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Defnepage {
    public Defnepage() {


        PageFactory.initElements(Driver.getDriver(), this);
    }

    //US008

    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement AccountMenu;

    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    public WebElement SingIN;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement UserName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement Password;

    @FindBy(xpath = "//button[@type='submit']//span[contains(text(),'Sign in')]")
    public WebElement SingIN2;

    @FindBy(xpath = "//h1[normalize-space()='Welcome to MEDUNNA']")
    public WebElement WelcomeMedunna;

    @FindBy(xpath = "//span[normalize-space()='Defne BAYRAM']")
    public WebElement AdminDefne;

    @FindBy(xpath = "//span[normalize-space()='Password']")
    public WebElement Password2;


    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']//span[contains(text(),'Medunna')]")
    public WebElement LoginAccount;

    @FindBy(xpath = "//span[normalize-space()='Password']")
    public WebElement LoginPassword;

    @FindBy(xpath = "//input[@id='currentPassword']")
    public WebElement CurrentPassword;

    @FindBy(xpath = "//input[@id='newPassword']")
    public WebElement NewPassword;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    public WebElement ConfirmPassword;

    @FindBy(xpath = "//span[normalize-space()='Save']")
    public WebElement Save;

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement passwordChangedText;

    @FindBy(xpath = "//span[normalize-space()='Sign out']")
    public WebElement signOutButton;

    @FindBy(xpath = "(//li[@class='point'])[1]")
    public WebElement passwordStrength1;

    @FindBy(xpath = "(//li[@class='point'])[2]")
    public WebElement passwordStrength2;

    @FindBy(xpath = "(//li[@class='point'])[3]")
    public WebElement passwordStrength3;

    @FindBy(xpath = "(//li[@class='point'])[4]")
    public WebElement passwordStrength4;

    @FindBy(xpath = "(//li[@class='point'])[5]")
    public WebElement passwordStrength5;


    //US003

    @FindBy(xpath = "//span[normalize-space()='Register']")
    public WebElement register;

    @FindBy(xpath = "//input[@id='firstPassword']")
    public WebElement registerNewPassword ;

    @FindBy(xpath = "//div/ul//li[7]//span[text()='Register']")
    public WebElement register2;


    @FindBy (xpath = "//input[@name='secondPassword']")
    public WebElement comfirmationPassword;

    @FindBy (xpath = "//div[@class='invalid-feedback']")
    public WebElement shortPassword;

    //US016 ROOM

    @FindBy(xpath = "//*[.='Items&Titles']")
    public WebElement itemsTitlesDropdown;

    @FindBy(xpath = "//span[normalize-space()='Room']")//a[@class='dropdown-item active']
    public WebElement roomDropdown;

    @FindBy(xpath = "//*[.='Rooms']")
    public WebElement roomsHeading;

    @FindBy(xpath = "//*[.='Create a new Room']")//span[normalize-space()='Create a new Room']
    public WebElement createANewRoomButton;

    @FindBy(xpath = "//h2[.='Create or edit a Room']")
    public WebElement createOrEditARoomHeading;

    @FindBy(xpath = "//input[@name='roomNumber']")//input[@id='room-roomNumber']  number
    public WebElement roomNumberTextBox;

    @FindBy(xpath = "//input[@name='price']")//input[@id='room-price']  price
    public WebElement priceTextBox;

    @FindBy(xpath = "//input[@name='createdDate']") //input[@id='room-createdDate'] tarih
    public WebElement createdDateTextBox;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> allRows;

    @FindBy(xpath = "//a[normalize-space()='»»']")//a[.='»»']
    public WebElement lastPage;

    @FindBy(xpath = "//span[normalize-space()='Save']")//span[normalize-space()='Save']
    public WebElement SaveRoom;

    @FindBy(xpath = "(//*[text()='This field is required.'])[1]")
    public WebElement invalidFeedbacks1;

    @FindBy(xpath = "(//*[text()='This field is required.'])[2]")//"//div[@class='invalid-feedback']"
    public WebElement invalidFeedbacks2;

    @FindBy(xpath = "//input[@name='status']") //"//input[@id='room-status']"
    public WebElement statusCheckBox;

    @FindBy(tagName = "select")
    public WebElement roomTypeSelect;

    @FindBy(tagName = "//span[normalize-space()='Room Type']")
    public WebElement roomType;

    @FindBy(tagName = "//tbody/tr[1]/td[3]/span[1]")
    public WebElement Twin;

    @FindBy(xpath = "(//a)[32]")//span[contains(text(),'Edit')]  edit (//*[text()='Edit'])[1] //span/span[.='Edit']
    public WebElement editElements;

    @FindBy(xpath = "//span/span[.='Delete']")//span[contains(text(),'Delete')]  delete
    public WebElement deleteElements;

    @FindBy(xpath = "//input[@name='description']")  //input[@id='room-description']  description
    public WebElement descriptionTextBox;

    @FindBy(xpath = "(//a)[65]")
    public WebElement deleteRoom;

    @FindBy(id = "jhi-confirm-delete-room") //button[@id='jhi-confirm-delete-room']//span[contains(text(),'Delete')]
    public WebElement deleteConfirm;

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement deleteToastContanier;


    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement roomcreationsave;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]")
    public WebElement roomcreatedtoastcontainer;

//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]


}

