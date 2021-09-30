package ru.mail.sergey_svotin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class InboxMailPage {
    /**
     * Constructor to initialize PageFactory for @FindBy usage/Конструктор для инициализации PageFactory
     * для обеспечения работоспособности @FindBy
     */
    public InboxMailPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Locating message entries/Определение писем в ящике
     */
    @FindBy(xpath =" //*[contains(@class, 'ns-view-messages-item-wrap ns-view-id')]" )
    private List<WebElement> messages;

    /**
     * Locating "Compose (mail)" button/ Определение кнопки "Написать/создать (письмо)"
     */
    @FindBy(css = ".mail-ComposeButton.js-main-action-compose")
    private WebElement composeMailButton;

    /**
     * Locating field for an address input/ Определение поля для ввода вдреса
     */
    @FindBy(className = "composeYabbles")
    private WebElement addressField;

    /**
     * Locating field for a subject of mail/Определение поля для ввода темы письма
     */
    @FindBy(css = ".composeTextField.ComposeSubject-TextField")
    private WebElement subjectField;

    /**
     * Locating text field for a text of an e-mail/Определение поля для текста письма
     */
    @FindBy(className = "cke_contents_ltr")
    private WebElement textField;

    /**
     * Locating "Send" button/Определение кнопки "Отправить"
     */
    @FindBy(css = ".Button2.Button2_pin_circle-circle")
    private WebElement sendButton;

    /**
     * This method grants access to a list of entries in mail box/Метод для доступа к списку писем
     * @return a list of entries in message box as WebElements/Список писем в виде WebElement
     */
    public List<WebElement> getMessages(){
        return messages;
    }

    /**
     * This method clicks a "Compose mail" button/Метод для нажатия кнопки "Написать (письмо)"
     */
    public void pressComposeMailButton(){
        composeMailButton.click();
    }

    /**
     * This method inputs an address in address field/Метод для ввода адреса в адресную строку
     * @param address is a String representing an e-mail address/Строка, содержащая адрес почты
     */
    public void inputAddress(String address){
        addressField.sendKeys(address);
    }

    /**
     * This method inputs a subject of a mail/Метод для ввода темы письма
     * @param subject is a String containing mail's subject/Строка, содержащая тему письма
     */
    public void inputMailSubject(String subject){
        subjectField.sendKeys(subject);
    }

    /**
     * This method inputs a text of a mail/Метод для ввода текста письма
     * @param text is a String containing text of a mail/Строка, содержащая текст письма
     */
    public void inputMailText(String text){
        textField.sendKeys(text);
    }

    /**
     * This method clicks "Send" button/Метод для нажатия кнопки "Отправить"
     */
    public void pressSendButton(){
        sendButton.click();
    }
}
