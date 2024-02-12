package PositiveTests;

import BeforeTests.BeforeTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ClearFieldsTest extends BeforeTests {
    @AfterMethod(onlyForGroups = {"refresh"})
    void shouldRefresh() {
        refresh();
    }

    @Test(groups = {"refresh"})
    void clearEveryFieldTest() {
        //введем в каждое поле значение, затем очистим
        $("#firstName").setValue("Anna-Nicole").clear();
        $("#lastName").setValue("Wolfeschlegelsteinhausenbergerdorff Sr.").clear();
        //Заполняем email
        $("#userEmail").setValue("Treat23@user.com.uk").clear();
        $("#dateOfBirthInput").sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE);
        $("#submit").click();

        //Кликаем на label Female
//        $("label[for='gender-radio-2']").click();
//        //телефон
//        $("#userNumber").setValue("1796535746").clear();
//        //Устанавливаем в ручную дату и жмем enter
//        $("#dateOfBirthInput").click();
//        //установим месяц и год через xpath
//        $x("//option[@value=\"8\"]").click();
//        $x("//option[@value=\"1986\"]").click();
//        //выберем день с пмомщью селектора
//        $("[aria-label*='Choose Thursday, September 18th, 1986']").click();
//        $("#dateOfBirthInput").clear();
//        //Добавим 3 значения в контейнер предметов, создав список со значениями
//        List<String> subjects = List.of("Maths", "English", "Economics");
//        subjects.forEach(s -> $("#subjectsContainer input").setValue(s).pressEnter());
//        $("#subjectsContainer input").clear();
//        //Проставим все чекбоксы Hobbies
//        for (int i = 1; i <= 3; i++) {
//            $("label[for='hobbies-checkbox-" + i + "']").click();
//        }
//        //загрузим картинку
//        $("#uploadPicture").uploadFile(new File("src/test/java/sample-clouds-400x300.jpg"));
//        //адрес
//        $("#currentAddress").setValue("Katip Kasım, Hayriye Tüccarı Cd. 29/B, 34130 Fatih/İstanbul, Турция");
//        //Выбираем штат и город из скрытых списков
//        $x("//div[text()='Select State']").click();
//        $("#react-select-3-option-0").click(); //NCR
//        $x("//div[text()='Select City']").click();
//        $("#react-select-4-option-1").click(); //Gurgaon
    }

    @Test
    void testOfTest() {
        $("#firstName").setValue("Anna-Nicole");
        $("#submit").click();
    }
}
