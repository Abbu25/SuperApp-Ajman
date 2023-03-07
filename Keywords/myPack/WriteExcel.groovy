package myPack
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import internal.GlobalVariable
//import MobileBuiltInKeywords as Mobile
//import WSBuiltInKeywords as WS
//import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
//import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Date as Date
import org.apache.poi.xssf.usermodel.XSSFCell as XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow as XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet as XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook as XSSFWorkbook
import java.lang.String as String
import org.apache.poi.ss.usermodel.Cell as Cell
import org.apache.poi.ss.usermodel.Row as Row
import org.apache.poi.hssf.usermodel.HSSFCell as HSSFCell
import org.apache.poi.hssf.usermodel.HSSFCellStyle as HSSFCellStyle
import org.apache.poi.hssf.usermodel.HSSFDataFormat as HSSFDataFormat
import org.apache.poi.hssf.usermodel.HSSFRow as HSSFRow
import org.apache.poi.hssf.usermodel.HSSFSheet as HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook as HSSFWorkbook
import org.apache.poi.hssf.util.HSSFColor as HSSFColor
import java.time.LocalDateTime as LocalDateTime
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.time.LocalDate as LocalDate
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem as NPOIFSFileSystem
import org.apache.poi.ss.util.CellRangeAddress as CellRangeAddress
import org.apache.poi.ss.usermodel.WorkbookFactory as WorkbookFactory
import org.apache.poi.ss.usermodel.Workbook as Workbook
import org.apache.poi.ss.usermodel.Sheet as Sheet


public class WriteExcel {

	//
	@Keyword
	public static void writeKey(String filePath, String SheetName, String TCNumber,int cellnum, String name) throws IOException{
		//WebUI.verifyEqual(filePath, filePath)
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//WebUI.verifyEqual(SheetName, SheetName)
		XSSFSheet sheet = workbook.getSheet(SheetName);
		/*//int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		 //Row row = sheet.createRow(rowCount+1);
		 */
		try {
			String Data_fromCell=sheet.getRow(1).getCell(0).getStringCellValue();
		}
		catch (Exception ex)
		{
			int rowCount = sheet.getLastRowNum();
			Row row = sheet.createRow(rowCount+1);
			Cell cell = row.createCell(0);
			cell.setCellType(cell.CELL_TYPE_STRING);
			cell.setCellValue("null");

		}
		int rowCount = sheet.getLastRowNum();
		for (int i = 1; i <= rowCount; i++) {
			'Read data from excel'
			//String Data_fromCell=sheet.getRow(i).getCell(0).getStringCellValue();
			String Data_fromCell=sheet.getRow(i).getCell(0).getStringCellValue()
			/*WebUI.verifyEqual(Data_fromCell, TCNumber)*/

			if (Data_fromCell == TCNumber) {
				'Write data to excel'
				//		Row row = sheet.createRow(i);
				Row row = sheet.getRow(i);

				Cell cell = row.createCell(cellnum);
				//Cell cell = row.;
				cell.setCellType(cell.CELL_TYPE_STRING);
				cell.setCellValue(name);
			}
		}

		FileOutputStream fos = new FileOutputStream( filePath);
		workbook.write(fos);
		fos.close();
	}
}

/*public class WriteExcelNumber {
 @Keyword
 public void writeKeyNumber(String filePath, String SheetName, String TCNumber, name) throws IOException{
 FileInputStream fis = new FileInputStream(filePath);
 XSSFWorkbook workbook = new XSSFWorkbook(fis);
 XSSFSheet sheet = workbook.getSheet(SheetName);
 //int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
 //Row row = sheet.createRow(rowCount+1);
 try {
 int Data_fromCell=sheet.getRow(1).getCell(0).getNumericCellValue();
 }
 catch (Exception ex)
 {
 int rowCount = sheet.getLastRowNum();
 Row row = sheet.createRow(rowCount+1);
 Cell cell = row.createCell(0);
 cell.setCellType(cell.CELL_TYPE_STRING);
 cell.setCellValue("null");
 }
 for (int i = 1; i <= sheet.getLastRowNum(); i++) {
 'Read data from excel'
 //String Data_fromCell=sheet.getRow(i).getCell(0).getStringCellValue();
 int Data_fromCell=sheet.getRow(i).getCell(0).getNumericCellValue()
 WebUI.verifyEqual(Data_fromCell, Data_fromCell)
 if (Data_fromCell == TCNumber) {
 'Write data to excel'
 //		Row row = sheet.createRow(i);
 Row row = sheet.getRow(i);
 Cell cell = row.createCell(1);
 //Cell cell = row.;
 cell.setCellType(cell.CELL_TYPE_STRING);
 cell.setCellValue(name);
 }
 }
 FileOutputStream fos = new FileOutputStream( filePath);
 workbook.write(fos);
 fos.close();
 }
 }*/
