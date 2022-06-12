package Pages;

import StepDefinitions.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPatient extends BaseClass {
    public AddPatient(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"main-menu\"]/div[1]/div[3]")
    WebElement patientsMenu;
    public WebElement getPatientsMenu() {
        return patientsMenu;
    }

    @FindBy(xpath = "//button[text()='New Patient']")
    WebElement addPatient;
    public WebElement getAddPatient(){
        return addPatient;
    }

    @FindBy(id = "new-patient_first")
    WebElement firstNameField;
    public WebElement getFirstNameField(){
        return firstNameField;
    }

    @FindBy(id = "new-patient_last")
    WebElement lastNameField;
    public WebElement getLastNameField(){
        return lastNameField;
    }

    @FindBy(id = "new-patient_email")
    WebElement emailField;
    public WebElement getEmailFieldField(){
        return emailField;
    }

    @FindBy(id = "new-patient_birth_date")
    WebElement dateOfBirthField;
    public WebElement getDateOfBirthField(){
        return dateOfBirthField;
    }

    @FindBy(id = "new-patient_gender")
    WebElement genderField;
    public WebElement getGenderField(){
        return genderField;
    }

    @FindBy(id = "new-patient_ssn")
    WebElement ssnField;
    public WebElement getSsnField(){
        return ssnField;
    }

    @FindBy(id = "new-patient_phone_no")
    WebElement phoneNumberField;
    public WebElement getPhoneNumberField(){
        return phoneNumberField;
    }

    @FindBy(id = "new-patient_facility_id")
    WebElement facilityField;
    public WebElement getFacilityField(){
        return facilityField;
    }

    @FindBy(id = "new-patient_billable_from")
    WebElement billField;
    public WebElement getBillField(){
        return billField;
    }

    @FindBy(className = "mapboxgl-ctrl-geocoder--input")
    WebElement addressField;
    public WebElement getAddressField(){
        return addressField;
    }

    @FindBy(xpath = "//button[text()='Create']")
    WebElement create;
    public WebElement getCreate(){
        return create;
    }

    @FindBy(id = "insuranceForm_plan")
    WebElement insurancePlan;
    public WebElement getInsurancePlan(){
        return insurancePlan;
    }

    @FindBy(id = "insuranceForm_policy_number")
    WebElement insurancePolicyNumber;
    public WebElement getInsurancePolicyNumber(){
        return insurancePolicyNumber;
    }

    @FindBy(id = "insuranceForm_phone")
    WebElement insuranceMobile;
    public WebElement getInsuranceMobile(){
        return insuranceMobile;
    }

    @FindBy(id = "insuranceForm_fax")
    WebElement fax;
    public WebElement getFax(){
        return fax;
    }

    @FindBy(id = "insuranceForm_copay_due")
    WebElement copay;
    public WebElement getCopay(){
        return copay;
    }

    @FindBy(id = "insuranceForm_priority")
    WebElement priority;
    public WebElement getPriority(){
        return priority;
    }

    @FindBy(id = "insuranceForm_contact")
    WebElement contactPerson;
    public WebElement getContactPerson(){
        return contactPerson;
    }

    @FindBy(id = "new-patient_primary_family_member_name")
    WebElement patientContactNames;
    public WebElement getPatientContactNames(){
        return patientContactNames;
    }

    @FindBy(id = "new-patient_primary_family_member_phone")
    WebElement patientContactMobile;
    public WebElement getPatientContactMobile(){
        return patientContactMobile;
    }

    @FindBy(id = "new-patient_physical_address")
    WebElement patientPhysicalAddress;
    public WebElement getPatientPhysicalAddress(){
        return patientPhysicalAddress;
    }

    @FindBy(id = "faceSheetForm_title")
    WebElement patientDocumentTitle;
    public WebElement getPatientDocumentTitle(){
        return patientDocumentTitle;
    }

    @FindBy(id = "faceSheetForm_type")
    WebElement patientDocumentType;
    public WebElement getPatientDocumentType(){
        return patientDocumentType;
    }

    @FindBy(xpath = "//button[span='Upload']/preceding-sibling::input")
    WebElement patientDocumentUpload;
    public WebElement getPatientDocumentUpload(){
        return patientDocumentUpload;
    }

    @FindBy(id = "new-progress-note_notes")
    WebElement patientNotes;
    public WebElement getPatientNotes(){
        return patientNotes;
    }

}
