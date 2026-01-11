package tests.browserstack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

@Tag("browserstack")
public class SearchTests extends TestBase {
    String articleName = "Appium";

    @Test
    @DisplayName("Article is founded from search")
    void successfulSearchTest() {
        mainScreen
                .revealSearchInput()
                .searchItem(articleName)
                .checkContentFound()
                .checkItemFounded(articleName);
    }

    @Test
    @DisplayName("Article opens from search results")
    void successfuArticleOpenTest() {
        mainScreen
                .revealSearchInput()
                .searchItem(articleName)
                .checkContentFound()
                .clickArticleName(articleName);

        articleScreen.checkArticleByName(articleName);
    }
}