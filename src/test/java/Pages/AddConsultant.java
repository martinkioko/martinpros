package Pages;

import StepDefinitions.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddConsultant extends BaseClass {
    public AddConsultant(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"main-menu\"]/div[1]/div[5]")
    WebElement consultantsMenu;
    public WebElement getConsultantsMenu() {
        return consultantsMenu;
    }

    @FindBy(xpath = "//button[text()='New Consultant']")
    WebElement addConsultant;
    public WebElement getAddConsultant(){
        return addConsultant;
    }

    @FindBy(id = "consultantForm_first")
    WebElement firstNameField;
    public WebElement getFirstNameField(){
        return firstNameField;
    }

    @FindBy(id = "consultantForm_last")
    WebElement lastNameField;
    public WebElement getLastNameField(){
        return lastNameField;
    }

    @FindBy(id = "consultantForm_birth_date")
    WebElement dateOfBirthField;
    public WebElement getDateOfBirthField(){
        return dateOfBirthField;
    }

    @FindBy(id = "consultantForm_gender")
    WebElement genderField;
    public WebElement getGenderField(){
        return genderField;
    }

    @FindBy(id = "consultantForm_date_of_hire")
    WebElement dohField;
    public WebElement getDohField(){
        return dohField;
    }

    @FindBy(id = "consultantForm_npi")
    WebElement NpiNumberField;
    public WebElement getNpiNumberField(){
        return NpiNumberField;
    }

    @FindBy(id = "consultantForm_caqh_id")
    WebElement CidField;
    public WebElement getCidField(){
        return CidField;
    }

    @FindBy(id = "consultantForm_bhpm_id")
    WebElement BidField;
    public WebElement getBidField(){
        return BidField;
    }

    @FindBy(id = "consultantForm_email")
    WebElement emailField;
    public WebElement getEmailField(){
        return emailField;
    }

    @FindBy(id = "consultantForm_phone_no")
    WebElement phoneNumberField;
    public WebElement getPhoneNumberField(){
        return phoneNumberField;
    }

    @FindBy(id = "consultantForm_degree")
    WebElement degreeField;
    public WebElement getDegreeField(){
        return degreeField;
    }

    @FindBy(id = "consultantForm_language")
    WebElement languageField;
    public WebElement getLanguageField(){
        return languageField;
    }

    @FindBy(id = "consultantForm_designation")
    WebElement designationField;
    public WebElement getDesignationField(){
        return designationField;
    }

    @FindBy(id = "consultantForm_roles")
    WebElement roleField;
    public WebElement getRoleField(){
        return roleField;
    }

    @FindBy(className = "mapboxgl-ctrl-geocoder--input")
    WebElement addressField;
    public WebElement getAddressField(){
        return addressField;
    }

    @FindBy(id = "new-patient_make")
    WebElement vehicleMake;
    public WebElement getVehicleMake(){
        return vehicleMake;
    }

    @FindBy(id = "new-patient_model")
    WebElement vehicleModel;
    public WebElement getVehicleModel(){
        return vehicleModel;
    }

    @FindBy(id = "new-patient_year")
    WebElement vehicleYear;
    public WebElement getVehicleYear(){
        return vehicleYear;
    }

    @FindBy(id = "new-patient_fuel_type")
    WebElement vehicleFuel;
    public WebElement getVehicleFuel(){
        return vehicleFuel;
    }

    @FindBy(id = "new-patient_registration_no")
    WebElement vehicleReg;
    public WebElement getVehicleReg(){
        return vehicleReg;
    }

    @FindBy(xpath = "//button[text()='Save']")
    WebElement vehicleSave;
    public WebElement getVehicleSave(){
        return vehicleSave;
    }

}
