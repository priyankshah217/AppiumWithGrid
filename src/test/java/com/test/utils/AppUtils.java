package com.test.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AppUtils {

    private Properties prop = new Properties();
    private String APPLICATION_NAME;
    private String BASE_PKG;
    private String APP_ACTIVITY;
    private String APPIUM_PORT;
    private String AUTOMATION_INSTRUMENTATION;
    private String PLATFORM_NAME;
    private String NEW_COMMAND_TIMEOUT;
    private String PLATFORM_VERSION;
    private String DEVICE_READY_TIMEOUT;
    private String DEVICE_NAME;
    private DesiredCapabilities capabilities = new DesiredCapabilities();

    public void loadConfigProp()
            throws IOException {
        prop.load(ClassLoader.getSystemResource("config_apidemo_test_app.properties").openStream());

        APPLICATION_NAME = prop.getProperty("application.path");
        BASE_PKG = prop.getProperty("base.pkg");
        APP_ACTIVITY = prop.getProperty("application.activity");
        APPIUM_PORT = prop.getProperty("appium.server.port");
        AUTOMATION_INSTRUMENTATION = prop.getProperty("automation.instumentation");
        DEVICE_NAME = prop.getProperty("device.name");
        PLATFORM_NAME = prop.getProperty("platform.name");
        PLATFORM_VERSION = prop.getProperty("platform.version");
        NEW_COMMAND_TIMEOUT = prop.getProperty("new.command.timeout");
        DEVICE_READY_TIMEOUT = prop.getProperty("device.ready.timeout");
    }

    public void setCapabilities(String deviceID) {
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
                PLATFORM_VERSION);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
                PLATFORM_NAME);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
                DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
                AUTOMATION_INSTRUMENTATION);
        capabilities.setCapability(MobileCapabilityType.APP, new File(
                ClassLoader.getSystemResource(APPLICATION_NAME)
                        .getFile()).getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,
                NEW_COMMAND_TIMEOUT);
        capabilities.setCapability(AndroidMobileCapabilityType.DEVICE_READY_TIMEOUT,
                DEVICE_READY_TIMEOUT);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
                APP_ACTIVITY);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,
                BASE_PKG);
        capabilities.setCapability(MobileCapabilityType.UDID, deviceID);
    }

    public AppiumDriver getDriver() throws MalformedURLException {
        URL serverUrl = new URL("http://localhost:" + APPIUM_PORT + "/wd/hub");
        AppiumDriver driver = new AndroidDriver(serverUrl, capabilities);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver;
    }

}
