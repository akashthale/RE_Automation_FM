package DataProvider;

import org.testng.annotations.DataProvider;

public class District_DataProvider {

	@DataProvider(name = "districtData")
	public Object[][] districtData() {
		return new Object[][] {

				{ "ED_Test_District_01", "testfirst901", "testlast901", "edtestdis901@yopmail.com", "Sunil Game" },
				{ "ED_Test_District_02", "testfirst902", "testlast902", "edtestdis902@yopmail.com", "Sunil Game" },
				{ "ED_Test_District_03", "testfirst903", "testlast903", "edtestdis903@yopmail.com", "Sunil Game" },
				{ "ED_Test_District_04", "testfirst904", "testlast904", "edtestdis904@yopmail.com", "Sunil Game" } };
	}

	@DataProvider(name = "districtSearchData")
	public Object[][] districtSearchData() {

		return new Object[][] {

				{ "ED_Test_District_01" }, { "ED_Test_District_02" }, { "ED_Test_District_03" },
				{ "ED_Test_District_04" } };
	}
}
