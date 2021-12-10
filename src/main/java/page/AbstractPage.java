package page;

import factory.FactoryDriver;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    WebDriver driver = FactoryDriver.getDriver();
    protected final WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(4));
}
