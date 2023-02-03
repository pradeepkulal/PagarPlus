package com.mwbtech.PagarPlusApp;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;

import com.wbtech.PagarPlus.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen extends AndroidActions {

	AndroidDriver driver;

	public LoginScreen(AndroidDriver driver) {
		super(driver); // Points to the driver of super class i.e. AndroidActions.java
		this.driver = driver; // driver is initiated to driver of this class(LoginPage.java)
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// Locating all the Elements in Login Page
	@AndroidFindBy(id = "com.pagarplus.app:id/etUserid")
	private WebElement mobileNoField;
	@AndroidFindBy(id = "com.pagarplus.app:id/etUserpassword")
	private WebElement passwordField;
	@AndroidFindBy(id = "com.pagarplus.app:id/btnLogin")
	private WebElement loginBtn;
	@AndroidFindBy(id = "com.pagarplus.app:id/checkBoxRememberMe")
	private WebElement rememberMeCheckBox;
	@AndroidFindBy(id = "com.pagarplus.app:id/btnSignUp")
	private WebElement ownerSignupBtn;
	@AndroidFindBy(id = "com.pagarplus.app:id/btnMyAttendance")
	private WebElement attendanceText;
	@AndroidFindBy(xpath = ("(//android.widget.FrameLayout)[1]"))
	private WebElement toastMsg;
	@AndroidFindBy(id = "android:id/message")
	private WebElement errorText;
	@AndroidFindBy(id = "android:id/button3")
	private WebElement errorOkBtn;

	@AndroidFindBy(id = "com.pagarplus.app:id/imageMenu")
	private WebElement sideMenuBtn;
	@AndroidFindBy(id = "com.pagarplus.app:id/txtLogout")
	private WebElement logoutBtn;
	@AndroidFindBy(id = "id=android:id/button1")
	private WebElement logoutYesBtn;
	@AndroidFindBy(id = "com.pagarplus.app:id/txtScreenName")
	private WebElement oganizationDetailsText;
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	private WebElement permissionBtn;
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private WebElement foreGroundAllowBtn;
	@AndroidFindBy(id = "com.pagarplus.app:id/radioEnglish")
	private WebElement englishLangSelectBtn;

	// Methods that can be executed on the Elements located in the login screen
	public void setMobileNOField(String mobileNo) {
		mobileNoField.sendKeys(mobileNo);
	}

	public void setPasswordField(String password) {
		passwordField.sendKeys(password);
	}

	public void clickLoginBtn() {
		loginBtn.click();
	}

	public void clickRememberMeCheckBox() {
		try {
			if (!rememberMeCheckBox.isSelected()) {
				rememberMeCheckBox.click();
			}
		} catch (Exception e2) {
			System.out.println("Remember Me is Selected");
		}

	}

	public void clickRegisterNowBtn() {
		ownerSignupBtn.click();
	}

	public void clearMobileNoField() {
		mobileNoField.clear();
	}

	public void clearPasswordField() {
		passwordField.clear();
	}

	public void clickLogoutBtn() {
		logoutBtn.click();
		logoutYesBtn.click();

	}

	public String getText() {
		return gettextof(errorText);
	}

	public String getTextOfMobileNo() {
		return mobileNoField.getText();
	}

	public void clickSIdeMenu() {
		sideMenuBtn.click();
	}

	public boolean isOrganizationEnabled() {
		return isBtnEnabled(oganizationDetailsText);
	}

	public String getToastText() {
		return toastMsg.getText();
	}

	public boolean checkAttendanceEnabled() {
		return attendanceText.isEnabled();
	}

	public void clickAllowPermissionBtn1() {
		permissionBtn.click();
	}

	public void ClickAllowPermissionBtn2() {
		foreGroundAllowBtn.click();
	}

	public void selectEnglishLangBtn() {
		englishLangSelectBtn.click();
	}

}
