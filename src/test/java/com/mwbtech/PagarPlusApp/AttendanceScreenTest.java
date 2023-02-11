package com.mwbtech.PagarPlusApp;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AttendanceScreenTest extends BaseTest{
	@BeforeMethod
	public void BeforeTest() throws Exception, InterruptedException {
		startAppiumServer();
		ConfigureAppium();
	}
	
	@AfterMethod
	public void AfterTest() {
		tearDown();
	}
  @Test(enabled = false)
  public void AttendaanceWithBranchVisitAndFirstHalf() throws Exception, InterruptedException {
	  doLogIn(driver, "9636635877", "123456");
	  AttendanceScreen AScrn = new AttendanceScreen(driver);
	 String userName= AScrn.getUserName();
	  AScrn.clickAttendanceBtn();
	  AScrn.selectAttendanceType("Branch visit","First Half" ,driver);
	  AScrn.takePhoto(driver);
	  AScrn.clickCheckIn();
	  String ActualToast = AScrn.getToastText();
	  String ExpectedResult = "Hi "+userName+", you have checked-in successfully! Have a good day";
	  Assert.assertEquals(ActualToast, ExpectedResult);
	  AScrn.clickBackBtn();
	  doLogout(driver);
  //done
  
  
  }
  @Test(priority =1)
  public void AttendaanceWithLocalVisitAndWholeDay() throws Exception, InterruptedException {
	  doLogIn(driver, "9666547899", "123456");
	  AttendanceScreen AScrn = new AttendanceScreen(driver);
	  String userName= AScrn.getUserName();
	  AScrn.clickAttendanceBtn();
	  AScrn.selectAttendanceType("Outstation visit","Whole Day" ,driver);
	  AScrn.takePhoto(driver);
	  AScrn.clickCheckIn();
	  String ActualToast = AScrn.getToastText();
	  String ExpectedResult = "Hi "+userName+", you have checked-in successfully! Have a good day";
	  Assert.assertEquals(ActualToast, ExpectedResult);
	  AScrn.clickBackBtn();
	  doLogout(driver);
  //done
  
  
  }
  @Test(priority = 2)
  public void AttendaanceWithOutstationVisitAndSecondHalf() throws Exception, InterruptedException {
	  doLogIn(driver, "9666547890", "123456");
	  AttendanceScreen AScrn = new AttendanceScreen(driver);
	  String userName= AScrn.getUserName();
	  AScrn.clickAttendanceBtn();
	  AScrn.selectAttendanceType("Outstation Visit","Second Half" ,driver);
	  AScrn.takePhoto(driver);
	  AScrn.clickCheckIn();
	  String ActualToast = AScrn.getToastText();
	  String ExpectedResult = "Hi "+userName+", you have checked-in successfully! Have a good day";
	  Assert.assertEquals(ActualToast, ExpectedResult);
	  AScrn.clickBackBtn();
	  doLogout(driver);
  }
  @Test(priority = 3)
  public void AttendaanceWithOutstationVisitAndWholeDay() throws Exception, InterruptedException {
	  doLogIn(driver, "9666547891", "123456");
	  AttendanceScreen AScrn = new AttendanceScreen(driver);
	 String userName= AScrn.getUserName();
	  AScrn.clickAttendanceBtn();
	  AScrn.selectAttendanceType("Outstation Visit","Wholeday" ,driver);
	  AScrn.takePhoto(driver);
	  AScrn.clickCheckIn();
	  String ActualToast = AScrn.getToastText();
	  String ExpectedResult = "Hi "+userName+", you have checked-in successfully! Have a good day";
	  Assert.assertEquals(ActualToast, ExpectedResult);
	  AScrn.clickBackBtn();
	  doLogout(driver);
  //done
  
  
  }
  
}
