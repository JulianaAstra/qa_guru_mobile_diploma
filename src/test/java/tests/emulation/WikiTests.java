package tests.emulation;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.ArticleScreen;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;
import static io.appium.java_client.AppiumBy.id;

@Tag("emulation")
public class WikiTests extends TestBase {
//    public ArticleScreen articleScreen = new ArticleScreen();
//    String articleName = "Appium";

//    @Test
//    @DisplayName("Article is founded from search")
//    void successfulSearchTest() {
//        back();
//        mainScreen
//                .revealSearchInput()
//                .searchItem(articleName)
//                .checkContentFound()
//                .checkItemFounded(articleName);
//    }

//    @Test
//    @DisplayName("Article opens from search results")
//    void successfulArticleOpenTest() {
//        back();
//        mainScreen
//                .revealSearchInput()
//                .searchItem(articleName)
//                .checkContentFound()
//                .clickFirstSearchItem();
//
//        articleScreen.closeModal() // todo написать метод
//                // убрать увед, чтобы получить доступ к элементам на странице "got it"
//                .checkArticleByName(articleName);
//    }

    @Test
    @DisplayName("Редактор создания новой заметки открывается")
    void successfulNewNoteTest() {
        SelenideElement btnDeny = $(id("com.android.permissioncontroller:id/permission_deny_button"));
        SelenideElement modal = $(id("com.android.permissioncontroller:id/grant_dialog"));
        SelenideElement header = $(id("//android.view.View[@content-desc=\"ToDo\"]"));

        modal.shouldBe(Condition.visible);
        btnDeny.click();
        header.shouldBe(Condition.visible);
    }


    // тест 2
    // скипнуть стартовый экран
    // ор: открывается главная страница

    // тест 3
    // пролистать вперед все 4 стартовых экрана
    // ор: экраны переключаются последовательно, в конце стартовая страница

    // Тест 4
    // сохранить статью
    // 1. найти и открыть статью
    // 2. нажать "сохранить" - тост "статья сохранена"
    // 3. перейти на главный экран
    // 4. открыть сохранения
    // ор: в списке есть сохраненная статья
}
