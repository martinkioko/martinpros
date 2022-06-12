package StepDefinitions;

import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


public class BaseClass {

    public static WebDriver driver;
    public static Properties prop;
    public Actions actions;
    static final String SMALL = "abcdefghijklmnopqrstuvwxyz";
    static final String CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static SecureRandom secureRnd = new SecureRandom();
    public static String filepath = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\document.pdf";
    public static String imagepath = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\wound.jpeg";

    public static void Launchbrowser() throws Exception {
        System.setProperty("webdriver.chrome.driver", "Browsers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //return driver;
    }

    public static void GetUrl(String URL) {
        driver.get(URL);
    }

    public static void Closebrowser() {
        driver.close();
        driver.quit();
    }

    public static WebDriverWait wait(int duration) {
        return new WebDriverWait(driver, Duration.ofSeconds(duration));
    }

    public static void implicitWait(int duration) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));

    }

    public static String daysFromToday(int i) {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(i, ChronoUnit.DAYS);
        return tomorrow.format(DateTimeFormatter.ofPattern("MM-dd-yyyyy"));
    }

    public static String randomDate() {

        LocalDate from = LocalDate.of(2000, 1, 1);
        LocalDate to = LocalDate.of(2017, 1, 1);
        long days = from.until(to, ChronoUnit.DAYS);
        long randomDays = ThreadLocalRandom.current().nextLong(days + 1);
        LocalDate randomDate = from.plusDays(randomDays);
        return randomDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyyy"));
    }

    public static String todaysDate(String format) {
        LocalDate today = LocalDate.now();
        return today.format(DateTimeFormatter.ofPattern(format));
    }

    public static String tomorrowsDate(String format) {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        return tomorrow.format(DateTimeFormatter.ofPattern(format));
    }

    public static String daysBeforeToday(int days, String format) {
        LocalDate today = LocalDate.now();
        LocalDate beforeToday = today.minus(days, ChronoUnit.DAYS);
        return beforeToday.format(DateTimeFormatter.ofPattern(format));
    }

    public static String daysAfterToday(int days) {
        LocalDate today = LocalDate.now();
        LocalDate afterToday = today.plus(days, ChronoUnit.DAYS);
        return afterToday.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
    }

    public static String randomNumber(int charLength) {
        return String.valueOf(charLength < 1 ? 0 : new Random()
                .nextInt((9 * (int) Math.pow(10, charLength - 1)) - 1)
                + (int) Math.pow(10, charLength - 1));
    }

    public static String randomSmall(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(SMALL.charAt(secureRnd.nextInt(SMALL.length())));
        return sb.toString();
    }

    public static String randomCaps(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(CAPS.charAt(secureRnd.nextInt(CAPS.length())));
        return sb.toString();
    }

    public static void scrollIntoView(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", element);

    }

    public static void javascriptClick(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", element);
    }

    public static void actionDown() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }

    public static void actionTab() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
    }

    public static void actionEnter() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

}
