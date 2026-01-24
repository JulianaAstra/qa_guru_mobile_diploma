package tests.browserstack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

@Tag("browserstack")
public class ToDoTests extends TestBase {
    String taskTitle = testData.randomTaskTitle;
    String taskDescription = testData.randomTaskDescription;

    @Test
    @DisplayName("Редактор создания новой заметки открывается")
    void successfulNewNoteTest() {
        taskScreen.checkMainPageOpened()
                .createTask()
                .addTaskTitle(taskTitle)
                .addTaskDescripition(taskDescription)
                .saveTask()
                .checkSavedTaskDisplays(taskTitle + "\n" + taskDescription);
    }
}