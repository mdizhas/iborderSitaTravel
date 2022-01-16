package com.inetbanking.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirtTestOpenBrowsers {

	public static void main(String[] args) {
	
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("testing");
		driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']")).click();
		
		driver.close();
		
		System.out.println("test completed...");

	}

}
