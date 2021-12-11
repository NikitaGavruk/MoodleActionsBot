package locators;

import org.openqa.selenium.By;
import page.MoodlePage;

public class MoodlePageLocators extends MoodlePage {
    private static final By LOGIN_FIELD = By.xpath("//input[@id='username']");
    private static final By PASSWORD_FIELD = By.xpath("//input[@id='password']");
    private static final By LOGIN_BUTTON = By.xpath("//button[@id='loginbtn']");
    private static final By JOIN_WEBINAR = By.xpath("//input");
    private static final By WITHOUT_MICRO =
        By.xpath("//button[@class='jumbo--Z12Rgj4 buttonWrapper--x8uow audioBtn--1H6rCK'][2]");
    private static final By MESSAGE_CHAT = By.id("message-input");

    public static By getLoginField() {
        return LOGIN_FIELD;
    }

    public static By getPasswordField() {
        return PASSWORD_FIELD;
    }

    public static By getLoginButton() {
        return LOGIN_BUTTON;
    }

    public static By getJoinWebinar() {
        return JOIN_WEBINAR;
    }

    public static By getWithoutMicro() {
        return WITHOUT_MICRO;
    }

    public static By getMessageChat() {
        return MESSAGE_CHAT;
    }
}
