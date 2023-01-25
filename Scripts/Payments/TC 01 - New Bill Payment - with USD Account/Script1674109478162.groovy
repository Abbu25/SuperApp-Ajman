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

Mobile.startExistingApplication('com.example.ajman', FailureHandling.STOP_ON_FAILURE)

WebUI.delay(10)

AndroidDriver<?> driver = MobileDriverFactory.getDriver()

driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1))

driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0))

driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2))

driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0))

driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3))

driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0))

driver.pressKey(new KeyEvent(AndroidKey.ENTER))

Mobile.tap(findTestObject('1.Registration and Login/mPIN Page/Button_Login mPIN'), 30)

Mobile.waitForElementPresent(findTestObject('3.Payments/Payments_page/tab_PAY'), 60)

Mobile.tap(findTestObject('3.Payments/Payments_page/tab_PAY'), 0)

Mobile.tap(findTestObject('3.Payments/Payments_page/tab_Bills'), 0)

Mobile.tap(findTestObject('3.Payments/Payments_page/button_NewBill'), 0)

WebUI.delay(2)

Mobile.tap(findTestObject('3.Payments/Pay To New Biller/Label_Select Biller', [('biller') : biller]), 0)

Mobile.tap(findTestObject('3.Payments/Pay To New Biller/Label_Select Sub Biller', [('subBiller') : subBiller]), 0)

WebUI.delay(10)

Mobile.swipe(1026, 614, 54, 614)

Mobile.tap(findTestObject('3.Payments/Pay To New Biller/Text Box_Account Number Entry'), 0)

Mobile.setText(findTestObject('3.Payments/Pay To New Biller/Text Box_Account Number Entry'), accountNumber, 0)

Mobile.pressBack()

Mobile.tap(findTestObject('3.Payments/Pay To New Biller/Button_Next'), 0)

Mobile.waitForElementPresent(findTestObject('3.Payments/Amount/Text Box_Amount Entry'), 0)

Mobile.tap(findTestObject('3.Payments/Amount/Text Box_Amount Entry'), 0)

Mobile.setText(findTestObject('3.Payments/Amount/Text Box_Amount Entry'), amount, 0)

Mobile.tap(findTestObject('3.Payments/Amount/Button_Next'), 0)

WebUI.delay(2)

Mobile.swipe(135, 1840, 447, 259)

Mobile.tap(findTestObject('3.Payments/Payment Confirmation Page/Button_Confirm'), 0)

WebUI.delay(2)

Mobile.tapAtPosition(137, 771)

driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1))

driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0))

driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2))

driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0))

driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3))

driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0))

driver.pressKey(new KeyEvent(AndroidKey.ENTER))

Mobile.tap(findTestObject('3.Payments/Payment Confirmation Page/Button_Verify'), 0)

Mobile.waitForElementPresent(findTestObject('3.Payments/Payment Success page/Button_Back To Payment'), 60)

Mobile.takeScreenshot('./ScreenShots/FEWA.png', FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('3.Payments/Payment Success page/Button_Back To Payment'), 0)

WebUI.delay(3)

Mobile.tap(findTestObject('2.Dashboard/Profile Settings/Icon_Home'), 0)

Mobile.tap(findTestObject('2.Dashboard/Profile Settings/Image_Profile Picture'), 0)

Mobile.swipe(135, 1840, 447, 259)

Mobile.swipe(135, 1840, 447, 259)

Mobile.tap(findTestObject('2.Dashboard/Profile Settings/Button_Logout'), 0)

Mobile.closeApplication()

