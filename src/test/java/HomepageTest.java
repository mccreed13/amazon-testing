import data_provider.EnumDataProvider;
import org.epam.anton.enums.CategoryDropdown;
import org.epam.anton.object.HeaderAmazon;
import org.epam.anton.page.ListPage;
import org.epam.anton.page.MainPage;
import org.epam.anton.page.SignInPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomepageTest extends BaseTest {
    private final static String SEARCH_TEXT = "RTX3060";

    @Test
    public void testLogoVisibilityAndClick() {
        MainPage mainPage = new MainPage();
        mainPage.getHeaderAmazon().isVisibleLogo();
        ListPage listPage = mainPage.search(SEARCH_TEXT);
        listPage.getHeader().clickLogo();
        webdriver().shouldHave(urlContaining("https://www.amazon.com/ref=nav_logo"));
    }

    @Test
    public void testSearchBarFunctionality() {
        MainPage mainPage = new MainPage();
        String expectedPlaceholder = "Search Amazon";
        assertEquals(mainPage.getPlaceholderFromSearchInput(), expectedPlaceholder);
        mainPage.search(SEARCH_TEXT);
        webdriver().shouldHave(urlContaining(SEARCH_TEXT));
    }

    @Test(dataProvider = "categoriesData", dataProviderClass = EnumDataProvider.class)
    public void testCategoryDropdown(CategoryDropdown category){
        MainPage mainPage = new MainPage();
        mainPage.headerAmazon.selectCategorySearch(category);
        mainPage.headerAmazon.verifyCategoryIsSelected(category);
    }

    @Test
    public void testSignInButton(){
        MainPage mainPage = new MainPage();
        HeaderAmazon headerAmazon = mainPage.getHeaderAmazon();
        headerAmazon.verifySignInSectionIsVisibleAndClickable();
        SignInPage page = headerAmazon.clickOnSignInSection();
        String text = page.getEnterMobileOrEmailContainer().text();
        String expectedContainsText = "Sign in or create account";
        assertTrue(text.contains(expectedContainsText));
    }

    @Test
    public void testFailing(){
        MainPage mainPage = new MainPage();
        webdriver().shouldHave(urlContaining("sd"));
    }

    @Test
    public void testCartIcon(){
        MainPage mainPage = new MainPage();
        mainPage.headerAmazon.isVisibleCartIcon();
        mainPage.headerAmazon.verifyCartIconCountEquals(0);
        ListPage listPage = mainPage.search(SEARCH_TEXT);
        listPage.addFirstAvailableItemToCart();
        listPage.getHeader().verifyCartIconCountEquals(1);
    }

    @AfterTest
    void clearCookies() {
        clearBrowserCookies();
    }

}
