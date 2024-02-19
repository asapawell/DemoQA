package Pages;

import Pages.components.CalendarComponents;
import Pages.components.StateAndCityComponents;
import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.util.List;

import static Pages.testData.TestData.closeText;
import static Pages.testData.TestData.modalTextHeader;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement emailInput = $("#userEmail");

    //В метод передаем три варианта пола
    public SelenideElement getGenderRadio(String value) {
        return $x("//label[text()='" + value + "']");
    }

    SelenideElement numberInput = $("#userNumber");
    CalendarComponents calendarComponents = new CalendarComponents();
    SelenideElement addressInput = $("#currentAddress");
    SelenideElement subjectContainer = $("#subjectsContainer input");

    public SelenideElement getHobbiesCheckBox(String value) {
        return $x("//label[text()='" + value + "']");
    }

    SelenideElement uploadPictureButton = $("#uploadPicture");
    StateAndCityComponents stateAndCityComponents = new StateAndCityComponents();

    SelenideElement submitButton = $("#submit");
    SelenideElement modalContent = $(".modal-content");
    SelenideElement resultsTable = $(".table-responsive");
    SelenideElement closeButton = $("#closeLargeModal");


    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return new RegistrationPage();
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return new RegistrationPage();
    }

    public RegistrationPage setUserEmail(String value) {
        emailInput.setValue(value);
        return new RegistrationPage();
    }

    public RegistrationPage clickOnGender(String value) {
        getGenderRadio(value).click();
        return new RegistrationPage();
    }

    public RegistrationPage setMobileNumber(String value) {
        numberInput.setValue(value);
        return new RegistrationPage();
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarComponents.setDate(day, month, year);
        return new RegistrationPage();
    }

    public RegistrationPage setSubjects(List<String> values) {
        values.forEach(s -> subjectContainer.setValue(s).pressEnter());
        return new RegistrationPage();
    }

    public RegistrationPage clickOnHobbies(List<String> values) {
        values.forEach(s -> getHobbiesCheckBox(s).click());
        return new RegistrationPage();
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPictureButton.uploadFile(new File(value));
        return new RegistrationPage();
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return new RegistrationPage();
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        stateAndCityComponents.selectStateAndCity(state, city);
        return new RegistrationPage();
    }

    public RegistrationPage setStateAndCity(String state) {
        stateAndCityComponents.selectStateAndCity(state);
        return new RegistrationPage();
    }

    public void clickOnSubmit() {
        submitButton.click();
    }

    public void checkModalContent() {
        modalContent.shouldBe(visible).shouldHave(text(modalTextHeader));
        closeButton.shouldBe(visible).shouldHave(text(closeText));
    }

    public void clickOnClose() {
        closeButton.click();
        modalContent.shouldNotBe(visible);
    }

    public RegistrationPage checkResults(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        return new RegistrationPage();
    }

    public RegistrationPage checkResults(String key, List<String> list) {
        SelenideElement parentElement = resultsTable.$(byText(key)).parent();
        list.forEach(item -> parentElement.shouldHave(text(item)));
        return new RegistrationPage();
    }
}
