package PositiveTests;

import baseTest.BaseTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.example.utils.TestData.*;
import static com.codeborne.selenide.Selenide.*;
import static org.example.AppConfig.baseUrl;

//Заполнение всех полей, с различными комбинациями
public class AllFieldsTest extends BaseTest {
    //Заполним все поля
    @AfterMethod(onlyForGroups = {"refresh"},alwaysRun = true)
    void shouldRefreshPage() {
        refresh();
    }

    @Test(groups = {"refresh"},alwaysRun = true)
    void sendAllFieldsTest() {
        basePage.openPage(baseUrl);

        registrationPage
                .setFirstName(validFirstName) //имя
                .setLastName(validLastName) //фамилия
                .setUserEmail(validEmail) //почта
                .clickOnGender(gender) //пол
                .setMobileNumber(mobileNumber) //мобильный номер
                .setDateOfBirth(day, month, year) //год рождения
                .setSubjects(subjects) //предметы, рандомное количество от 1 до 5
                .clickOnHobbies(hobbies) //проставим хобби
                .uploadPicture(pathToPicture)//загрузим картинку
                .setAddress(address) //адрес
                .setStateAndCity(state, city) //штат и город
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
                .checkResults("Subjects", subjects)
                .checkResults("Hobbies", hobbies)
                .checkResults("Picture", picture)
                .checkResults("State and City", String.format("%s %s", state, city))
                .checkResults("Address", address);
    }

    @Test(priority = 2,alwaysRun = true)
    void sendEmptyCityTest() {
        basePage.openPage(baseUrl);
        //Поле city пустое
        registrationPage
                .setFirstName(validFirstName) //имя
                .setLastName(validLastName) //фамилия
                .setUserEmail(validEmail) //почта
                .clickOnGender(gender) //пол
                .setMobileNumber(mobileNumber) //мобильный номер
                .setDateOfBirth(day, month, year) //год рождения
                .setSubjects(subjects) //предметы, рандомное количество от 1 до 5
                .clickOnHobbies(hobbies) //проставим хобби
                .uploadPicture(pathToPicture)//загрузим картинку
                .setAddress(address) //адрес
                .setStateAndCity(state) //штат
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
                .checkResults("Subjects", subjects)
                .checkResults("Hobbies", hobbies)
                .checkResults("Picture", picture)
                .checkResults("State and City", state)
                .checkResults("Address", address);
    }
}