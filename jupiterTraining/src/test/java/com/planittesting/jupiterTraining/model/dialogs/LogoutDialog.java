package com.planittesting.jupiterTraining.model.dialogs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogoutDialog extends BaseDialog {

	public LogoutDialog(WebElement rootElement) {
		super(rootElement);
	}

	
	private By logoutButton = By.className("btn-success");

	
	public void clickLogout() {
		rootElement.findElement(logoutButton).click();
		
	}

}
