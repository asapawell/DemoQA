package NegativeTests;

import BeforeTests.BeforeTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class StateAndCityTest extends BeforeTests {
    @AfterMethod(onlyForGroups = {"refresh"})
    void shouldRefreshPage() {
        refresh();
    }

    @Test(groups = {"refresh"})
    void sendInvalidFormatStateTest() {
        $("#firstName").setValue("Anna-Nicole");
        $("#lastName").setValue("Wolfeschlegelsteinhausenbergerdorff Sr.");
        //Заполняем email
        $("#userEmail").setValue("Treat23@user.com.uk");
        //Кликаем на label Female
        $("label[for='gender-radio-2']").click();
        //телефон
        $("#userNumber").setValue("1796535746");
        //Устанавливаем в ручную дату и жмем enter
        $("#dateOfBirthInput").setValue("22.01.2012").pressEnter();
        //адрес
        $("#currentAddress").setValue("Katip Kasım, Hayriye Tüccarı Cd. 29/B, 34130 Fatih/İstanbul, Турция");
        //Пишем несуществующее значение в State
        $("#react-select-3-input").setValue("ffdgs");
        //отправка
        $("#submit").click();

        //проверяем что модалка появилась
        $(".modal-header").shouldBe(visible);
        //проверка что State and City в модалке пустое
        resultLinks.get(9).shouldNotHave(text("ffdgs"));
    }

    @Test(priority = 1)
    void sendInvalidFormatCityTest() {
        $("#firstName").setValue("Anna-Nicole");
        $("#lastName").setValue("Wolfeschlegelsteinhausenbergerdorff Sr.");
        //Заполняем email
        $("#userEmail").setValue("Treat23@user.com.uk");
        //Кликаем на label Female
        $("label[for='gender-radio-2']").click();
        //телефон
        $("#userNumber").setValue("1796535746");
        //Устанавливаем в ручную дату и жмем enter
        $("#dateOfBirthInput").setValue("22.01.2012").pressEnter();
        //адрес
        $("#currentAddress").setValue("Katip Kasım, Hayriye Tüccarı Cd. 29/B, 34130 Fatih/İstanbul, Турция");
        $x("//div[text()='Select State']").click();
        $("#react-select-3-option-0").click(); //NCR
        //Пишем несуществующее значение в City
        $("#react-select-4-input").setValue("test");
        //отправка
        $("#submit").click();

        //проверяем что модалка появилась
        $(".modal-header").shouldBe(visible);
        //проверка что State and City в модалке пустое
        resultLinks.get(9).shouldNotHave(text("test"));
    }
}
