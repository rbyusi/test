package com.planittesting.jupiterTraining.model.dialogs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RemoveItemDialog extends BaseDialog{

	private By yesButton = By.className("btn-success");
	
	public RemoveItemDialog(WebElement rootElement) {
		super(rootElement);
	}

	public void clickYes() {
		rootElement.findElement(yesButton).click();
		
	}
	
	
}
