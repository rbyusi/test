package com.planittesting.jupiterTraining.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.planittesting.jupiterTraining.model.dialogs.LoginDialog;
import com.planittesting.jupiterTraining.model.dialogs.LogoutDialog;


public class BasePage {
	
	protected WebDriver driver;
	
	private By loginLink = By.id("nav-login");
	private By logoutLink = By.id("nav-logout");
	private By shopLink = By.id("nav-shop");
	private By loginDialog = By.className("popup");
	private By logoutDialog = By.className("popup");
	private By loggedInUser = By.className("user");

	public BasePage(WebDriver driver) {
		  	this.driver = driver;
	}
	
	public LoginDialog clickLogin() {
		driver.findElement(loginLink).click();
		var dialogRootElement = driver.findElement(loginDialog);
		
		return new LoginDialog(dialogRootElement);
		
	}
	
	public void clickShop() {
		driver.findElement(shopLink).click();
	}

	public LogoutDialog clickLogout() {
		driver.findElement(logoutLink).click();
		var dialogRootElement = driver.findElement(logoutDialog);
		
		return new LogoutDialog(dialogRootElement);
	}


	
	public String getLoggedInUser() {
		return driver.findElement(loggedInUser).getText();
	}

	public  String checkLoginLinkIfPresent() {
		return driver.findElement(loginLink).getText();
	}

}
