package com.QAPractice.Utils;

import com.QAPractice.Enums.DriverTypes;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BrowserUtils {
    public WebDriver driver;
    public static PropertyUtils propertyUtils;

    public WebDriver CreateDriver() {
        DriverTypes driverType = DriverTypes.valueOf(propertyUtils.getConfigProperty("BROWSER").toUpperCase());
        switch (driverType)
        {
            case CHROME:
                String path = propertyUtils.getConfigProperty("CHROMEDRIVERPATH");
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + path);
                driver = new ChromeDriver(chromeOptions());
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                break;
            case FIREFOX:
                // FIREFOX RELATED DRIVER CODE
                break;
            case EDGE:
                // EDGE RELATED DRIVER CODE
                break;
            default:
        }

        return driver;
    }

    public void closeDriver(WebDriver driver) {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    private static ChromeOptions chromeOptions() {
        ChromeOptions opts = new ChromeOptions();
        opts.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        opts.addArguments("--window-size=" + propertyUtils.getConfigProperty("WINDOW_SIZE"));
        opts.addArguments("--disable-gpu", "--no-sandbox");
        return opts;
    }
}
