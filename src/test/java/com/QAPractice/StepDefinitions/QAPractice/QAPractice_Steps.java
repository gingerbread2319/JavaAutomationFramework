package com.QAPractice.StepDefinitions.QAPractice;

import com.QAPractice.Pages.RegistrationPage;
import com.QAPractice.Utils.ElementUtils;
import com.QAPractice.Utils.PropertyUtils;
import com.QAPractice.Utils.StepHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class QAPractice_Steps {

    WebDriver driver = StepHooks.driver;
    RegistrationPage registrationPage = new RegistrationPage(driver);
    ElementUtils elementUtil = new ElementUtils();

    @Given("I navigate to QA Practice home page URL")
    public void INavigateToQAPracticeURL()  {
        driver.get(PropertyUtils.getConfigProperty("HOMEPAGE_URL"));
    }

    @When("^I input \"(.*)\" in the firstname field")
    public void IInputValueInFirstNameField(String firstname) {
        registrationPage.inputFirstname(firstname);
    }

    @When("^I input \"(.*)\" in the lastname field")
    public void IInputValueInLastNameField(String lastname) {
        registrationPage.inputLastname(lastname);
    }

    @When("^I input \"(.*)\" in the phone number field")
    public void IInputValueInPhoneNumberField(String phoneNum) {
        registrationPage.inputPhoneNumber(phoneNum);
    }

    @When("^I select \"(.*)\" in the country dropdown")
    public void ISelectAValueInCountryDropdown(String country) {
        registrationPage.selectCountry(country);
    }

    @When("^I input \"(.*)\" in the email address field")
    public void IInputValueInEmailAddressField(String email) {
        registrationPage.inputEmailAddress(email);
    }

    @When("^I input \"(.*)\" in the password field")
    public void IInputValueInPasswordField(String password) {
        registrationPage.inputPassword(password);
    }

    @When("^I tick the terms and conditions checkbox")
    public void ITickTheTermsAndConditionsCheckbox() {
        registrationPage.clickTermsAndConditionsCheckbox();
    }

    @Then("^I verify that terms and conditions checkbox is checked")
    public void IVerifyThatTheTermsAndConditionsCheckboxIsChecked() {
        Assert.assertTrue("The Terms and Conditions checkbox should be checked.", registrationPage.termsAndConditionCheckboxIsChecked());
    }

    @When("^I click the Register button")
    public void IClickTheRegisterButton() {
        registrationPage.clickRegisterButton();
    }

    @Then("^I verify that the firstname result value is \"(.*)\"")
    public void IVerifyThatFirstNameResultValueIs(String firstname) {
        String firstnameResult = registrationPage.getFirstNameResultText();
        assertTrue("The firstname result value should contain " + firstname + ". Actual: " + firstnameResult, firstnameResult.contains(firstname));
    }

    @Then("^I verify that the lastname result value is \"(.*)\"")
    public void IVerifyThatLastNameResultValueIs(String lastname) {
        String lastnameResult = registrationPage.getLastNameResultText();
        assertTrue("The lastname result value should contain " + lastname + ". Actual: " + lastnameResult, lastnameResult.contains(lastname));
    }

    @Then("^I verify that the phone number result value is \"(.*)\"")
    public void IVerifyThatPhoneNumberResultValueIs(String phoneNum) {
        String phoneNumResult = registrationPage.getPhoneNumberResultText();
        assertTrue("The phone number result value should contain " + phoneNum + ". Actual: " + phoneNumResult, phoneNumResult.contains(phoneNum));
    }

    @Then("^I verify that the country result value is \"(.*)\"")
    public void IVerifyThatCountryResultValueIs(String country) {
        String countryResult = registrationPage.getCountryResultText();
        assertTrue("The country result value should contain " + country +  ". Actual: " + countryResult, countryResult.equals("Country: " + country));
    }

    @Then("^I verify that the email address result value is \"(.*)\"")
    public void IVerifyThatEmailAddressResultValueIs(String email) {
        String emailAddressResult = registrationPage.getEmailAddressResultText();
        assertTrue("The email address result value should contain " + email + ". Actual: " + emailAddressResult, emailAddressResult.contains(email));
    }

    @Then("^I verify that the success message is \"(.*)\"")
    public void IVerifyThatTheSuccessMessageIs(String message) {
        assertTrue("The success message value should be: " + message, registrationPage.getRegistrationSuccessMessageText().contains(message));
    }

    @When("^I scroll to the bottom of the page")
    public void IScrollAtTheBottomOfThePage() {
        elementUtil.scrollToBottom(driver);
    }

    @Then("^I verify that the success message is not displayed")
    public void IVerifyThatTheSuccessMessageIsNotDisplayed() {
        assertFalse("The success message should not be displayed", registrationPage.RegistrationSuccessMessageTextIsDisplayed());
    }

    @Then("^I verify that the first name result text is not displayed")
    public void IVerifyThatTheFirstNameResultTextIsNotDisplayed() {
        assertFalse("The first name result text should not be displayed. Found: " + registrationPage.FirstNameResultTextIsDisplayed(), registrationPage.FirstNameResultTextIsDisplayed());
    }

    @Then("^I verify that the last name result text is not displayed")
    public void IVerifyThatTheLastNameResultTextIsNotDisplayed() {
        assertFalse("The last name result text should not be displayed. Found: " + registrationPage.LastNameResultTextIsDisplayed(), registrationPage.LastNameResultTextIsDisplayed());
    }

    @Then("^I verify that the phone number result text is not displayed")
    public void IVerifyThatThePhoneNumberResultTextIsNotDisplayed() {
        assertFalse("The phone number result text should not be displayed. Found: " + registrationPage.PhoneNumberResultTextIsDisplayed(), registrationPage.PhoneNumberResultTextIsDisplayed());
    }

    @Then("^I verify that the email address result text is not displayed")
    public void IVerifyThatTheEmailAddressResultTextIsNotDisplayed() {
        assertFalse("The email address result text should not be displayed. Found: " + registrationPage.EmailAddressResultTextIsDisplayed(), registrationPage.EmailAddressResultTextIsDisplayed());
    }

    @Then("^I verify that the error message is \"(.*)\"")
    public void IVerifyThatTheErrorMessageIs(String message) {
        assertTrue("The error message value should be: " + message, registrationPage.getRegistrationErrorMessageText().equals(message));
    }

    @Then("^I verify that the first name label text is \"(.*)\"")
    public void IVerifyThatFirstNameLabelIs(String expectedFirstNameLabel) {
        String firstNameLabelText = registrationPage.getFirstNameLabelText();
        assertEquals("The first name label should be: " + expectedFirstNameLabel, expectedFirstNameLabel, firstNameLabelText);
    }

    @Then("^I verify that the last name label text is \"(.*)\"")
    public void IVerifyThatLastNameLabelIs(String expectedLastNameLabel) {
        String lastNameLabelText = registrationPage.getLastNameLabelText();
        assertEquals("The last name label should be: " + expectedLastNameLabel, expectedLastNameLabel, lastNameLabelText);
    }

    @Then("^I verify that the phone number label text is \"(.*)\"")
    public void IVerifyThatPhoneNumberLabelIs(String expectedPhoneNumberLabel) {
        String phoneNumberLabelText = registrationPage.getPhoneNumberLabelText();
        assertEquals("The phone number label should be: " + expectedPhoneNumberLabel, expectedPhoneNumberLabel, phoneNumberLabelText);
    }

    @Then("^I verify that the country label text is \"(.*)\"")
    public void IVerifyThatCountryLabelIs(String expectedCountryLabel) {
        String countryLabelText = registrationPage.getCountryLabelText();
        assertEquals("The country label should be: " + expectedCountryLabel, expectedCountryLabel, countryLabelText);
    }

    @Then("^I verify that the email address label text is \"(.*)\"")
    public void IVerifyThatEmailAddressLabelIs(String expectedEmailAddressLabel) {
        String emailLabelText = registrationPage.getEmailAddressLabelText();
        assertEquals("The email address label should be: " + expectedEmailAddressLabel, expectedEmailAddressLabel, emailLabelText);
    }

    @Then("^I verify that the password label text is \"(.*)\"")
    public void IVerifyThatPasswordLabelIs(String expectedPasswordLabel) {
        String passwordLabelText = registrationPage.getPasswordLabelText();
        assertEquals("The password label should be: " + expectedPasswordLabel, expectedPasswordLabel, passwordLabelText);
    }

    @Then("^I verify that the terms and conditions label text is \"(.*)\"")
    public void IVerifyThatTermsAndConditionsLabelIs(String expectedTCLabel) {
        String tCLabelText = registrationPage.getTermsAndConditionsLabelText();
        assertEquals("The terms and conditions label should be: " + expectedTCLabel, expectedTCLabel, tCLabelText);
    }

    @Then("^I verify that the note help text is \"(.*)\"")
    public void IVerifyThatNoteHelpTextIs(String expectedNoteHelpText) {
        String noteHelpText = registrationPage.getNoteText();
        assertEquals("The note help text should be: " + expectedNoteHelpText, expectedNoteHelpText, noteHelpText);
    }

    @Then("^I verify that the phone help text is \"(.*)\"")
    public void IVerifyThatPhoneHelpTextIs(String expectedPhoneHelpText) {
        String phoneHelpText = registrationPage.getPhoneHelpText();
        assertEquals("The phone help text should be: " + expectedPhoneHelpText, expectedPhoneHelpText, phoneHelpText);
    }

    @Then("^I verify that the password help text is \"(.*)\"")
    public void IVerifyThatPasswordHelpTextIs(String expectedPasswordHelpText) {
        String passwordHelpText = registrationPage.getPasswordHelpText();
        assertEquals("The phone help text should be: " + expectedPasswordHelpText, expectedPasswordHelpText, passwordHelpText);
    }

    @Then("^I verify that the first name placeholder text is \"(.*)\"")
    public void IVerifyThatFirstNamePlaceHolderIs(String expectedFirstNamePlaceHolder) {
        String firstNamePlaceHolderText = registrationPage.getFirstNamePlaceHolderText();
        assertEquals("The first name placeholder should be: " + expectedFirstNamePlaceHolder, expectedFirstNamePlaceHolder, firstNamePlaceHolderText);
    }

    @Then("^I verify that the last name placeholder text is \"(.*)\"")
    public void IVerifyThatLastNamePlaceHolderIs(String expectedLastNamePlaceHolder) {
        String lastNamePlaceHolderText = registrationPage.getLastNamePlaceHolderText();
        assertEquals("The last name placeholder should be: " + expectedLastNamePlaceHolder, expectedLastNamePlaceHolder, lastNamePlaceHolderText);
    }

    @Then("^I verify that the phone number placeholder text is \"(.*)\"")
    public void IVerifyThatPhoneNumberPlaceHolderIs(String expectedPhoneNumberPlaceHolder) {
        String phoneNumberPlaceHolderText = registrationPage.getPhoneNumberPlaceHolderText();
        assertEquals("The phone number placeholder should be: " + expectedPhoneNumberPlaceHolder, expectedPhoneNumberPlaceHolder, phoneNumberPlaceHolderText);
    }

    @Then("^I verify that the email address placeholder text is \"(.*)\"")
    public void IVerifyThatEmailAddressPlaceHolderIs(String expectedEmailAddressPlaceHolder) {
        String emailPlaceHolderText = registrationPage.getEmailAddressPlaceHolderText();
        assertEquals("The email address placeholder should be: " + expectedEmailAddressPlaceHolder, expectedEmailAddressPlaceHolder, emailPlaceHolderText);
    }

    @Then("^I verify that the password placeholder text is \"(.*)\"")
    public void IVerifyThatPasswordPlaceHolderIs(String expectedPasswordPlaceHolder) {
        String passwordPlaceHolderText = registrationPage.getPasswordPlaceHolderText();
        assertEquals("The password placeholder should be: " + expectedPasswordPlaceHolder, expectedPasswordPlaceHolder, passwordPlaceHolderText);
    }

    @Then("^I verify that the password field masks its value")
    public void IVerifyThatPasswordFieldMasksItsValue() {
        String passwordInputType = registrationPage.getPasswordInputType().toLowerCase();
        assertEquals("The password input type should be: password", "password", passwordInputType);
    }
}
