package Utilities;

import java.io.IOException;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import Base.Basepage;
import Base.WebDriverInstance;
import Email.ReportSendByEmail;
import PageObject.ValidLogin;

public class Hooks extends Basepage {

	public Hooks() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeMethod
	public void setup() throws IOException {
		WebDriver driver = getDriver();
		driver.get(getUrl());
		
		// For Login
		//AWC_ValidCredentialLogin login = new AWC_ValidCredentialLogin();
		ValidLogin login = new ValidLogin();
		login.vaildLogin();
	}
	
	@AfterMethod
    public void tearDown() {
        WebDriverInstance.cleanupDriver();
    }
	
	@AfterSuite
	public void mail() throws EmailException {
		ReportSendByEmail report = new ReportSendByEmail();
		report.sendMail();
	}

}
