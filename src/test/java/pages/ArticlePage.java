package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ArticlePage extends BasePage {
    private final SelenideElement articleTitle = $("h5.card-title");
    private final SelenideElement description = $("textarea.form-control");
    public final SelenideElement downloadInfoButton = $$("button").findBy(text("Download info"));
    private final SelenideElement articleImage = $("#heroImage");
    private final SelenideElement imageSlider = $("div.ui-slider");
    private final SelenideElement sliderControl = $("span.ui-slider-handle");
    private final SelenideElement moveToSavedButton = $$("button").findBy(text("Move to saved"));
    private final SelenideElement removedFromSavedButton = $$("button").findBy(text("Removed from saved"));
    private final SelenideElement avatar = $("#avatar");
    private final SelenideElement advertisersButton = $$("button.tree-main-button").findBy(text("Advertisers"));

    public ArticlePage waitForArticlePageIsDisplayed() {
        articleTitle.waitUntil(visible, 12000);
        downloadInfoButton.shouldBe(visible);
        articleImage.shouldBe(visible);
        imageSlider.scrollTo().shouldBe(visible);
        moveToSavedButton.scrollTo().shouldBe(visible);
        removedFromSavedButton.scrollTo().shouldBe(visible);
        return this;
    }

    public String getArticleTitle() {
        return articleTitle.text();
    }

    public ArticlePage scrollToDescriptionBottom() {
        executeJavaScript("$('textarea.form-control').scrollTop($('textarea.form-control')[0].scrollHeight);");
        return this;
    }

    public ArticlePage clickMoveToSavedButton() {
        moveToSavedButton.click();
        return this;
    }

    public ArticlePage checkMoveToSavedButtonIsDisabled() {
        moveToSavedButton.shouldHave(attribute("disabled", "true"));
        return this;
    }

    public ArticlePage checkMoveToSavedButtonIsActive() {
        moveToSavedButton.shouldNotHave(attribute("disabled"));
        return this;
    }

    public ArticlePage checkImageSizeIsCorrect(String expectedSize) {
        articleImage.shouldHave(attribute("style", expectedSize));
        return this;
    }

    public ArticlePage increaseImageToMaximum() {
        sliderControl.dragAndDropTo(avatar);
        imageSlider.scrollTo();
        return this;
    }

    public ArticlePage decreaseImageToMinimum() {
        sliderControl.dragAndDropTo(advertisersButton);
        imageSlider.scrollTo();
        return this;
    }

}
