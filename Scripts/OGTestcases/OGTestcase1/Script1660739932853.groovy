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
import ogkeywords.GeneralLibrary as GeneralLibrary
import org.openqa.selenium.Keys as Keys

GeneralLibrary.startAndLoginToOGApp(GlobalVariable.OGUserName, GlobalVariable.OGPassword)

GeneralLibrary.navigateToItemsPage()

GeneralLibrary.addItem(itemName, itemNameAr)

String actualItemArName = GeneralLibrary.getItemDetails(itemName, "ItemNameAr")
String createdDate = GeneralLibrary.getItemDetails(itemName, "CreatedDate")
String amountType = GeneralLibrary.getItemDetails(itemName, "ItemType")

WebUI.verifyEqual(actualItemArName, itemNameAr)
WebUI.verifyEqual(createdDate, "8/17/2022")
WebUI.verifyEqual(amountType, "Open")

WebUI.closeBrowser()

