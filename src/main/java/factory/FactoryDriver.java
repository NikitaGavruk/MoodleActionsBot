package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FactoryDriver {

    public static WebDriver driver;


    public FactoryDriver() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.media_stream_mic", 2);
            prefs.put("profile.default_content_setting_values.media_stream_camera", 2);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }
}

