package BeforeTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

abstract public class BeforeTests {
    //Коллекция элементов в модальном окне "Thanks for submitting the form"
    public static final ElementsCollection resultLinks = $$("table.table-dark.table-striped.table-bordered.table-hover tbody tr");

    @BeforeTest
    public void setUp() {
        //ставим таймаут 60 сек, тк на сстранице долго грузятся скрипты
        Configuration.pageLoadTimeout = 60000;
        //разрешение указываем, чтобы селенид нашел кнопку submit
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/automation-practice-form");
    }
}
