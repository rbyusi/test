package com.planittesting.jupiterTraining.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.planittesting.jupitertestingTraining.model.data.Contact;

public class CheckoutPage extends BasePage{
	
	private By forename = By.id("forename");
	private By surname = By.id("surname");
	private By email = By.id("email");
	private By phone = By.id("telephone");
	private By address = By.id("address");
	private By cardType = By.id("cardType");
	private By cardNumber = By.id("card");
	private By checkOutButton = By.id("checkout-submit-btn");
	private By successMessage = By.className("alert-success");
	private By shopAgainButton = By.className("btn-success");

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	public void fillUpContactForm(Contact contact) {

			driver.findElement(forename).sendKeys("Ryan");
			driver.findElement(surname).sendKeys(contact.getSurname());
			driver.findElement(email).sendKeys(contact.getEmail());
			driver.findElement(phone).sendKeys(contact.getPhone());
			driver.findElement(address).sendKeys(contact.getAddress());

	}
	

	public void selectCardType(String card) {
		var cardDropDown = new Select(driver.findElement(cardType));
		cardDropDown.selectByValue(card);
	}

	public void fillInCardNumber(String number) {
		driver.findElement(cardNumber).sendKeys(number);
		
	}

	public void clickSubmitButton() {
		driver.findElement(checkOutButton).click();
	}

	public String getSuccessMessage() {
		var wait = new WebDriverWait(driver, 20);
		var message = wait.until(d -> d.findElement(successMessage).getText());
		return message;
	}
	


	public Boolean ShoppinAgainButtonExist() {
		return driver.findElement(shopAgainButton).isDisplayed();
		 
	}



}
