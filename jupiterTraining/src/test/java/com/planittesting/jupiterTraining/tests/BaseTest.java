package com.planittesting.jupiterTraining.tests;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	protected WebDriver driver;

	@BeforeEach
	private void TestSetup() {
		driver = new ChromeDriver(); // ideally in config
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://jupiter.cloud.planittesting.com");
		
		
	}

	@AfterEach
	private void TestCleanup() {
		driver.quit();
	}
}
