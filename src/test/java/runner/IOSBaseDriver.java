package runner;

import io.appium.java_client.ios.IOSDriver;

public class IOSBaseDriver extends BaseDriver {
    public IOSBaseDriver(IOSDriver driver) {
        this.driver = driver;
    }

    @Override
    public void hideKeyboard() {
        ((IOSDriver) driver).hideKeyboard();
    }
}
