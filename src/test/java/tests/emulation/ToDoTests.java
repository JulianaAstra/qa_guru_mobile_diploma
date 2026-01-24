package tests.emulation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

@Tag("emulation")
public class ToDoTests extends TestBase {
    String taskTitle = testData.randomTaskTitle;
    String taskDescription = testData.randomTaskDescription;
    String noteTitle = testData.randomNoteTitle;

    @Test
    @DisplayName("Редактор создания новой задачи открывается")
    void successfulOpenTaskTest() {
        taskScreen.denyNotifications()
                .checkMainPageOpened()
                .createTask();
    }

    @Test
    @DisplayName("Новая задача добавляется")
    void successfulNewTaskAddTest() {
        taskScreen.denyNotifications()
                .checkMainPageOpened()
                .createTask()
                .addTaskTitle(taskTitle)
                .addTaskDescripition(taskDescription)
                .saveTask()
                .checkSavedTaskDisplays(taskTitle + "\n" + taskDescription);
    }

    @Test
    @DisplayName("Редактор создания новой заметки открывается")
    void successfulNewNoteTest() {
        taskScreen.denyNotifications()
                .checkMainPageOpened();
        noteScreen.openNotesScreen()
                .createNote();
    }

    @Test
    @DisplayName("Новая заметка добавляется")
    void successfulNewNoteAddTest() {
        taskScreen.denyNotifications()
                .checkMainPageOpened();
        noteScreen.openNotesScreen()
                .createNote()
                .addNoteTitle(noteTitle)
                .saveNote()
                .checkSavedNoteDisplays(noteTitle);
    }
}
