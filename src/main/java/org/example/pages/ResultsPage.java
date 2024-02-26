package org.example.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

//ResultPage не расширяет класс BasePage, т.к. не открывается новый урл
public class ResultsPage {
    private final SelenideElement modalContent = $(".modal-content");
    private final SelenideElement resultsTable = $(".table-responsive");
    private final SelenideElement closeButton = $("#closeLargeModal");

    public void checkModalContent() {
        modalContent.shouldBe(visible).shouldHave(text("Thanks for submitting the form"));
        closeButton.shouldBe(visible).shouldHave(text("Close"));
    }

    public void clickOnClose() {
        closeButton.click();
        modalContent.shouldNotBe(visible);
    }

    public ResultsPage checkResults(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public ResultsPage checkResults(String key, List<String> list) {
        SelenideElement parentElement = resultsTable.$(byText(key)).parent();
        list.forEach(item -> parentElement.shouldHave(text(item)));
        return this;
    }
}
