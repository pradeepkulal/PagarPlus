package com.wbtech.PagarPlus.utils;

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
	

}
