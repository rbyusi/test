package com.planittesting.jupiterTraining.model.dialogs;

import org.openqa.selenium.WebElement;

public class BaseDialog {
	
	protected WebElement rootElement;
	
	public BaseDialog(WebElement rootElement) {
		this.rootElement = rootElement;
	}

}
