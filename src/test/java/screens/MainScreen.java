package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class MainScreen {
    SelenideElement searchField = $(accessibilityId("Search Wikipedia"));

    SelenideElement searchInput = $(id("org.wikipedia.alpha:id/search_src_text"));
    ElementsCollection searchResultsList = $$(id("org.wikipedia.alpha:id/page_list_item_title"));
    SelenideElement searchResult = $(id("org.wikipedia.alpha:id/page_list_item_title"));

    ElementsCollection searchResults = $$x("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View");
    SelenideElement firstSearchResult = $x("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View");
    SelenideElement firstSearchResultHead = $x("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.TextView");


    @Step("Reveal search input")
    public MainScreen revealSearchInput() {
        searchField.shouldBe(visible)
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
        searchResults
                .shouldHave(sizeGreaterThan(0));
        return this;
    };

    @Step("Check content found browserstack")
    public MainScreen checkContentFoundBS() {
        searchResultsList
                .shouldHave(sizeGreaterThan(0));
        return this;
    };

    @Step("Check item {item} founded")
    public void checkItemFounded(String item) {
        firstSearchResultHead
                .shouldHave(text(item));
    };

    @Step("Click first result in search results")
    public void clickFirstSearchItem() {
        firstSearchResult.click();
    }

    @Step("Check item {item} founded browserstack")
    public void checkItemFoundedBS(String item) {
        searchResult
                .shouldHave(text(item));
    }
}