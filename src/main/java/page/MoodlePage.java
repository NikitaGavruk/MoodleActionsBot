package page;

import factory.FactoryDriver;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import util.PropertiesReader;

@Component
@PropertySource("classpath:database.properties")
public class MoodlePage {
    private static final By LOGIN_FIELD = By.xpath("//input[@id='username']");
    private static final By PASSWORD_FIELD = By.xpath("//input[@id='password']");
    private static final By LOGIN_BUTTON = By.xpath("//button[@id='loginbtn']");
    private static final By JOIN_WEBINAR = By.xpath("//input");
    private static final By WITHOUT_MICRO =
        By.xpath("//button[@class='jumbo--Z12Rgj4 buttonWrapper--x8uow audioBtn--1H6rCK'][2]");
    private static final By MESSAGE_CHAT = By.id("message-input");
    private static final By SEND_MESSAGE =
        By.xpath("//span[@class='button--Z2dosza md--Q7ug4 primary--1IbqAO circle--Z2c8umk']");
    String userLogin = PropertiesReader.getUserName();
    String userPassword = PropertiesReader.getPassword();
    String moodle = PropertiesReader.getMoodleLink();
    String moodleWebinar = PropertiesReader.getMoodleWebinar();
    WebDriver driver = FactoryDriver.getDriver();
    private final WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(4));

    public MoodlePage getMoodleSite() {
        driver.get(moodle);
        return this;
    }

    public MoodlePage loginToMoodle() {
        if (driver != null) {
            for (char element : userLogin.toCharArray()
            ) {
                new WebDriverWait(driver, Duration.ofSeconds(6));
                waitElementForVisibility(LOGIN_FIELD).sendKeys(Character.toString(element));
            }
            for (char element : userPassword.toCharArray()
            ) {
                new WebDriverWait(driver, Duration.ofSeconds(6));
                waitElementForVisibility(PASSWORD_FIELD).sendKeys(Character.toString(element));
            }
            waitElementForVisibility(LOGIN_BUTTON).click();
        }
        return this;
    }

    public MoodlePage connectToWebinar() {
        driver.navigate().to(moodleWebinar);
        String currentHandle = driver.getWindowHandle();
        waitElementForVisibility(JOIN_WEBINAR).click();
        driver.switchTo().window(currentHandle);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String actual : windowHandles) {
            if (!actual.equalsIgnoreCase(currentHandle)) {
                driver.switchTo().window(actual);
            }
        }
        for (int i = 0; i < 10; i++) {
            waitElementForVisibility(WITHOUT_MICRO).click();
        }
        //waitElementForVisibility(MESSAGE_CHAT).sendKeys("Hello)))");
       // waitElementForVisibility(MESSAGE_CHAT).sendKeys(Keys.ENTER);
        return this;
    }

    public WebElement waitElementForVisibility(By locator) {
        return waiter.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
