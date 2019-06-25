package com.planittesting.jupiterTraining.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.planittesting.jupiterTraining.model.pages.HomePage;
import com.planittesting.jupiterTraining.model.pages.ShopPage;

public class ShopTest extends BaseTest {


	@Test
	public void VerifyProdcutPrice() throws Exception {
		var homePage = new HomePage(driver);
		homePage.clickShop();
		var shopPage = new ShopPage(driver);

		var productTitle = "Teddy Bear";
		double productPrice = 12.99;

		

		var product = shopPage.getProductByTitle(productTitle);
		assertEquals(productPrice, product.getPrice(), "Product price for " + productTitle + " was Incorrect");

	}

}
