package com.qsgsoft.Logicbay.support;

import java.io.File;
import java.util.Properties;
import java.util.Date;
import java.text.SimpleDateFormat;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableWorkbook;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import jxl.format.Border;
import jxl.format.BorderLineStyle;

public class WriteDataToTestDataExcel {
	
	private static WritableCellFormat courier;

	public void writeDataToTestData(String strSheetName, int intRow,
			int intColumn,String strData) throws Exception {
		
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		String FILE_PATH = pathProps.getProperty("TestData_Path");
		String[] fileName = FILE_PATH.split("/");
		File file = new File(fileName[fileName.length - 1]);
		String path = file.getAbsolutePath();
		FILE_PATH = path.replaceAll(fileName[fileName.length - 1], FILE_PATH);
		
		// Read the existing file
		Workbook wb = Workbook.getWorkbook(new File(FILE_PATH));
		
		WritableCellFormat wcf = new WritableCellFormat();
		wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
		wcf.setWrap(true);

		WritableFont courier10pt = new WritableFont(
				WritableFont.COURIER, 10);
		// Define the cell format
		courier = new WritableCellFormat(courier10pt);
		wcf.setFont(courier10pt);
		
		// Create a writable workbook with the same name using the workbook
		// object that has been read from file
		WritableWorkbook wwb = Workbook.createWorkbook(new File(FILE_PATH), wb);
				
		Label label1 = new Label(intColumn-1,intRow-1, strData);
		wwb.getSheet(strSheetName).addCell(label1);			
				
		// Write the data
		wwb.write();
		wwb.close();
		
	}
	
	public void WritePdfDetailsToExcel(String pStrTCID, String pStrTO,
			String pStrFacility, String pStrIncident, String pStrUrl)
			throws Exception {
	
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		// strDate = date.toString();
	
		// WRITE RESULTS TO EXCEL UNDER ANY CONDITION WITHOUT CHECKING ANY FLAG.
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();						
		String FILE_PATH =pathProps.getProperty("PDFDetails");	
		String[] fileName = FILE_PATH.split("/");
		File file = new File(fileName[fileName.length - 1]);
		String path = file.getAbsolutePath();
		FILE_PATH = path.replaceAll(fileName[fileName.length - 1], FILE_PATH);
		
		// Read the existing file
		Workbook wb = Workbook.getWorkbook(new File(FILE_PATH));
	
		// Create a writable workbook with the same name using the workbook
		// object that has been read from file
		WritableWorkbook wwb = Workbook.createWorkbook(new File(FILE_PATH), wb);
	
		// Total number of rows in the sheet
		int intRowCount = wwb.getSheet(0).getRows();
		for (int intRow = 4; intRow <= intRowCount; intRow++) {
			// Target cell
			WritableCell cell = wwb.getSheet(0).getWritableCell(1, intRow);
	
			if (cell.getType() == CellType.EMPTY) {
				WritableCellFormat wcf = new WritableCellFormat();
				wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf.setWrap(true);
	
				WritableFont courier10pt = new WritableFont(
						WritableFont.COURIER, 10);
				// Define the cell format
				courier = new WritableCellFormat(courier10pt);
				wcf.setFont(courier10pt);
	
				Label label0 = new Label(0, intRow, "", wcf);
				wwb.getSheet(0).addCell(label0);
	
				// Enter the TC ID
				Label label1 = new Label(1, intRow, pStrTCID, wcf);
				wwb.getSheet(0).addCell(label1);
				
				// Enter Test Objective
				Label label2 = new Label(2, intRow, pStrTO, wcf);
				wwb.getSheet(0).addCell(label2);
				
				// Enter facility name
				Label label3 = new Label(3, intRow, pStrFacility, wcf);
				wwb.getSheet(0).addCell(label3);
				
				// Enter incident
				Label label4 = new Label(4, intRow, pStrIncident, wcf);
				wwb.getSheet(0).addCell(label4);
				
				// Enter Pdf Url
				Label label5 = new Label(5, intRow, pStrUrl, wcf);
				wwb.getSheet(0).addCell(label5);	
			
				// Write the data
				wwb.write();
				intRow = intRowCount + 1;
			}
		}
		wwb.close();	
	}
	
}

