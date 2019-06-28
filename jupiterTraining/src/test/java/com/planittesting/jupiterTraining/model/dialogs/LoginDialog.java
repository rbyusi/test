package com.planittesting.jupiterTraining.model.dialogs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginDialog extends BaseDialog {

	public LoginDialog(WebElement rootElement) {
		super(rootElement);
	}

	private By usernameInput = By.id("loginUserName");
	private By passwordInput = By.id("loginPassword");
	private By termsCheckBox = By.id("agree");
	private By loginButton = By.className("btn-primary");

	public void logIn(String username, String password) {
		rootElement.findElement(usernameInput).sendKeys(username);
		rootElement.findElement(passwordInput).sendKeys(password);
//		added to click terms and conditions checkbox
		rootElement.findElement(termsCheckBox).click();
	}

	public void clickLogin() {
		rootElement.findElement(loginButton).click();
	}

}
