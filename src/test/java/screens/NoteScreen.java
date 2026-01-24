package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class NoteScreen {
    SelenideElement header = $x("//android.view.View[@content-desc=\"Notes\"]");
    SelenideElement openNotesBtn = $x("//android.widget.Button[1]");
    SelenideElement createNoteBtn = $x("//android.widget.Button[2]");
    SelenideElement addNoteModalHeader = $x("//android.view.View[@content-desc=\"Add Note\"]");

    @Step("Открыть экран заметок")
    public NoteScreen openNotesScreen() {
        openNotesBtn.shouldBe(visible)
                .click();
        header.shouldBe(visible);

        return this;
    }

    @Step("Создать заметку")
    public NoteScreen createNote() {
        createNoteBtn.shouldBe(visible)
                .click();
        addNoteModalHeader.shouldBe(visible);

        return this;
    }
}
