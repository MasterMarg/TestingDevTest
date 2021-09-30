package ru.mail.sergey_svotin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    /**
     * Constructor to initialize PageFactory for @FindBy usage/Конструктор для инициализации PageFactory
     * для обеспечения работоспособности @FindBy
     */
    public LogInPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Locating field for a username/Определение поля ввода имени пользователя
     */
    @FindBy(xpath = "//*[contains(@id, 'passp-field-login')]")
    private WebElement loginField;


    /**
     * Locating log in button/Определение кнопки входа в систему
     */
    @FindBy(xpath = "//*[contains(@id, 'passp:sign-in')]")
    private WebElement logInButton;

    /**
     * Locating field for a password/Определение поля для ввода пароля
     */
    @FindBy(xpath = "//*[contains(@id, 'passp-field-passwd')]")
    private WebElement passwordField;

    /**
     * This method types a username into a login field/Метож для ввода имени пользователя в соответствующее поле
     * @param username is a String containing username/Строка, содержащая имя пользователя
     */
    public void inputUsername(String username) {
        loginField.sendKeys(username);
    }

    /**
     * This method clicks the log in button/Метод для нажатия кнопки входа в систему
     */
    public void pressLogInButton() {
        logInButton.click();
    }

    /**
     * This method types a password into a proper field/Метод для ввода пароля в соответствующее поле
     * @param password is a String containing password/Строка, содержащая пароль
     */
    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }
}
