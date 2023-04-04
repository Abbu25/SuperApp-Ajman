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
import com.kms.katalon.core.annotation.Keyword as Keyword
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper as MobileElementCommonHelper
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.android.AndroidDriver as AndroidDriver
import io.appium.java_client.android.nativekey.AndroidKey as AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent as KeyEvent
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.callTestCase(findTestCase('Utilities/Login'), [:], FailureHandling.STOP_ON_FAILURE)

String dirName = System.getProperty('user.dir')

filePath = (dirName + ExcelPath)

int rowNum = RowNum.toInteger() + 1

Mobile.tap(findTestObject('3.Payments/Payments_page/tab_PAY'), 0)

Mobile.tap(findTestObject('4.Transfers/tab_Accounts'), 0)

Mobile.tap(findTestObject('4.Transfers/UAE Bank/tab_UAE Bank'), 0)

Mobile.waitForElementPresent(findTestObject('4.Transfers/Text Box_ IBAN Account Number'), 0)

Mobile.tap(findTestObject('4.Transfers/Text Box_ IBAN Account Number'), 0)

Mobile.setText(findTestObject('4.Transfers/Text Box_ IBAN Account Number'), IBANNumber, 0)

Mobile.tap(findTestObject('4.Transfers/Button_Verify mPIN'), 0)

Mobile.tap(findTestObject('4.Transfers/UAE Bank/taxtBox_Account Holder Name'), 0)

Mobile.setText(findTestObject('4.Transfers/UAE Bank/taxtBox_Account Holder Name'), AccountHolderName, 0)

Mobile.tap(findTestObject('4.Transfers/Button_Next'), 0)

WebUI.callTestCase(findTestCase('Utilities/Account Selection Based on AccountNumber'), [('accountNumber') : AccountNumber], 
    FailureHandling.OPTIONAL)

Mobile.waitForElementPresent(findTestObject('4.Transfers/Text Box_Amount'), 0)

WebUI.callTestCase(findTestCase('Utilities/KeyboardFunction'), [('text') : Amount], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('4.Transfers/Button_Next'), 0)

Mobile.waitForElementPresent(findTestObject('4.Transfers/UAE Bank/dropdown_Purpose'), 0)

Mobile.tap(findTestObject('4.Transfers/UAE Bank/dropdown_Purpose'), 0)

if (((((Purpose != 'Charitable Contributions') && (Purpose != 'Educational Support')) && (Purpose != 'Equated Monthly Installments')) && 
(Purpose != 'Family Support')) && (Purpose != 'Financial Services')) {
    Mobile.swipe(66, 2015, 66, 1300)

    Mobile.tap(findTestObject('4.Transfers/UAE Bank/select_Item in Purpose Dropdown', [('purpose') : Purpose]), 0)
} else {
    Mobile.tap(findTestObject('4.Transfers/UAE Bank/select_Item in Purpose Dropdown', [('purpose') : Purpose]), 0)
}

Mobile.tap(findTestObject('4.Transfers/Button_Next'), 0)

WebUI.delay(2)

Mobile.swipe(135, 1840, 447, 259)

Mobile.tap(findTestObject('4.Transfers/Button_Confirm'), 0)

Mobile.waitForElementPresent(findTestObject('1.Registration and Login/mPIN Page/page_mPIN'), 0)

Mobile.tapAtPosition(137, 771)

WebUI.callTestCase(findTestCase('Utilities/Enter_mPIN'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('4.Transfers/Button_Verify mPIN'), 0)

WebUI.callTestCase(findTestCase('Utilities/Enter_OTP'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('4.Transfers/Button_VerifyOTP'), 0)

Mobile.waitForElementPresent(findTestObject('4.Transfers/Button_BackToPayment'), 180)

Mobile.takeScreenshot()

if (Mobile.verifyElementExist(findTestObject('3.Payments/Payment Success page/Button_Share'), 5, FailureHandling.CONTINUE_ON_FAILURE)) {
    content = Mobile.getAttribute(findTestObject('3.Payments/Payment Success page/label_SuccessPage'), 'contentDescription', 
        0)

    println(content)

    String[] line = content.split('\\R')

    ActualResult = content

    println(line[0])

    println(Amount)

    if (Amount == (line[0])) {
        KeywordUtil.markPassed('Transfer Within Ajman Successfull')

        CustomKeywords.'myPack.WriteExcel.writeResult'(SheetName, rowNum, ActualResult, filePath)
    } else {
        KeywordUtil.markFailed("Transfer Failed to $IBANNumber")

        CustomKeywords.'myPack.WriteExcel.writeResult'(SheetName, rowNum, ActualResult, filePath)
    }
} else {
    KeywordUtil.markFailed("Transfer Failed to $IBANNumber")

    CustomKeywords.'myPack.WriteExcel.writeResult'(SheetName, rowNum, "Transfer Failed to $IBANNumber", filePath)
}

Mobile.tap(findTestObject('4.Transfers/Button_BackToPayment'), 0)

WebUI.callTestCase(findTestCase('Utilities/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

