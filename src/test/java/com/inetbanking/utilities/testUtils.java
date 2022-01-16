package com.inetbanking.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.inetbanking.testCase.BaseTest;

public class testUtils extends BaseTest {
	
	public String getScreenshot() throws IOException {
		
		Date currentdate = new Date();
		String screenshotfilename = currentdate.toString().replace(" ","-").replace(":","-");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String finalDestination = System.getProperty("user.dir") +"/screenshot/"+ screenshotfilename + ".png";
		FileUtils.copyFile(screenshotFile, new File(finalDestination));
		
		return finalDestination;
	}
	


}
