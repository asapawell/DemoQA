package Pages;

import Pages.components.CalendarComponents;
import com.codeborne.selenide.SelenideElement;

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
    SelenideElement submitButton = $("#submit");
    SelenideElement modalContent = $(".modal-content");
    SelenideElement resultsTable = $(".table-responsive");


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

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return new RegistrationPage();
    }

    public void clickOnSubmit() {
        submitButton.click();
    }

    public void checkModalContent() {
        modalContent.shouldBe(visible);
    }

    public RegistrationPage checkResults(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        return new RegistrationPage();
    }

}
