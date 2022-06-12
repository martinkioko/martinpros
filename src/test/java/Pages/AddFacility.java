package Pages;

import StepDefinitions.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddFacility extends BaseClass {

    public AddFacility(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"main-menu\"]/div[1]/div[6]")
    WebElement FacilityMenu;
    public WebElement getFacilityMenu(){
        return FacilityMenu;
    }

    @FindBy(xpath = "//button[text()='New Facility']")
    WebElement addFacility;
    public WebElement getAddFacility(){
        return addFacility;
    }

    @FindBy(xpath = "//*[@id=\"facilityForm_sales_managers\"]")
    WebElement salesManager;
    public WebElement getSalesManager(){
        return salesManager;
    }

    @FindBy(id = "facilityForm_name")
    WebElement facilityName;
    public WebElement getFacilityName(){
        return facilityName;
    }

    @FindBy(id = "facilityForm_primary_contact_name")
    WebElement contactPerson;
    public WebElement getContactPerson(){
        return contactPerson;
    }

    @FindBy(id = "facilityForm_file_id")
    WebElement facilityDocument;
    public WebElement getFacilityDocument(){
        return facilityDocument;
    }

    @FindBy(id = "faceSheetForm_title")
    WebElement documentTitle;
    public WebElement getDocumentTitle(){
        return documentTitle;
    }

    @FindBy(id = "faceSheetForm_type")
    WebElement documentType;
    public WebElement getDocumentType(){
        return documentType;
    }

    @FindBy(xpath = "//*[@id=\"faceSheetForm\"]/div[4]/div[2]/div/div/span/div[1]/span/input")
    WebElement uploadButton;
    public WebElement getUploadButton(){
        return uploadButton;
    }

    @FindBy(className = "mapboxgl-ctrl-geocoder--input")
    WebElement addressField;
    public WebElement getAddressField(){
        return addressField;
    }

    @FindBy(id = "facilityForm_email")
    WebElement emailField;
    public WebElement getEmailField(){
        return emailField;
    }

    @FindBy(id = "facilityForm_phone_no")
    WebElement phoneNumberField;
    public WebElement getPhoneNumberField(){
        return phoneNumberField;
    }

    @FindBy(xpath = "//button[text()='Create']")
    WebElement create;
    public WebElement getCreate(){
        return create;
    }

    @FindBy(id = "faceSheetForm_title")
    WebElement facilityDocumentTitle;
    public WebElement getFacilityDocumentTitle(){
        return facilityDocumentTitle;
    }

    @FindBy(id = "faceSheetForm_type")
    WebElement facilityDocumentType;
    public WebElement getFacilityDocumentType(){
        return facilityDocumentType;
    }

    @FindBy(xpath = "//*[@id=\"faceSheetForm\"]/div[4]/div[2]/div/div/span/div[1]/span/input")
    WebElement facilityDocumentUpload;
    public WebElement getFacilityDocumentUpload(){
        return facilityDocumentUpload;
    }

}
