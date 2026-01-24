package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.id;

public class MainScreen {
    SelenideElement header = $x("//android.view.View[@content-desc=\"ToDo\"]");
    SelenideElement btnDeny = $(id("com.android.permissioncontroller:id/permission_deny_button"));
    SelenideElement modal = $(id("com.android.permissioncontroller:id/grant_dialog"));

    @Step("Главная страница открыта")
    public MainScreen checkMainPageOpened() {
        header.shouldBe(visible);

        return this;
    }

    @Step("Отказ от показа уведомлений - закрытие окна")
    public MainScreen denyNotifications() {
        modal.shouldBe(visible);
        btnDeny.click();
        modal.shouldNotBe(visible);

        return this;
    }
}