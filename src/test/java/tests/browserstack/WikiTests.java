package tests.browserstack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.back;

@Tag("browserstack")
public class WikiTests extends TestBase {
    String articleName = "Appium";

    @Test
    @DisplayName("Article is founded from search")
    void successfulSearchTest() {
//        back();
        mainScreen
                .revealSearchInput()
                .searchItem(articleName)
                .checkContentFoundBS()
                .checkItemFoundedBS(articleName);
    }

//    @Test
//    @DisplayName("Article opens from search results")
//    void successfulArticleOpenTest() {
//        mainScreen
//                .revealSearchInput()
//                .searchItem(articleName)
//                .checkContentFoundBS()
//                .clickFirstSearchItemBS();
//
//        articleScreen.checkArticleByName(articleName);
//    }
}