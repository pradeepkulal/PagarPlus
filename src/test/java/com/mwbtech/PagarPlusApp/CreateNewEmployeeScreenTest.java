package com.mwbtech.PagarPlusApp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class CreateNewEmployeeScreenTest extends BaseTest {
  @Test
  public void createEmployeePositiveScenario() {
	  doLogIn(driver, "8660656352", "123456");
	  CreateEmployeeScreen CEScreen = new CreateEmployeeScreen(driver);
	  CEScreen.navigateToCreateEmpScreen();
	  CEScreen.enterFirstName("Kartik");
	  CEScreen.enterSecondName("Kumar");
	  CEScreen.enterMobileNum("9900141100");
	  CEScreen.enterSalary("25000");
	  CEScreen.enterPasswrd("123456");
	  CEScreen.enterConfirmPasswrd("123456");
	  CEScreen.clickSubmit();
  }
  @BeforeClass
	public void BeforeClass() {
		startAppiumServer();
	}
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException, InterruptedException {
	  ConfigureAppium();
	  
  }
  

  @AfterMethod
  public void afterMethod() {
	  tearDown();
  }

}
