package com.mwbtech.PagarPlusApp;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;
import com.wbtech.PagarPlus.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AttendanceScreen extends AndroidActions {
	AndroidDriver driver;

	public AttendanceScreen(AndroidDriver driver) {
		super(driver); // Points to the driver of super class i.e. AndroidActions.java
		this.driver = driver; // driver is initiated to driver of this class(LoginPage.java)
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

// Locate all the elements in Attendance screen
	@AndroidFindBy(id = "com.pagarplus.app:id/txtAttendance")
	private WebElement myAttendanceBtn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Suraj Groups Visit']")
	private WebElement branchVisitbtn;
	

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Local Visit']")
	private WebElement localVisitbtn;

	@AndroidFindBy(id = "com.pagarplus.app:id/btnBack")
	private WebElement backtbtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Outstation Visit']")
	private WebElement outstationVisitbtn;
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='First Half']")
	private WebElement firstHalfbtn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Second Half']")
	private WebElement secondHalfbtn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Whole Day']")
	private WebElement wholeDaybtn;
	
	@AndroidFindBy(id = "com.pagarplus.app:id/squareImage")
	private WebElement cameraBtn;
	@AndroidFindBy(id = "com.pagarplus.app:id/text_camera")
	private WebElement takePictureBtn;
	@AndroidFindBy(id = "com.android.camera2:id/shutter_button")
	private WebElement cameraShutterBtn;
	
	@AndroidFindBy(id = "com.android.camera2:id/done_button")
	private WebElement doneBtn;
	
	@AndroidFindBy(id = "com.pagarplus.app:id/btnMyAttendance")
	private WebElement checkInbtn;
	@AndroidFindBy(xpath = "android.widget.Button[@text='Attendance Details']")
	private WebElement attendanceDetailsBtn;
	@AndroidFindBy(id = "com.pagarplus.app:id/imageMenu")
	private WebElement sideMenuBtn;
	@AndroidFindBy(id = "com.pagarplus.app:id/txtFirmName")
	private WebElement firmName;
	@AndroidFindBy(xpath = ("(//android.widget.FrameLayout)[1]"))
	private WebElement toastMsg;
	
	// xpath of element //element_tag[@attribute_name='attribute_value']

	
	
	//Methods on located Elements
	public void clickAttendanceBtn() {
		myAttendanceBtn.click();
	}
	public void selectAttendanceType(String visitType, String attendanceType, String branchName,AndroidDriver driver) {
		if (visitType.equalsIgnoreCase(branchName+" Visit")  && attendanceType.equalsIgnoreCase("Whole day")) {
			System.out.println("Default is selected");
		}
		else if (visitType.equalsIgnoreCase(branchName+" Visit")  && attendanceType.equalsIgnoreCase("Second Half")) {
			wholeDaybtn.click();
			secondHalfbtn.click();
		}
		else if (visitType.equalsIgnoreCase(branchName+" Visit")  && attendanceType.equalsIgnoreCase("First Half")) {
			wholeDaybtn.click();
			firstHalfbtn.click();
		
		}
		else if	(visitType.equalsIgnoreCase("Local Visit")  && attendanceType.equalsIgnoreCase("Whole day")) {
			clickOnScreen(driver, 370, 270);
			localVisitbtn.click();
			
		}
		else if (visitType.equalsIgnoreCase("Local Visit")  && attendanceType.equalsIgnoreCase("Second Half")) {
			clickOnScreen(driver, 370, 270);
			localVisitbtn.click();
			wholeDaybtn.click();
			secondHalfbtn.click();
		} 
		else if(visitType.equalsIgnoreCase("Local Visit")  && attendanceType.equalsIgnoreCase("Whole Day")) {
			System.out.println("Local visit and Whole Day is selected");
			clickOnScreen(driver, 370, 270);
			localVisitbtn.click();
			System.out.println("Local visit and Whole Day is selected");
		}
		else if	(visitType.equalsIgnoreCase("Outstation Visit")  && attendanceType.equalsIgnoreCase("First Half")) {
			clickOnScreen(driver, 370, 270);
			outstationVisitbtn.click();
			wholeDaybtn.click();
			firstHalfbtn.click();
			
			
		}
		else if (visitType.equalsIgnoreCase("Outstation Visit")  && attendanceType.equalsIgnoreCase("Second Half")) {
			clickOnScreen(driver, 370, 270);
			branchVisitbtn.click();
			outstationVisitbtn.click();
			wholeDaybtn.click();
			secondHalfbtn.click();
		} 
		else if(visitType.equalsIgnoreCase("Outstation Visit")  && attendanceType.equalsIgnoreCase("Whole Day")) {
			clickOnScreen(driver, 370, 270);
			outstationVisitbtn.click();
			firstHalfbtn.click();
			wholeDaybtn.click();
		}
		else {
			System.out.println("Enter Valid Visit type and Attendance type");
		}
	}
	
	public void takePhoto(AndroidDriver driver) throws Exception {
		cameraBtn.click();
		takePictureBtn.click();
		capturePhoto();
		 // 460 1489
		
	}
	
	public void clickCheckIn() {
		checkInbtn.click();
	}
	public void clickSIdeMenu() {
		sideMenuBtn.click();		
	}
	
	public String getFirmName() {
		return firmName.getText();
	}
	public void clickBackBtn() {
		backtbtn.click();
	}
	public String getToastText() {
		return toastMsg.getText();
	}
	

}
