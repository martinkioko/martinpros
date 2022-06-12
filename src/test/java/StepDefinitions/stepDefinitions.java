package StepDefinitions;

import Pages.*;
import Pages.AddPatient;
import com.github.javafaker.Faker;
import dataProvider.ConfigFileReader;
import gherkin.lexer.Th;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertEquals;


public class stepDefinitions extends BaseClass {

    ConfigFileReader read = new ConfigFileReader();
    Properties pro = read.ConfigFile();
    Login log = new Login();
    AddPatient addPatient = new AddPatient();
    AddConsultant addConsultant = new AddConsultant();
    AddFacility addFacility = new AddFacility();
    AddAppointment addAppointment = new AddAppointment();
    PatientAssessment patientAssessment = new PatientAssessment();
    Faker faker = new Faker();

    @Given("Navigate to Woundpros login page")
    public void Navigate_to_Woundpros() {
        try {
            GetUrl(pro.getProperty("Url"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @When("^Enter username and Password")
    public void enter_username_and_password() {
        wait(20).until(ExpectedConditions.visibilityOf(log.username())).sendKeys(pro.getProperty("Username"));
        implicitWait(2);
        log.password().sendKeys(pro.getProperty("Password"));

    }

    @And("Click on login button")
    public void click_on_log_in_button() {
        scrollIntoView(log.Click_login_button());
        log.Click_login_button().click();

    }


    @Then("User should be logged in with success message {string}")
    public void userShouldBeLoggedInWithSuccessMessage(String expected) {

        String Actual = wait(30).until(ExpectedConditions.visibilityOf(log.validLogin())).getText();
        assertEquals(expected, Actual);
    }

    @Given("User clicks on patient menu from dashboard")
    public void userClicksOnPatientMenuFromDashboard() throws InterruptedException {
        wait(30).until(ExpectedConditions.visibilityOf(addPatient.getPatientsMenu())).click();
        Thread.sleep(3000);
        driver.navigate().refresh();
    }

    @Then("User clicks add patient button")
    public void userClicksAddPatientButton() {
        wait(60).until(ExpectedConditions.visibilityOf(addPatient.getAddPatient()));
        javascriptClick(addPatient.getAddPatient());
        implicitWait(3);
    }

    @Then("Enters patient first name")
    public void entersPatientFirstdName() {
        sharedatastep.PatientFirstName = faker.name().firstName();
        wait(30).until(ExpectedConditions.visibilityOf(addPatient.getFirstNameField())).sendKeys(sharedatastep.PatientFirstName);
        implicitWait(1);
    }

    @Then("Enters patient last name")
    public void entersPatientLastName() {
        sharedatastep.PatientLastName = faker.name().lastName();
        wait(30).until(ExpectedConditions.visibilityOf(addPatient.getLastNameField())).sendKeys(sharedatastep.PatientLastName);
        implicitWait(1);
        System.out.println("Patient names provided are: " + sharedatastep.PatientFirstName + " " + sharedatastep.PatientLastName);
    }

    @Then("Enters patient date of birth as {string}")
    public void entersPatientDateOfBirthAs(String dob) throws InterruptedException {
        Thread.sleep(1000);
        addPatient.getDateOfBirthField().sendKeys(dob);
        actionEnter();
    }

    @Then("Select patient gender as {string}")
    public void selectPatientGender(String gender) throws InterruptedException {
        addPatient.getGenderField().click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(@title, '" + gender + "')]//div[text()='" + gender + "']")).click();
    }

    @Then("Enters SSN number")
    public void entersSSNNumber() throws InterruptedException {
        addPatient.getSsnField().sendKeys(randomNumber(9));
    }

    @Then("Enters patient email")
    public void entersPatientEmail() {
        String email = sharedatastep.PatientFirstName + "_" + sharedatastep.PatientLastName + "@gmail.com";
        addPatient.getEmailFieldField().sendKeys(email);
    }

    @Then("Enters patient phone number")
    public void entersPatientPhoneNumber() throws InterruptedException {
        Thread.sleep(1000);
        addPatient.getPhoneNumberField().sendKeys("+(1)(713) 644-" + randomNumber(4));
    }

    @Then("Selects Facility")
    public void selectsFacility() throws InterruptedException {
        wait(20).until(ExpectedConditions.visibilityOf(addPatient.getFacilityField()));
//        addFacility.getSalesManager().sendKeys("Xfuookv");
        addPatient.getFacilityField().sendKeys(sharedatastep.FacilityName);
        Thread.sleep(6000);
        actionDown();
        Thread.sleep(600);
        actionEnter();
    }

    @Then("Enters patient date can bill")
    public void entersPatientDateCanBill() {
        addPatient.getBillField().sendKeys(todaysDate("MM-dd-yyyy"));
        actionEnter();
    }

    @Then("Enters patient address as {string}")
    public void entersPatientAddressAs(String address) throws InterruptedException {
        addPatient.getAddressField().sendKeys(address);
        Thread.sleep(2000);
        actionTab();
    }

    @Then("Clicks create")
    public void clicksCreate() {
        javascriptClick(addPatient.getCreate());
    }

    @Then("Verify success message alert {string}")
    public void verifySuccessMessageAlert(String expected) {
        String Actual = wait(120).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + expected + "']"))).getText();
        assertEquals(expected, Actual);
    }

