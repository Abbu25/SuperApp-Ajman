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

Mobile.tap(findTestObject('3.Payments/Payments_page/tab_PAY'), 0)

Mobile.tap(findTestObject('3.Payments/Payments_page/tab_Bills'), 0)

Mobile.tap(findTestObject('3.Payments/Manage Bills/link_Select My Bills'), 0)

Mobile.tap(findTestObject('3.Payments/Manage Bills/link_MultipleBills'), 0)

Mobile.waitForElementPresent(findTestObject('3.Payments/Pay To New Biller/Button_Next'), 0)

Mobile.tap(findTestObject('3.Payments/Pay To New Biller/Button_Next'), 0)

Mobile.waitForElementPresent(findTestObject('3.Payments/Pay To New Biller/Button_Next'), 0)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('3.Payments/Pay To New Biller/Button_Next'), 0)

Mobile.waitForElementPresent(findTestObject('4.Transfers/My Own/Label_Transfer from'), 0)

WebUI.callTestCase(findTestCase('Utilities/Account Selection Based on AccountNumber - Copy'), [('accountNumber') : AccountNumber], 
    FailureHandling.OPTIONAL)

WebUI.delay(2)

Mobile.swipe(135, 1840, 447, 259)

Mobile.takeScreenshot()

expectedResult = Mobile.getAttribute(findTestObject('3.Payments/Multiple Bill Payment/PaymentAmount'), 'contentDescription', 
    0)

expectedResult = expectedResult.replace(',', '')

println(expectedResult)

expectedResult = expectedResult.split(' ', 0)

println(expectedResult[0])

Mobile.tap(findTestObject('4.Transfers/Button_Confirm'), 0)

WebUI.callTestCase(findTestCase('Utilities/Enter_mPIN'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('3.Payments/Payment Confirmation Page/Button_Verify'), 0)

Mobile.waitForElementPresent(findTestObject('4.Transfers/Button_BackToPayment'), 180)

Mobile.takeScreenshot()

if (Mobile.verifyElementExist(findTestObject('3.Payments/Payment Success page/Button_Share'), 5, FailureHandling.CONTINUE_ON_FAILURE)) {
    ActualResult = Mobile.getAttribute(findTestObject('3.Payments/Multiple Bill Payment/SuccessScreen_Amount'), 'contentDescription', 
        0)

    println(ActualResult)

    if (ActualResult == (expectedResult[0])) {
        KeywordUtil.markPassed('Multiple bill Payment Successfull')

        CustomKeywords.'myPack.WriteExcel.writeResult'(SheetName, rowNum, "Multiple Bill Payment Successful with Amount - $ActualResult", 
            filePath)
    } else {
        KeywordUtil.markFailed('Multiple Bill Payment Failed')

        CustomKeywords.'myPack.WriteExcel.writeResult'(SheetName, RowNum, "Multiple Bill Payment Failed with Amount - $ActualResult", 
            filePath)
    }
} else {
    KeywordUtil.markFailed('Multiple Bill Payment Failed')

    CustomKeywords.'myPack.WriteExcel.writeResult'(SheetName, rowNum, 'Multiple Bill Payment Failed', filePath)
}

Mobile.tap(findTestObject('4.Transfers/Button_BackToPayment'), 0)

WebUI.callTestCase(findTestCase('Utilities/Logout - Copy'), [:], FailureHandling.STOP_ON_FAILURE)

