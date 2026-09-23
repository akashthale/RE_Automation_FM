package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	// Excel file location
	private static final String filePath = "/RippleEffects_Automation_Framework-3-automation-framework/Testdata/Logintestdata.xlsx";

	/**
	 * Reads all cells from a specific row of an Excel sheet.
	 *
	 * @param sheetName Name of the Excel sheet
	 * @param rowNum    Row number to read (0-based)
	 * @return String array containing the row data
	 */
	public static String[] getRowData(String sheetName, int rowNum) {

		try (FileInputStream inputStream = new FileInputStream(filePath);

				XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
			System.out.println("Available Excel sheets:");

			// Get the required sheet
			XSSFSheet sheet = workbook.getSheet(sheetName);

			// Get number of cells in the row
			int totalCells = sheet.getRow(rowNum).getLastCellNum();

			// Create array to store row data
			String[] rowData = new String[totalCells];

			// Read each cell
			for (int cell = 0; cell < totalCells; cell++) {

				rowData[cell] = sheet.getRow(rowNum).getCell(cell).toString();
			}

			return rowData;

		} catch (IOException e) {

			e.printStackTrace();
			return null;
		}
	}
}
