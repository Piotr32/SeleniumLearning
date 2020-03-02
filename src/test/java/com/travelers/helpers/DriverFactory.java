package com.travelers.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;

public class DriverFactory {

    private static WebDriver driverInstance;

    public static WebDriver getDriver(DriverType driverType) throws NoSuchDriverExepction {

        if (driverInstance == null) {
            getSpecificDriver(driverType);
            driverInstance.manage().window().maximize();
        }
        return driverInstance;
    }

    private static void getSpecificDriver(DriverType driverType) throws NoSuchDriverExepction {

        switch (driverType) {
            case IE: // tylko na windows, IEDriverServer
             /* File driverExe = new File("src//main//resources//executables//drivers//IEDriverServer");
                InternetExplorerDriverService ieService = new InternetExplorerDriverService.Builder()
                        .usingDriverExecutable(driverExe)
                        .usingAnyFreePort().build();
                driverInstance = new InternetExplorerDriverService(ieService);*/
                break;
            case CHROME:
                File chromeExe = new File("src//main//resources//executables//drivers//chromedriver");
                ChromeDriverService chromeService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(chromeExe)
                        .usingAnyFreePort().build();
                driverInstance = new ChromeDriver(chromeService);
                break;
            case FIREFOX:
                File firefoxExe = new File("src//main//resources//executables//drivers//geckodriver");
                GeckoDriverService firefoxService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(firefoxExe)
                        .usingAnyFreePort().build();
                driverInstance = new FirefoxDriver(firefoxService);
                break;
            default:
                System.out.println("Brak drivera danego typu");
                throw new NoSuchDriverExepction();
        }
    }
}

