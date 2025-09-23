package data_provider;

import org.anton.enums.CategoryDropdown;
import org.testng.annotations.DataProvider;

public class EnumDataProvider {
    @DataProvider(name = "categoriesData")
    public Object[] getCategoriesData() {
        return CategoryDropdown.values();
    }
}
