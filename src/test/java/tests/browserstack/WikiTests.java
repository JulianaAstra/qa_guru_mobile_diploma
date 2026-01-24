package tests.browserstack;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.id;

@Tag("browserstack")
public class WikiTests extends TestBase {

    @Test
    @DisplayName("Редактор создания новой заметки открывается")
    void successfulNewNoteTest() {
        SelenideElement btnDeny = $(id("com.android.permissioncontroller:id/permission_deny_button"));
        SelenideElement modal = $(id("com.android.permissioncontroller:id/grant_dialog"));
        SelenideElement header = $x("//android.view.View[@content-desc=\"ToDo\"]");

//        modal.shouldBe(Condition.visible);
//        btnDeny.click();
        header.shouldBe(Condition.visible);
    }

//    String articleName = "Appium";
//
//    @Test
//    @DisplayName("Article is founded from search")
//    void successfulSearchTest() {
////        back();
//        mainScreen
//                .revealSearchInput()
//                .searchItem(articleName)
//                .checkContentFoundBS()
//                .checkItemFoundedBS(articleName);
//    }

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