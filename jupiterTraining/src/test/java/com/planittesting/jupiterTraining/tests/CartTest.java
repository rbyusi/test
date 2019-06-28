package com.planittesting.jupiterTraining.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.planittesting.jupiterTraining.model.pages.CartPage;
import com.planittesting.jupiterTraining.model.pages.HomePage;
import com.planittesting.jupiterTraining.model.pages.ShopPage;

public class CartTest extends BaseTest {
	HomePage homePage;
	ShopPage shopPage;
	CartPage cartPage;

	@BeforeEach
	public void Setup() {
		homePage = new HomePage(driver);
		shopPage = new ShopPage(driver);
		cartPage = new CartPage(driver);
		homePage.clickShop();
	}

	@Test
	public void VerifyPriceInTheShoppingCart() throws Exception {

		shopPage.buyRandomNumberOfItems(7);
		shopPage.clickCart();
		var productTitle = ("Fluffy Bunny");

		var cartPage = new CartPage(driver);

		assertEquals(8.99, cartPage.getPriceOfItem(productTitle),
				"Was expecting 13.99 ang got " + cartPage.getPriceOfItem(productTitle));

	}

	

	@Test
	public void RemoveItemFromTheCart() throws Exception {

		var productTitle = "Stuffed Frog";
		shopPage.clickProductBuyButtonBasedOnTile(productTitle);
		shopPage.clickCart();
		var cartSize = Integer.parseInt(cartPage.getCartText());
		cartPage.removeItem(productTitle);
		
		assertEquals(cartSize - 1, Integer.parseInt(cartPage.getCartText()), "Removing an item decrease the cart size");
		var actualMessage = cartPage.getEmptyCartMessage();
		assertTrue(actualMessage.contains("Your cart is empty - there's nothing to see here."),
				"Cart empty message was incorrect " + actualMessage);
		

	}

}
