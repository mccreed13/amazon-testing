package org.epam.anton.object;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.epam.anton.enums.CategoryDropdown;
import org.epam.anton.page.ListPage;
import org.epam.anton.page.MainPage;

import static com.codeborne.selenide.Selenide.$x;

public class HeaderAmazon {
    private final SelenideElement searchButton = $x("//*[@id=\"nav-search-submit-button\"]");
    private final SelenideElement searchInput = $x("//*[@id=\"twotabsearchtextbox\"]");
    private final SelenideElement logo = $x("//*[@id=\"nav-logo\"]");
    private final SelenideElement searchSelect = $x("//select[contains(@class, \"searchSelect\")]");
    private final SelenideElement displayedSelectedOption = $x("//*[@id=\"nav-search-label-id\"]");

    public ListPage search(String text) {
        searchInput.setValue(text);
        searchButton.click();
        return new ListPage();
    }

    public String getPlaceholderFromSearchInput() {
        return searchInput.getAttribute("placeholder");
    }

    public MainPage clickLogo() {
        logo.click();
        return new MainPage();
    }

    public void isVisibleLogo() {
        logo.shouldBe(Condition.visible);
    }

    public void selectCategorySearch(CategoryDropdown category) {
        searchSelect.selectOption(category.getDisplayName());
    }

    public void verifyCategoryIsSelected(CategoryDropdown category) {
        displayedSelectedOption.shouldBe(Condition.visible);
        if (category.equals(CategoryDropdown.ALL_DEPARTMENTS)){
            displayedSelectedOption.shouldHave(Condition.text("All"));
        }else {
            displayedSelectedOption.shouldHave(Condition.exactText(category.getDisplayName()));
        }
    }
}
