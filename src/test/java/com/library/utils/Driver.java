package com.library.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Driver {
    private Driver() { }

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            //it will make that 2 threads cannot access this piece of code at the same time
            //only 1 thread at the time
            synchronized (Driver.class) {
                String browser = ConfigurationReader.getProperty("browser");
//            jenkins command: test -Dcucumber.filter.tags="@smoke" -Dbrowser="chrome"
//            custom environment variables: -Dbrowser
//            -Dproperty  = then read in java System.getProperty("property")
//            if env variable was specified
                String gridUrlProperties = ConfigurationReader.getProperty("gridUrl");
                if (System.getProperty("browser") != null) {
//                then change browser type
//                regardless on value configuration.properties
                    System.out.println("Browser type was changed to: " + System.getProperty("browser"));
                    browser = System.getProperty("browser");
                }

                switch (browser) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver());
                        break;

                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        break;

                    case "remote-chrome":
                        try {
                            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                            desiredCapabilities.setBrowserName("chrome");
                            URL gridUrl = new URL(gridUrlProperties);
                            driverPool.set(new RemoteWebDriver(gridUrl, desiredCapabilities));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case "remote-firefox":
                        try {
                            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                            desiredCapabilities.setBrowserName("firefox");
                            URL gridUrl = new URL(gridUrlProperties);
                            driverPool.set(new RemoteWebDriver(gridUrl, desiredCapabilities));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    default:
                        throw new RuntimeException("No such a browser yet!");
                }
            }
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
