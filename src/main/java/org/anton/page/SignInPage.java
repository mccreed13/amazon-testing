package org.anton.page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SignInPage extends BasePage {
    @Getter
    SelenideElement enterMobileOrEmailContainer = $(By.id("claim-collection-container"));
}
