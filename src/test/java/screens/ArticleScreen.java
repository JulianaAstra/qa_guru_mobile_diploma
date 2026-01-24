package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class ArticleScreen {
    SelenideElement article = $(id("pcs"));
    SelenideElement closeModalBtn = $(id("org.wikipedia.alpha:id/closeButton"));
    SelenideElement modalWindow = $(id("org.wikipedia.alpha:id/dialogContainer"));

    @Step("Check article by name")
    public ArticleScreen checkArticleByName(String articleName) {
        article
                .shouldBe(visible)
                .shouldHave(text(articleName));
        return this;
    }

    @Step("Close modal window")
    public ArticleScreen closeModal() {
        modalWindow.shouldBe(visible);
        closeModalBtn.shouldBe(visible)
                .click();
        modalWindow.shouldNotBe(visible);

        return this;
    }
}