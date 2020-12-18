package com.grainchain.resources;

import com.grainchain.exceptions.PageNotLoaded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ShowsMethods extends Base{
    protected WebDriver driver;
    private final WebDriverWait wait4;

    public ShowsMethods(WebDriver driver) {
        this.driver = driver;
        this.wait4 = new WebDriverWait(driver, 10);
    }

    protected boolean isPageLoaded(By locator) throws PageNotLoaded {
        try{
        WebDriverWait pageWait = new WebDriverWait(driver,15);
        pageWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
        catch (Exception e) {
            throw new PageNotLoaded();
        }
        return true;
    }
    protected WebElement isElementClickable(By locator) {
        return wait4.until(ExpectedConditions.elementToBeClickable(locator));
    }
    protected WebElement isElementPresent(By locator) {
        return wait4.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    protected WebElement convertToWebElement(By locator) {
        return driver.findElement(locator);
    }

}