    @Then("Verify added patient populates in table")
    public void verifyAddedPatientPopulatesInTable() {
        String Actual = wait(30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='" + sharedatastep.PatientFirstName + " " + sharedatastep.PatientLastName + "']"))).getText();
        assertEquals(sharedatastep.PatientFirstName + " " + sharedatastep.PatientLastName, Actual);
    }

    @Given("User clicks on consultant menu from dashboard")
    public void userClicksOnConsultantMenuFromDashboard() throws InterruptedException {
        wait(30).until(ExpectedConditions.visibilityOf(addConsultant.getConsultantsMenu())).click();
        Thread.sleep(1000);
    }

    @Then("User clicks add consultant button")
    public void userClicksAddConsultantButton() {
        wait(30).until(ExpectedConditions.visibilityOf(addConsultant.getAddConsultant()));
        javascriptClick(addConsultant.getAddConsultant());
        implicitWait(3);
    }

    @Then("Enters consultant first name")
    public void entersConsultantFirstName() {
//        sharedatastep.ConsultantFirstName = randomCaps(1) + randomSmall(6);
        sharedatastep.ConsultantFirstName = faker.name().firstName();
        wait(30).until(ExpectedConditions.visibilityOf(addConsultant.getFirstNameField())).sendKeys(sharedatastep.ConsultantFirstName);
        implicitWait(1);
    }

    @Then("Enters consultant last name")
    public void entersConsultantLastName() {
//        sharedatastep.ConsultantLastName = randomCaps(1) + randomSmall(6);
        sharedatastep.ConsultantLastName = faker.name().lastName();;
        wait(30).until(ExpectedConditions.visibilityOf(addConsultant.getLastNameField())).sendKeys(sharedatastep.ConsultantLastName);
        implicitWait(1);
        System.out.println("Consultant names provided are: " + sharedatastep.ConsultantFirstName + " " + sharedatastep.ConsultantLastName);
    }

    @Then("Enters consultant date of birth as {string}")
    public void entersConsultantDateOfBirthAs(String dob) throws InterruptedException {
        Thread.sleep(1000);
        addConsultant.getDateOfBirthField().sendKeys(dob);
        actionEnter();
    }

    @Then("Select consultant gender as {string}")
    public void selectConsultantGender(String gender) throws InterruptedException {
        addConsultant.getGenderField().click();
        Thread.sleep(300);
        driver.findElement(By.xpath("//*[contains(@title, '" + gender + "')]//div[text()='" + gender + "']")).click();
    }

    @Then("Enters consultant date of hire")
    public void entersConsultantDateOfHire() throws InterruptedException {
        Thread.sleep(1000);
        addConsultant.getDohField().sendKeys(daysBeforeToday(10, "yyyy-MM-dd"));
        actionEnter();

    }

    @Then("Enters consultant NPI")
    public void entersConsultantNPI() {
        addConsultant.getNpiNumberField().sendKeys(randomNumber(5));
        implicitWait(1);
    }

    @Then("Enters consultants CAQH ID")
    public void entersConsultantsCAQHID() {
        addConsultant.getCidField().sendKeys(randomNumber(6));
        implicitWait(1);
    }

    @Then("Enters consultants BHPN Practitioner ID")
    public void entersConsultantsBHPNPractitionerID() {
        addConsultant.getBidField().sendKeys(randomNumber(6));
        implicitWait(1);
    }

    @Then("Enters consultant email")
    public void entersConsultantEmail() {
        String email = sharedatastep.ConsultantFirstName + "_" + sharedatastep.ConsultantLastName + "@gmail.com";
        addConsultant.getEmailField().sendKeys(email);
    }

    @Then("Enters consultant phone number")
    public void entersConsultantPhoneNumber() {
        addConsultant.getPhoneNumberField().sendKeys("+(1)(713) 644-" + randomNumber(4));
    }

    @Then("Selects consultant degree as {string}")
    public void selectsConsultantDegreeAs(String degree) throws InterruptedException {
        addConsultant.getDegreeField().click();
        Thread.sleep(1000);
        wait(5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + degree + "']"))).click();
        implicitWait(1);
        actionTab();
    }

    @Then("Enters consultant language as {string}")
    public void entersConsultantLanguageAs(String language) {
        addConsultant.getLanguageField().sendKeys(language);
    }

    @Then("Selects consultant designation as {string}")
    public void selectsConsultantDesignationAs(String designation) throws InterruptedException {
        addConsultant.getDesignationField().click();
        Thread.sleep(1000);
//        WebElement desg = wait(30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+designation+"']")));
//        javascriptClick(desg);
        actionDown();
        actionDown();
        actionEnter();
        implicitWait(1);

    }

    @And("Enters consultant role as {string}")
    public void entersConsultantRoleAs(String role) throws InterruptedException {
        addConsultant.getRoleField().sendKeys(role);
        Thread.sleep(3000);
        actionEnter();
        actionTab();
    }

    @Then("Enters consultant address as {string}")
    public void entersConsultantAddressAs(String address) throws InterruptedException {
        addConsultant.getAddressField().sendKeys(address);
        Thread.sleep(2000);
        actionTab();
        actionTab();
    }

    @Then("Verify added consultant populates in table")
    public void verifyAddedConsultantPopulatesInTable() {
        String Actual = wait(30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='" + sharedatastep.ConsultantFirstName + " " + sharedatastep.ConsultantLastName + "']"))).getText();
        assertEquals(sharedatastep.ConsultantFirstName + " " + sharedatastep.ConsultantLastName, Actual);
    }

    @Given("User clicks on facility menu from dashboard")
    public void userClicksOnFacilityMenuFromDashboard() {
        wait(30).until(ExpectedConditions.visibilityOf(addFacility.getFacilityMenu())).click();
    }

    @Then("User clicks add facility button")
    public void userClicksAddFacilityButton() {
        wait(30).until(ExpectedConditions.visibilityOf(addFacility.getAddFacility()));
        javascriptClick(addFacility.getAddFacility());
        implicitWait(3);
    }

    @Then("Enters Sales manager name")
    public void entersSalesManagerName() throws InterruptedException {
        wait(20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"facilityForm\"]/div[2]/div[2]/div/div/div/div/div"))).click();
        Thread.sleep(400);
