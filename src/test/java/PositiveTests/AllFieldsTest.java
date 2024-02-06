package PositiveTests;

import org.testng.annotations.Test;
import BeforeTests.*;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AllFieldsTest extends BeforeTests {
    //Заполнение всех полей, с различными комбинациями
    @Test
    void sendingAllFields() {
        //Указываем имя и фамилию
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
        //Добавим 3 значения в контейнер предметов, создав список со значениями
        List<String> subjects = List.of("Maths", "English", "Economics");
        subjects.forEach(s -> $("#subjectsContainer input").setValue(s).pressEnter());
        //Проставим все чекбоксы Hobbies
        for (int i = 1; i <= 3; i++) {
            $("label[for='hobbies-checkbox-" + i + "']").click();
        }
        //загрузим картинку
        $("#uploadPicture").uploadFile(new File("src/test/java/sample-clouds-400x300.jpg"));
        //адрес
        $("#currentAddress").setValue("Katip Kasım, Hayriye Tüccarı Cd. 29/B, 34130 Fatih/İstanbul, Турция");
        //Выбираем штат и город из скрытых списков
        $x("//div[text()='Select State']").click();
        $("#react-select-3-option-0").click(); //NCR
        $x("//div[text()='Select City']").click();
        $("#react-select-4-option-1").click(); //Gurgaon
        //отправка
        $("#submit").click();

        //проверяем что модалка появилась
        $(".modal-header").shouldBe(visible);
        //проверяем все значения
        List<String> results = List.of("Anna-Nicole Wolfeschlegelsteinhausenbergerdorff Sr.", "Treat23@user.com.uk",
                "Female", "1796535746", "22.01.2012", "Maths, English, Economics",
                "Reading", "sample-clouds-400x300.jpg",
                "Katip Kasım, Hayriye Tüccarı Cd. 29/B, 34130 Fatih/İstanbul, Турция", "State and City",
                "NCR Gurgaon");
        for (int i = 0; i < results.size(); i++) {
            resultLinks.get(i).shouldHave(text(results.get(i)));
        }
    }
}