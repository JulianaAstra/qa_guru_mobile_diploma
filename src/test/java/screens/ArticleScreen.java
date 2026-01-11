package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class ArticleScreen {
    SelenideElement article = $(id("pcs"));
    // добавить элементы для модалок и закрытие

    @Step("Check article by name")
    public ArticleScreen checkArticleByName(String articleName) {
        article
                .shouldBe(visible)
                .shouldHave(text(articleName));
        return this;
    }

    @Step("Close modal window")
    public ArticleScreen closeModal() {
        return this;
    }
}