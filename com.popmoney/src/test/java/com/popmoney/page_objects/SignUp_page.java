package com.popmoney.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.popmoney.utilities.CommonUtiles;

public class SignUp_page {
	
	private static SignUp_page SignupPageInstance;
	
	private SignUp_page() {
		
	}
	public static SignUp_page getInstance() {
		
		if (SignupPageInstance == null) {
			SignupPageInstance =new SignUp_page();	
		}
		return SignupPageInstance;	
	}
	
	
	@FindBy(id = "main-form:phone-number:phone-number")
	private WebElement PHONE_NUMBER;
	
	@FindBy(id = "main-form:password")
	private WebElement PASSWORD;
	
	@FindBy(id = "main-form:repassword")
	private WebElement RE_PASSWORD;
	
	@FindBy(id = "main-form:business-check")
	private WebElement BUSINESS_CHECK;
	
	@FindBy(id = "main-form:business-name:business-name")
	private WebElement BUSINESS_NAME;
	
	@FindBy(id = "main-form:address1:address1")
	private WebElement ADDRESS_1;
	
	@FindBy(id = "main-form:city:city")
	private WebElement CITY;
	
	@FindBy(id = "main-form:state")
	private WebElement STATE;
	
	@FindBy(id = "main-form:zip:zip")
	private WebElement ZIP;
	
	@FindBy(id = "main-form:birthday-month:birthday-month")
	private WebElement BIRTH_MONTH;
	
	@FindBy(id = "main-form:birthday-day:birthday-day")
	private WebElement BIRTH_DAY;
	
	@FindBy(id = "main-form:birthday-year:birthday-year")
	private WebElement BIRHT_YEAR;
	
	@FindBy(name = "main-form:j_idt395")
	private WebElement POLICY;
	
	@FindBy(id = "main-form:signup")
	private WebElement SIGNUP;

//	public  WebElement getPHONE_NUMBER() {
//		return PHONE_NUMBER;
//	}
//	public  WebElement getPASSWORD() {
//		return PASSWORD;
//	}
//	public  WebElement getRE_PASSWORD() {
//		return RE_PASSWORD;
//	}
//	public  WebElement getBUSINESS_CHECK() {
//		return BUSINESS_CHECK;
//	}
//	public  WebElement getBUSINESS_NAME() {
//		return BUSINESS_NAME;
//	}
//	public  WebElement getADDRESS_1() {
//		return ADDRESS_1;
//	}
//	public  WebElement getCITY() {
//		return CITY;
//	}
	public WebElement getSTATE() {
		return STATE;
	}
//	public  WebElement getZIP() {
//		return ZIP;
//	}
//	public  WebElement getBIRTH_MONTH() {
//		return BIRTH_MONTH;
//	}
//	public  WebElement getBIRTH_DAY() {
//		return BIRTH_DAY;
//	}
//	public  WebElement getBIRHT_YEAR() {
//		return BIRHT_YEAR;
//	}
//	public  WebElement getPOLICY() {
//		return POLICY;
//	}
//	public  WebElement getSIGNUP() {
//		return SIGNUP;
//	}
	
	public void enterPhoneNo(String phoneNo) {
		CommonUtiles.getInstance().highLightElement(PHONE_NUMBER);
		PHONE_NUMBER.sendKeys(phoneNo);
	}
	public void enterPassword(String password) {
		CommonUtiles.getInstance().highLightElement(PASSWORD);
		PASSWORD.sendKeys(password);
	}
	public void enterRePassword(String password) {
		CommonUtiles.getInstance().highLightElement(RE_PASSWORD);
		RE_PASSWORD.sendKeys(password);
	}
	public void clickBussinesscheck() {
		CommonUtiles.getInstance().highLightElement(BUSINESS_CHECK);
		BUSINESS_CHECK.click();
	}
	public void enterBussinessName(String bussinessName) {
		CommonUtiles.getInstance().highLightElement(BUSINESS_NAME);
		BUSINESS_NAME.sendKeys(bussinessName);
	}
	public void enterAddress1(String Address1) {
		CommonUtiles.getInstance().highLightElement(ADDRESS_1);
		ADDRESS_1.sendKeys(Address1);
	}
	public void enterCity(String city) {
		CommonUtiles.getInstance().highLightElement(CITY);
		CITY.sendKeys(city);
	}
//	public Select selectState(String state) {
//		CommonUtiles.getInstance().highLightElement(STATE);
//		Select select = new Select(STATE);
//		select.selectByVisibleText(state);
//		
//		return select;
//	}
	public void enterZip(String zip) {
		CommonUtiles.getInstance().highLightElement(ZIP);
		ZIP.sendKeys(zip);
	}
	public void enterBirthDay(String birthday) {
		CommonUtiles.getInstance().highLightElement(BIRTH_DAY);
		BIRTH_DAY.sendKeys(birthday);
	}
	public void enterBirthMonth(String birthmonth) {
		CommonUtiles.getInstance().highLightElement(BIRTH_MONTH);
		BIRTH_MONTH.sendKeys(birthmonth);
	}
	public void enterBirthyear(String birthyear) {
		CommonUtiles.getInstance().highLightElement(BIRHT_YEAR);
		BIRHT_YEAR.sendKeys(birthyear);
	}
	public void clickPolicy() {
		CommonUtiles.getInstance().highLightElement(POLICY);
		POLICY.click();
	}
	public void clickSignUp() {
		CommonUtiles.getInstance().highLightElement(SIGNUP);
		SIGNUP.click();
	}
	
}
