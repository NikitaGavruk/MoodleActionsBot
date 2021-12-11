package page;

import java.util.Set;
import locators.MoodlePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:database.properties")
public class MoodlePage extends AbstractPage {

    public MoodlePage getMoodleSite() {
        driver.get(moodle);
        return this;
    }

    public MoodlePage loginToMoodle() {
        if (driver != null) {
            waitElementForVisibility(MoodlePageLocators.getLoginField()).sendKeys(userLogin);
            waitElementForVisibility(MoodlePageLocators.getPasswordField()).sendKeys(userPassword);
            waitElementForVisibility(MoodlePageLocators.getLoginButton()).click();
        }
        return this;
    }

    public MoodlePage connectToWebinar() {
        driver.navigate().to(moodleWebinar);
        String currentHandle = driver.getWindowHandle();
        waitElementForVisibility(MoodlePageLocators.getJoinWebinar()).click();
        driver.switchTo().window(currentHandle);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String actual : windowHandles) {
            if (!actual.equalsIgnoreCase(currentHandle)) {
                driver.switchTo().window(actual);
            }
        }
        for (int i = 0; i < 10; i++) {
            waitElementForVisibility(MoodlePageLocators.getWithoutMicro()).click();
        }
        return this;
    }

    public MoodlePage sendMessage(String message) {
        waitElementForVisibility(MoodlePageLocators.getMessageChat()).sendKeys(message);
        waitElementForVisibility(MoodlePageLocators.getMessageChat()).sendKeys(Keys.ENTER);
        return this;
    }

    public WebElement waitElementForVisibility(By locator) {
        return waiter.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
