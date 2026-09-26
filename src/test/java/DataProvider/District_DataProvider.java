package DataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Wrappers.WebCommonPath;
import utilities.ExcelUtil;

public class District_DataProvider {

    @DataProvider(name = "districtData")
    public Object[][] districtData() throws IOException {

        return ExcelUtil.getAllDataFromExcel(
                WebCommonPath.MultipleDistrictTestData,
                "MultipleDistrict"
        );
    }
}