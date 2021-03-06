package ru.mail.sergey_svotin;

import io.qameta.allure.Description;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LogInTest {
    private static WebDriver webDriver;
    private static LogInPage logInPage;
    private static ProfilePage profilePage;
    private static InboxMailPage inboxMailPage;

    /**
     * Setting up the environment/Первоначальная настройка
     */
    @BeforeClass
    public static void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(OperaOptions.CAPABILITY, new OperaOptions());
        capabilities.setBrowserName("opera");
        webDriver = new RemoteWebDriver(new URL(ConfProperties.getProperty("Node")), capabilities);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.get(ConfProperties.getProperty("LogInPage"));
        logInPage = new LogInPage(webDriver);
        profilePage = new ProfilePage(webDriver);
        inboxMailPage = new InboxMailPage(webDriver);
    }

    /**
     * Test method/Тест
     */
    @Test
    @Description("Testing my abilities")
    public void logIn() {
        logInPage.inputUsername(ConfProperties.getProperty("UserName"));
        logInPage.pressLogInButton();
        logInPage.inputPassword(ConfProperties.getProperty("Password"));
        logInPage.pressLogInButton();
        profilePage.pressUserMenu();
        profilePage.pressMailButton();
       int counter = 0;
        for (WebElement webElement : inboxMailPage.getMessages())
            if (webElement.findElement(By.cssSelector(ConfProperties.getProperty("MailCssSelector"))).getText().
                    equals("Simbirsoft Тестовое задание")) counter++;
        inboxMailPage.pressComposeMailButton();
        inboxMailPage.inputAddress(ConfProperties.getProperty("E-mail"));
        inboxMailPage.inputMailSubject("Simbirsoft Тестовое задание. Свотин");
        inboxMailPage.inputMailText(Integer.toString(counter));
        inboxMailPage.pressSendButton();
    }

    /**
     * Final method for closing a browser/Финальный метод для закрытия браузера
     */
    @AfterClass
    public static void finalizeWork() {
        profilePage.pressUserMenu();
        profilePage.pressExitButton();
        webDriver.quit();
    }
}
