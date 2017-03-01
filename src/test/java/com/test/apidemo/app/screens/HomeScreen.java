package com.test.apidemo.app.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends AbstractScreen {

	@AndroidFindBy(accessibility = "App")
	private WebElement appMenuItem;

	public HomeScreen(AppiumDriver driver) {
		super(driver);
	}

	public AppMenuScreen getAppMenuPage() {
		appMenuItem.click();
		return new AppMenuScreen(driver);
	}
}
