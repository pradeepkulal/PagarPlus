package com.wbtech.PagarPlus.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumUtils {
	public AppiumDriverLocalService startAppiumServer(String ipAddress, int port) {
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();

		 service.start(); 
		return service;
	}
	public void waitForElementToAppear(WebElement ele, AppiumDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains((ele),"text","Cart"));
	}
	public String getScreenShotPath(String testCaseName,AppiumDriver driver) throws IOException   {
	File source =	driver.getScreenshotAs(OutputType.FILE);
	String destinationFile =System.getProperty("user.dir")+"//reports"+testCaseName+".png";
	FileUtils.copyFile(source, new File(destinationFile));
	return destinationFile;
	}


}
