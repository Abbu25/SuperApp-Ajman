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

String dirName = System.getProperty('user.dir')

filePath = (dirName + ExcelPath)

int rowNum = RowNum.toInteger() + 1
Mobile.tap(findTestObject('3.Payments/Payments_page/tab_PAY'), 0)

Mobile.tap(findTestObject('3.Payments/Payments_page/tab_Bills'), 0)

Mobile.tap(findTestObject('3.Payments/Payments_page/button_NewBill'), 0)

WebUI.delay(2)

Mobile.tap(findTestObject('3.Payments/Pay To New Biller/Label_Select Biller', [('biller') : Biller]), 0)

Mobile.tap(findTestObject('3.Payments/Pay To New Biller/Label_Select Sub Biller', [('subBiller') : SubBiller]), 0)

Mobile.waitForElementPresent(findTestObject('3.Payments/Pay To New Biller/Text Box_Account Number Entry'), 0)

Mobile.tap(findTestObject('3.Payments/Pay To New Biller/Text Box_Account Number Entry'), 0)

Mobile.setText(findTestObject('3.Payments/Pay To New Biller/Text Box_Account Number Entry'), ConsumerNumber, 0)

Mobile.pressBack()

if (Biller == 'Salik') {
    Mobile.tap(findTestObject('3.Payments/Pay To New Biller/Text Box_Salik PIN'), 0)

    Mobile.setText(findTestObject('3.Payments/Pay To New Biller/Text Box_Salik PIN'), SalikPIN, 0)

    Mobile.pressBack()
}

Mobile.tap(findTestObject('3.Payments/Pay To New Biller/Button_Next'), 0)

WebUI.callTestCase(findTestCase('Utilities/Account Selection Based on AccountNumber'), [('accountNumber') : AccountNumber], 
    FailureHandling.OPTIONAL)

Mobile.waitForElementPresent(findTestObject('3.Payments/Amount/Text Box_Amount Entry'), 0, FailureHandling.OPTIONAL)

String[] due

if (PaymentType.equals('partial')) {
    AndroidDriver<?> driver = MobileDriverFactory.getDriver()

    dueamount = Mobile.getAttribute(findTestObject('3.Payments/Amount/Text Box_Amount Entry'), 'text', 30, FailureHandling.OPTIONAL)

    println(dueamount)

    for (int i = 0; i < dueamount.length(); i++) {
        driver.pressKey(new KeyEvent(AndroidKey.DEL))
    }
    
    WebUI.callTestCase(findTestCase('Utilities/KeyboardFunction'), [('text') : Amount], FailureHandling.STOP_ON_FAILURE)
} else {
    Amount = Mobile.getAttribute(findTestObject('3.Payments/Amount/Text Box_Amount Entry'), 'text', 2, FailureHandling.OPTIONAL)
}

Mobile.tap(findTestObject('3.Payments/Amount/Button_Next'), 0)

Mobile.waitForElementPresent(findTestObject('3.Payments/Payment Confirmation Page/Button_Confirm'), 0)

Mobile.tap(findTestObject('3.Payments/Payment Confirmation Page/Button_Confirm'), 0)

WebUI.delay(5)

//Mobile.tapAtPosition(137, 771)
WebUI.callTestCase(findTestCase('Utilities/Enter_mPIN'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('3.Payments/Payment Confirmation Page/Button_Verify'), 0)

WebUI.delay(5)

WebUI.callTestCase(findTestCase('Utilities/Enter_OTP'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('4.Transfers/Button_VerifyOTP'), 0)

Mobile.waitForElementPresent(findTestObject('3.Payments/Payment Success page/Button_Back To Payment'), 30)

Mobile.tap(findTestObject('3.Payments/Payment Success page/Button_Add ToMy Bills'), 0)

Mobile.waitForElementPresent(findTestObject('3.Payments/Save Bill/textBox_Nickname'), 30)

Mobile.tap(findTestObject('3.Payments/Save Bill/textBox_Nickname'), 0)

Mobile.setText(findTestObject('3.Payments/Save Bill/textBox_Nickname'), Biller, 0)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('3.Payments/Save Bill/button_Verify'), 0)

Mobile.waitForElementPresent(findTestObject('3.Payments/Payment Success page/Button_Back To Payment'), 30)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('3.Payments/Payment Success page/Button_Back To Payment'), 0)

Mobile.waitForElementPresent(findTestObject('3.Payments/Payments_page/button_NewBill'), 0)

Mobile.takeScreenshot()

if (Mobile.waitForElementPresent(findTestObject('3.Payments/Save Bill/vrify_Saved Biller', [('biller') : Biller, ('consumerNumber') : ConsumerNumber]), 
    0)) {
    KeywordUtil.markPassed("Biller $Biller Saved Successfully with consumer number $ConsumerNumber")
	CustomKeywords.'myPack.WriteExcel.writeResult'(SheetName, rowNum, "Biller $Biller Saved Successfully with consumer number $ConsumerNumber", filePath)
} else {
    KeywordUtil.markFailed("Biller $Biller Saved Failed with consumer number $ConsumerNumber")
	CustomKeywords.'myPack.WriteExcel.writeResult'(SheetName, rowNum, "Biller $Biller Saved Failed with consumer number $ConsumerNumber", filePath)
}

WebUI.callTestCase(findTestCase('Utilities/Logout'), [:], FailureHandling.CONTINUE_ON_FAILURE)

