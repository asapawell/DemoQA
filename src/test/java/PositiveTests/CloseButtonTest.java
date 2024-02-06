package PositiveTests;

import BeforeTests.BeforeTests;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CloseButtonTest extends BeforeTests {
    @Test
    void clickOnCloseButtonTest() {
        $("#firstName").setValue("Sam");
        $("#lastName").setValue("Smith-Efron");
        //Корректно заполняем email
        $("#userEmail").setValue("asa424p@mail.ru.com");
        //Кликаем на label Male
        $("label[for='gender-radio-1']").click();
        //телефон
        $("#userNumber").setValue("1234567890");
        //нажимаем на инпут даты рождения
        $("#dateOfBirthInput").click();
        //установим месяц и год через xpath
        $x("//option[@value=\"8\"]").click();
        $x("//option[@value=\"1986\"]").click();
        //выберем день с пмомщью селектора
        $("[aria-label*='Choose Thursday, September 18th, 1986']").click();
        //адрес
        $("#currentAddress").setValue("Drive avenue 28, h.1200");
        //жмем на отправку
        $("#submit").click();

        //Проверка наличия Заголовка
        $(".modal-header").shouldBe(visible).shouldHave(text("Thanks for submitting the form"));
        //Проверка наличия кнопки Close
        $("#closeLargeModal").shouldBe(visible).shouldHave(text("Close"));
        //Проверка работы кнопки Close
        $("#closeLargeModal").click();
        $(".modal-header").shouldNotBe(visible);
        //Проверка, что после нажатия на close, значения в поля формы очищены
        var emptyCSSElements = List.of("#firstName", "#lastName", "#userEmail", "label[for='gender-radio-1']",
                "#userNumber", "#dateOfBirthInput", "#currentAddress");
        //Будет ошибка, из-за того что #dateOfBirthInput предзаполнено, но по идее оно должно иметь плейсхолдер.
        //Считаю поведение багом
        emptyCSSElements.forEach(e -> {
            if (e.contains("label[for='gender-radio-1']")) {
                $(e).shouldNotBe(selected);
            } else
                $(e).shouldBe(empty);
        });
    }
}
