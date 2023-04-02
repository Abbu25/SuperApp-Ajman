import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.callTestCase(findTestCase('Utilities/Login'), [:], FailureHandling.CONTINUE_ON_FAILURE)

String dirName = System.getProperty('user.dir')

filePath = (dirName + ExcelPath)

int rowNum = RowNum.toInteger() + 1

Mobile.tap(findTestObject('2.Dashboard/Profile Settings/Image_Profile Picture_DashBoard'), 0)

Mobile.waitForElementPresent(findTestObject('2.Dashboard/Profile Settings/Button_Change Mobile Number'), 0)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('2.Dashboard/Profile Settings/Button_Change Mobile Number'), 0)

WebUI.callTestCase(findTestCase('Utilities/Enter_mPIN'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('3.Payments/Payment Confirmation Page/Button_Verify'), 0)

Mobile.waitForElementPresent(findTestObject('2.Dashboard/Profile Settings/TextBox_Enter Mobile Number'), 0)

Mobile.setText(findTestObject('2.Dashboard/Profile Settings/TextBox_Enter Mobile Number'), MobileNumber, 0)

Mobile.tap(findTestObject('3.Payments/Payment Confirmation Page/Button_Verify'), 0)

Mobile.delay(5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Utilities/Enter_OTP'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('3.Payments/Payment Confirmation Page/Button_Verify'), 0)

Mobile.waitForElementPresent(findTestObject('2.Dashboard/Profile Settings/Image_Profile Picture_Profile Settings'), 0)

Mobile.takeScreenshot()

mobileNumber = Mobile.getAttribute(findTestObject('2.Dashboard/Profile Settings/Button_Change Mobile Number'), 'contentDescription', 
    0)

String[] list = mobileNumber.split('\\R')

ActualResult = (list[1]).replaceAll('\\s', '')

if (ActualResult.contains(MobileNumber)) {
    KeywordUtil.markPassed('Mobile Number Updated Successfully')

    CustomKeywords.'myPack.WriteExcel.writeResult'(SheetName, rowNum, 'Mobile Number Updated Successfully', filePath)
} else {
    KeywordUtil.markFailed('Mobile Number Not Updated. Please Try Again')

    CustomKeywords.'myPack.WriteExcel.writeResult'(SheetName, rowNum, 'Mobile Number Not Updated. Please Try Again', filePath)
}

WebUI.delay(5)

Mobile.tap(findTestObject('2.Dashboard/Profile Settings/Button_Logout-newApp'), 0)

