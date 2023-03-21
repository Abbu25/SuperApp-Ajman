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

AndroidDriver<?> driver = MobileDriverFactory.getDriver()

Mobile.tap(findTestObject('4.Transfers/tab_Accounts'), 0)

Mobile.tap(findTestObject('4.Transfers/International/tab_Overseas'), 0)

Mobile.waitForElementPresent(findTestObject('4.Transfers/International/dropdown_Country'), 0)

WebUI.callTestCase(findTestCase('Utilities/Account Selection Based on AccountNumber'), [('accountNumber') : SelectAccount], 
    FailureHandling.OPTIONAL)

Mobile.tap(findTestObject('4.Transfers/International/dropdown_Country'), 0)

Mobile.tap(findTestObject('4.Transfers/International/textBox_Search'), 0)

Mobile.setText(findTestObject('4.Transfers/International/textBox_Search'), Contry, 0)

Mobile.tap(findTestObject('4.Transfers/International/Select Country From DropDown', [('country') : Contry]), 0)

Mobile.tap(findTestObject('4.Transfers/International/dropdown_Bank Name'), 0)

Mobile.tap(findTestObject('4.Transfers/International/textBox_Search'), 0)

Mobile.setText(findTestObject('4.Transfers/International/textBox_Search'), BankName, 0)

Mobile.tap(findTestObject('4.Transfers/International/Select Bank from DropDown', [('bankName') : BankName]), 0)

if (IBANNumber != '') {
    Mobile.tap(findTestObject('4.Transfers/International/textBox_ IBAN'), 0)

    Mobile.setText(findTestObject('4.Transfers/International/textBox_ IBAN'), IBANNumber, 0)

    driver.pressKey(new KeyEvent(AndroidKey.ENTER))
}

if (AccountNumber != '') {
    Mobile.tap(findTestObject('4.Transfers/International/textBox_Account Number'), 0)

    Mobile.setText(findTestObject('4.Transfers/International/textBox_Account Number'), AccountNumber, 0)

    driver.pressKey(new KeyEvent(AndroidKey.ENTER))
}

if (AccountHolderName != '') {
    Mobile.tap(findTestObject('4.Transfers/International/textBox_Account Holder Name'), 0)

    Mobile.setText(findTestObject('4.Transfers/International/textBox_Account Holder Name'), AccountHolderName, 0)

    driver.pressKey(new KeyEvent(AndroidKey.ENTER))
}

if (IFSCCode != '') {
    Mobile.tap(findTestObject('4.Transfers/International/textBox_IFSC Number'), 0)

    Mobile.setText(findTestObject('4.Transfers/International/textBox_IFSC Number'), IFSCCode, 0)

    driver.pressKey(new KeyEvent(AndroidKey.ENTER))
}

if (RoutingNumber != '') {
    Mobile.tap(findTestObject('4.Transfers/International/textBox_Routing Number'), 0)

    Mobile.setText(findTestObject('4.Transfers/International/textBox_Routing Number'), RoutingNumber, 0)

    driver.pressKey(new KeyEvent(AndroidKey.ENTER))
}

if (BankAddress != '') {
    Mobile.tap(findTestObject('4.Transfers/International/textBox_Bank Address'), 0)

    Mobile.setText(findTestObject('4.Transfers/International/textBox_Bank Address'), BankAddress, 0)

    driver.pressKey(new KeyEvent(AndroidKey.ENTER))
}

Mobile.takeScreenshot()

Mobile.tap(findTestObject('4.Transfers/Button_Next'), 0)

Mobile.tap(findTestObject('4.Transfers/Text Box_Amount'), 0)

Mobile.setText(findTestObject('4.Transfers/Text Box_Amount'), Amount, 0)

Mobile.tap(findTestObject('4.Transfers/Button_Next'), 0)

Mobile.waitForElementPresent(findTestObject('4.Transfers/UAE Bank/dropdown_Purpose'), 0)

if ((ChargesOption != '') && (ChargesOption != 'Shared by both')) {
    Mobile.tap(findTestObject('4.Transfers/International/dropDown_ChargesOption'), 0)

    Mobile.tap(findTestObject('4.Transfers/International/select_Item in Charges Option', [('option') : ChargesOption]), 
        0)
}

Mobile.tap(findTestObject('4.Transfers/International/dropdown_Purpose'), 0)

if (((((Purpose != 'Charitable Contributions') && (Purpose != 'Educational Support')) && (Purpose != 'Equated Monthly Installments')) && 
(Purpose != 'Family Support')) && (Purpose != 'Financial Services')) {
    Mobile.swipe(66, 2015, 66, 1300)

    Mobile.tap(findTestObject('4.Transfers/UAE Bank/select_Item in Purpose Dropdown', [('purpose') : Purpose]), 0)
} else {
    Mobile.tap(findTestObject('4.Transfers/UAE Bank/select_Item in Purpose Dropdown', [('purpose') : Purpose]), 0)
}

Mobile.takeScreenshot()

Mobile.tap(findTestObject('4.Transfers/Button_Next'), 0)

WebUI.delay(2)

Mobile.swipe(135, 1840, 447, 259)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('4.Transfers/Button_Confirm'), 0)

Mobile.waitForElementPresent(findTestObject('1.Registration and Login/mPIN Page/page_mPIN'), 0)

Mobile.tapAtPosition(137, 771)

WebUI.callTestCase(findTestCase('Utilities/Enter_mPIN'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('4.Transfers/Button_Verify mPIN'), 0)

WebUI.callTestCase(findTestCase('Utilities/Enter_OTP'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('4.Transfers/Button_VerifyOTP'), 0)

Mobile.waitForElementPresent(findTestObject('4.Transfers/Button_BackToPayment'), 180)

Mobile.takeScreenshot()

content = ''

if (Mobile.verifyElementExist(findTestObject('4.Transfers/International/Label_Inter_Success Page'), 5, FailureHandling.OPTIONAL)) {
    content = Mobile.getAttribute(findTestObject('4.Transfers/International/Label_Inter_Success Page'), 'contentDescription', 
        0)
} else {
	content= Mobile.getAttribute(findTestObject('4.Transfers/International/label_Faild Page'), 'contentDescription', 0)
}

println(content)

String[] line = content.split('\\R')

ActualResult = content

println(line[0])

println(Amount)

if (Amount == (line[0]) && line[3]!="Transfer Failed") {
    KeywordUtil.markPassed("Transfer To $Contry - $AccountNumber Successfull")

    CustomKeywords.'myPack.WriteExcel.writeResult'(SheetName, rowNum, ActualResult, filePath)
} else {
    KeywordUtil.markFailed("Transfer Failed to $Contry - $AccountNumber")

    CustomKeywords.'myPack.WriteExcel.writeResult'(SheetName, rowNum, ActualResult, filePath)
}

Mobile.tap(findTestObject('4.Transfers/Button_BackToPayment'), 0)

WebUI.callTestCase(findTestCase('Utilities/Logout'), [:], FailureHandling.STOP_ON_FAILURE)



