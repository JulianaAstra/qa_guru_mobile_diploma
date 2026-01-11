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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import screens.ArticleScreen;
import screens.MainScreen;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

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

        System.out.println("=== START TEST TEARDOWN ===");

        try {
            // 1. Получаем информацию о драйвере
            WebDriver driver = getWebDriver();
            System.out.println("Driver: " + driver);
            System.out.println("Session ID: " + ((RemoteWebDriver) driver).getSessionId());

            // 2. Пытаемся получить скриншот с подробным логированием
            System.out.println("--- Attempting screenshot ---");
            Attach.screenshotAs("Last screenshot");

            // 3. Получаем page source
            System.out.println("--- Getting page source ---");
            Attach.pageSource();

        } catch (Exception e) {
            System.out.println("ERROR in teardown: " + e.getMessage());
        }

        // 4. Закрываем драйвер
        System.out.println("--- Closing driver ---");
        closeWebDriver();

        if ("browserstack".equals(deviceHost)) {
            Attach.addVideo(sessionId);
        }

        System.out.println("=== END TEST TEARDOWN ===");
    }
}