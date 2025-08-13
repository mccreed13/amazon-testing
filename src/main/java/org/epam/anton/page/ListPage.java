package org.epam.anton.page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.epam.anton.object.HeaderAmazon;

import static com.codeborne.selenide.Selenide.$x;

public class ListPage extends BasePage {
    @Getter
    private final HeaderAmazon header = new HeaderAmazon();

    SelenideElement item = $x("//div[@role=\"listitem\"]");



}
