package com.grainchain.pageobjects;

import com.grainchain.exceptions.PageNotLoaded;
import com.grainchain.resources.Constants;
import com.grainchain.resources.ShowsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultsPage extends ShowsMethods {
    private final WebDriver driver;

    public ResultsPage(WebDriver driver) throws PageNotLoaded {
        super(driver);
        this.driver = driver;
        isPageLoaded(PageElements.HEADER.getLocator());
    }

    public void clickOnSecondCardURL() {
        isElementClickable(PageElements.SECOND_CARD_URL.getLocator()).click();
    }

    public void clickOnBackButton() {
        isElementClickable(PageElements.BACK_BUTTON.getLocator()).click();
    }

    public void changeCardColorToPurple(){
        WebElement element = isElementClickable(PageElements.BATMAN_UNLIMITED_CHART.getLocator());
        String colorChangeScript = "arguments[0].setAttribute('style', 'background-color: "
                + Constants.PURPLE_COLOR +"');";

        JavascriptExecutor jsEx = (JavascriptExecutor) driver;
        jsEx.executeScript("arguments[0].scrollIntoView(true);", element);
        jsEx.executeScript(colorChangeScript, element);
    }

    private enum PageElements{
        HEADER(By.xpath("//h2[contains(text(),'Search results')]")),
        SECOND_CARD_URL(By.xpath("//div[@class='row'][2]//a[contains(text(),'URL')]")),
        BATMAN_UNLIMITED_CHART(By.xpath("//span[contains(text(),'Batman Unlimited')]//parent::div")),
        BACK_BUTTON(By.xpath("//a[@class='btn btn-primary' and @href='/shows']"));

        private final By by;
        PageElements(By by) {
            this.by = by;
        }
        public By getLocator() {
            return(by);
        }
    }

}
