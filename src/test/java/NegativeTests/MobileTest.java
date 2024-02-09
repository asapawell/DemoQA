package NegativeTests;

import BeforeTests.BeforeTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class MobileTest extends BeforeTests {
    //устанавливаем логическую переменную для выполнения аннотации AfterTest
    private boolean refreshPage = true;

    @Test
    void sendEmptyMobileTest() {
        //оставляем поле userNumber пустым, остальные заполняем
        $("#firstName").setValue("Marcus");
        $("#lastName").setValue("Beckham");
        $("#userEmail").setValue("mecks@tr.ri");
        $("label[for='gender-radio-1']").click();
        $("#dateOfBirthInput").click();
        $x("//option[@value=\"8\"]").click();
        $x("//option[@value=\"1986\"]").click();
        $("[aria-label*='Choose Thursday, September 18th, 1986']").click();
        $("#currentAddress").setValue("Sovetskaya 28, d35");
        $("#submit").click();

        //Проверяем что границы поля окрашены в красный цвет
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @AfterMethod()
    void shouldRefreshPage() {
        if (refreshPage)
            refresh();
        refreshPage = false;
    }

    @Test(priority = 1)
    void sendInvalidMobileTest() {
        //отправляем невалидный формат мобильного номера
        $("#firstName").setValue("Marcus");
        $("#lastName").setValue("Beckham");
        $("#userEmail").setValue("mecks@tr.ri");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("+7$1134553)");
        $("#dateOfBirthInput").click();
        $x("//option[@value=\"8\"]").click();
        $x("//option[@value=\"1986\"]").click();
        $("[aria-label*='Choose Thursday, September 18th, 1986']").click();
        $("#currentAddress").setValue("Sovetskaya 28, d35");
        $("#submit").click();

        //Проверяем что границы поля окрашены в красный цвет
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}
