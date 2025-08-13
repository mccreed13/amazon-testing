package org.epam.anton.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.epam.anton.object.HeaderAmazon;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends BasePage {
    @Getter
    public HeaderAmazon headerAmazon = new HeaderAmazon();

    private final SelenideElement button = $x("/html/body/div/div[1]/div[3]/div/div/form/div/div/span/span/button");

    public ListPage search(String text) {
        return headerAmazon.search(text);
    }

    public String getPlaceholderFromSearchInput() {
        return headerAmazon.getPlaceholderFromSearchInput();
    }

    public void openWebSite(String url){
        Selenide.open(url);
        if(button.isDisplayed()){
            button.click();
        }
    }
}
