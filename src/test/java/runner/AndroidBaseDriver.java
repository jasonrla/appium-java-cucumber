package runner;

import io.appium.java_client.android.AndroidDriver;

public class AndroidBaseDriver extends BaseDriver {
    public AndroidBaseDriver(AndroidDriver driver) {
        this.driver = driver;
    }

    @Override
    public void hideKeyboard() {
        ((AndroidDriver) driver).hideKeyboard();
    }
}
