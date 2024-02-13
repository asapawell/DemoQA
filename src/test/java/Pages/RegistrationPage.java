package Pages;

import Pages.components.CalendarComponents;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement resultsTable = $(".table-responsive");
    CalendarComponents calendarComponents = new CalendarComponents();

    public RegistrationPage setFirstNameInput(String value) {
        firstNameInput.setValue(value);
        return new RegistrationPage();
    }

    public RegistrationPage setLastNameInput(String value) {
        lastNameInput.setValue(value);
        return new RegistrationPage();
    }

    public RegistrationPage setDateOfBirth(String day,String month, String year){
        calendarComponents.setDate(day,month,year);
        return new RegistrationPage();
    }

    public RegistrationPage checkResults(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        return new RegistrationPage();
    }

    public RegistrationPage checkEmptyResults(String key){
        resultsTable.$(byText(key)).parent().shouldBe(empty);
        return new RegistrationPage();
    }


}
