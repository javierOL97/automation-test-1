package com.grainchain.pageobjects;

import com.grainchain.exceptions.PageNotLoaded;
import com.grainchain.resources.ShowsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends ShowsMethods {

    public SearchPage(WebDriver driver) throws PageNotLoaded {
        super(driver);
        isPageLoaded(PageElements.SEARCH_TEXTBOX.getLocator());
    }

    public void populateTextField(String text) {
        isElementPresent(PageElements.SEARCH_TEXTBOX.getLocator()).sendKeys(text);
    }
    public void eraseTextField(){
        isElementPresent(PageElements.SEARCH_TEXTBOX.getLocator()).clear();
    }
    public void clickOnSearchButton() {
        isElementClickable(PageElements.SEARCH_BUTTON.getLocator()).click();
    }




    private enum PageElements{
        SEARCH_TEXTBOX(By.xpath("//input[@class='validate' and @placeholder='Search']")),
        SEARCH_BUTTON(By.xpath("//button[@class='btn waves-effect waves-light' and @type='submit']"));

        private final By by;
        PageElements(By by) {
            this.by = by;
        }
        public By getLocator() {
            return(by);
        }
    }

}
