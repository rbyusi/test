package com.planittesting.jupiterTraining.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By contactLink = By.cssSelector("#nav-contact > a");
		
	public void clickContactLink() {
		driver.findElement(contactLink).click();
	}

}
