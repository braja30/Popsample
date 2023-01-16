package com.popmoney.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.popmoney.utilities.CommonUtiles;

public class Home_Page {

	private static Home_Page HomePageInstance;

	private Home_Page() {
	}
	public static Home_Page getInstance() {
		
		if (HomePageInstance == null) {
			HomePageInstance = new Home_Page();
		}
		return HomePageInstance;
	}

	//	PageFactory method
	// ------------------------
		@FindBy(name = "token")
		private WebElement EMAIL;
	
		@FindBy(id = "start")
		private WebElement START;
		
	// public WebElement getEMAIL() {
	// return EMAIL;
	// }
	//
	// public WebElement getSTART() {
	// return START;
	// }
	
	
	public void enterEmail(String email) {
		CommonUtiles.getInstance().highLightElement(EMAIL);
		EMAIL.sendKeys(email);
	}

	public void clickStart() {
		CommonUtiles.getInstance().highLightElement(START);
		START.click();
	}

}
