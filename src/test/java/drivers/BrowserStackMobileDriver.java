package drivers;
import com.codeborne.selenide.WebDriverProvider;
import config.Credentials;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackMobileDriver implements WebDriverProvider {
    public static URL getBrowserstackUrl() {
        try {
//            return new URL(Credentials.url());
            return new URL(Credentials.config.url());
//            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities caps) {

        // Set your access credentials
        caps.setCapability("browserstack.user", Credentials.config.user());
        caps.setCapability("browserstack.key", Credentials.config.password());
//        caps.setCapability("browserstack.user", Credentials.getUserName());
//        caps.setCapability("browserstack.key", Credentials.getPassword());
//        caps.setCapability("browserstack.user", "alex_QZdv0s");
//        caps.setCapability("browserstack.key", "Gq9TBzG8VjEVvKkJdrXh");

        // Set URL of the application under test
        caps.setCapability("app", Credentials.config.app());
//        caps.setCapability("app", Credentials.getApp());
//        caps.setCapability("app", "bs://6a6d2e2661ba89ef50d3993cec86bb94edc32f5c");

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");



        return new AndroidDriver(getBrowserstackUrl(), caps);

    }

}