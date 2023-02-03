package com.mwbtech.PagarPlusApp;

import java.util.HashMap;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.Immutable;
import com.wbtech.PagarPlus.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.KeyEvent;
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

	
	// xpath of element //element_tag[@attribute_name='attribute_value']

	
	
	//Methods on located Elements
	public void clickAttendanceBtn() {
		myAttendanceBtn.click();
	}
	public void selectAttendanceType(String visitType, String attendanceType, String branchName) {
		if (visitType.equalsIgnoreCase(branchName+" Visit")  && attendanceType.equalsIgnoreCase("First Half")) {
			System.out.println("Default is selected");
		}
		else if (visitType.equalsIgnoreCase(branchName+" Visit")  && attendanceType.equalsIgnoreCase("Second Half")) {
			firstHalfbtn.click();
			secondHalfbtn.click();
		}
		else if (visitType.equalsIgnoreCase(branchName+" Visit")  && attendanceType.equalsIgnoreCase("Whole Day")) {
			firstHalfbtn.click();
			wholeDaybtn.click();
		}
		else if	(visitType.equalsIgnoreCase("Local Visit")  && attendanceType.equalsIgnoreCase("First Half")) {
			branchVisitbtn.click();
			localVisitbtn.click();
			
		}
		else if (visitType.equalsIgnoreCase("Local Visit")  && attendanceType.equalsIgnoreCase("Second Half")) {
			branchVisitbtn.click();
			localVisitbtn.click();
			firstHalfbtn.click();
			secondHalfbtn.click();
		} 
		else if(visitType.equalsIgnoreCase("Local Visit")  && attendanceType.equalsIgnoreCase("Whole Day")) {
			System.out.println("Local visit and Whole Day is selected");
			branchVisitbtn.click();
			localVisitbtn.click();
			firstHalfbtn.click();
			wholeDaybtn.click();
			System.out.println("Local visit and Whole Day is selected");
		}
		else if	(visitType.equalsIgnoreCase("Outstation Visit")  && attendanceType.equalsIgnoreCase("First Half")) {
			branchVisitbtn.click();
			outstationVisitbtn.click();
			
		}
		else if (visitType.equalsIgnoreCase("Outstation Visit")  && attendanceType.equalsIgnoreCase("Second Half")) {
			branchVisitbtn.click();
			outstationVisitbtn.click();
			firstHalfbtn.click();
			secondHalfbtn.click();
		} 
		else if(visitType.equalsIgnoreCase("Outstation Visit")  && attendanceType.equalsIgnoreCase("Whole Day")) {
			branchVisitbtn.click();
			outstationVisitbtn.click();
			firstHalfbtn.click();
			wholeDaybtn.click();
		}
		else {
			System.out.println("Enter Valid Visit type and Attendance type");
		}
	}
	
	public void takePhoto(AndroidDriver driver) throws InterruptedException {
		cameraBtn.click();
		takePictureBtn.click();
//		Actions act = new Actions(driver);
//		act.moveToElement(attendanceDetailsBtn, 0, 0);
//		act.moveByOffset(292, 1270).click().build().perform();
//		cameraShutterBtn.click();
		
//		HashMap<String, Double> map = new HashMap<String, Double>();
//		map.put("x", 0.5);
//		map.put("y", 0.9);
//		(driver).executeScript("mobile : tap",map);
//		if (driver instanceof JavascriptExecutor) {
//			((JavascriptExecutor) driver).executeScript("el = document.elementFromPoint(0.5 , 0.9); el.click();");
//		}
		Thread.sleep(5000);
//		doneBtn.click();
		
		driver.executeScript("mobile: longClickGesture", ImmutableMap.of("x",365,"y",1381,"duration",1000));
		Thread.sleep(5000);
		driver.executeScript("mobile: longClickGesture", ImmutableMap.of("x",535,"y",1380,"duration",1000));
		
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
	public String clickBackBtn() {
		return backtbtn.getText();
	}
	

}
