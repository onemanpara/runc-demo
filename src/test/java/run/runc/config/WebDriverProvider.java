package run.runc.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverProvider {

    static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public static void configuration() {

        Configuration.browser = config.browser();
        Configuration.browserSize = config.browserSize();
        Configuration.baseUrl = config.baseUrl();
        String configSource = config.remoteAddress();
        if (configSource != null) {
            Configuration.remote = config.baseUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            Configuration.browserCapabilities = capabilities;
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }
    }

}
