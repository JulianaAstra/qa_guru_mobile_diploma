package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class NoteScreen {
    SelenideElement header = $x("//android.view.View[@content-desc=\"Notes\"]");
    SelenideElement openNotesBtn = $x("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button[1]");
    SelenideElement createNoteBtn = $x("//android.widget.Button[2]");
    SelenideElement addNoteModalHeader = $x("//android.view.View[@content-desc=\"Add Note\"]");
    SelenideElement addTitleInput = $x("//*[contains(@hint, 'Title')]");
    SelenideElement saveNoteBtn = $x("//android.widget.Button[@content-desc=\"Save\"]");
    ElementsCollection noteCards = $$x("//android.view.View[@content-desc]");

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

    @Step("Ввести текст заголовка заметки")
    public NoteScreen addNoteTitle(String title) {
        addTitleInput.should(exist, Duration.ofSeconds(15))
                .click();
        addTitleInput.sendKeys(title);

        return this;
    }

    @Step("Сохранить заметку")
    public NoteScreen saveNote() {
        saveNoteBtn.shouldBe(visible)
                .click();
        return this;
    }

    @Step("Сохраненная задача отображается в списке")
    public NoteScreen checkSavedNoteDisplays(String expectedValue) {
        noteCards.shouldHave(sizeGreaterThan(0))
                .findBy(attribute("content-desc", expectedValue))
                .shouldBe(visible);

        return this;
    }
}
