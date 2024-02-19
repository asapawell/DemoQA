package Pages.components;


import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class StateAndCityComponents {
    //карта ключей и значений state and city
    public static Map<String, List<String>> citiesByState = Map.of(
            "NCR", List.of("Delhi", "Gurgaon", "Noida"),
            "Uttar Pradesh", List.of("Agra", "Lucknow", "Merrut"),
            "Haryana", List.of("Karnal", "Panipat"),
            "Rajasthan", List.of("Jaipur", "Jaiselmer")
    );

    public void selectStateAndCity(String state, String city) {
        $("#state").click();
        $(byText(state)).click();

        $("#city").click();
        $(byText(city)).click();
    }

    public void selectStateAndCity(String state) {
        $("#state").click();
        $(byText(state)).click();
    }
}
