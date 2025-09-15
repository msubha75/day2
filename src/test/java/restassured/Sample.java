package restassured;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;

public class Sample {

	public static void main(String[] args) {
		
		try {
			FileInputStream fis = new FileInputStream("src/test/resources/testdata.xlsx");
			Workbook workbook = WorkbookFactory.create(fis);

			Sheet sheet = workbook.getSheetAt(0);
			for (Row row : sheet) {
				for (Cell cell : row) {
					switch (cell.getCellType()) {
					case STRING:
						System.out.print(cell.getStringCellValue() + "\t");
						break;
					case NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t");
						break;
					case BOOLEAN:
						System.out.print(cell.getBooleanCellValue() + "\t");
						break;
					default:
						System.out.print(" \t");
					}
				}
				System.out.println();
			}
			workbook.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
