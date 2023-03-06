package com.mwbtech.PagarPlusApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.wbtech.PagarPlus.utils.AndroidActions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CreateEmployeeScreen extends AndroidActions {
	AndroidDriver driver;

	public CreateEmployeeScreen(AndroidDriver driver) {
		super(driver); // Points to the driver of super class i.e. AndroidActions.java
		this.driver = driver; // driver is initiated to driver of this class(CreateEmployeeScreen.java)
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	// Locate all the elements in Create Employee screen
		@AndroidFindBy(id = "com.pagarplus.app:id/btnCreateEmployeeOne")
		private WebElement createEmpBtn;
		
		@AndroidFindBy (id = "com.pagarplus.app:id/fabCreate")
		private WebElement  createEmpIcon;
		
		@AndroidFindBy (id = "com.pagarplus.app:id/etEdtTxtfirstname")
		private WebElement  firstNameField;
		
		@AndroidFindBy (id = "com.pagarplus.app:id/etEdtTxtlastname")
		private WebElement  lastNameField;
		
		@AndroidFindBy (id = "com.pagarplus.app:id/etEdtTxtmobileNo")
		private WebElement mobileNoTxtField ;
		
		@AndroidFindBy (id = "com.pagarplus.app:id/etEdtTxtfirstname")
		private WebElement  AddressTxtField;
		
		@AndroidFindBy (id = "com.pagarplus.app:id/etEdtTxtState")
		private WebElement  stateTxtField;
		
		@AndroidFindBy (id = "com.pagarplus.app:id/etEdtTxtCiity")
		private WebElement  cityTxtField;
		
		@AndroidFindBy (id = "com.pagarplus.app:id/etEdtTxtSalary")
		private WebElement  salaryTxtField; 
		@AndroidFindBy (id = "com.pagarplus.app:id/etEdtTxtBloodGroup")
		private WebElement  bloodGrpTxtField;
		
		@AndroidFindBy (id = "com.pagarplus.app:id/etEdtTxtPwd")
		private WebElement  pwdTxtField;
		
		@AndroidFindBy (id = "com.pagarplus.app:id/etEdtTxtcnfPwd")
		private WebElement  confPwdTxtField;
		
		@AndroidFindBy (id = "com.pagarplus.app:id/btnSubmit")
		private WebElement  submitBtn;
		@AndroidFindBy (id = "com.pagarplus.app:id/etEdtTxtEmergencynum")
		private WebElement  emergenctNumField;
		public void navigateToCreateEmpScreen() {
			createEmpBtn.click();
			createEmpIcon.click();
		}
		
		public void enterFirstName(String firstName) {
			firstNameField.sendKeys(firstName);
		}
		
		public void enterSecondName(String lastName) {
			lastNameField.sendKeys(lastName);
		}
		
		public void enterMobileNum(String mobileNum) {
			mobileNoTxtField.sendKeys(mobileNum);
		}
		
		public void enterAddress(String address) {
			AddressTxtField.sendKeys(address);
		}
		
		public void selectState(AndroidDriver driver) {
			stateTxtField.click();
			driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Karnataka\"));"));
			driver.findElement(By.xpath("//android.widget.TextView[@text='Karnataka']")).click();
			
		}
		public void enterSalary(String salary) {
			salaryTxtField.sendKeys(salary);
		}
		public void selectWeekOff() {
			
		}
		public void enterBloodGroup(String bldGrp) {
			bloodGrpTxtField.sendKeys(bldGrp);
		}
		public void enterGuardianName(String emergencyNum) {
			emergenctNumField.sendKeys(emergencyNum);
			
		}
		public void enterPasswrd(String pwd) {
			pwdTxtField.sendKeys(pwd);
		}
		
		public void enterConfirmPasswrd(String confPwd) {
			confPwdTxtField.sendKeys(confPwd);
		}
		public void clickSubmit() {
			submitBtn.click();
		}
		
	
	

}
