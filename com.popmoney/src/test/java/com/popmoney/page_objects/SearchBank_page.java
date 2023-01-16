package com.popmoney.page_objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.popmoney.utilities.CommonUtiles;

public class SearchBank_page {
	
	private static final Logger LOGGER = LogManager.getLogger(SearchBank_page.getInstance());
	
	private static SearchBank_page SearchBankPage;
	
	private SearchBank_page() {	
	}
	public static SearchBank_page getInstance() {
	
		if (SearchBankPage == null) {
			SearchBankPage = new SearchBank_page();	
		}
		return SearchBankPage;	
	}
	
	
	@FindBy(id = "main-form:j_idt34:bank-search-name")
	private WebElement ENTER_BANK_NAME;
		
	@FindBy(partialLinkText = "Ally Bank")
	private WebElement ALLY_BANK;
	
	@FindBy(partialLinkText = "Bank of America")
	private WebElement BANK_OF_AMERICA;
	
	@FindBy(partialLinkText = "TD Bank")
	private WebElement TD_BANK;
	
	@FindBy(partialLinkText = "Citibank")
	private WebElement CITYBANK;
	
	@FindBy(partialLinkText = "Fifth Third Bank")
	private WebElement FIFTH_THIRD_BANK;
	
	@FindBy(partialLinkText = "PNC Bank, N.A.")
	private WebElement PNC_BANK;
	
	@FindBy(partialLinkText = "Regions Bank")
	private WebElement REGIONS_BANK;
	
	@FindBy(partialLinkText = "SunTrust Bank")
	private WebElement SUNTRUST_BANK;
	
	@FindBy(partialLinkText = "US Bank")
	private WebElement US_BANK;
	
	@FindBy(id = "main-form:bank10")
	private WebElement RETURN_BANK_SELECTION;
	
	@FindBy(id = "main-form:log-in")
	private WebElement LOGIN;

	
//	public WebElement getENTER_BANK_NAME() {
//		return ENTER_BANK_NAME;
//	}
//
//	public WebElement getALLY_BANK() {
//		return ALLY_BANK;
//	}
//
//	public WebElement getLOGIN() {
//		return LOGIN;
//	}
	public void bankSelection(String bankName) {
		switch (bankName) {
		case "Ally Bank":
			CommonUtiles.getInstance().highLightElement(ALLY_BANK);
			ALLY_BANK.click();
			break;
		case "TD Bank":
			CommonUtiles.getInstance().highLightElement(TD_BANK);
			TD_BANK.click();
			break;
		case "US Bank":
			CommonUtiles.getInstance().highLightElement(US_BANK);
			US_BANK.click();
			break;
		case "Regions Bank":
			CommonUtiles.getInstance().highLightElement(REGIONS_BANK);
			REGIONS_BANK.click();
			break;
		case "Suntrust Bank":
			CommonUtiles.getInstance().highLightElement(SUNTRUST_BANK);
			SUNTRUST_BANK.click();
			break;
		case "Fifth Third Bank":
			CommonUtiles.getInstance().highLightElement(FIFTH_THIRD_BANK);
			FIFTH_THIRD_BANK.click();
			break;
		case "City Bank":
			CommonUtiles.getInstance().highLightElement(CITYBANK);
			CITYBANK.click();
			break;
		case "PNC Bank":
			CommonUtiles.getInstance().highLightElement(PNC_BANK);
			PNC_BANK.click();
			break;
		case "Bank of America":
			CommonUtiles.getInstance().highLightElement(BANK_OF_AMERICA);
			BANK_OF_AMERICA.click();
			break;
		default:
			LOGGER.info("Please provide valid bank names. Valid selections are: Ally Bank,Bank of America,TD Bank,Suntrust Bank,City Bank,PNC Bank,US Bank,Fifth Third Bank");
			break;
		}
	}
	
//	public void bankSelection(String bankName) {
//		if (bankName.contains("Ally Bank")) {
//			DriverManager.getDriver().findElement(By.partialLinkText(bankName)).click();	
//		} 
//		else if (bankName.contains("TD Bank")) {
//			DriverManager.getDriver().findElement(By.partialLinkText(bankName)).click();	
//		}else {
//			LOGGER.info("Please provide valid bank names. Valid selections are: Ally Bank,Bank of America,TD Bank");
//		}		
//	}	
}
	
