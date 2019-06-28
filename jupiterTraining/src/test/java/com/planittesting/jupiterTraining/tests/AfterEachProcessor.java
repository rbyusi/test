package com.planittesting.jupiterTraining.tests;

import java.io.File;
import java.nio.file.StandardCopyOption;
import java.util.logging.Logger;
import java.nio.file.Files;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class AfterEachProcessor implements AfterEachCallback {

	Logger logger = Logger.getLogger(AfterEachProcessor.class.getName());

	private WebDriver driver;

	public void setDriver(WebDriver driver) {
		this.driver = driver;

	}

	@Override
	public void afterEach(ExtensionContext context) throws Exception {
		if (context.getExecutionException().isPresent()) {
			var screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			var destination = new File(
					System.getProperty("user.home") + "/" + context.getTestMethod().orElseThrow().getName() + ".png");// config
			logger.info("Screenshot saved at: " + destination.getAbsolutePath());
			Files.move(screenshotFile.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}

		driver.quit();
	}
}
