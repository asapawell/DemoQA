package PositiveTests;

import baseTest.BaseTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.example.AppConfig.baseUrl;
import static org.example.utils.UserBuilder.user;

//Заполнение всех полей, с различными комбинациями
public class AllFieldsTest extends BaseTest {
    //Заполним все поля
    @AfterMethod(onlyForGroups = {"refresh"}, alwaysRun = true)
    void shouldRefreshPage() {
        refresh();
    }

    @Test(groups = {"refresh"}, alwaysRun = true)
    void sendAllFieldsTest() {
        basePage.openPage(baseUrl);

        registrationPage
                .setFirstName(user.getValidFirstName()) //имя
                .setLastName(user.getValidLastName()) //фамилия
                .setUserEmail(user.getValidEmail()) //почта
                .clickOnGender(user.getGender()) //пол
                .setMobileNumber(user.getMobileNumber()) //мобильный номер
                .setDateOfBirth(user.getDay(), user.getMonth(), user.getYear()) //год рождения
                .setSubjects(user.getSubjects()) //предметы, рандомное количество от 1 до 5
                .clickOnHobbies(user.getHobbies()) //проставим хобби
                .uploadPicture(user.getPathToPicture())//загрузим картинку
                .setAddress(user.getAddress()) //адрес
                .setStateAndCity(user.getState(), user.getCity()) //штат и город
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
                .checkResults("Subjects", user.getSubjects())
                .checkResults("Hobbies", user.getHobbies())
                .checkResults("Picture", user.getPicture())
                .checkResults("State and City", String.format("%s %s", user.getState(), user.getCity()))
                .checkResults("Address", user.getAddress());
    }

    @Test(priority = 2, alwaysRun = true)
    void sendSomeEmptyFieldsTest() {
        basePage.openPage(baseUrl);
        //Поле city пустое
        registrationPage
                .setFirstName(user.getValidFirstName()) //имя
                .setLastName(user.getValidLastName()) //фамилия
                .setUserEmail(user.getValidEmail()) //почта
                .clickOnGender(user.getGender()) //пол
                .setMobileNumber(user.getMobileNumber()) //мобильный номер
                .setDateOfBirth(user.getDay(), user.getMonth(), user.getYear()) //год рождения
                .clickOnHobbies(user.getHobbies()) //проставим хобби
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
                .checkResults("Hobbies", user.getHobbies())
                .checkResults("Address", user.getAddress());
    }
}