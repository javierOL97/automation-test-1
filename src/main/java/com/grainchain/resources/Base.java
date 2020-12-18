package com.grainchain.resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Base {

    protected WebDriver driver;
    protected Properties prop;

    protected Properties getProperties() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + Constants.DATAPROP_PATH);
        prop.load(fis);
        return prop;
    }

    public WebDriver initializeDriver() throws IOException {
        String browserName = getProperties().getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")) {
        System.setProperty("webdriver.chrome driver", Constants.CHROMEDIVER_PATH);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
        return driver;
    }
}
