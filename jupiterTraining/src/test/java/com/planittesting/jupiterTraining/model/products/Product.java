package com.planittesting.jupiterTraining.model.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Product {
	private WebElement rootElement;
	
	private By title = By.className("product-title");
	private By price = By.className("product-price");
	private By rating = By.className("star-level");
	
	public Product(WebElement rootElement) {
		this.rootElement = rootElement;
	}

	public String getTitle() {
		return rootElement.findElement(title).getText();
		
	}

	public double getPrice() {
		var priceAsString = rootElement.findElement(price).getText().replace("$", "");
		return Double.parseDouble(priceAsString);
	}

	public String getRating() {
		return rootElement.findElement(rating).getText();
	}

}
