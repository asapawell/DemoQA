package PositiveTests;

import BeforeTests.BeforeTests;
import Pages.RegistrationPage;
import org.testng.annotations.Test;

import static Pages.testData.TestData.*;

public class CloseButtonTest extends BeforeTests {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void clickOnCloseButtonTest() {
        registrationPage.setFirstName(validFirstName) //имя
                .setLastName(validLastName) //фамилия
                .setUserEmail(validEmail) //почта
                .clickOnGender(gender) //пол
                .setMobileNumber(mobileNumber) //мобильный номер
                .setDateOfBirth(day, month, year) //год рождения
                .setAddress(address) //адрес
                .clickOnSubmit(); //жмем на кнопку отправки

        //проверка, что появилось модальное окно с заголовком и кнопкой закрыть
        registrationPage.checkModalContent();
        //Проверка работы кнопки Close и то, что после закрытия не отображается модальное окно
        registrationPage.clickOnClose();
    }
}
