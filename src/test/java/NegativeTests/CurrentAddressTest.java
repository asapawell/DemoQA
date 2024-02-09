package NegativeTests;

import BeforeTests.BeforeTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.*;

public class CurrentAddressTest extends BeforeTests {
    //устанавливаем логическую переменную для выполнения аннотации AfterTest
    private boolean refreshPage = true;
    @Test
    void sendEmptyCurrentAddressTest(){
        //оставляем поле currentAddress пустым, остальные заполняем
        $("#firstName").setValue("Marcus");
        $("#lastName").setValue("Beckham");
        $("#userEmail").setValue("mecks@tr.ri");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("1796535746");;
        $("#dateOfBirthInput").click();
        $x("//option[@value=\"8\"]").click();
        $x("//option[@value=\"1986\"]").click();
        $("[aria-label*='Choose Thursday, September 18th, 1986']").click();
        $("#submit").click();

        //Проверяем что границы поля окрашены в красный цвет
        $("#currentAddress").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
    @AfterMethod()
    void shouldRefreshPage() {
        if (refreshPage)
            refresh();
        refreshPage = false;
    }
    @Test(priority = 1)
    void sendInvalidFormatTest(){
        //отправляем невалидные символы в поле currentAddress
        $("#firstName").setValue("Marcus");
        $("#lastName").setValue("Beckham");
        $("#userEmail").setValue("mecks@tr.ri");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("1796535746");;
        $("#dateOfBirthInput").click();
        $x("//option[@value=\"8\"]").click();
        $x("//option[@value=\"1986\"]").click();
        $("[aria-label*='Choose Thursday, September 18th, 1986']").click();
        $("#currentAddress").setValue("@!$&()*%");
        $("#submit").click();

        //Проверяем что границы поля окрашены в красный цвет
        $("#currentAddress").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

}
