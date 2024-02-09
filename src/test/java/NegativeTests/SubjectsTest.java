package NegativeTests;

import BeforeTests.BeforeTests;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SubjectsTest extends BeforeTests {
    @Test
    void sendInvalidFormatTest() {
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
        //Отправим несуществующий предмет
        $("#subjectsContainer input").setValue("random");
        $("#currentAddress").setValue("Sovetskaya 28, d35");
        $("#submit").click();

        //проверяем что модалка появилась
        $(".modal-header").shouldBe(visible);
        //проверка что subjects в модалке пустое
        resultLinks.get(5).shouldNotHave(text("random"));

    }
}
