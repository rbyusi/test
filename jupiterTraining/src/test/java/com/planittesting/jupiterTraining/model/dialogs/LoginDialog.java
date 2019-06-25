package com.planittesting.jupiterTraining.model.dialogs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginDialog extends BaseDialog {
	

	public LoginDialog(WebElement rootElement) {
		super(rootElement);
		// TODO Auto-generated constructor stub
	}

	private By usernameInput = By.id("loginUserName");
	private By passwordInput = By.id("loginPassword");
	private By loginButton = By.className("btn-primary");
	

//  multiple input
//	public void setUserName(String username) {
//		rootElement.findElement(usernameInput).sendKeys(username);
//	}
//	
//	public void setPassword(String password) {
//		rootElement.findElement(passwordInput).sendKeys(password);
//	}
//	
	public void logIn(String username, String password) {
		rootElement.findElement(usernameInput).sendKeys(username);
		rootElement.findElement(passwordInput).sendKeys(password);
	}
	
	public void clickLogin() {
		rootElement.findElement(loginButton).click();
	}

}
