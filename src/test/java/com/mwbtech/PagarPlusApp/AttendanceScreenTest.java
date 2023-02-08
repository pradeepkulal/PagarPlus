package com.mwbtech.PagarPlusApp;

import org.testng.annotations.Test;

public class AttendanceScreenTest extends BaseTest{
  @Test(priority = 0)
  public void AttendaanceWithBranchVisitAndFirstHalf() throws Exception, InterruptedException {
	  ConfigureAppium();
	  doLogIn(driver, "9687556666", "123456");
	  AttendanceScreen AScrn = new AttendanceScreen(driver);
	  AScrn.clickSIdeMenu();
	  String BranchName = AScrn.getFirmName();
	  AScrn.clickAttendanceBtn();
	  AScrn.selectAttendanceType(BranchName+" visit","Whole day" , BranchName,driver);
	  AScrn.takePhoto(driver);
	  AScrn.clickCheckIn();
	  String ActualToast = AScrn.getToastText();
	  System.out.println(ActualToast);
	  AScrn.clickBackBtn();
	  
	  doLogout(driver);
  //done
  
  
  }
  @Test(priority = 1)
  public void AttendaanceWithLocalVisitAndWholeDay() throws Exception, InterruptedException {
	  doLogIn(driver, "9481126661", "Divya@1");
	  AttendanceScreen AScrn = new AttendanceScreen(driver);
	  AScrn.clickSIdeMenu();
	  String BranchName = AScrn.getFirmName();
	  AScrn.clickAttendanceBtn();
	  AScrn.selectAttendanceType("Outstation visit","First Half" , BranchName,driver);
	 // AScrn.selectAttendanceType(BranchName+" visit","First Half" , BranchName);
	  AScrn.takePhoto(driver);
	  AScrn.clickCheckIn();
	  AScrn.clickBackBtn();
	  doLogout(driver);
	  
  //done
  
  
  }
  @Test(priority = 2)
  public void AttendaanceWithOutstationVisitAndSecondHalf() throws Exception, InterruptedException {
	  doLogIn(driver, "8796543210", "123456");
	  AttendanceScreen AScrn = new AttendanceScreen(driver);
	  AScrn.clickSIdeMenu();
	  String BranchName = AScrn.getFirmName();
	  AScrn.clickAttendanceBtn();
	  AScrn.selectAttendanceType("Outstation Visit","Second Half" , BranchName,driver);
	  AScrn.takePhoto(driver);
	  AScrn.clickCheckIn();
	  AScrn.clickBackBtn();
	  doLogout(driver);
	  
	  
  //done
  
  
  }
}
