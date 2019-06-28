package com.planittesting.jupiter.Training.model.cart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartTable {
	
	WebElement rootElement;
	
	private By tableBody = By.xpath("//table[@class='table table-striped cart-items']//tbody");
	private By tableRow = By.tagName("tr");
	
	public CartTable(WebElement rootElement) {
		this.rootElement = rootElement;
	}


	public WebElement getTable() {
		return rootElement.findElement(tableBody);
	}
	public List<WebElement> getRows() {
		return getTable().findElements(tableRow);
		
	}
}
