package DataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Wrappers.WebCommonPath;
import utilities.ExcelUtil;

public class Organization_DataProvider {

	@DataProvider(name = "organizationData")
	public Object[][] organizationData() throws IOException {

		return ExcelUtil.getAllDataFromExcel(WebCommonPath.MultipleOranizationTestData, "MultipleOrganization");
	}
}