//        addFacility.getSalesManager().sendKeys("Omari");
        addFacility.getSalesManager().sendKeys(sharedatastep.ConsultantFirstName);
        Thread.sleep(6000);
        actionDown();
        Thread.sleep(600);
        actionEnter();
    }

    @Then("Enters facility name")
    public void entersFacilityName() {
        sharedatastep.FacilityName = faker.company().name();
        addFacility.getFacilityName().sendKeys(sharedatastep.FacilityName);
        System.out.println("Facility name : "+sharedatastep.FacilityName);
    }

    @Then("Enters contact person")
    public void entersContactPerson() {
//        addFacility.getContactPerson().sendKeys("Xjnhypj Lufirkj");
        addFacility.getContactPerson().sendKeys(sharedatastep.ConsultantFirstName+" "+sharedatastep.ConsultantLastName);
    }

    @Then("Select facility type as {string}")
    public void selectFacilityTypeAs(String facility) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[span='" + facility + "']")).click();
    }

    @Then("Click add facility document")
    public void clickAddFacilityDocument() {
        addFacility.getFacilityDocument().click();
    }

    @Then("Enter document title and document type as {string}")
    public void enterDocumentTitleAndDocumentTypeAs(String docType) throws InterruptedException {
        wait(30).until(ExpectedConditions.visibilityOf(addFacility.getDocumentTitle())).sendKeys(randomCaps(1) + randomSmall(6));
        implicitWait(3);
        addFacility.getDocumentType().click();
        Thread.sleep(1500);
        WebElement type = wait(30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + docType + "')]//div[text()='" + docType + "']")));
        type.click();
    }

    @Then("Selects facility document")
    public void selectsFacilityDocument() throws InterruptedException {
        addFacility.getUploadButton().sendKeys(filepath);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[text()='Add']")).click();
    }

    @Then("Enters facility address as {string}")
    public void entersFacilityAddressAs(String address) throws InterruptedException {
        Thread.sleep(2000);
        addFacility.getAddressField().sendKeys(address);
        Thread.sleep(2000);
        actionTab();
        actionTab();
    }

    @Then("Enters facility primary email")
    public void entersFacilityPrimaryEmail() {
        String email = sharedatastep.ConsultantFirstName + "@gmail.com";
        addFacility.getEmailField().sendKeys(email);
    }

    @Then("Enters facility primary phone number")
    public void entersFacilityPrimaryPhoneNumber() {
        addFacility.getPhoneNumberField().sendKeys("+(1)(713) 644-" + randomNumber(4));
    }

    @Then("Clicks create to add facility")
    public void clicksCreateToAddFacility() {
        addFacility.getCreate().click();
    }

    @Then("Verify added facility populates in table")
    public void verifyAddedFacilityPopulatesInTable() {
        String Actual = wait(30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='" + sharedatastep.FacilityName + "']"))).getText();
        assertEquals(sharedatastep.FacilityName, Actual);
    }


    @Then("User selects newly created patient")
    public void userSelectsNewlyCreatedPatient() {
        wait(30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='" + sharedatastep.PatientFirstName + " " + sharedatastep.PatientLastName + "']"))).click();
//        wait(30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Hubert Carroll']"))).click();
    }

    @Then("User clicks add appointment button")
    public void userClicksAddAppointmentButton() {
        wait(30).until(ExpectedConditions.visibilityOf(addAppointment.getAddAppointmentButton())).isDisplayed();
        javascriptClick(addAppointment.getAddAppointmentButton());
    }

    @Then("User selects visit type as {string}")
    public void userSelectsVisitTypeAs(String visitType) {
        wait(20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[span='" + visitType + "']"))).click();
    }

    @Then("User enters date as today")
    public void userEntersDateAsToday() throws InterruptedException {
        Thread.sleep(1000);
        addAppointment.getAppointmentDate().sendKeys(todaysDate("MM-dd-yyyy"));
        actionEnter();
    }

    @Then("User enters timeslot as {string} to {string}")
    public void userEntersTimeslotAsTo(String from, String to) throws InterruptedException {
        Thread.sleep(1000);
        addAppointment.getAppointmentFrom().sendKeys(from);
        actionEnter();
        addAppointment.getAppointmentTo().sendKeys(to);
        actionEnter();
    }

    @Then("User Selects newly created consultant")
    public void userSelectsNewlyCreatedConsultant() throws InterruptedException {
        addAppointment.getConsultantField().sendKeys(sharedatastep.ConsultantFirstName);
//        addAppointment.getConsultantField().sendKeys("Melanie Ping");
        Thread.sleep(4000);
        actionDown();
        Thread.sleep(600);
        actionEnter();
    }

    @Then("User Selects wound location as {string}")
    public void userSelectsWoundLocationAs(String woundLocation) throws InterruptedException {
        addAppointment.getWoundsLocation().click();
        Thread.sleep(1000);
        wait(5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + woundLocation + "']"))).click();
        implicitWait(1);
        actionTab();

    }

    @Then("User Selects Procedue as {string}")
    public void userSelectsProcedueAs(String procedue) throws InterruptedException {
        addAppointment.getProcedue().click();
        Thread.sleep(1000);
//        wait(5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+procedue+"']"))).click();
        actionDown();
        actionEnter();
        implicitWait(1);
        actionTab();
    }

    @Then("User Enters reason as {string}")
    public void userEntersReasonAs(String reason) {
        implicitWait(2);
        addAppointment.getReason().sendKeys(reason);
    }

    @Then("User Saves appointment")
    public void userSavesAppointment() {
        implicitWait(2);
        addAppointment.getSaveAppointment().click();
    }

    @Given("User clicks on newly created appointment")
    public void userClicksOnNewlyCreatedAppointment() {
//        wait(30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='"+sharedatastep.ConsultantFirstName+" "+sharedatastep.ConsultantLastName+"']"))).click();
//        wait(30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Cbkegbl Rnfuhik']"))).click();
        wait(30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='new visit']"))).click();
    }

    @Then("User clicks on start assessment button")
    public void userClicksOnStartAssessmentButton() {
        wait(30).until(ExpectedConditions.visibilityOf(patientAssessment.getAssessmentButton()));
        javascriptClick(patientAssessment.getAssessmentButton());
    }

    @Then("Select procedue as {string}")
    public void selectProcedueAs(String arg0) throws InterruptedException {
        wait(30).until(ExpectedConditions.visibilityOf(patientAssessment.getProcedueDropdown())).click();
        Thread.sleep(1000);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Select wound status as {string}")
    public void selectWoundStatusAs(String arg0) throws InterruptedException {
        wait(50).until(ExpectedConditions.visibilityOf(patientAssessment.getWoundStatus())).click();
        Thread.sleep(1000);
//        wait(30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+arg0+"']"))).click();
        actionDown();
        actionEnter();
    }

    @Then("Upload image wound")
    public void uploadImageWound() throws InterruptedException {
        Thread.sleep(1000);
        patientAssessment.getUploadWound().sendKeys(imagepath);
    }

    @Then("Fill in dimensions that have not been generated")
    public void fillInDimensionsThatHaveNotBeenGenerated() {
        String length = patientAssessment.getAssessmentLength().getAttribute("value");
        String width = patientAssessment.getAssessmentWidth().getAttribute("value");
        String depth = patientAssessment.getAssessmentDepth().getAttribute("value");
        String area = patientAssessment.getAssessmentArea().getAttribute("value");
        String volume = patientAssessment.getAssessmentVolume().getAttribute("value");

        if (length.isEmpty()) {
            patientAssessment.getAssessmentLength().sendKeys("3.85");
        }
        if (width.isEmpty()) {
            patientAssessment.getAssessmentWidth().sendKeys("4.30");
        }
        if (depth.isEmpty()) {
            patientAssessment.getAssessmentDepth().sendKeys("1.30");
        }
//         if(area.isEmpty()){
//             patientAssessment.getAssessmentArea().sendKeys("16.56");
//         }
//         if(volume.isEmpty()){
//             patientAssessment.getAssessmentVolume().sendKeys("");
//         }
    }

    @Then("Select wound size as {string}")
    public void selectWoundSizeAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getSize().click();
        Thread.sleep(300);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Select wound Type as {string}")
    public void selectWoundTypeAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getWoundType().click();
        Thread.sleep(300);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Select stage as {string}")
    public void selectStageAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getAssessmentStage().click();
        Thread.sleep(300);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Select exudate amount as {string}")
    public void selectExudateAmountAs(String arg0) throws Throwable {
        Thread.sleep(300);
        patientAssessment.getExudateAmount().click();
        Thread.sleep(300);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Select wound side as {string}")
    public void selectWoundSideAs(String arg0) throws Throwable {
        Thread.sleep(300);
        patientAssessment.getWoundSide().click();
        Thread.sleep(300);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Select wound position as {string}")
    public void selectWoundPositionAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getWoundPosition().click();
        Thread.sleep(300);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();

    }

    @Then("User fills in tissues affected if they have not been generated")
    public void userFillsInTissuesAffectedIfTheyHaveNotBeenGenerated() {
        String granulationTissue = patientAssessment.getGranularTissue().getAttribute("value");
        String necroticTissue = patientAssessment.getNecroticTissue().getAttribute("value");
        String fibrousTissue = patientAssessment.getFibrousTissue().getAttribute("value");
        String sloughTissue = patientAssessment.getSloughTissue().getAttribute("value");
        String escharTissue = patientAssessment.getEscharTissue().getAttribute("value");

        if (granulationTissue.isEmpty()) {
            patientAssessment.getGranularTissue().sendKeys("65.82");
        }
        if (necroticTissue.isEmpty()) {
            patientAssessment.getNecroticTissue().sendKeys("10");
        }
        if (fibrousTissue.isEmpty()) {
            patientAssessment.getFibrousTissue().sendKeys("34.18");
        }
        if (sloughTissue.isEmpty()) {
            patientAssessment.getSloughTissue().sendKeys("0");
        }
        if (escharTissue.isEmpty()) {
            patientAssessment.getEscharTissue().sendKeys("7");
        }
    }

    @Then("Select conservative treatment as {string}")
    public void selectConservativeTreatmentAs(String arg0) throws Throwable {
        Thread.sleep(300);
        patientAssessment.getConservativeTreatment().click();
        Thread.sleep(300);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Select wound duration as {string}")
    public void selectWoundDurationAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getWoundDuration().click();
        Thread.sleep(300);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Select wound condition as {string}")
    public void selectWoundConditionAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getWoundCondition().click();
        Thread.sleep(300);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Select wound dressing as {string}")
    public void selectWoundDressingAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getWoundDressing().click();
        Thread.sleep(300);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Select response to therapy as {string}")
    public void selectResponseToTherapyAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getTherapyResponse().click();
        Thread.sleep(300);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Select wound edges as {string}")
    public void selectWoundEdgesAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getWoundEdges().click();
        Thread.sleep(300);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Select wound bed as {string}")
    public void selectWoundBedAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getWoundBed().click();
        Thread.sleep(300);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Enter undermining value as {string}")
    public void enterUnderminingValueAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getAssessmentUndermining().sendKeys(arg0);
    }

    @Then("Enter tunneling size as {string}")
    public void enterTunnelingSizeAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getTunnelingSize().sendKeys(arg0);
    }

    @Then("Select tunneling direction as {string}")
    public void selectTunnelingDirectionAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getTunnelingDirection().click();
        Thread.sleep(300);
        actionDown();
        actionEnter();
    }

    @Then("Enter sinus tract as {string}")
    public void enterSinusTractAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getSinnusTract().sendKeys(arg0);
    }

    @Then("Select exposed structures as {string}")
    public void selectExposedStructuresAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getExposedStructures().click();
        Thread.sleep(300);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Select periwound color as {string}")
    public void selectPeriwoundColorAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getPeriwoundColor().click();
        Thread.sleep(300);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Select pain level as {string}")
    public void selectPainLevelAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getPainLevel().click();
        Thread.sleep(300);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Select exudate type as {string}")
    public void selectExudateTypeAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getExudateType().click();
        Thread.sleep(300);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Select epithelialization as {string}")
    public void selectEpithelializationAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getEpithelialization().click();
        Thread.sleep(300);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Select odor as {string}")
    public void selectOdorAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getOdor().click();
        Thread.sleep(300);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Select infection as {string}")
    public void selectInfectionAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getInfection().click();
        Thread.sleep(300);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Select other interventions as {string}")
    public void selectOtherInterventionsAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getOtherInterventions().click();
        Thread.sleep(300);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Select other related factors as {string}")
    public void selectOtherRelatedFactorsAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getOtherRelatedFactors().click();
        Thread.sleep(300);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Enter Referral recommendations as {string}")
    public void enterReferralRecommendationsAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getReferralRecommendations().sendKeys(arg0);
    }

    @Then("Enter treatment filter as {string}")
    public void enterTreatmentFilterAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getTreatmentFilter().click();
        Thread.sleep(300);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Select wound location")
    public void selectWoundLocation() throws InterruptedException {
        Thread.sleep(1000);
        patientAssessment.getBodyImage().click();
        Thread.sleep(1000);
        wait(10).until(ExpectedConditions.visibilityOf(patientAssessment.getWouldLocation())).click();
        Thread.sleep(300);
        patientAssessment.getSaveWoundLocation().click();
        Thread.sleep(1000);
    }

    @Then("Click get treatment button")
    public void clickGetTreatmentButton() {
        patientAssessment.getGetTreatment().click();
    }

    @Then("Select treatment scenario as {string}")
    public void selectTreatmentScenarioAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getTreatmentScenario().click();
        Thread.sleep(300);
        patientAssessment.getTreatmentScenario().sendKeys(arg0);
        wait(60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Add treatment order item {string}")
    public void addTreatmentOrderItem(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getOrderItems().click();
        Thread.sleep(300);
        patientAssessment.getOrderItemField().sendKeys(arg0);
        Thread.sleep(6000);
        actionDown();
        Thread.sleep(600);
        actionEnter();
    }

    @Then("Add plan of care as {string}")
    public void addPlanOfCareAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getPlanOfCare().click();
        Thread.sleep(1000);
        wait(30).until(ExpectedConditions.visibilityOf(patientAssessment.getPlanOfCareField())).sendKeys(arg0);
        Thread.sleep(8000);
        actionDown();
        Thread.sleep(600);
        actionEnter();
        wait(20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='" + arg0 + "']"))).isDisplayed();
    }

    @Then("Click create assessment button")
    public void clickCreateAssessmentButton() throws InterruptedException {
        Thread.sleep(3000);
        patientAssessment.getCreateAssessment().click();
    }


    @Then("Wait until treatment order item is generated {string}")
    public void waitUntilTreatmentOrderItemIsGenerated(String arg0) {
        wait(30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[text()='" + arg0 + "']")));
    }

    @Then("Click select all under plan of care")
    public void clickSelectAllUnderPlanOfCare() {
        wait(20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Select All']/parent::div/preceding-sibling::label"))).click();
    }


    //Podiatry extra data
    @Then("Enter Post Debridement Wound Measurements")
    public void enterPostDebridementWoundMeasurements() throws InterruptedException {
        Thread.sleep(200);
        patientAssessment.getPostDebridementLength().sendKeys("2");
        Thread.sleep(200);
        patientAssessment.getPostDebridementWidth().sendKeys("2");
        Thread.sleep(200);
        patientAssessment.getPostDebridementDepth().sendKeys("2");
    }

    @Then("Add Vascular measurements")
    public void addVascularMeasurements() throws InterruptedException {
        Thread.sleep(200);
        patientAssessment.getRightDp().click();
        Thread.sleep(200);
        actionDown();
        actionEnter();

        Thread.sleep(200);
        patientAssessment.getLeftDp().click();
        Thread.sleep(200);
        actionDown();
        actionEnter();

        Thread.sleep(200);
        patientAssessment.getRightPt().click();
        Thread.sleep(200);
        actionDown();
        actionEnter();

        Thread.sleep(200);
        patientAssessment.getLeftPt().click();
        Thread.sleep(200);
        actionDown();
        actionEnter();

        Thread.sleep(200);
        patientAssessment.getSkinTemperatureRight().click();
        Thread.sleep(200);
        actionDown();
        actionEnter();

        Thread.sleep(200);
        patientAssessment.getSkinTemperatureLeft().click();
        Thread.sleep(200);
        actionDown();
        actionEnter();

        Thread.sleep(200);
        patientAssessment.getDigitalHairRight().click();
        Thread.sleep(200);
        actionDown();
        actionEnter();

        Thread.sleep(200);
        patientAssessment.getDigitalHairLeft().click();
        Thread.sleep(200);
        actionDown();
        actionEnter();

    }

    @Then("Add Neurology measurements")
    public void addNeurologyMeasurements() throws InterruptedException {
        Thread.sleep(200);
        patientAssessment.getMonofilamentTestingRight().click();
        Thread.sleep(200);
        actionDown();
        actionEnter();

        Thread.sleep(200);
        patientAssessment.getMonofilamentTestingLeft().click();
        Thread.sleep(200);
        actionDown();
        actionEnter();

        Thread.sleep(200);
        patientAssessment.getPinPrickRight().click();
        Thread.sleep(200);
        actionDown();
        actionEnter();

        Thread.sleep(200);
        patientAssessment.getPinPrickLeft().click();
        Thread.sleep(200);
        actionDown();
        actionEnter();

        Thread.sleep(200);
        patientAssessment.getSoftTouchRight().click();
        Thread.sleep(200);
        actionDown();
        actionEnter();

        Thread.sleep(200);
        patientAssessment.getSoftTouchLeft().click();
        Thread.sleep(200);
        actionDown();
        actionEnter();
    }
    //end Podiatry procedue extra data

    //biologic data
    @Then("Click on add biologic button")
    public void clickOnAddBiologicButton() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[span='Add Biologic']")).click();
    }


    @Then("Select biologic {string}")
    public void selectBiologic(String arg0) throws InterruptedException {
        Thread.sleep(300);
        wait(20).until(ExpectedConditions.visibilityOf(patientAssessment.getBiologic())).click();
        Thread.sleep(1000);
//        wait(30).until(ExpectedConditions.visibilityOf(patientAssessment.getBiologic())).sendKeys(arg0);
//        Thread.sleep(8000);
        actionDown();
        actionEnter();
//        wait(20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='" + arg0 + "']"))).isDisplayed();
    }

    @Then("Select graft size and enter quantity as {string}")
    public void selectGraftSizeAndEnterQuantityAs(String arg0) throws InterruptedException {
        Thread.sleep(1000);
        wait(20).until(ExpectedConditions.visibilityOf(patientAssessment.getGraftsize())).click();
        Thread.sleep(200);
        actionDown();
        actionEnter();
        Thread.sleep(300);
        patientAssessment.getQuantity().sendKeys(arg0);
    }

    @Then("Add circulation and neurologic status")
    public void addCirculationAndNeurologicStatus() throws InterruptedException {
        Thread.sleep(1000);
        wait(20).until(ExpectedConditions.visibilityOf(patientAssessment.getCirculation())).click();
        Thread.sleep(200);
        actionDown();
        actionDown();
        actionEnter();
        Thread.sleep(300);
        wait(20).until(ExpectedConditions.visibilityOf(patientAssessment.getNeurologic())).click();
        Thread.sleep(200);
        actionDown();
        actionDown();
        actionEnter();
        Thread.sleep(300);
    }

    @Then("Select Comorbidities as {string}")
    public void selectComorbiditiesAs(String arg0) throws InterruptedException {
        patientAssessment.getComorbidities().click();
        Thread.sleep(300);
        wait(60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
        actionTab();
        Thread.sleep(300);
    }

    @Then("Add primary care physician as {string}")
    public void addPrimaryCarePhysicianAs(String arg0) {
        patientAssessment.getPhysician().sendKeys(arg0);
    }

    @Then("Select treatment number {string}")
    public void selectTreatmentNumber(String arg0) throws InterruptedException {
        Thread.sleep(300);
        patientAssessment.getTreatmentNumber().click();
        Thread.sleep(300);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Add assessment for {string}")
    public void addAssessmentFor(String arg0) throws InterruptedException {
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-body\"]/div/div[3]/div/div[1]/div[1]/div[2]/button"))).click();
        implicitWait(2);
        driver.findElement(By.xpath("//button[text()='Start Assessment']/preceding-sibling::div/div/span[2]")).click();
        Thread.sleep(2000);
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
        verifySuccessMessageAlert("Updating wound procedures");
        verifySuccessMessageAlert("Update complete");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='"+arg0+"']/following-sibling::button[text()='Start Assessment']")).click();
    }


    @Then("Click on newly created consultant")
    public void clickOnNewlyCreatedConsultant() {
        wait(30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='" + sharedatastep.ConsultantFirstName + " " + sharedatastep.ConsultantLastName + "']"))).click();
//        wait(30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Omari Koch']"))).click();
    }

    @Then("Click + under vehicle details")
    public void clickUnderVehicleDetails() throws InterruptedException {
        Thread.sleep(1000);
        wait(20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Vehicle Details']/following-sibling::button"))).click();
    }

    @Then("Select vehicle make as {string}")
    public void selectVehicleMakeAs(String arg0) throws InterruptedException {
        Thread.sleep(1000);
        addConsultant.getVehicleMake().click();
        Thread.sleep(300);
        wait(60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
        actionTab();
        Thread.sleep(2300);
    }

    @Then("Select vehicle model")
    public void selectVehicleModel() throws InterruptedException {
        addConsultant.getVehicleModel().click();
        Thread.sleep(300);
        actionDown();
        actionEnter();
        Thread.sleep(300);
    }

    @Then("Enter vehicle year")
    public void enterVehicleYear() throws InterruptedException {
        addConsultant.getVehicleYear().sendKeys("2020");
        Thread.sleep(200);
        actionEnter();
    }

    @Then("Select fuel type")
    public void selectFuelType() throws InterruptedException {
        addConsultant.getVehicleFuel().click();
        Thread.sleep(300);
        actionDown();
        actionEnter();
        Thread.sleep(300);
    }

    @Then("Enter registration number")
    public void enterRegistrationNumber() throws InterruptedException {
        Thread.sleep(500);
        addConsultant.getVehicleReg().sendKeys("KDB "+randomNumber(4));
    }

    @Then("Click save to add vehicle details")
    public void clickSaveToAddVehicleDetails() throws InterruptedException {
        Thread.sleep(300);
        addConsultant.getVehicleSave().click();
    }

    @Then("Click on newly created facility")
    public void clickOnNewlyCreatedFacility() {
        wait(30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='" + sharedatastep.FacilityName + "']"))).click();
//        wait(30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Rohan Group']"))).click();
    }

    @Then("Click + under documents")
    public void clickUnderDocuments() throws InterruptedException {
        Thread.sleep(1000);
        wait(20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Documents:']/following-sibling::button"))).click();
    }

    @Then("Enter document title as {string} and select document type as {string}")
    public void enterDocumentTitleAsAndSelectDocumentTypeAs(String arg0, String arg1) throws InterruptedException {
        Thread.sleep(300);
        addFacility.getFacilityDocumentTitle().sendKeys(arg0);
        Thread.sleep(300);
        addFacility.getFacilityDocumentType().click();
        Thread.sleep(300);
        wait(60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg1 + "')]//div[text()='" + arg1 + "']"))).click();
    }

    @Then("Upload facility document")
    public void uploadFacilityDocument() throws InterruptedException {
        addFacility.getUploadButton().sendKeys(filepath);
        Thread.sleep(4000);
    }

    @Then("Click add to add facility document")
    public void clickAddToAddFacilityDocument() {
        driver.findElement(By.xpath("//button[text()='Add']")).click();
    }

    @Then("Click on newly created patient")
    public void clickOnNewlyCreatedPatient() {
        wait(30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='" + sharedatastep.PatientFirstName + " " + sharedatastep.PatientLastName + "']"))).click();
//        wait(30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Andrian Andrew']"))).click();
    }

    @Then("Click + under insurance information")
    public void clickUnderInsuranceInformation() throws InterruptedException {
        Thread.sleep(1000);
        wait(20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Insurance Information']/following-sibling::button"))).click();
    }

    @Then("Enter Insurance plan as {string}")
    public void enterInsurancePlanAs(String arg0) {
        implicitWait(1);
        addPatient.getInsurancePlan().sendKeys(arg0);
    }

    @Then("Enter policy number")
    public void enterPolicyNumber() throws InterruptedException {
        Thread.sleep(300);
        addPatient.getInsurancePolicyNumber().sendKeys(randomNumber(5));
    }

    @Then("Enter phone number")
    public void enterPhoneNumber() throws InterruptedException {
        Thread.sleep(300);
        addPatient.getInsuranceMobile().sendKeys("+(1)(713) 644-" + randomNumber(4));
    }

    @Then("Enter fax")
    public void enterFax() throws InterruptedException {
        Thread.sleep(300);
        addPatient.getFax().sendKeys("+5 (655) " + randomNumber(3)+ " " + randomNumber(4));
    }

    @Then("Enter copay due")
    public void enterCopayDue() throws InterruptedException {
        Thread.sleep(300);
        addPatient.getCopay().sendKeys("12000");
    }

    @Then("Select priority")
    public void selectPriority() throws InterruptedException {
        Thread.sleep(300);
        addPatient.getPriority().click();
        Thread.sleep(300);
        actionDown();
        actionEnter();
        Thread.sleep(300);
    }

    @Then("Enter contact person name")
    public void enterContactPersonName() throws InterruptedException {
        Thread.sleep(300);
        addPatient.getContactPerson().sendKeys("Maxipain Codei");
    }

    @Then("Save Insurance Information")
    public void saveInsuranceInformation() throws InterruptedException {
        Thread.sleep(300);
        driver.findElement(By.xpath("//button[text()='Save']")).click();
    }


    @Then("Click edit under contact information")
    public void clickEditUnderContactInformation() throws InterruptedException {
        Thread.sleep(1000);
        wait(20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Additional Contacts']/following-sibling::button"))).click();
    }

    @Then("Enter patient contact full names")
    public void enterPatientContactFullNames() throws InterruptedException {
        Thread.sleep(300);
        addPatient.getPatientContactNames().clear();
        addPatient.getPatientContactNames().sendKeys(faker.name().firstName()+" "+faker.name().lastName());
    }

    @Then("Enter patient contact phone number")
    public void enterPatientContactPhoneNumber() throws InterruptedException {
        Thread.sleep(300);
        addPatient.getPatientContactMobile().clear();
        addPatient.getPatientContactMobile().sendKeys("+(1)(713) 644-" + randomNumber(4));
    }

    @Then("Save patient contact information")
    public void savePatientContactInformation() throws InterruptedException {
        Thread.sleep(300);
        driver.findElement(By.xpath("//button[text()='Save']")).click();
    }

    @Then("Click + under shipping address")
    public void clickUnderShippingAddress() throws InterruptedException {
        Thread.sleep(500);
        wait(20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Shipping Address']/following-sibling::button"))).click();
    }

    @Then("Enter patient shipping address as {string}")
    public void enterPatientShippingAddressAs(String arg0) throws InterruptedException {
        addPatient.getAddressField().sendKeys(arg0);
        Thread.sleep(2000);
        actionEnter();
    }

    @Then("Enter patient physical address as {string}")
    public void enterPatientPhysicalAddressAs(String arg0) throws InterruptedException {
        Thread.sleep(500);
        addPatient.getPatientPhysicalAddress().sendKeys(arg0);
    }

    @Then("Save patient shipping address")
    public void savePatientShippingAddress() throws InterruptedException {
        Thread.sleep(300);
        driver.findElement(By.xpath("//button[text()='Save']")).click();
    }

    @Then("Click patient documents tab")
    public void clickPatientDocumentsTab() {
        wait(20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//p[text()='Documents']"))).click();
    }

    @Then("Click + under patient documents")
    public void clickUnderPatientDocuments() throws InterruptedException {
        Thread.sleep(300);
        wait(20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Documents']/following-sibling::button"))).click();
    }

    @Then("Enter patient document title as {string}")
    public void enterPatientDocumentTitleAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        wait(20).until(ExpectedConditions.visibilityOf(addPatient.getPatientDocumentTitle())).sendKeys(arg0);
    }

    @Then("Select patient document type as {string}")
    public void selectPatientDocumentTypeAs(String arg0) throws InterruptedException {
        Thread.sleep(300);
        addPatient.getPatientDocumentType().click();
        Thread.sleep(300);
        wait(60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '" + arg0 + "')]//div[text()='" + arg0 + "']"))).click();
    }

    @Then("Upload patient document")
    public void uploadPatientDocument() throws InterruptedException {
        Thread.sleep(300);
        addPatient.getPatientDocumentUpload().sendKeys(filepath);
        wait(30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='document.pdf']"))).isDisplayed();
        Thread.sleep(2000);
    }

    @Then("Click add to add patient document")
    public void clickAddToAddPatientDocument() {
        driver.findElement(By.xpath("//button[text()='Add']")).click();
    }

    @Then("Click patient internal notes tab")
    public void clickPatientInternalNotesTab() {
        wait(20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//p[text()='Internal Notes']"))).click();
    }

    @Then("Click + under internal notes")
    public void clickUnderInternalNotes() throws InterruptedException {
        Thread.sleep(300);
        wait(20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-body\"]/div/div[3]/div/div/div[1]/div/div/div/button"))).click();
    }

    @Then("Enter patient notes")
    public void enterPatientNotes() throws InterruptedException {
        Thread.sleep(300);
        wait(20).until(ExpectedConditions.visibilityOf(addPatient.getPatientNotes())).sendKeys("Notes are this here");
    }

    @Then("Click add to add patient notes")
    public void clickAddToAddPatientNotes() {
        driver.findElement(By.xpath("//button[text()='Add']")).click();
    }
}




