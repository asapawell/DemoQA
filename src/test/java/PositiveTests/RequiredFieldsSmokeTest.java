package PositiveTests;

import org.testng.annotations.Test;
import BeforeTests.*;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class RequiredFieldsSmokeTest extends BeforeTests {
    //отправка обязательных параметров
    @Test
    void sendRequiredFieldsTest() {
        //Указываем имя и фамилию
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
        $x("//option[@value=\"8\"]").click();
        $x("//option[@value=\"1986\"]").click();
        //выберем день с пмомщью селектора
        $("[aria-label*='Choose Thursday, September 18th, 1986']").click();
        //адрес
        $("#currentAddress").setValue("Sovetskaya 28, d35");
        //жмем на отправку
        $("#submit").click();

        //проверяем что модалка появилась
        $(".modal-header").shouldBe(visible);
        //Обращаемся к каждому элементу коллекции и проверяем введенные значения
        //Где не вводились значения, указал просто название строки
        var results = List.of("Pavel Ogorodnikov", "asap@mail.ru", "Male", "1234567890"
                , "18 September,1986", "Subjects", "Hobbies", "Picture", "Sovetskaya 28, d35", "State and City");
        for (int i = 0; i < results.size(); i++) {
            resultLinks.get(i).shouldHave(text(results.get(i)));
        }
    }
}
