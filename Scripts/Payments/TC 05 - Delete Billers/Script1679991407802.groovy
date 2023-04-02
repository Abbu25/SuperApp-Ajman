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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.callTestCase(findTestCase('Utilities/Login'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('3.Payments/Payments_page/tab_PAY'), 0)

Mobile.tap(findTestObject('3.Payments/Payments_page/tab_Bills'), 0)

Mobile.tap(findTestObject('3.Payments/Manage Bills/link_Select My Bills'), 0)

Mobile.waitForElementPresent(findTestObject('3.Payments/Manage Bills/link_Manage Bills'), 0)

Mobile.tap(findTestObject('3.Payments/Manage Bills/link_Manage Bills'), 0)

Mobile.waitForElementPresent(findTestObject('3.Payments/Payments_page/tab_Bills'), 0)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('3.Payments/Save Bill/vrify_Saved Biller', [('biller') : Biller, ('consumerNumber') : ConsumerNumber]), 
    0)

Mobile.tap(findTestObject('3.Payments/Manage Bills/button_Delete'), 0)

Mobile.tap(findTestObject('3.Payments/Manage Bills/button_Sure in Delete Popup'), 0)

WebUI.delay(2)

Mobile.tapAtPosition(137, 771)

WebUI.callTestCase(findTestCase('Utilities/Enter_mPIN'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('3.Payments/Payment Confirmation Page/Button_Verify'), 0)

Mobile.waitForElementPresent(findTestObject('3.Payments/Payments_page/tab_Bills'), 0)

Mobile.takeScreenshot()

if (Mobile.verifyElementNotExist(findTestObject('3.Payments/Save Bill/vrify_Saved Biller', [('biller') : Biller, ('consumerNumber') : ConsumerNumber]), 
    2, FailureHandling.CONTINUE_ON_FAILURE)) {
    KeywordUtil.markPassed("Biller $Biller Deleted Successfully with consumer number $ConsumerNumber")
} else {
    KeywordUtil.markFailed("Biller $Biller Not Deleted with consumer number $ConsumerNumber")
}

WebUI.delay(5)

Mobile.tap(findTestObject('3.Payments/Manage Bills/button_Back'), 0)

WebUI.callTestCase(findTestCase('Utilities/Logout - Copy'), [:], FailureHandling.STOP_ON_FAILURE)

