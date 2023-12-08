package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Basepage {
	
		
 public static String screenShotDestinationPath;
	public String url;
	public Properties prop;
	public Properties iprop;

	public Basepage() throws IOException {
		prop = new Properties();
		FileInputStream config1data = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\config.properties");
		prop.load(config1data);
		
		//for Config2 data input data
		iprop = new Properties();
		FileInputStream config2data = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\config2.properties");
		iprop.load(config2data);
		
	}

	public static WebDriver getDriver() throws IOException {
		return WebDriverInstance.getDriver();
	}

	public String getUrl() throws IOException {
		url = prop.getProperty("url");
		return url;
	}

	public static String takeSnapShot(String name) throws IOException, WebDriverException {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

		String destFile = System.getProperty("user.dir") + "\\target\\screenshots\\" + timestamp() + ".png";
		screenShotDestinationPath = destFile;

		try {
			FileUtils.copyFile(srcFile, new File(destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return name;

	}

	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	public static String getScreenshotDestinationPath() {
		return screenShotDestinationPath;
	}

}
