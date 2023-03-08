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

WebUI.callTestCase(findTestCase('Utilities/Login'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('3.Payments/Payments_page/tab_PAY'), 0)

Mobile.waitForElementPresent(findTestObject('4.Transfers/Button_Ajman Transfer'), 0)

Mobile.tap(findTestObject('4.Transfers/Button_Ajman Transfer'), 0)

Mobile.waitForElementPresent(findTestObject('4.Transfers/Text Box_ IBAN Account Number'), 0)

WebUI.callTestCase(findTestCase('Utilities/Account Selection Based on AccountNumber'), [('accountNumber') : accountNumber], 
    FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('4.Transfers/Text Box_ IBAN Account Number'), 0)

Mobile.setText(findTestObject('4.Transfers/Text Box_ IBAN Account Number'), '011000833011', 0)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('4.Transfers/Button_Verify mPIN'), 0)

Mobile.waitForElementPresent(findTestObject('4.Transfers/Button_Next'), 0)

Mobile.tap(findTestObject('4.Transfers/Button_Next'), 0)

WebUI.delay(3)

Mobile.setText(findTestObject('4.Transfers/Text Box_Amount'), amount, 0)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('4.Transfers/Button_Next'), 0)

WebUI.delay(3)

Mobile.swipe(135, 1840, 447, 259)

Mobile.tap(findTestObject('4.Transfers/Button_Confirm'), 0)

WebUI.delay(5)

Mobile.tapAtPosition(137, 771)

WebUI.callTestCase(findTestCase('Utilities/Enter_mPIN'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('4.Transfers/Button_Verify mPIN'), 0)

WebUI.delay(5)

WebUI.callTestCase(findTestCase('Utilities/Enter_OTP'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('4.Transfers/Button_VerifyOTP'), 0)

Mobile.waitForElementPresent(findTestObject('4.Transfers/Button_BackToPayment'), 180)

Mobile.takeScreenshot()

content = Mobile.getAttribute(findTestObject('3.Payments/Payment Success page/label_SuccessPage'), 'contentDescription', 
    0)

println(content)

String[] line = content.split('\\R')

println(line[0])

if (amount == (line[0])) {
    KeywordUtil.markPassed('Pass')
} else {
    KeywordUtil.markFailed('Fail')
}

Mobile.tap(findTestObject('3.Payments/Payment Success page/Button_Back To Payment'), 0)

WebUI.callTestCase(findTestCase('Utilities/Logout'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Mobile.closeApplication()

