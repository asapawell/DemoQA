package org.example.pages;

import com.codeborne.selenide.SelenideElement;

import org.example.utils.components.CalendarComponents;
import org.example.utils.components.StateAndCityComponents;

import java.io.File;
import java.util.List;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class RegistrationPage extends BasePage {
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement numberInput = $("#userNumber");
    private final CalendarComponents calendarComponents = new CalendarComponents();
    private final SelenideElement addressInput = $("#currentAddress");
    private final SelenideElement subjectContainer = $("#subjectsContainer input");
    private final SelenideElement uploadPictureButton = $("#uploadPicture");
    private final StateAndCityComponents stateAndCityComponents = new StateAndCityComponents();
    private final SelenideElement submitButton = $("#submit");

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    //В метод передаем три варианта пола
    public SelenideElement getGenderRadio(String value) {
        return $x("//label[text()='" + value + "']");
    }

    public RegistrationPage clickOnGender(String value) {
        getGenderRadio(value).click();
        return this;
    }

    public RegistrationPage setMobileNumber(String value) {
        numberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarComponents.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(List<String> values) {
        values.forEach(s -> subjectContainer.setValue(s).pressEnter());
        return this;
    }

    //передаем значения чекбоксов
    public SelenideElement getHobbiesCheckBox(String value) {
        return $x("//label[text()='" + value + "']");
    }

    public RegistrationPage clickOnHobbies(List<String> values) {
        values.forEach(s -> getHobbiesCheckBox(s).click());
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPictureButton.uploadFile(new File(value));
        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        stateAndCityComponents.selectStateAndCity(state, city);
        return this;
    }

    public void clickOnSubmit() {
        submitButton.click();
    }

}
