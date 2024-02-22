package PositiveTests;

import baseTest.BaseTest;
import org.testng.annotations.Test;


import static org.example.AppConfig.baseUrl;
import static org.example.utils.TestData.*;


//Тест на отправку обязательных параметров
public class RequiredFieldsSmokeTest extends BaseTest {

    @Test
    void sendRequiredFieldsTest() {
        basePage.openPage(baseUrl);

        registrationPage
                .setFirstName(validFirstName) //имя
                .setLastName(validLastName) //фамилия
                .setUserEmail(validEmail) //почта
                .clickOnGender(gender) //пол
                .setMobileNumber(mobileNumber) //мобильный номер
                .setDateOfBirth(day, month, year) //год рождения
                .setAddress(address) //адрес
                .clickOnSubmit(); //жмем на кнопку отправки

        //проверка, что появилось модальное окно
        resultsPage
                .checkModalContent();
        //проверка, что введенные значения корректно отображаются в соответствующих полях
        resultsPage
                .checkResults("Student Name", validFirstName + " " + validLastName)
                .checkResults("Student Email", validEmail)
                .checkResults("Gender", gender)
                .checkResults("Mobile", mobileNumber)
                .checkResults("Date of Birth", String.format("%s %s,%s", day, month, year))
                .checkResults("Address", address);
    }
}