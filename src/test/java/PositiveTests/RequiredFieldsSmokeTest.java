package PositiveTests;

import baseTest.BaseTest;
import org.testng.annotations.Test;


import static org.example.AppConfig.baseUrl;
import static org.example.utils.UserBuilder.user;


//Тест на отправку обязательных параметров
public class RequiredFieldsSmokeTest extends BaseTest {

    @Test(alwaysRun = true)
    void sendRequiredFieldsTest() {
        basePage.openPage(baseUrl);

        registrationPage
                .setFirstName(user.getValidFirstName()) //имя
                .setLastName(user.getValidLastName()) //фамилия
                .setUserEmail(user.getValidEmail()) //почта
                .clickOnGender(user.getGender()) //пол
                .setMobileNumber(user.getMobileNumber()) //мобильный номер
                .setDateOfBirth(user.getDay(), user.getMonth(), user.getYear()) //год рождения
                .setAddress(user.getAddress()) //адрес
                .clickOnSubmit(); //жмем на кнопку отправки

        //проверка, что появилось модальное окно
        resultsPage
                .checkModalContent();
        //проверка, что введенные значения корректно отображаются в соответствующих полях
        resultsPage
                .checkResults("Student Name", user.getValidFirstName() + " " + user.getValidLastName())
                .checkResults("Student Email", user.getValidEmail())
                .checkResults("Gender", user.getGender())
                .checkResults("Mobile", user.getMobileNumber())
                .checkResults("Date of Birth", String.format("%s %s,%s", user.getDay(), user.getMonth(), user.getYear()))
                .checkResults("Address", user.getAddress());
    }
}