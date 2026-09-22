package utilities;

public class LoginTestData {

	public static String[] getLoginData() {
		return ExcelUtil.getRowData("logindata", 1);
	}
}