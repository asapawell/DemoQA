package PositiveTests;

import Pages.RegistrationPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import BeforeTests.*;

import static Pages.testData.TestData.*;
import static com.codeborne.selenide.Selenide.*;

//Заполнение всех полей, с различными комбинациями
public class AllFieldsTest extends BeforeTests {
    //Заполним все поля
    RegistrationPage registrationPage = new RegistrationPage();

    @AfterMethod(onlyForGroups = {"refresh"})
    void shouldRefreshPage() {
        refresh();
    }

    @Test(groups = {"refresh"})
    void sendAllFieldsTest() {
        registrationPage.setFirstName(validFirstName) //имя
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
        registrationPage.checkModalContent();
        //проверка, что введенные значения корректно отображаются в соответствующих полях
        registrationPage.checkResults("Student Name", validFirstName + " " + validLastName)
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

    @Test(priority = 2)
    void sendEmptyCityTest() {
        //Поле city пустое
        registrationPage.setFirstName(validFirstName) //имя
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
        registrationPage.checkModalContent();
        //проверка, что введенные значения корректно отображаются в соответствующих полях
        registrationPage.checkResults("Student Name", validFirstName + " " + validLastName)
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
