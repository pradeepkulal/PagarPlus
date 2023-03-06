package com.wbtech.PagarPlus.utils;

import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions {
	AndroidDriver driver;
	public AndroidActions(AndroidDriver driver) {
		this.driver = driver;
		
	}
	public void longPressActions(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: scrollGesture", 
		ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
	}
	public String gettextof(WebElement ele) {
		return ele.getText();
	}
	
	public boolean isBtnEnabled(WebElement ele) {
		return ele.isEnabled();
	}
	
	public void clickOnScreen(AndroidDriver driver ,int x,int y) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("x",x,"y",y,"duration",1000));
	}
	
	public void capturePhoto() throws Exception {
		Thread.sleep(5000);
		clickOnScreen(driver, 365, 1381);
		Thread.sleep(5000);
		try {
			clickOnScreen(driver, 460, 1489);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

}
