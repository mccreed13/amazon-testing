package api.data_provider;

import org.anton.api.enums.Status;
import org.testng.annotations.DataProvider;

public class EnumDataProvider {
    @DataProvider(name = "statusesData")
    public Object[] getStatusesData() {
        return Status.values();
    }
}
