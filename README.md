AppiumTestAutomation
====================

This is implementation of PageFactory framework with Appium for Android device.

Current framework provide basic implementation of PageFactory frame and demonstrated on native android application.


Prerequisite
=====================
1. Android SDK
2. Appium
3. Maven (For managing dependencies)
4. Eclipse
5. Selenium Standalone (http://goo.gl/cvntq5)

Installation
=====================
1. Install from git
2. Before installation run selenium hub using
 
	* java -jar selenium-server-standalone-2.XX.0.jar -role hub)

3. Run two server instance of appium servers, each pointing to separate android devices
	
	* Launch appium from comman line (run from source),
	node . -p 6001 -p 5001 -U <Device 1> -nodeconfig <Project directory>/nodeconfig_device1.json
	node . -p 6002 -p 5002 -U <Device 2> -nodeconfig <Project directory>/nodeconfig_device2.json
	
	* Launch appium from comman line,
	appium -p 6001 -p 5001 -U <Device 1> -nodeconfig <Project directory>/nodeconfig_device1.json
	appium -p 6002 -p 5002 -U <Device 2> -nodeconfig <Project directory>/nodeconfig_device2.json
		 
4. Run "mvn clean test" from project directory

Script Description
=====================
1. AppiumApiDemoAppTests:

	* apk Name: ApiDemos-debug.apk
	* apk Location: /src/test/resources
	* Type of Application: Native
	* Gesture Simulated: Swipe/Scroll

	
