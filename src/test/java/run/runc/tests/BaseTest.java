package run.runc.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import run.runc.config.UserDataConfig;
import run.runc.config.WebDriverProvider;
import run.runc.helpers.Attach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    static UserDataConfig userDataConfig = ConfigFactory.create(UserDataConfig.class, System.getProperties());

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("Allure", new AllureSelenide());
        WebDriverProvider.configuration();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.browserCapabilities = capabilities;
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        System.setProperty("chromeoptions.prefs", "intl.accept_languages=ru");
    }

    @AfterEach
    void addAttach() {
        Attach.addVideo();
        Attach.browserConsoleLogs();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();
    }
}
