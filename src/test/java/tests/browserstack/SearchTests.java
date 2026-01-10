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

    // тест 5
    // статья открывается
    // 1. найти поиском статью - статья есть в списке
    // 2. кликнуть по статье в списке
    // ор: статья открылась
}