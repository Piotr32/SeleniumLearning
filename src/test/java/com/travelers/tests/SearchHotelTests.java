package com.travelers.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.travelers.helpers.SeleniumHelper;
import com.travelers.helpers.TestListener;
import com.travelers.pages.HomePage;
import com.travelers.pages.ResultPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

@Listeners(TestListener.class)
public class SearchHotelTests extends BaseSeleniumTest {


    @Test
    public void searchHoteltest() throws IOException {

        ExtentTest test = reports.createTest("Search Hotel Test");
        driver.get("http://www.kurs-selenium.pl/demo/");
        HomePage homePage = new HomePage(driver);

        test.info ("ON PHP Travelers Home Page", getScreenshot());
        homePage.setCityHotel("Dubai")
                .setDateRange("07/11/2019", "09/11/2019")
                .openTravellersModel()
                .addAdult()
                .addChild()
                .addChild();
        test.info ("Before performing search", getScreenshot());
        ResultPage resultPage = homePage.performSearch();


        test.info ("Checking hotel names", getScreenshot());
        List<String> hotelNames = resultPage.getHotelNames();
        Assert.assertEquals("Jumeirah Beach Hotel", hotelNames.get(0));
        Assert.assertEquals("Oasis Beach Tower", hotelNames.get(1));

        test.info ("Checking hotel prices", getScreenshot());
        List<String> prices = resultPage.getHotelPrices();
        Assert.assertEquals("$22", prices.get(0));
        Assert.assertEquals("$50", prices.get(1));
    }

}
