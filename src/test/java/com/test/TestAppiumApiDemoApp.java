package com.test;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.apidemo.app.screens.AppActivityScreen;
import com.test.apidemo.app.screens.AppMenuScreen;
import com.test.apidemo.app.screens.HomeScreen;
import com.test.apidemo.app.screens.ScreenOrientationScreen;
import com.test.utils.AppUtils;

public class TestAppiumApiDemoApp {
	private AndroidDriver driver;
	private HomeScreen homeScreen;
	private AppMenuScreen appMenuPage;
	private AppActivityScreen appActivityPage;
	private ScreenOrientationScreen screenOrientationPage;
	private AppUtils appUtil;

	@BeforeClass(alwaysRun = true)
	public void startAutomation() throws IOException {
		appUtil = new AppUtils();
		appUtil.loadConfigProp("config_apidemo_test_app.properties");
		appUtil.setCapabilities();
		driver = appUtil.getDriver();
	}

	@AfterClass(alwaysRun = true)
	public void stopAutomation() {
		driver.quit();
	}

	@Test(groups = { "Smoke" }, enabled = true)
	public void testAppActivity() {
		homeScreen = new HomeScreen(driver);
		appMenuPage = homeScreen.getAppMenuPage();
		appActivityPage = appMenuPage.getActivityPage();
		screenOrientationPage = appActivityPage.getScreenOrientationPage();
		Assert.assertEquals(screenOrientationPage.isItValidScreenOrientationPage(), true);
		screenOrientationPage.changeScreenOrientation("USER");
		Assert.assertEquals(screenOrientationPage.checkOrientationType(), true);
	}
}
