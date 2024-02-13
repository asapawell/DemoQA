package PositiveTests;

import Pages.RegistrationPage;
import org.testng.annotations.Test;
import BeforeTests.*;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RequiredFieldsSmokeTest extends BeforeTests {
    //отправка обязательных параметров
    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void sendRequiredFieldsTest() {
        String firstName = "Markus";
        String lastName = "Detroit";
//        String emptyEmail = String.valueOf($x("//td[text()='Student Email']/following-sibling::td").shouldBe(empty));
        //Указываем имя и фамилию
        registrationPage.setFirstNameInput(firstName).setLastNameInput(lastName);
        //Корректно заполняем email
        //$("#userEmail").setValue("asap@mail.ru");
        //Кликаем на label Male
        $("label[for='gender-radio-1']").click();
        //телефон
        $("#userNumber").setValue("1234567890");
        //дата
        registrationPage.setDateOfBirth("30", "June", "1939");
        //адрес
        $("#currentAddress").setValue("Sovetskaya 28, d35");
        //жмем на отправку
        $("#submit").click();

        //проверяем что модалка появилась
        $(".modal-header").shouldBe(visible);
        //Обращаемся к каждому элементу коллекции и проверяем введенные значения
        //Где не вводились значения, указал просто название строки
//        var results = List.of("Pavel Ogorodnikov", "asap@mail.ru", "Male", "1234567890"
//                , "18 September,1986", "Subjects", "Hobbies", "Picture", "Sovetskaya 28, d35", "State and City");
//        for (int i = 0; i < results.size(); i++) {
//            resultLinks.get(i).shouldHave(text(results.get(i)));
//        }
        registrationPage.checkResults("Student Name", firstName + " " + lastName);
                //.checkResults("Student Email", emptyEmail);

        registrationPage.checkEmptyResults("Student Email");
        int a = 4;
    }
}
