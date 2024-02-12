package PositiveTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import BeforeTests.*;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AllFieldsTest extends BeforeTests {
    @AfterMethod(onlyForGroups = {"refresh"})
    void shouldRefreshPage() {
        refresh();
    }

    //Заполнение всех полей, с различными комбинациями
    @Test(groups = {"refresh"})
    void sendAllFieldsTest() {
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
        var subjects = List.of("Maths", "English", "Economics");
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
        var results = List.of("Anna-Nicole Wolfeschlegelsteinhausenbergerdorff Sr.", "Treat23@user.com.uk",
                "Female", "1796535746", "22.01.2012", "Maths, English, Economics",
                "Sports, Reading, Music", "sample-clouds-400x300.jpg",
                "Katip Kasım, Hayriye Tüccarı Cd. 29/B, 34130 Fatih/İstanbul, Турция",
                "NCR Gurgaon");
        for (int i = 0; i < results.size(); i++) {
            resultLinks.get(i).shouldHave(text(results.get(i)));
        }
    }

    @Test(groups = {"refresh"})
    void sendEmptySubjectsAndFullHobbiesTest() {
        //Оставим пустым поле subjects и отметим все чекбоксы hobbies
        $("#firstName").setValue("Anna-Nicole");
        $("#lastName").setValue("Wolfeschlegelsteinhausenbergerdorff Sr.");
        //Заполняем email
        $("#userEmail").setValue("Treat23@user.com.uk");
        //Кликаем на label Other
        $("label[for='gender-radio-3']").click();
        //телефон
        $("#userNumber").setValue("1796535746");
        //Устанавливаем дату
        $("#dateOfBirthInput").click();
        $x("//option[@value=\"8\"]").click();
        $x("//option[@value=\"1986\"]").click();
        $("[aria-label*='Choose Tuesday, September 30th, 1986']").click();
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
        var results = List.of("Anna-Nicole Wolfeschlegelsteinhausenbergerdorff Sr.", "Treat23@user.com.uk",
                "Other", "1796535746", "30 September,1986", "Subjects",
                "Sports, Reading, Music", "sample-clouds-400x300.jpg",
                "Katip Kasım, Hayriye Tüccarı Cd. 29/B, 34130 Fatih/İstanbul, Турция",
                "NCR Gurgaon");
        for (int i = 0; i < results.size(); i++) {
            resultLinks.get(i).shouldHave(text(results.get(i)));
        }
    }

    @Test(priority = 2)
    void sendEmptyCityTest() {
        //Заполняем обязательные поля + State. City оставляем пустым
        $("#firstName").setValue("George Ant");
        $("#lastName").setValue("Expect-Test");
        //Корректно заполняем email
        $("#userEmail").setValue("fdsgfd@mail.ru");
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
        //Выбираем NCR
        $x("//div[text()='Select State']").click();
        $("#react-select-3-option-0").click();//NCR
        //жмем на отправку
        $("#submit").click();

        $(".modal-header").shouldBe(visible);
        //обращаемся к каждому элементу коллекции и проверяем введенные значения
        List<String> results = List.of("George Ant Expect-Test", "fdsgfd@mail.ru", "Male", "1234567890"
                , "18 September,1986", "Subjects", "Hobbies", "Picture", "Sovetskaya 28, d35", "NCR");
        for (int i = 0; i < results.size(); i++) {
            resultLinks.get(i).shouldHave(text(results.get(i)));
        }
    }

}