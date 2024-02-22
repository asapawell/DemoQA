package org.example.pages;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static java.time.Duration.ofSeconds;

public class BasePage {
    SelenideElement userForm = $x("//*[@id='userForm']");

    public void openPage(String pageURL) {
        Configuration.pageLoadStrategy = "none";
        Configuration.browserSize = "1920x1080";
        open(pageURL);
        userForm.shouldBe(visible, ofSeconds(10));
    }
}
