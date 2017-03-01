package com.test.apidemo.app.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AppActivityScreen extends AbstractScreen {

    @AndroidFindBy(id = "android:id/text1")
    private List<WebElement> activityList;

    public AppActivityScreen(AppiumDriver driver) {
        super(driver);
    }

    public ScreenOrientationScreen getScreenOrientationPage() {
        return new ScreenOrientationScreen(driver);
    }
}
