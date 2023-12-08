package PageObject;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Basepage;
import Base.ExtentManager;

public class ValidLogin extends Basepage {
	// Log4j
	public Logger logger = LogManager.getLogger(ValidLogin.class.getName());

	public WebDriver driver = getDriver();

	public String wait = iprop.getProperty("TIMEOUT");
	public long waits = Long.parseLong(wait);
	By userName = By.xpath("//input[@placeholder='Username']");
	By password = By.xpath("//input[@placeholder='Password']");
	By signInBtn = By.xpath("//button[@type='submit']");
	//By Error = By.xpath("//div[@class='aw-session-errorMessage ng-binding']");
	//By InternalError = By.xpath("//div[.='You were not signed in because of an internal error.']");

	public ValidLogin() throws IOException {
		super();
	}

	public WebElement getuserName() throws IOException {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waits));
		wait.until(ExpectedConditions.visibilityOfElementLocated(userName));

		return driver.findElement(userName);
	}

	public WebElement getpassword() throws IOException {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waits));
		wait.until(ExpectedConditions.visibilityOfElementLocated(password));
		return driver.findElement(password);
	}

	public WebElement getsignInBtn() throws IOException {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waits));
		wait.until(ExpectedConditions.visibilityOfElementLocated(signInBtn));
		return driver.findElement(signInBtn);
	}

//	public WebElement getError() throws IOException {
//		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waits));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(Error));
//		return driver.findElement(Error);
//	}
//
//	public WebElement getInternalError() throws IOException {
////		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waits));
////		wait.until(ExpectedConditions.visibilityOfElementLocated(InternalError));
//		return driver.findElement(InternalError);
//	}

	public void vaildLogin() throws IOException {
		ExtentManager.log("Starting........Login Method");
		logger.info("Starting........Login Method");
		// send Username

		getuserName().sendKeys(prop.getProperty("USERNAME"));
		ExtentManager.pass("send Username");
		logger.info("send Username");
		// send Password
		getpassword().sendKeys(prop.getProperty("PASSWORD"));
		ExtentManager.pass("send password");
		logger.info("send password");
		getsignInBtn().click();
		ExtentManager.pass("SignIn Button click");
		logger.info("SignIn Button click");
//
//		try {
//			if (getInternalError().isDisplayed()) {
//				for (int i = 0; i < 999 && getInternalError().isDisplayed(); i++) {
//					getsignInBtn().click();
//					continue;
//				}
//			}
//		} catch (Exception e) {
//
//		}
//
////	wait
//		int i = 0;
//		do {
//			i++;
//			continue;
//		} while (titleCheck() && i <= 1000);
	}

//	public boolean titleCheck() throws IOException {
//		boolean result = getDriver().getTitle().equals("Teamcenter");
//		return result;
//	}

	public void inVaildLogin() throws IOException, InterruptedException {
		// send Username
		getuserName().sendKeys(prop.getProperty("USERNAME"));
		ExtentManager.pass("send Username");
		logger.info("send Username");

		// send Invalid Password
		getpassword().sendKeys(prop.getProperty("PASSWORD") + "90");
		ExtentManager.pass("send password");
		logger.info("send password");

//		Click on Sign In Button
		getsignInBtn().click();
		ExtentManager.pass("SignIn Button click");
		logger.info("SignIn Button click");
	}
	

}
