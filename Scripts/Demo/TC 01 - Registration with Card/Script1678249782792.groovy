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

Mobile.waitForElementPresent(findTestObject('1.Registration and Login/Welcome Page/button_Skip'), 30, FailureHandling.OPTIONAL)

Mobile.tap(findTestObject('1.Registration and Login/Welcome Page/button_Skip'), 0)

Mobile.waitForElementPresent(findTestObject('1.Registration and Login/Welcome Page/button_Already a Customer'), 15, FailureHandling.OPTIONAL)

Mobile.tap(findTestObject('1.Registration and Login/Welcome Page/button_Already a Customer'), 0)

Mobile.waitForElementPresent(findTestObject('1.Registration and Login/Card Details Page/Radio Button_Debit Card'), 0)

if (cardType.equals('Debit Card')) {
    Mobile.tap(findTestObject('1.Registration and Login/Card Details Page/Radio Button_Debit Card'), 0)
} else {
    Mobile.tap(findTestObject('1.Registration and Login/Card Details Page/Radio Button_Credit Card'), 0)
}

Mobile.setText(findTestObject('1.Registration and Login/Card Details Page/Text Box_Card Number'), cardNumber, 0)

Mobile.setText(findTestObject('1.Registration and Login/Card Details Page/Text Box_Card Pin'), cardPin, 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('1.Registration and Login/Card Details Page/Button_Next on Card details'), 0)

Mobile.waitForElementPresent(findTestObject('1.Registration and Login/OTP Page/label_Enter OTP'), 0)

WebUI.callTestCase(findTestCase('Utilities/Enter_OTP'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('1.Registration and Login/OTP Page/Button_Verify OTP'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('1.Registration and Login/mPIN Page/Text Box_Create mPIN'), mPIN, 0)

Mobile.setText(findTestObject('1.Registration and Login/mPIN Page/Text Box_Confirm mPIN Entry'), mPIN, 0)

Mobile.tap(findTestObject('1.Registration and Login/mPIN Page/Button_Next mPIN Page'), 0)

Mobile.waitForElementPresent(findTestObject('1.Registration and Login/mPIN Page/Button_Maybe later Biometric'), 0)

Mobile.tap(findTestObject('1.Registration and Login/mPIN Page/Button_Maybe later Biometric'), 0)

if (Mobile.waitForElementPresent(findTestObject('2.Dashboard/Accounts/AccountDetails'), 0)) {
    KeywordUtil.markPassed("User Registered Successfully with $cardType")
} else {
    KeywordUtil.markFailed('User registration faild')
}

Mobile.takeScreenshot()

WebUI.callTestCase(findTestCase('Utilities/Logout'), [:], FailureHandling.CONTINUE_ON_FAILURE)

