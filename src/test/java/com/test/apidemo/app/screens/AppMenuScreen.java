package com.test.apidemo.app.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class AppMenuScreen extends AbstractScreen {

    @AndroidFindBy(accessibility = "Activity")
    private WebElement appActivity;

    public AppMenuScreen(AppiumDriver driver) {
        super(driver);
    }

    public AppActivityScreen getActivityPage() {
        // TODO Auto-generated method stub
        appActivity.click();
        return new AppActivityScreen(driver);
    }

}
