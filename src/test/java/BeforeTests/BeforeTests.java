package BeforeTests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;

abstract public class BeforeTests {
    @BeforeTest
    public void setUp() {
        //ставим таймаут 60 сек, тк на сстранице долго грузятся скрипты
        Configuration.pageLoadTimeout = 60000;
        //разрешение указываем, чтобы селенид нашел кнопку submit
        Configuration.browserSize = "1920x1080";
    }
}
