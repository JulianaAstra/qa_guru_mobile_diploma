package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.id;

public class TaskScreen {
    SelenideElement header = $x("//android.view.View[@content-desc=\"ToDo\"]");
    SelenideElement btnDeny = $(id("com.android.permissioncontroller:id/permission_deny_button"));
    SelenideElement modal = $(id("com.android.permissioncontroller:id/grant_dialog"));
    SelenideElement openTaskBtn = $x("//android.widget.Button[1]");
    SelenideElement createTaskBtn = $x("//android.widget.Button[2]");
    SelenideElement addTaskModalHeader = $x("//android.view.View[@content-desc=\"Add Task\"]");
    SelenideElement addTitleInput = $x("//*[contains(@hint, 'Title')]");
    SelenideElement addDescriptionInput = $x("//android.widget.EditText[@hint='Description']");
    SelenideElement saveTaskBtn = $x("//android.widget.Button[@content-desc=\"Save\"]");
    ElementsCollection taskCards = $$x("//android.view.View[@content-desc]");

    @Step("Главная страница открыта")
    public TaskScreen checkMainPageOpened() {
        header.shouldBe(visible);

        return this;
    }

    @Step("Отказ от показа уведомлений - закрытие окна")
    public TaskScreen denyNotifications() {
        modal.shouldBe(visible);
        btnDeny.click();
        modal.shouldNotBe(visible);

        return this;
    }

    @Step("Создать задачу")
    public TaskScreen createTask() {
        createTaskBtn.shouldBe(visible)
                .click();
        addTaskModalHeader.shouldBe(visible);

        return this;
    }

    @Step("Ввести текст заголовка задачи")
    public TaskScreen addTaskTitle(String title) {
        addTitleInput.should(exist, Duration.ofSeconds(15))
                .click();
        addTitleInput.sendKeys(title);

        return this;
    }

    @Step("Ввести текст описания задачи")
    public TaskScreen addTaskDescripition(String description) {
        addDescriptionInput.shouldBe(visible)
                .click();
        addDescriptionInput.sendKeys(description);

        return this;
    }

    @Step("Сохранить задачу")
    public TaskScreen saveTask() {
        saveTaskBtn.shouldBe(visible)
                .click();
        return this;
    }

    @Step("Сохраненная задача отображается в списке")
    public TaskScreen checkSavedTaskDisplays(String expectedValue) {
        taskCards.shouldHave(sizeGreaterThan(0))
                .findBy(attribute("content-desc", expectedValue))
                .shouldBe(visible);

        return this;
    }
}