package com.QAPractice.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementUtils {
    public void SelectValueFromDropdown(WebElement dropdownElement, String value) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(value);
    }

    public void Wait(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    public void scrollToBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
}
