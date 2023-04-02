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



char ch

AndroidDriver<?> driver = MobileDriverFactory.getDriver()

text = text.toUpperCase()

for (int i = 0; i < text.length(); i++) {
    ch = text.charAt(i)

    switch (ch) {
        case 'A':
            driver.pressKey(new KeyEvent(AndroidKey.A))

            break
        case 'B':
            driver.pressKey(new KeyEvent(AndroidKey.B))

            break
        case 'C':
            driver.pressKey(new KeyEvent(AndroidKey.C))

            break
        case 'D':
            driver.pressKey(new KeyEvent(AndroidKey.D))

            break
        case 'E':
            driver.pressKey(new KeyEvent(AndroidKey.E))

            break
        case 'F':
            driver.pressKey(new KeyEvent(AndroidKey.F))

            break
        case 'G':
            driver.pressKey(new KeyEvent(AndroidKey.G))

            break
        case 'H':
            driver.pressKey(new KeyEvent(AndroidKey.H))

            break
        case 'I':
            driver.pressKey(new KeyEvent(AndroidKey.I))

            break
        case 'J':
            driver.pressKey(new KeyEvent(AndroidKey.J))

            break
        case 'K':
            driver.pressKey(new KeyEvent(AndroidKey.K))

            break
        case 'L':
            driver.pressKey(new KeyEvent(AndroidKey.L))

            break
        case 'M':
            driver.pressKey(new KeyEvent(AndroidKey.M))

            break
        case 'N':
            driver.pressKey(new KeyEvent(AndroidKey.N))

            break
        case 'O':
            driver.pressKey(new KeyEvent(AndroidKey.O))

            break
        case 'P':
            driver.pressKey(new KeyEvent(AndroidKey.P))

            break
        case 'Q':
            driver.pressKey(new KeyEvent(AndroidKey.Q))

            break
        case 'R':
            driver.pressKey(new KeyEvent(AndroidKey.R))

            break
        case 'S':
            driver.pressKey(new KeyEvent(AndroidKey.S))

            break
        case 'T':
            driver.pressKey(new KeyEvent(AndroidKey.T))

            break
        case 'U':
            driver.pressKey(new KeyEvent(AndroidKey.U))

            break
        case 'V':
            driver.pressKey(new KeyEvent(AndroidKey.V))

            break
        case 'W':
            driver.pressKey(new KeyEvent(AndroidKey.W))

            break
        case 'X':
            driver.pressKey(new KeyEvent(AndroidKey.X))

            break
        case 'Y':
            driver.pressKey(new KeyEvent(AndroidKey.Y))

            break
        case 'Z':
            driver.pressKey(new KeyEvent(AndroidKey.Z))

            break
        case ' ':
            driver.pressKey(new KeyEvent(AndroidKey.SPACE))

            break
    }
}

