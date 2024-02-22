package PositiveTests;

import baseTest.BaseTest;
import org.testng.annotations.Test;


import static org.example.utils.TestData.*;
import static org.example.AppConfig.baseUrl;

public class CloseButtonTest extends BaseTest {

    @Test
    void clickOnCloseButtonTest() {
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

        //проверка, что появилось модальное окно с заголовком и кнопкой закрыть
        resultsPage
                .checkModalContent();
        //Проверка работы кнопки Close и то, что после закрытия не отображается модальное окно
        resultsPage
                .clickOnClose();
    }
}