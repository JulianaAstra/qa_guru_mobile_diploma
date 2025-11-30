package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class MainScreen {
    SelenideElement searchField = $(accessibilityId("Search Wikipedia"));
    SelenideElement searchInput = $(id("org.wikipedia.alpha:id/search_src_text"));
    ElementsCollection searchResultsList = $$(id("org.wikipedia.alpha:id/page_list_item_title"));
    SelenideElement searchResult = $(id("org.wikipedia.alpha:id/page_list_item_title"));

    @Step("Reveal search input")
    public MainScreen revealSearchInput() {
        searchField
                .click();
        return this;
    }

    @Step("Search item {item}")
    public MainScreen searchItem(String item) {
        searchInput
                .sendKeys(item);
        return this;
    };

    @Step("Check content found")
    public MainScreen checkContentFound() {
        searchResultsList
                .shouldHave(sizeGreaterThan(0));
        return this;
    };

    @Step("Check item {item} founded")
    public void checkItemFounded(String item) {
        searchResult
                .shouldHave(text(item));
    };
}