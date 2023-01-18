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

Mobile.startApplication('kobiton-store:490925', false)

Mobile.delay(30, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('1.Registration and Login/Welcome Page/Button_Existing Customer'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('1.Registration and Login/Card Details Page/Radio Button_Debit Card'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('1.Registration and Login/Card Details Page/Text Box_Debit Card'), 0)

Mobile.delay(1, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('1.Registration and Login/Card Details Page/Text Box_Debit Card Entry'), '5244550100131209', 
    0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('1.Registration and Login/Card Details Page/Text Box_Card Pin'), 0)

Mobile.delay(1, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('1.Registration and Login/Card Details Page/Text Box_Card Pin'), '1234', 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('1.Registration and Login/Card Details Page/Button_Next on Card details'), 0)

Mobile.delay(30, FailureHandling.STOP_ON_FAILURE)

AndroidDriver<?> driver = MobileDriverFactory.getDriver()

Mobile.delay(2)

driver.pressKey(new KeyEvent(AndroidKey.DIGIT_6))

Mobile.delay(2)

driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5))

Mobile.delay(2)

driver.pressKey(new KeyEvent(AndroidKey.DIGIT_4))

Mobile.delay(2)

driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3))

Mobile.delay(2)

driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2))

Mobile.delay(2)

driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1))

Mobile.delay(2)

driver.pressKey(new KeyEvent(AndroidKey.ENTER))

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('1.Registration and Login/OTP Page/Button_Verify OTP'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('1.Registration and Login/mPIN Page/Text Box_Create mPIN'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('1.Registration and Login/mPIN Page/Text Box_Create mPIN Entry'), '102030', 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('1.Registration and Login/mPIN Page/Text Box_Confirm mPIN Entry'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('1.Registration and Login/mPIN Page/Text Box_Confirm mPIN Entry'), '102030', 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('1.Registration and Login/mPIN Page/Button_Next mPIN Page'), 0)

Mobile.delay(4, FailureHandling.STOP_ON_FAILURE)

Mobile.swipe(135, 1840, 447, 259)

Mobile.tap(findTestObject('1.Registration and Login/mPIN Page/Button_Maybe later Biometric'), 0)

Mobile.delay(6, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('2.Dashboard/Profile Settings/Image_Profile Picture'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.swipe(135, 1840, 447, 259)

Mobile.swipe(135, 1840, 447, 259)

Mobile.tap(findTestObject('2.Dashboard/Profile Settings/Button_Logout'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

