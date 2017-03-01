package com.test.apidemo.app.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ScreenOrientationScreen extends AbstractScreen {

    private String sensorType;
    @AndroidFindBy(id = "io.appium.android.apis:id/orientation")
    private WebElement orientationMenu;

    @AndroidFindBy(id = "android:id/text1")
    private List<WebElement> orientationList;

    @AndroidFindBy(id = "android:id/action_bar_title")
    private WebElement actionBarTitle;

    public ScreenOrientationScreen(AppiumDriver driver) {
        super(driver);
    }

    public ScreenOrientationScreen changeScreenOrientation() {
        this.sensorType = "USER";
        orientationMenu.click();
        if (!isElementPresent(By.name("USER"))) {
            TouchAction action = new TouchAction(driver);
            action
                    .press(245, 1637)
                    .waitAction(300)
                    .moveTo(245, 615)
                    .release()
                    .perform();
        }
        for (WebElement el : orientationList) {
            if (el.getText().equals("USER")) {
                el.click();
                break;
            }
        }
        return this;
    }

    public boolean checkOrientationType() {
        boolean isPassed = false;
        if (orientationList.get(0).getText().equals(this.sensorType)) {
            isPassed = true;
        } else {
            takeScreenShot("InvalidOrientation");
        }
        return isPassed;
    }

    public boolean isItValidScreenOrientationPage() {
        boolean isPassed = false;
        if (actionBarTitle.getText().equals("App/Activity/Screen Orientation")) {
            isPassed = true;
        } else {
            takeScreenShot("InvalidSensor");
        }
        return isPassed;
    }
}
