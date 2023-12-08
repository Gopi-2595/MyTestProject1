package com.tc_awc.BasicTestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.Basepage;
import Base.ExtentManager;
import Base.WebDriverInstance;
import PageObject.ValidLogin;

@Listeners(resources.Listeners.class)
public class AWC_ValidCredentialLogin extends Basepage {
	//  For Log4j
	public Logger logger = LogManager.getLogger(AWC_ValidCredentialLogin.class.getName());

	public AWC_ValidCredentialLogin() throws IOException {
		super();
		
	}

	@BeforeMethod
	public void setup() throws IOException {
		WebDriver driver = getDriver();
		driver.get(getUrl());
	}

	@AfterMethod
	public void tearDown() throws IOException {
        WebDriverInstance.cleanupDriver();
		
	}

	@Test
	public void validlogin() throws IOException {

		ExtentManager.log("Starting.....Login Method");
		ValidLogin login = new ValidLogin();

//		for Valid login
		login.vaildLogin();

		// ExtentManager.pass("Called Login ");
//		try {
////			if (getDriver().getTitle().equals("Teamcenter - Home")) {
//			if (getDriver().getTitle().equals(iprop.getProperty("HOMETITLE"))) {
//				System.out.println("Signed In Successfully...........");
//				ExtentManager.pass("Login In Teamcenter");
//				//Intentionally  
//				Assert.assertTrue(false);
//			}
//		} catch (AssertionError e) {
//
//			System.out.println("Signed In Failed........ ");
//			ExtentManager.fail("Failed to Login In");
//			Assert.fail();
//			logger.error("Failed to login page");
//
//		}

	}

}
