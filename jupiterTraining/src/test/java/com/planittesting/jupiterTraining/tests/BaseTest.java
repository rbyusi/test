package com.planittesting.jupiterTraining.tests;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Execution(ExecutionMode.CONCURRENT)
public class BaseTest {
	
	@RegisterExtension
	AfterEachProcessor afterEachProcessor = new AfterEachProcessor();
	
	protected WebDriver driver;
	

	@BeforeEach
	private void TestSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver(); // ideally in config
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		driver.get("http://jupiter.cloud.planittesting.com");
		driver.get("http://jupiter2.cloud.planittesting.com");
	}
	
	

	@AfterEach
	private void BaseTestCleanup() {	
		afterEachProcessor.setDriver(driver);
	}

}
