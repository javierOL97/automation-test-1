package com.grainchain.test;

import com.grainchain.exceptions.PageNotLoaded;
import com.grainchain.pageobjects.ResultsPage;
import com.grainchain.pageobjects.SearchPage;
import com.grainchain.resources.Base;
import com.grainchain.resources.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class SeleniumTest extends Base{
    private  WebDriver driver;

    @BeforeTest
    public void basePageNav() throws IOException {
        driver=initializeDriver();
        driver.get(Constants.URL);
    }

    @Test
    public void test() throws PageNotLoaded, InterruptedException {
        SearchPage sp = new SearchPage(driver);
        sp.populateTextField(Constants.BATMAN);
        sp.clickOnSearchButton();

        ResultsPage rp = new ResultsPage(driver);
        rp.clickOnSecondCardURL();

        driver.navigate().back();

        //Sleeps are just to visualize the color changes
        rp.changeCardColorToPurple();
        Thread.sleep(2000);
        rp.clickOnBackButton();

        sp.eraseTextField();
        Thread.sleep(2000);
    }

    @AfterTest
    public void after() {
        driver.quit();
    }

}
