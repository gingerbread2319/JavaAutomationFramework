package com.QAPractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QAPractice.Utils.ElementUtils;


public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    private WebElement FirstNameField;
    @FindBy(id = "lastName")
    private WebElement LastNameField;
    @FindBy(id = "phone")
    private WebElement PhoneNumberField;
    @FindBy(id = "countries_dropdown_menu")
    private WebElement CountryDropdownMenu;
    @FindBy(id = "emailAddress")
    private WebElement EmailAddressField;
    @FindBy(id = "password")
    private WebElement PasswordField;
    @FindBy(id = "exampleCheck1")
    private WebElement TermsAndConditionsCheckbox;
    @FindBy(id = "registerBtn")
    private WebElement RegisterButton;
    @FindBy(id = "resultFn")
    private WebElement FirstNameResultText;
    @FindBy(id = "resultLn")
    private WebElement LastNameResultText;
    @FindBy(id = "resultPhone")
    private WebElement PhoneNumberResultText;
    @FindBy(id = "country")
    private WebElement CountryResultText;
    @FindBy(id = "resultEmail")
    private WebElement EmailAddressResultText;
    @FindBy(id = "message")
    private WebElement RegistrationSuccessMessage;
    @FindBy(xpath = "//div[@class='alert alert-danger' and @id='message']")
    private WebElement RegistrationErrorMessage;
    @FindBy(xpath = "//label[@for='firstName']")
    private WebElement FirstNameLabel;
    @FindBy(xpath = "//label[@for='lastName']")
    private WebElement LastNameLabel;
    @FindBy(id = "lnHelp")
    private WebElement NoteText;
    @FindBy(xpath = "//input[@id='phone']/preceding-sibling::label")
    private WebElement PhoneNumberLabel;
    @FindBy(id = "phoneHelp")
    private WebElement PhoneHelpText;
    @FindBy(xpath = "//select[@id='countries_dropdown_menu']/preceding-sibling::label")
    private WebElement CountryLabel;
    @FindBy(xpath = "//label[@for='exampleInputEmail1']")
    private WebElement EmailAddressLabel;
    @FindBy(xpath = "//label[@for='exampleInputPassword1']")
    private WebElement PasswordLabel;
    @FindBy(xpath = "//label[@for='exampleCheck1']")
    private WebElement TermsAndConditionsLabel;
    @FindBy(id = "pwHelp")
    private WebElement PasswordHelpText;

    ElementUtils elementUtil = new ElementUtils();

    public void inputFirstname(String firstname) {
        FirstNameField.sendKeys(firstname);
    }

    public void inputLastname(String lastname) {
        LastNameField.sendKeys(lastname);
    }

    public void inputPhoneNumber(String phoneNum) {
        PhoneNumberField.sendKeys(phoneNum);
    }

    public void selectCountry(String country) {
        elementUtil.SelectValueFromDropdown(CountryDropdownMenu, country);
    }

    public void inputEmailAddress(String email) {
        EmailAddressField.sendKeys(email);
    }

    public void inputPassword(String password) {
        PasswordField.sendKeys(password);
    }

    public void clickTermsAndConditionsCheckbox() {
        TermsAndConditionsCheckbox.click();
    }

    public boolean termsAndConditionCheckboxIsChecked() {
        return TermsAndConditionsCheckbox.isSelected();
    }

    public void clickRegisterButton() {
        RegisterButton.click();
    }

    public String getFirstNameResultText() {
        return FirstNameResultText.getText();
    }

    public String getLastNameResultText() {
        return LastNameResultText.getText();
    }

    public String getPhoneNumberResultText() {
        return PhoneNumberResultText.getText();
    }

    public String getCountryResultText() {
        return CountryResultText.getText();
    }

    public String getEmailAddressResultText() {
        return EmailAddressResultText.getText();
    }

    public String getRegistrationSuccessMessageText() {
        return RegistrationSuccessMessage.getText();
    }

    public Boolean RegistrationSuccessMessageTextIsDisplayed() {
        return RegistrationSuccessMessage.isDisplayed();
    }

    public Boolean FirstNameResultTextIsDisplayed() {
        return FirstNameResultText.isDisplayed();
    }

    public Boolean LastNameResultTextIsDisplayed() {
        return LastNameResultText.isDisplayed();
    }

    public Boolean PhoneNumberResultTextIsDisplayed() {
        return PhoneNumberResultText.isDisplayed();
    }

    public Boolean EmailAddressResultTextIsDisplayed() {
        return EmailAddressResultText.isDisplayed();
    }

    public String getRegistrationErrorMessageText() {
        return RegistrationErrorMessage.getText();
    }

    public String getFirstNameLabelText() {
        return FirstNameLabel.getText();
    }

    public String getLastNameLabelText() {
        return LastNameLabel.getText();
    }

    public String getNoteText() {
        return NoteText.getText();
    }

    public String getPhoneNumberLabelText() {
        return PhoneNumberLabel.getText();
    }

    public String getPhoneHelpText() {
        return PhoneHelpText.getText();
    }

    public String getCountryLabelText() {
        return CountryLabel.getText();
    }

    public String getEmailAddressLabelText() {
        return EmailAddressLabel.getText();
    }

    public String getPasswordLabelText() {
        return PasswordLabel.getText();
    }

    public String getPasswordHelpText() {
        return PasswordHelpText.getText();
    }

    public String getTermsAndConditionsLabelText() {
        return TermsAndConditionsLabel.getText();
    }

    public String getFirstNamePlaceHolderText() {
        return FirstNameField.getAttribute("placeholder");
    }

    public String getLastNamePlaceHolderText() {
        return LastNameField.getAttribute("placeholder");
    }

    public String getPhoneNumberPlaceHolderText() {
        return PhoneNumberField.getAttribute("placeholder");
    }

    public String getEmailAddressPlaceHolderText() {
        return EmailAddressField.getAttribute("placeholder");
    }

    public String getPasswordPlaceHolderText() {
        return PasswordField.getAttribute("placeholder");
    }

    public String getPasswordInputType() {
        return PasswordField.getAttribute("type");
    }
}
