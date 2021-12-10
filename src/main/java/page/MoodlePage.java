package page;

import factory.FactoryDriver;
import java.time.Duration;
import org.openqa.selenium.By;
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
    String userLogin = PropertiesReader.getUserName();
    String userPassword = PropertiesReader.getPassword();
    String moodle = PropertiesReader.getMoodleLink();
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

    public WebElement waitElementForVisibility(By locator) {
        return waiter.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
