package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screens.ArticleScreen;
import screens.MainScreen;

public class SearchTests extends TestBase {
    MainScreen mainScreen = new MainScreen();
    String articleName = "Appium";

    @Test
    @DisplayName("Article is founded from search")
    void successfulSearchTest() {
        mainScreen
                .revealSearchInput()
                .searchItem(articleName)
                .checkItemFounded(articleName);
    }
}