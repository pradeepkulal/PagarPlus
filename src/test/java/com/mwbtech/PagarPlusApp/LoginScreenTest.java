package com.mwbtech.PagarPlusApp;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginScreenTest extends BaseTest {

	@Test(priority = 0)
	public void validMobileNoAndPasswordTest() throws Exception {
		ConfigureAppium();
		LoginScreen lp = new LoginScreen(driver);
		lp.setMobileNOField("8665577890");
		lp.setPasswordField("123456");
		lp.clickLoginBtn();
		boolean actualResult = lp.checkAttendanceEnabled();
		doLogout(driver);
		Assert.assertEquals(actualResult, true);
	}

	@Test(priority = 1)
	public void remebmberMeFunctionalityTest() {
		LoginScreen lp = new LoginScreen(driver);
		lp.setMobileNOField("8665577890");
		lp.setPasswordField("123456");
		lp.clickRememberMeCheckBox();
		lp.clickLoginBtn();
		doLogout(driver);
		String actualResult = lp.getTextOfMobileNo();
		assertEquals(actualResult, "8665577890");
	}

	@Test(priority = 2)
	public void validMobileNoAndInvalidPasswordTest() throws MalformedURLException, InterruptedException {
		LoginScreen lp = new LoginScreen(driver);
		lp.clearMobileNoField();
		lp.clearPasswordField();
		lp.setMobileNOField("8665577890");
		lp.setPasswordField("123");
		lp.clickLoginBtn();
		String actualText = lp.getText();

		assertEquals(actualText, "Invalid Password!!");
	}

	@Test(priority = 3)
	public void invalidMobileNoAndValidPasswordTest() throws MalformedURLException, InterruptedException {
		LoginScreen lp = new LoginScreen(driver);
		lp.clearMobileNoField();
		lp.clearPasswordField();
		lp.setMobileNOField("9108721776");
		lp.setPasswordField("1234");
		lp.clickLoginBtn();
		String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		System.out.println(toastMsg);
		assertEquals(toastMsg, "Login failed please confirm the Mobile Number");

	}

	@Test(priority = 4)
	public void invalidMobileNoAndInvalidPasswordTest() throws MalformedURLException, InterruptedException {
		LoginScreen lp = new LoginScreen(driver);
		lp.clearMobileNoField();
		lp.clearPasswordField();
		lp.setMobileNOField("9108hd8566");
		lp.setPasswordField("123");
		lp.clickLoginBtn();
		String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		System.out.println(toastMsg);
		assertEquals(toastMsg, "Login failed please confirm the Mobile Number pradeep");
	}

}
