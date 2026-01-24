package tests.browserstack;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

@Tag("browserstack")
@Feature("Создание заметок")
@DisplayName("Тесты на создание задач и заметок")
public class ToDoTests extends TestBase {
    @Test
    @DisplayName("Редактор создания новой задачи открывается")
    void successfulNewTaskTest() {
        taskScreen.denyNotifications()
                .checkMainPageOpened()
                .createTask();
    }

    @Test
    @DisplayName("Редактор создания новой заметки открывается")
    void successfulNewNoteTest() {
        taskScreen.denyNotifications()
                .checkMainPageOpened();
        noteScreen.openNotesScreen()
                .createNote();
    }
}