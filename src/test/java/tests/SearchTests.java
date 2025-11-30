package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screens.MainScreen;

public class SearchTests extends TestBase {
    MainScreen mainScreen = new MainScreen();

    @Test
    @DisplayName("Search ")
    void successfulSearchTest() {
        mainScreen
                .revealSearchInput()
                .searchItem("Appium")
                .checkItemFounded("Appium");
    }
}