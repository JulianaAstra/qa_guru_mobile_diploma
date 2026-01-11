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
    void addAttachments() throws InterruptedException {
        String sessionId = Selenide.sessionId().toString();
        String deviceHost = System.getProperty("deviceHost");

        // 1. Сначала скриншот (самая важная операция)
        try {
            Attach.screenshotAs("Last screenshot");
        } catch (Exception e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }

        // 2. Небольшая пауза
        Thread.sleep(1000);

        // 3. Затем page source
        try {
            Attach.pageSource();
        } catch (Exception e) {
            System.out.println("Page source failed: " + e.getMessage());
        }

        // 4. Закрываем драйвер
        closeWebDriver();

        if ("browserstack".equals(deviceHost)) {
            Attach.addVideo(sessionId);
        }
    }
}