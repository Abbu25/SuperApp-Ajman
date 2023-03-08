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

Mobile.startExistingApplication('com.cbt.ajmandigital', FailureHandling.CONTINUE_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('1.Registration and Login/Login Page/button_ForgotmPIN'), 0)

WebUI.callTestCase(findTestCase('Utilities/Enter_mPIN'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('2.Dashboard/Accounts/AccountDetails'), 60)

Mobile.takeScreenshot()

content = Mobile.getAttribute(findTestObject('2.Dashboard/Accounts/AccountDetails'), 'contentDescription', 0)

Mobile.tap(findTestObject('2.Dashboard/Accounts/label_Finances'), 0)

content1 = Mobile.getAttribute(findTestObject('2.Dashboard/Accounts/Finance Account Details'), 'contentDescription', 0)

Mobile.tap(findTestObject('2.Dashboard/Accounts/label_Deposits'), 0)

content2 = Mobile.getAttribute(findTestObject('2.Dashboard/Accounts/AccountDetails'), 'contentDescription', 0)

println(content)

String[] line = content.split('\\R')

String[] line1 = content1.split('\\R')

String[] line2 = content2.split('\\R')

println(line[4])

if (((VerifyAccountNumber == (line[4])) && (VerifyFinanceAccountNumber == (line1[4]))) && (VerifyDepositAccountNumber == (line2[4]))) {
    KeywordUtil.markPassed('Login Successful')
} else {
    KeywordUtil.markFailed('Login Failed')
}

WebUI.callTestCase(findTestCase('Utilities/Logout'), [:], FailureHandling.CONTINUE_ON_FAILURE)

