package com.QAPractice.Utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class StepHooks {
    public static WebDriver driver;

    BrowserUtils browserUtils = new BrowserUtils();

    @Before
    public void setUp(Scenario scenario) {
        driver = browserUtils.CreateDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        browserUtils.closeDriver(driver);
    }
}
