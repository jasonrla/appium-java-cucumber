package runner;

import io.appium.java_client.AppiumDriver;

public abstract class BaseDriver {
    protected AppiumDriver driver;

    public abstract void hideKeyboard();

    public AppiumDriver getDriver() {
        return driver;
    }
}
