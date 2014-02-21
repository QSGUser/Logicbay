package com.qsgsoft.Logicbay.support;

import java.io.File;
import java.util.Properties;

import jxl.Sheet;
import jxl.Workbook;

public class ReadDataFromExcel {
	
	public String readDataFromTestDataDetails(String SheetName, int intRow,
			int intColumn) throws Exception {
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		String FILE_PATH = pathProps.getProperty("TestData_Path");
		String[] fileName = FILE_PATH.split("/");
		File file = new File(fileName[fileName.length - 1]);
		String path = file.getAbsolutePath();
		FILE_PATH = path.replaceAll(fileName[fileName.length - 1], FILE_PATH);
		Sheet ws = null;

		// Read the existing file
		Workbook wb = Workbook.getWorkbook(new File(FILE_PATH));
		ws = wb.getSheet(SheetName);

		// Read content of the cell
		String strCellContent = ws.getCell(intColumn - 1, intRow - 1)
				.getContents();
		wb.close();

		return strCellContent;
	}
	
}

