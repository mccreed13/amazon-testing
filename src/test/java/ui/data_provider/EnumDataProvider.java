package ui.data_provider;

import org.anton.ui.enums.CategoryDropdown;
import org.testng.annotations.DataProvider;

public class EnumDataProvider {
    @DataProvider(name = "categoriesData")
    public Object[] getCategoriesData() {
        return CategoryDropdown.values();
    }
}
