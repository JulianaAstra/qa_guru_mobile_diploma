package tests.emulation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.ArticleScreen;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.back;

@Tag("emulation")
public class WikiTests extends TestBase {
    public ArticleScreen articleScreen = new ArticleScreen();
    String articleName = "Appium";

    @Test
    @DisplayName("Article is founded from search")
    void successfulSearchTest() {
        back();
        mainScreen
                .revealSearchInput()
                .searchItem(articleName)
                .checkContentFound()
                .checkItemFounded(articleName);
    }

    @Test
    @DisplayName("Article opens from search results")
    void successfulArticleOpenTest() {
        back();
        mainScreen
                .revealSearchInput()
                .searchItem(articleName)
                .checkContentFound()
                .clickFirstSearchItem();

        articleScreen.closeModal() // todo написать метод
                .checkArticleByName(articleName);
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
