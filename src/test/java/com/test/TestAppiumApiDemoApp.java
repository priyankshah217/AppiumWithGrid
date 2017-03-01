package com.test;

import com.test.apidemo.app.screens.AppActivityScreen;
import com.test.apidemo.app.screens.AppMenuScreen;
import com.test.apidemo.app.screens.HomeScreen;
import com.test.apidemo.app.screens.ScreenOrientationScreen;
import com.test.utils.AppUtils;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestAppiumApiDemoApp {
    private AppiumDriver driver;
    private HomeScreen homeScreen;
    private AppMenuScreen appMenuPage;
    private AppActivityScreen appActivityPage;
    private ScreenOrientationScreen screenOrientationPage;
    private AppUtils appUtil;


    @Parameters({"deviceID"})
    @BeforeMethod(alwaysRun = true)
    public void startAutomation(String deviceID) throws IOException {
        appUtil = new AppUtils();
        appUtil.loadConfigProp();
        appUtil.setCapabilities(deviceID);
        driver = appUtil.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopAutomation() {
        driver.quit();
    }

    @Test(groups = {"Smoke"})
    public void testAppActivity() {
        homeScreen = new HomeScreen(driver);
        appMenuPage = homeScreen.getAppMenuPage();
        appActivityPage = appMenuPage.getActivityPage();
        screenOrientationPage = appActivityPage.getScreenOrientationPage();
        Assert.assertEquals(screenOrientationPage.isItValidScreenOrientationPage(), true);
        screenOrientationPage.changeScreenOrientation();
        Assert.assertEquals(screenOrientationPage.checkOrientationType(), true);
    }
}
