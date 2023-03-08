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

Mobile.startExistingApplication('com.cbt.ajmandigital', FailureHandling.CONTINUE_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('1.Registration and Login/Welcome Page/button_Already a Customer'), 60)

Mobile.tap(findTestObject('1.Registration and Login/Welcome Page/button_Already a Customer'), 0)

Mobile.waitForElementPresent(findTestObject('1.Registration and Login/Card Details Page/Radio Button_Debit Card'), 0)

Mobile.tap(findTestObject('1.Registration and Login/Registration with Accounts/Button_ I dont have a card'), 0)

Mobile.tap(findTestObject('1.Registration and Login/Registration with Accounts/Button_ I dont have a card'), 0)

Mobile.waitForElementPresent(findTestObject('1.Registration and Login/Registration with Accounts/TextBox_Emirates ID'), 
    0)

Mobile.tap(findTestObject('1.Registration and Login/Registration with Accounts/TextBox_Emirates ID'), 0)

Mobile.setText(findTestObject('1.Registration and Login/Registration with Accounts/TextBox_Emirates ID'), emirates_ID, 0)

Mobile.setText(findTestObject('1.Registration and Login/Registration with Accounts/TextBox_AccountNumber'), accountNumber, 
    0)

Mobile.tap(findTestObject('1.Registration and Login/Registration with Accounts/Text Box_Mobile Number'), 0)

Mobile.sendKeys(findTestObject('1.Registration and Login/Registration with Accounts/Text Box_Mobile Number'), mobileNumber, 
    FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('1.Registration and Login/Registration with Accounts/Button_NEXT'), 0)

