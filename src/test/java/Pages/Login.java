package Pages;

import StepDefinitions.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login extends BaseClass {

    public Login() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Agency_username")
    WebElement username;

    @FindBy(id = "Agency_password")
    WebElement password;

    @FindBy(xpath = "//button[span='Log in']")
    WebElement Login_btn;

    @FindBy(xpath = "//div[text()='Login success']")
    WebElement Valid_login;


    public WebElement username() {
        return username;
    }

    public WebElement password() {
        return password;
    }

    public WebElement Click_login_button() {
        return Login_btn;
    }

    public WebElement validLogin() {
        return Valid_login;
    }

}

