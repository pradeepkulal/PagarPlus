package com.mwbtech.PagarPlusApp;

import org.testng.annotations.Test;

public class AttendanceScreenTest extends BaseTest{
  @Test(enabled = false)
  public void AttendaanceWithBranchVisitAndFirstHalf() throws Exception, InterruptedException {
	  ConfigureAppium();
	  doLogIn(driver, "9639639638", "123456");
	  AttendanceScreen AScrn = new AttendanceScreen(driver);
	  AScrn.clickSIdeMenu();
	  String BranchName = AScrn.getFirmName();
	  AScrn.clickAttendanceBtn();
	  AScrn.selectAttendanceType(BranchName+" visit","First Half" , BranchName);
	  AScrn.takePhoto(driver);
	  AScrn.clickCheckIn();
  //done
  
  
  }
  @Test
  public void AttendaanceWithLocalVisitAndWholeDay() throws Exception, InterruptedException {
	  ConfigureAppium();
	  doLogIn(driver, "8660656358", "123456");
	  AttendanceScreen AScrn = new AttendanceScreen(driver);
	  AScrn.clickSIdeMenu();
	  String BranchName = AScrn.getFirmName();
	  AScrn.clickAttendanceBtn();
	  AScrn.selectAttendanceType("Outstation visit","Second Half" , BranchName);
	 // AScrn.selectAttendanceType(BranchName+" visit","First Half" , BranchName);
	  AScrn.takePhoto(driver);
	  AScrn.clickCheckIn();
	  
  //done
  
  
  }
  @Test(enabled = false)
  public void AttendaanceWithOutstationVisitAndSecondHalf() throws Exception, InterruptedException {
	  ConfigureAppium();
	  doLogIn(driver, "8660656356", "123456");
	  AttendanceScreen AScrn = new AttendanceScreen(driver);
	  AScrn.clickSIdeMenu();
	  String BranchName = AScrn.getFirmName();
	  AScrn.clickAttendanceBtn();
	  AScrn.selectAttendanceType("Outstation Visit","Second Half" , BranchName);
	  AScrn.takePhoto(driver);
	  AScrn.clickCheckIn();
	  AScrn.clickBackBtn();
	  
	  
  //done
  
  
  }
}
