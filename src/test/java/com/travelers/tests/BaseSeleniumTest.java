package com.travelers.tests;

import com.travelers.helpers.DriverFactory;
import com.travelers.helpers.DriverType;
import com.travelers.helpers.NoSuchDriverExepction;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseSeleniumTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp() throws NoSuchDriverExepction {
        System.out.println("Wykonuje się przed testem");
        driver = DriverFactory.getDriver(DriverType.CHROME);
    }

    @AfterTest
    public void tearDown() {
        System.out.println("Wykonuje się po teście");

    }

}
