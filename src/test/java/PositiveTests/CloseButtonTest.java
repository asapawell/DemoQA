package PositiveTests;

import baseTest.BaseTest;
import org.testng.annotations.Test;


import static org.example.AppConfig.baseUrl;
import static org.example.utils.UserBuilder.user;

public class CloseButtonTest extends BaseTest {

    @Test(alwaysRun = true)
    void clickOnCloseButtonTest() {
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

        //проверка, что появилось модальное окно с заголовком и кнопкой закрыть
        resultsPage
                .checkModalContent();
        //Проверка работы кнопки Close и то, что после закрытия не отображается модальное окно
        resultsPage
                .clickOnClose();
    }
}