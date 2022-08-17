package ogkeywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class GeneralLibrary {

	@Keyword
	def static void startAndLoginToOGApp(String userName, String password) {
		WebUI.openBrowser('')
		WebUI.navigateToUrl(GlobalVariable.OGUrl)
		WebUI.click(findTestObject('Object Repository/OGPages/Page_Og Business/input_UserName'))
		WebUI.setText(findTestObject('Object Repository/OGPages/Page_Og Business/input_UserName'), userName)
		WebUI.setText(findTestObject('Object Repository/OGPages/Page_Og Business/input_Password'), password)
		WebUI.click(findTestObject('Object Repository/OGPages/Page_Og Business/button_Sign In'))
	}

	@Keyword
	def static void navigateToItemsPage() {
		WebUI.click(findTestObject('Object Repository/OGPages/Page_Og Business/a_Items'))
		WebUI.click(findTestObject('Object Repository/OGPages/Page_Og Business/a_Items_1'))
	}

	@Keyword
	def static void addItem(String itemName, String itemArabicName) {
		WebUI.click(findTestObject('Object Repository/OGPages/Page_Og Business/button_Add Item'))
		WebUI.setText(findTestObject('Object Repository/OGPages/Page_Og Business/input_itemName'), itemName)
		WebUI.setText(findTestObject('Object Repository/OGPages/Page_Og Business/input_itemNameAr'), itemArabicName)
		WebUI.click(findTestObject('Object Repository/OGPages/Page_Og Business/btn_AddMerchantItem'))
		WebUI.click(findTestObject('Object Repository/OGPages/Page_Og Business/button_Ok'))
	}

	@Keyword
	def static String getItemDetails(String itemName, String colName) {
		String rowItemXpath = String.format("//*[@id='divGridComplaintsDetails']/div/div/table/tbody/tr/td[@data-name='ItemName' and contains(.,'%s')]/../td[@data-name='%s']", itemName, colName)
		println rowItemXpath
		TestObject testObject = new TestObject().addProperty("XPATH", ConditionType.EQUALS, rowItemXpath)
		return WebUI.getText(testObject)
	}
}
