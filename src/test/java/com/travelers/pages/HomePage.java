package com.travelers.pages;


import com.travelers.helpers.SeleniumHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//span[text() = 'Search by Hotel or City Name']")
    private WebElement searchSpan;

    @FindBy(xpath = "//div[@id = 'select2-drop']//input")
    private WebElement searchCityInput;

    @FindBy(name = "checkin")
    private WebElement checkInInput;

    @FindBy(name = "checkout")
    private WebElement checkOutInput;

    @FindBy(id = "travellersInput")
    private WebElement travellersInput;

    @FindBy(id = "adultPlusBtn")
    private WebElement adultPlusBtn;

    @FindBy(id = "childPlusBtn")
    private WebElement childPlusBtn;

    @FindBy(xpath = "//button[text()=' Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='select2-result-label']")
    private WebElement selectResult;

    private SeleniumHelper helper;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new SeleniumHelper(driver);
        this.driver = driver;
    }

    // metoda na dodawanie nazwy miasta w przeglądarce;
    public HomePage setCityHotel(String cityName) {
        searchSpan.click();
        searchCityInput.sendKeys(cityName);
        // zastąpienie thread.sleep - trzeba znalezc elementy na ktory mamy czekac i zastosowac do niego metode z helpera;
        // By locationLabel = By.xpath("//div[@class='select2-result-label']");
        // helper.waitForElementToBeDisplayed(locationLabel);
        helper.waitForElementToBeDisplayed(selectResult);
        searchCityInput.sendKeys(Keys.ENTER);
        return this;
    }

    // metoda na dodawanie daty pobytu w hotelu;
    public HomePage setDateRange(String checkInDate, String checkOutDate) {
        checkInInput.sendKeys(checkInDate);
        checkOutInput.sendKeys(checkOutDate);
        checkOutInput.click();
        return this;
    }

    // metoda dodająca liczbę pasażerów;
    // otwieramy okienkto w którym możemy dodawać rodzica itp;

    public HomePage openTravellersModel() {
        travellersInput.click();
        helper.waitForElementToBeDisplayed(adultPlusBtn);
        return this;
    }
    // metoda dodaje osoby dorosłe (podobnie było by z odejmowaniem);
    public HomePage addAdult() {
        adultPlusBtn.click();
        return this;
    }
    // metoda dodaje dzieci;
    public HomePage addChild() {
        childPlusBtn.click();
        return this;
    }
    // metoda naciska przycisk search;
    public ResultPage performSearch() {
        searchButton.click();
        return new ResultPage(driver);
    }
    }



