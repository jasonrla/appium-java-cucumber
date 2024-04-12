package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {

    public static AppiumDriver driver;

    public static void Android_setUp() throws MalformedURLException {

        String apiLevel = System.getProperty("api.level");
        System.out.printf("API Level: %s\n", apiLevel);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", getPlatformVersionFromApiLevel(apiLevel)); //28:9 , 29:10 en CI
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("app",
                System.getProperty("user.dir") + "/apps/ToDo.apk");
        capabilities.setCapability("unicodeKeyboard", true); // Deshabilita el teclado Unicode
        capabilities.setCapability("resetKeyboard", true);
        driver = new AndroidDriver(new URL("http://localhost:4723/"), capabilities); //sin wd/hub en local
    }

    public static void iOS_setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 15 Pro Max");
        capabilities.setCapability("automationName","XCUITest");
        capabilities.setCapability("isHeadless",true);
        capabilities.setCapability("app",
                System.getProperty("user.dir") + "/apps/DailyCheck.zip");
        driver = new IOSDriver(new URL("http://localhost:4723/"), capabilities);
    }

    public static String getPlatformVersionFromApiLevel(String apiLevel) {
        switch (apiLevel) {
            case "21":
                return "5.0";
            case "22":
                return "5.1";
            case "23":
                return "6.0";
            case "24":
                return "7.0";
            case "25":
                return "7.1";
            case "26":
                return "8.0";
            case "27":
                return "8.1";
            case "28":
                return "9.0";
            case "29":
                return "10.0";
            case "30":
                return "11.0";
            case "31":
                return "12.0";
            case "32":
                return "12L";
            case "33":
                return "13.0";
            case "34":
                return "14.0";
            case "35":
                return "15.0";
            default:
                throw new IllegalArgumentException("API Level " + apiLevel + " is not supported");
        }
    }

    public static void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}