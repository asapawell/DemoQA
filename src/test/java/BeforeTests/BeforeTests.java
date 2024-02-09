package BeforeTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;

abstract public class BeforeTests {
    //Коллекция элементов в модальном окне "Thanks for submitting the form"
    public static final ElementsCollection resultLinks = $$("table.table-dark.table-striped.table-bordered.table-hover tbody tr");

    @BeforeTest
    public void setUp() {
        Configuration.pageLoadStrategy = "none";
        //разрешение указываем, чтобы селенид нашел кнопку submit
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/automation-practice-form");
        $x("//*[@id='userForm']").shouldBe(visible, ofSeconds(10));
    }

}
