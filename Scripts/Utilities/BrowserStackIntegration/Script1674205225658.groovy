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
import java.net.URL as URL
import java.util.List as List
import java.util.function.Function as Function
import java.net.MalformedURLException as MalformedURLException
import io.appium.java_client.MobileBy as MobileBy
import io.appium.java_client.android.AndroidDriver as AndroidDriver
import io.appium.java_client.android.AndroidElement as AndroidElement
import org.openqa.selenium.support.ui.ExpectedConditions as ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait as WebDriverWait
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.remote.DesiredCapabilities as DesiredCapabilities
import com.kms.katalon.core.appium.driver.AppiumDriverManager as AppiumDriverManager
import io.appium.java_client.ios.IOSDriver as IOSDriver
import com.kms.katalon.core.mobile.driver.MobileDriverType as MobileDriverType

DesiredCapabilities caps = new DesiredCapabilities()

// Set your access credentials
caps.setCapability('browserstack.user', 'akhilg_bcP6MO')

caps.setCapability('browserstack.key', 'RcXLz7Sh5mbzziaT81Jd')

// Set URL of the application under test
caps.setCapability('app', 'bs://8e1bdaf1e2220e857eeee2a8c8d2d59f4ba08396')

// Specify device and os_version for testing
caps.setCapability('device', 'Google Pixel 3')

caps.setCapability('os_version', '9.0')

// Set other BrowserStack capabilities
caps.setCapability('project', 'First Java Project')

caps.setCapability('build', 'browserstack-build-1')

caps.setCapability('name', 'first_test')

// Initialise the remote Webdriver using BrowserStack remote URL
// and desired capabilities defined above
//		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
//				new URL("http://hub.browserstack.com/wd/hub"), caps);
//			
AppiumDriverManager.createMobileDriver(MobileDriverType.ANDROID_DRIVER, caps, new URL('http://hub.browserstack.com/wd/hub'))



