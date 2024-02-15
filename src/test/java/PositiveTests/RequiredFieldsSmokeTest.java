package PositiveTests;

import Pages.RegistrationPage;
import org.testng.annotations.Test;
import BeforeTests.*;

import static Pages.testData.TestData.*;

//Тест на отправку обязательных параметров
public class RequiredFieldsSmokeTest extends BeforeTests {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void sendRequiredFieldsTest() {
        registrationPage.setFirstName(validFirstName) //имя
                .setLastName(validLastName) //фамилия
                .setUserEmail(validEmail) //почта
                .clickOnGender(gender) //пол
                .setMobileNumber(mobileNumber) //мобильный номер
                .setDateOfBirth(day, month, year) //год рождения
                .setAddress(address) //адрес
                .clickOnSubmit(); //жмем на кнопку отправки

        //проверка, что появилось модальное окно
        registrationPage.checkModalContent();
        //проверка, что введенные значения корректно отображаются в соответствующих полях
        registrationPage.checkResults("Student Name", validFirstName + " " + validLastName)
                .checkResults("Student Email", validEmail)
                .checkResults("Gender", gender)
                .checkResults("Mobile", mobileNumber)
                .checkResults("Date of Birth", String.format("%s %s,%s", day, month, year))
                .checkResults("Address", address);
    }
}
