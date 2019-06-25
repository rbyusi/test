package com.planittesting.jupiterTraining.model.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.planittesting.jupiterTraining.model.products.Product;

public class ShopPage extends BasePage {
	
	 By productTitle = By.className("product-title");
	 By productPrice = By.className("product-price");
	 By listId = By.id("product-1");
	
	 By product = By.className("product");

	public ShopPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void getPriceOf(String title) {
		 List<WebElement> elements = driver.findElements(By.className("product"));
		 for (WebElement element : elements) {
			
		    System.out.println(element.getText());  
		 }
	}

	public Product getProductByTitle(String productTitle) throws Exception {
		// find all products
		var elements = driver.findElements(product);
		// find particular product that matches my title
		for(var element : elements) {
			var product = new Product(element);
			if(product.getTitle().equals(productTitle)) {
				return product;
			}
		}
		
		//return product
		throw new Exception("Could not find product " + productTitle );
	}

	
}
