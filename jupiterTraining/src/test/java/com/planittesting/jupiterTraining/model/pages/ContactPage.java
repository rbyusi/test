package com.planittesting.jupiterTraining.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage extends BasePage {

	public ContactPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By forename = By.id("forename");
	private By surname = By.id("surname");
	private By emailAddress = By.id("email");
	private By phone = By.id("telephone");
	private By message = By.id("message");
	private By forenameErr = By.id("forename-err");
	private By emailErr = By.id("email-err");
	private By messageErr = By.id("message-err");
	private By submitButton = By.className("btn-contact");
	private By successMessage = By.className("alert-success");
	
	
	public void setEmailAddress(String email) {
		driver.findElement(emailAddress).sendKeys(email);
	}
	
	public String getInvalidForeNameErr() {
		var element = driver.findElements(forenameErr).size();
		var errorMessage = driver.findElement(forenameErr).getText();
			
		if(element != 0) {
			return errorMessage;
		}else {
			return "No Error Message";
		}
		
	}
	
	public String getInvalidEmailErr() {
		var element = driver.findElements(emailErr).size();
		var errorMessage = driver.findElement(emailErr).getText();
		
		if( element > 0 && errorMessage != "") {
			return errorMessage;
		}else {
			return "No Error Message";
		}
		
	}
	
	public String getInvalidMessageErr() {
		var element = driver.findElements(forenameErr).size();
		var errorMessage = driver.findElement(messageErr).getText();
		
		if( element != 0) {
			return errorMessage;
		}else {
			return "No Error Message";
		}
		
	}
	
	public void setForename(String forenameInput) {
		driver.findElement(forename).sendKeys(forenameInput);
	}
	
	public void setMessage(String messageInput) {
		driver.findElement(message).sendKeys(messageInput);
	}
	
	public void clickSubmit() {
		driver.findElement(submitButton).click();
	}

	public void setSurname(String surnameInput) {
		driver.findElement(surname).sendKeys(surnameInput);
		
	}

	public void setPhone(String phoneInput) {
		driver.findElement(phone).sendKeys(phoneInput);
		
	}
	
	public String verifySuccessMessage() {
		var wait = new WebDriverWait(driver,10);
		var message = wait.until(d -> d.findElement(successMessage).getText());
		
		
		return message;
	}


}
