package com.travelers.tests;

import com.travelers.helpers.TestListener;
import com.travelers.pages.HomePage;
import com.travelers.pages.ResultPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(TestListener.class)
public class SearchHotelTests extends BaseSeleniumTest {


    @Test
    public void searchHoteltest() {
        driver.get("http://www.kurs-selenium.pl/demo/");
        HomePage homePage = new HomePage(driver);
        ResultPage resultPage = homePage
                .setCityHotel("Dubai")
                .setDateRange("07/11/2019", "09/11/2019")
                .openTravellersModel()
                .addAdult()
                .addChild()
                .addChild()
                .performSearch();

        List<String> hotelNames = resultPage.getHotelNames();
        Assert.assertEquals("Jumeirah Beach Hotel", hotelNames.get(0));
        Assert.assertEquals("Oasis Beach Tower", hotelNames.get(1));

        List<String> prices = resultPage.getHotelPrices();
        Assert.assertEquals("$22", prices.get(0));
        Assert.assertEquals("$50", prices.get(1));
    }
}
