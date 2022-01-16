package com.inetbanking.testCase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.inetbanking.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getApplicationUrl();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassward();
	public static WebDriver driver;
	public static Logger logger;
	

	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		logger = Logger.getLogger("MyProject");
		PropertyConfigurator.configure("log4j.properties");

		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (br.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
		//driver.manage().window().maximize();
	
		
	
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public String getScreenshot() throws IOException {
		
		Date currentdate = new Date();
		String screenshotfilename = currentdate.toString().replace(" ","-").replace(":","-");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String finalDestination = System.getProperty("user.dir") +"screenshot"+ screenshotfilename + ".png";
		FileUtils.copyFile(screenshotFile, new File(finalDestination));
		
		return finalDestination;
	}
	
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	
}
