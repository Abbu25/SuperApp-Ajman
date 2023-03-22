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


char ch;
AndroidDriver<?> driver = MobileDriverFactory.getDriver()
for(int i=0;i<text.length();i++) {
	ch=text.charAt(i)
		
	switch(ch) {
		
		case '0': driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0))
		       
				break
		
		case '1': driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1))
		       
				break
								
		case '2': driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2))
		        
				break
				
		case '3': driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3))
		        
				break
				
		case '4': driver.pressKey(new KeyEvent(AndroidKey.DIGIT_4))
	
				break
				
		case '5': driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5))
		       
				break
		
		case '6': driver.pressKey(new KeyEvent(AndroidKey.DIGIT_6))
				break
				
		case '7': driver.pressKey(new KeyEvent(AndroidKey.DIGIT_7))
				break
				
		case '8': driver.pressKey(new KeyEvent(AndroidKey.DIGIT_8))
				break
				
		case '9': driver.pressKey(new KeyEvent(AndroidKey.DIGIT_9))
				break
	}
	
	
}