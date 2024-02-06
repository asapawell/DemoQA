package NegativeTests;

import BeforeTests.BeforeTests;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FirstNameTest extends BeforeTests {
    @Test()
    void emptyFirstNameTest() {
        //Оставляем поле Last Name пустым, остальные обязательные заполняем
        $("#firstName").setValue("TESTTESTST");
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
        $("#lastName").shouldHave(cssValue("border-color","rgb(220, 53, 69)"));
    }
    @Test(priority = 1)
    void digitsAndSymbolsTest(){
        //проверка невозможности отправки всего кроме букв для поля Last Name
        $("#firstName").setValue("TEST");
        $("#lastName").setValue("122341#46(*&^33");
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
        $("#lastName").shouldHave(cssValue("border-color","rgb(220, 53, 69)"));
    }
}
