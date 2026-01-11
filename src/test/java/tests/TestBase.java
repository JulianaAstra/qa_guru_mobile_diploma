package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.DriverSelector;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import screens.ArticleScreen;
import screens.MainScreen;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    public MainScreen mainScreen = new MainScreen();
    public ArticleScreen articleScreen = new ArticleScreen();

    @BeforeAll
    static void setupConfig() {
//        Configuration.browser = BrowserstackDriver.class.getName();
        Configuration.browser = DriverSelector.getDriver();
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void addAllureListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        String deviceHost = System.getProperty("deviceHost");

        if ("browserstack".equals(deviceHost)) {
            Attach.addVideo(sessionId);
        }
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();
    }
}