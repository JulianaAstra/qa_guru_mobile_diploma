package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.DriverSelector;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import screens.NoteScreen;
import screens.TaskScreen;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    public TaskScreen taskScreen = new TaskScreen();
    public NoteScreen noteScreen = new NoteScreen();
    public TestData testData = new TestData();

    @BeforeAll
    static void setupConfig() {
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
        } else {
            Attach.pageSource();
            Attach.screenshotAs("Last screenshot");
        }

        closeWebDriver();
    }
}