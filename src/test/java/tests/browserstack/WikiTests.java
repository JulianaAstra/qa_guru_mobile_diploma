package tests.browserstack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

@Tag("browserstack")
public class WikiTests extends TestBase {
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
    void successfulArticleOpenTest() {
        mainScreen
                .revealSearchInput()
                .searchItem(articleName)
                .checkContentFound()
                .clickFirstSearchItem();

        articleScreen.checkArticleByName(articleName);
    }
}