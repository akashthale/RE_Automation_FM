package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static String readDataFromExcel(String file, String expSheetName, String expCardName, String expectValue)
			throws IOException {

		FileInputStream fis = new FileInputStream(file);
		try (XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
			int numOfSheets = workbook.getNumberOfSheets();
			int column = 0;

			for (int i = 0; i < numOfSheets; i++) {
				if (workbook.getSheetName(i).equals(expSheetName)) {
					column = i;
				}
			}

			XSSFSheet sheet = workbook.getSheetAt(column);
			int rowCount = sheet.getPhysicalNumberOfRows();
			XSSFRow headerRow = sheet.getRow(0);
			int columnCount = headerRow.getLastCellNum();

			String outputVal = null;

			for (int i = 1; i < rowCount; i++) {
				XSSFRow reqRow = sheet.getRow(i);

				if (reqRow.getCell(0).getStringCellValue().equalsIgnoreCase(expCardName)) {
					for (int j = 0; j < columnCount; j++) {
						Cell cell = reqRow.getCell(j);
						String cellHeader = headerRow.getCell(j).getStringCellValue();

						if (cellHeader.equalsIgnoreCase(expectValue)) {
							if (cell != null) {
								if (cell.getCellType() == CellType.STRING) {
									outputVal = cell.getStringCellValue();
								} else {
									outputVal = NumberToTextConverter.toText(cell.getNumericCellValue());
								}
								break; // Break loop once the value is found
							}
						}
					}
					break; // Break outer loop once the row is found
				}
			}

			return outputVal;
		}
	}

	public static Object[][] getAllDataFromExcel(String filePath, String sheetName) throws IOException {

	    FileInputStream fis = new FileInputStream(filePath);
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);

	    XSSFSheet sheet = workbook.getSheet(sheetName);

	    if (sheet == null) {
	        workbook.close();
	        fis.close();
	        throw new RuntimeException("Sheet not found: " + sheetName);
	    }

	    int columnCount = sheet.getRow(0).getLastCellNum();

	    List<Object[]> rows = new ArrayList<>();

	    for (int i = 1; i <= sheet.getLastRowNum(); i++) {

	        XSSFRow row = sheet.getRow(i);

	        if (row == null) {
	            continue;
	        }

	        Object[] rowData = new Object[columnCount];

	        boolean isEmptyRow = true;

	        for (int j = 0; j < columnCount; j++) {

	            XSSFCell cell = row.getCell(j);

	            if (cell == null) {
	                rowData[j] = "";
	            } else {
	                String value = cell.toString().trim();
	                rowData[j] = value;

	                if (!value.isEmpty()) {
	                    isEmptyRow = false;
	                }
	            }
	        }

	        if (!isEmptyRow) {
	            rows.add(rowData);
	        }
	    }

	    workbook.close();
	    fis.close();

	    return rows.toArray(new Object[0][]);
	}
}