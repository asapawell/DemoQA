package NegativeTests;

import BeforeTests.BeforeTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.*;

public class FirstNameTest extends BeforeTests {
    //устанавливаем логическую переменную для выполнения аннотации AfterTest
    private boolean refreshPage = true;

    @Test()
    void sendEmptyFirstNameTest() {
        //Оставляем поле First Name пустым, остальные обязательные заполняем
        $("#lastName").setValue("TESTTESTST");
        //Корректно заполняем email
        $("#userEmail").setValue("asap@mail.ru");
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
        $("#currentAddress").setValue("Sovetskaya 28, d35");
        //жмем на отправку
        $("#submit").click();

        //Проверяем что границы поля окрашены в красный цвет
        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @AfterMethod()
    void shouldRefreshPage() {
        if (refreshPage)
            refresh();
        refreshPage = false;
    }

    @Test(priority = 1)
    void sendFirstNameDigitsAndSymbolsTest() {
        //проверка невозможности отправки всего кроме букв для поля First Name
        $("#firstName").setValue("122341#46(*&^33");
        $("#lastName").setValue("TEST");
        //Корректно заполняем email
        $("#userEmail").setValue("as3ap@mail.ru");
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
        $("#currentAddress").setValue("Sovetskaya 28, d35");
        //жмем на отправку
        $("#submit").click();

        //Проверяем что границы поля окрашены в красный цвет
        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}
