package org.anton.ui.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.anton.ui.object.HeaderAmazon;

import static com.codeborne.selenide.Selenide.$x;

@Slf4j
public class MainPage extends BasePage {
    @Getter
    public HeaderAmazon headerAmazon = new HeaderAmazon();
    private final SelenideElement button = $x("/html/body/div/div[1]/div[3]/div/div/form/div/div/span/span/button");
    private final static String BASE_URL = "https://www.amazon.com/";

    public MainPage() {
        openWebSite(BASE_URL);
    }

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
            log.info("Button clicked on MainPage");
        }else {
            log.info("Website opened, but button is not displayed");
        }
    }
}
