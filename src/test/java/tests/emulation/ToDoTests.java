package tests.emulation;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.id;

@Tag("emulation")
public class ToDoTests extends TestBase {
    @Test
    @DisplayName("Редактор создания новой заметки открывается")
    void successfulNewNoteTest() {
        mainScreen.denyNotifications()
                  .checkMainPageOpened();
    }
}
