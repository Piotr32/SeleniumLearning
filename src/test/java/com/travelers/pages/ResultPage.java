package com.travelers.pages;

import com.travelers.helpers.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultPage {


    @FindBy(xpath = "//table[@class = 'bgwhite table table-striped']")
    private WebElement resultsTable;

    private SeleniumHelper helper;

    public ResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        helper = new SeleniumHelper(driver);
    }

    public List<String> getHotelNames() {
        List<String> hotelNames = new ArrayList<>();
        helper.waitForListOFWebElements(resultsTable.findElements(By.xpath(".//h4//b")));
        List<WebElement> hotelNamesWebElements = resultsTable.findElements(By.xpath(".//h4//b"));
        for(WebElement hotelNameElement : hotelNamesWebElements) {
            System.out.println(hotelNameElement.getText());
            hotelNames.add(hotelNameElement.getText());
        }
        return hotelNames;
    }

    public List<String> getHotelPrices() {
        List<WebElement> hotelPrices = resultsTable.findElements(By.xpath("//div[contains(@class,'price_tab')]//b"));
        List<String> prices = hotelPrices.stream().map(element -> element.getText()).collect(Collectors.toList());
        return prices;
    }
}
