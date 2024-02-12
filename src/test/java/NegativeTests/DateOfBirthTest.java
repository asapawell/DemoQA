package NegativeTests;

import BeforeTests.BeforeTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class DateOfBirthTest extends BeforeTests {
    @AfterMethod(onlyForGroups = {"refresh"})
    void shouldRefreshPage() {
        refresh();
    }
    //оставляем пустым dateOfBirthInput
    @Test(groups = {"refresh"})
    void sendEmptyDateOfBirthTest() {
        $("#firstName").setValue("Pavel");
        $("#lastName").setValue("Ogorodnikov");
        //Корректно заполняем email
        $("#userEmail").setValue("asap@mail.ru");
        //Кликаем на label Male
        $("label[for='gender-radio-1']").click();
        //телефон
        $("#userNumber").setValue("1234567890");
        //адрес
        $("#currentAddress").setValue("Sovetskaya 28, d35");
        //жмем на отправку
        $("#submit").click();

        //Проверяем что границы поля окрашены в красный цвет
        $("#dateOfBirthInput").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test(priority = 1)
    void sendFutureDateOfBirthTest(){
        $("#firstName").setValue("Pavel");
        $("#lastName").setValue("Ogorodnikov");
        //Корректно заполняем email
        $("#userEmail").setValue("asap@mail.ru");
        //Кликаем на label Male
        $("label[for='gender-radio-1']").click();
        //телефон
        $("#userNumber").setValue("1234567890");
        //нажимаем на инпут даты рождения
        $("#dateOfBirthInput").click();
        //установим месяц и год через xpath
        $("button[aria-label='Next Month']").click();
        $x("//option[@value=\"2100\"]").click();
        //выберем день с пмомщью селектора
        $("[aria-label*='Choose Wednesday, March 31st, 2100']").click();
        //адрес
        $("#currentAddress").setValue("Sovetskaya 28, d35");
        //жмем на отправку
        $("#submit").click();

        //Проверяем что границы поля окрашены в красный цвет
        $("#dateOfBirthInput").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}
