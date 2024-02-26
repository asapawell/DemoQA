package org.example.utils.components;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class StateAndCityComponents {
    public void selectStateAndCity(String state, String city) {
        $("#state").click();
        $(byText(state)).click();

        $("#city").click();
        $(byText(city)).click();
    }
}
