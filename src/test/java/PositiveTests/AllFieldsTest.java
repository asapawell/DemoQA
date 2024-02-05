package PositiveTests;

import com.codeborne.selenide.ElementsCollection;
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
        open("https://demoqa.com/automation-practice-form");
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
        //штат и город
        $x("//div[text()='Select State']/..").setValue("NCR");
        $("#city").setValue("Delhi").pressEnter();
        //отправка
        $("#submit").click();

        //проверяем что модалка появилась
        $(".modal-header").shouldBe(visible);
        //проверяем все значения
        ElementsCollection resultLinks = $$("table.table-dark.table-striped.table-bordered.table-hover tbody tr");
        System.out.println(resultLinks.size());
        List<String> results = List.of("Anna-Nicole Wolfeschlegelsteinhausenbergerdorff Sr.","Treat23@user.com.uk",
                "Female","1796535746","22.01.2012","Maths, English, Economics",
                "Reading","sample-clouds-400x300.jpg",
                "Katip Kasım, Hayriye Tüccarı Cd. 29/B, 34130 Fatih/İstanbul, Турция","State and City",
                "NCR Delhi");
        for (int i = 0; i < results.size(); i++){
            resultLinks.get(i).shouldHave(text(results.get(i)));
        }
    }
}