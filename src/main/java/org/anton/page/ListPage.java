package org.anton.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.anton.object.HeaderAmazon;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ListPage extends BasePage {
    @Getter
    private final HeaderAmazon header = new HeaderAmazon();

    ElementsCollection item = $$x("//div[@role=\"listitem\"]");
    SelenideElement addToCartButton = $x("//button[contains(text(), 'Add to cart')]");

    public void addFirstAvailableItemToCart(){
        addToCartButton.click();
    }
}
