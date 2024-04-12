package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase extends AbstractTestNGCucumberTests {

    public static AppiumDriver driver;

    public static void Android_setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10"); //10 en CI
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("app",
                System.getProperty("user.dir") + "/apps/ToDo.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities); //sin wd/hub en local
    }

    public void iOS_setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 15 Pro Max");
        capabilities.setCapability("automationName","XCUITest");
        capabilities.setCapability("isHeadless",true);
        capabilities.setCapability("app",
                System.getProperty("user.dir") + "/apps/DailyCheck.zip");
        driver = new IOSDriver<>(new URL("http://localhost:4723/"), capabilities);
    }

    public static void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}