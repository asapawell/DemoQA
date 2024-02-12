package NegativeTests;

import BeforeTests.BeforeTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.*;

public class EmailTest extends BeforeTests {
    @AfterMethod(onlyForGroups = {"refresh"})
    void shouldRefreshPage() {
        refresh();
    }

    @Test(groups = {"refresh"})
    void sendEmptyEmailTest() {
        //Оставляем поле Email пустым
        $("#firstName").setValue("TESTTESTST");
        $("#lastName").setValue("Beckham");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $x("//option[@value=\"8\"]").click();
        $x("//option[@value=\"1986\"]").click();
        $("[aria-label*='Choose Thursday, September 18th, 1986']").click();
        $("#currentAddress").setValue("Sovetskaya 28, d35");
        $("#submit").click();

        //Проверяем что границы поля окрашены в красный цвет
        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test(priority = 1)
    void sendInvalidFormatEmailTest() {
        var options = List.of("@asapmail.ru", "aa@asapmail.ru.", "you.ru", "name@example", "frosya 33@mail.ru");
        options.forEach(option -> {
            $("#firstName").setValue("TESTTESTST");
            $("#lastName").setValue("TESTTESTST");
            $("#userEmail").setValue(option);
            $("label[for='gender-radio-1']").click();
            $("#userNumber").setValue("1234567890");
            $("#dateOfBirthInput").click();
            $x("//option[@value=\"8\"]").click();
            $x("//option[@value=\"1986\"]").click();
            $("[aria-label*='Choose Thursday, September 18th, 1986']").click();
            $("#currentAddress").setValue("Sovetskaya 28, d35");
            $("#submit").click();
            //Проверяем что границы поля окрашены в красный цвет
            $("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        });
    }
}
