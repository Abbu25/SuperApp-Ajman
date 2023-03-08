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

	@Keyword
	public static void writeResult(String sheetName, int rowNum, String value,String ExcelPath) {

		FileInputStream fis = new FileInputStream(ExcelPath);
		FileOutputStream fos = null;
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Credentials");
		XSSFRow row = null;
		XSSFCell cell = null;

		int col_Num = -1;
		sheet = workbook.getSheet(sheetName);

		row = sheet.getRow(0);
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals("ActualResult")) {
				col_Num = i;
			}
		}

		sheet.autoSizeColumn(col_Num);
		row = sheet.getRow(rowNum - 1);
		if(row==null)
			row = sheet.createRow(rowNum - 1);

		cell = row.getCell(col_Num);
		if(cell == null)
			cell = row.createCell(col_Num);

		cell.setCellValue(value);

		fos = new FileOutputStream(ExcelPath);
		workbook.write(fos);
		fos.close();
	}
}