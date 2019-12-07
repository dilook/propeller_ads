package tests.articles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.MainPage;
import tests.Actions;

public class PA023_MoveToSavedButtonIsDisabledUntilScroll extends Actions {

    @BeforeMethod(alwaysRun = true)
    public void preConditions() {
        signInWithCookies();
    }

    @Test(testName = "PA023 Move to Saved button is disabled until scroll")
    public void PA023_MoveToSavedButtonIsDisabledUntilScrollTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickAdvertisersButton()
                .clickFirstArticleButton();

        ArticlePage articlePage = new ArticlePage();
        articlePage.waitForArticlePageIsDisplayed()
                .checkMoveToSavedButtonIsDisabled()
                .scrollToDescriptionBottom()
                .checkMoveToSavedButtonIsActive();
    }
}
