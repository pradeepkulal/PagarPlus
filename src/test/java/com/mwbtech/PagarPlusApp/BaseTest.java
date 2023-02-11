package com.mwbtech.PagarPlusApp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTest {
	public AndroidDriver driver;
	public void startAppiumServer() {
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		String host = "localhost";
	      int port = 4723;
	      try (Socket socket = new Socket(host, port)) {
	         System.out.println("Mobile device is connected to port " + port);
	      } catch (Exception e) {
	         System.out.println("Mobile device is not connected to port " + port);
	      }
	}

	// to start the Appium Server
	public void ConfigureAppium() throws MalformedURLException, InterruptedException {
	

		// Launch the app in Mobile/Emulator
		UiAutomator2Options opt = new UiAutomator2Options();
		opt.setPlatformName("Android");
		opt.setCapability("appium:udid", "R58N345JQXY"); // emulator= emulator-5554 Samsung=5200c6ce8da77687 c SamTab=R9AR70ZLHSE
		Activity act = new Activity("com.pagarplus.app", ".modules.splashscreen.ui.SplashActivity");
		opt.setCapability(MobileCapabilityType.NO_RESET,"true");
		URL remoteUrl = new URL("http://127.0.0.1:4723/");
		driver = new AndroidDriver(remoteUrl, opt);
		driver.startActivity(act);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}

	public void tearDown() {
		driver.quit();

	}

	public static void takeSnapShot(AndroidDriver driver, String fileWithPath) throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}

	public static void doLogout(AndroidDriver driver) {

		driver.findElement(By.id("com.pagarplus.app:id/logOut")).click();
		driver.findElement(By.id("android:id/button1")).click();
		
		
		
	}

	public static void doLogIn(AndroidDriver driver, String phoneNum, String password) {
		driver.findElement(By.id("com.pagarplus.app:id/etUserid")).sendKeys(phoneNum);
		driver.findElement(By.id("com.pagarplus.app:id/etUserpassword")).sendKeys(password);
		driver.findElement(By.id("com.pagarplus.app:id/btnLogin")).click();
	}

}
