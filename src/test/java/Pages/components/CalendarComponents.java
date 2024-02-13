package Pages.components;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class CalendarComponents {
    public void setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        //установим месяц и год через xpath
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        //выберем день с пмомщью селектора
        $(".react-datepicker__day--0" + day
                + ":not(.react-datepicker__day--outside-month)").click();

    }
}
