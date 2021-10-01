package ru.mail.sergey_svotin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    /**
     * Constructor to initialize PageFactory for @FindBy usage/Конструктор для инициализации PageFactory
     * для обеспечения работоспособности @FindBy
     */
    public ProfilePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Locating user's menu pop-up element/Определение кнопки меню пользователя
     */
    @FindBy(className = "user-account")
    private WebElement userMenu;

    /**
     * Locating "Mail" button/Определение кнопки "Почта"
     */
    @FindBy(className = "legouser__menu-item_action_mail")
    private WebElement mailButton;

    /**
     * Locating exit button/Определение кнопки выхода
     */
    @FindBy(className = "legouser__menu-item_action_exit")
    private WebElement exitButton;

    /**
     * This method clicks on a popping-up user's menu/Метод для открытия всплывающего меню пользователя
     */
    public void pressUserMenu() {
        userMenu.click();
    }

    /**
     * This method clicks on a "Mail" button/Метод для нажатия кнопки "Почта"
     */
    public void pressMailButton() {
        mailButton.click();
    }

    /**
     * This method clicks on an "Exit" button/Метод для нажатия кнопки выхода
     */
    public void pressExitButton(){
        exitButton.click();
    }
}
