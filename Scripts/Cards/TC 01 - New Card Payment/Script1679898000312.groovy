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

int rowNum = rowNum.toInteger() + 1

while (Mobile.verifyElementNotExist(findTestObject('2.Dashboard/Cards/tab_Cards'), 2, FailureHandling.OPTIONAL)) {
    Mobile.swipe(135, 200, 135, 2000)

    Mobile.waitForElementPresent(findTestObject('2.Dashboard/Accounts/AccountDetails'), 60)
}

Mobile.tap(findTestObject('3.Payments/Payments_page/tab_PAY'), 0)

Mobile.tap(findTestObject('2.Dashboard/Cards/tab_Cards'), 0)

if (NewCardPayment.toString().equals('yes')) {
    Mobile.tap(findTestObject('5. Cards/button_New Card'), 0)

    WebUI.delay(2)

    Mobile.tap(findTestObject('5. Cards/texBox_Credit Card Number'), 0)

    Mobile.setText(findTestObject('5. Cards/texBox_Credit Card Number'), CreditCardNumber, 0)

    Mobile.pressBack()

    Mobile.tap(findTestObject('5. Cards/button_Verify'), 0)

    Mobile.waitForElementPresent(findTestObject('5. Cards/button_Next'), 60, FailureHandling.OPTIONAL)

    Mobile.takeScreenshot()

    Mobile.tap(findTestObject('5. Cards/button_Next'), 0)
} else {
    WebUI.callTestCase(findTestCase('Utilities/Card Selection Based on CardNumber'), [('cardLastFourDigits') : CardLastFourDigits], 
        FailureHandling.STOP_ON_FAILURE)

    Mobile.waitForElementPresent(findTestObject('5. Cards/Label_Pay from'), 60)
}

WebUI.callTestCase(findTestCase('Utilities/Account Selection Based on AccountNumber - Copy'), [('accountNumber') : AccountNumber], 
    FailureHandling.OPTIONAL)

Mobile.waitForElementPresent(findTestObject('5. Cards/textBox_Amount'), 0, FailureHandling.OPTIONAL)

Mobile.tap(findTestObject('5. Cards/textBox_Amount'), 2, FailureHandling.OPTIONAL)

WebUI.callTestCase(findTestCase('Utilities/KeyboardFunction'), [('text') : Amount], FailureHandling.STOP_ON_FAILURE)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('3.Payments/Amount/Button_Next'), 2, FailureHandling.OPTIONAL)

Mobile.waitForElementPresent(findTestObject('3.Payments/Payment Confirmation Page/Button_Confirm'), 0)

Mobile.tap(findTestObject('3.Payments/Payment Confirmation Page/Button_Confirm'), 0)

WebUI.delay(5)

Mobile.tapAtPosition(137, 771)

//Mobile.tapAtPosition(137, 771)
WebUI.callTestCase(findTestCase('Utilities/Enter_mPIN'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('3.Payments/Payment Confirmation Page/Button_Verify'), 0)

Mobile.waitForElementPresent(findTestObject('3.Payments/Payment Success page/Button_Back To Payment'), 180)

Mobile.takeScreenshot()

if (Mobile.verifyElementExist(findTestObject('3.Payments/Payment Success page/Button_Share'), 5, FailureHandling.CONTINUE_ON_FAILURE)) {
    content = Mobile.getAttribute(findTestObject('3.Payments/Payment Success page/label_SuccessPage'), 'contentDescription', 
        0)

    println(content)

    String[] line = content.split('\\R')

    ActualResult = content

    println(line[0])

    if (Amount == (line[0])) {
        KeywordUtil.markPassed("Card Payment Successfully")

        CustomKeywords.'myPack.WriteExcel.writeResult'(SheetName, rowNum, ActualResult, filePath)
    } else {
        KeywordUtil.markFailed("Card Payment Faild")

        CustomKeywords.'myPack.WriteExcel.writeResult'(SheetName, rowNum, ActualResult, filePath)
    }
} else {
    KeywordUtil.markFailed("Card Payment Faild")
}

Mobile.tap(findTestObject('3.Payments/Payment Success page/Button_Back To Payment'), 0)

WebUI.callTestCase(findTestCase('Utilities/Logout - Copy'), [:], FailureHandling.CONTINUE_ON_FAILURE)

