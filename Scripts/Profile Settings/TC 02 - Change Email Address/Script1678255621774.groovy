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

WebUI.callTestCase(findTestCase('Utilities/Login'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('2.Dashboard/Profile Settings/Image_Profile Picture_DashBoard'), 0)

Mobile.waitForElementPresent(findTestObject('2.Dashboard/Profile Settings/Button_Change Email Address'), 0)

Mobile.tap(findTestObject('2.Dashboard/Profile Settings/Button_Change Email Address'), 0)

WebUI.callTestCase(findTestCase('Utilities/Enter_mPIN'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('3.Payments/Payment Confirmation Page/Button_Verify'), 0)

Mobile.waitForElementPresent(findTestObject('2.Dashboard/Profile Settings/TextBox_Enter Email Address'), 0)

Mobile.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('2.Dashboard/Profile Settings/TextBox_Enter Email Address'), 0)

Mobile.setText(findTestObject('2.Dashboard/Profile Settings/TextBox_Enter Email Address'), EmailAddress, 0)

Mobile.tap(findTestObject('3.Payments/Payment Confirmation Page/Button_Verify'), 0)

Mobile.delay(6, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Utilities/Enter_OTP'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('3.Payments/Payment Confirmation Page/Button_Verify'), 0)

Mobile.tap(findTestObject('2.Dashboard/Profile Settings/Image_Profile Picture_DashBoard'), 0)

Mobile.waitForElementPresent(findTestObject('2.Dashboard/Profile Settings/Image_Profile Picture_Profile Settings'), 0)

Mobile.swipe(135, 1840, 447, 259)

Mobile.swipe(135, 1840, 447, 259)

Mobile.tap(findTestObject('2.Dashboard/Profile Settings/Button_Logout'), 0)

