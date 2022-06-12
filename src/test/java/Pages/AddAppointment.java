package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import StepDefinitions.BaseClass;

public class AddAppointment extends BaseClass{
    public AddAppointment(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"main-body\"]/div/div[3]/div/div/div[1]/div/div[3]/div[1]/button")
    WebElement addAppointmentButton;
    public WebElement getAddAppointmentButton() {
        return addAppointmentButton;
    }

    @FindBy(id = "new-patient_date")
    WebElement appointmentDate;
    public WebElement getAppointmentDate() {
        return appointmentDate;
    }

    @FindBy(id = "new-patient_time_slot")
    WebElement appointmentFrom;
    public WebElement getAppointmentFrom() {
        return appointmentFrom;
    }

    @FindBy(xpath = "//*[@id=\"appointmentForm\"]/div[4]/div[2]/div/div[2]/div/div/div/div[3]/input")
    WebElement appointmentTo;
    public WebElement getAppointmentTo() {
        return appointmentTo;
    }

    @FindBy(id = "new-patient_consultant")
    WebElement consultantField;
    public WebElement getConsultantField() {
        return consultantField;
    }

    @FindBy(id = "new-patient_wounds_0_location")
    WebElement woundsLocation;
    public WebElement getWoundsLocation() {
        return woundsLocation;
    }

    @FindBy(id = "new-patient_wounds_0_recommended_procedure")
    WebElement procedue;
    public WebElement getProcedue() {
        return procedue;
    }

    @FindBy(id = "new-patient_visit_reason")
    WebElement reason;
    public WebElement getReason() {
        return reason;
    }

    @FindBy(xpath = "//button[text()='Save']")
    WebElement saveAppointment;
    public WebElement getSaveAppointment() {
        return saveAppointment;
    }
}
