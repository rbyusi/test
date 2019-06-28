package com.planittesting.jupiterTraining.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.planittesting.jupiter.model.ui.Table;
import com.planittesting.jupiterTraining.model.pages.CartPage;
import com.planittesting.jupiterTraining.model.pages.CheckoutPage;
import com.planittesting.jupiterTraining.model.pages.HomePage;
import com.planittesting.jupiterTraining.model.pages.ShopPage;
import com.planittesting.jupitertestingTraining.model.data.Contact;

public class CheckoutTest extends BaseTest {

	HomePage homePage;
	ShopPage shopPage;
	CartPage cartPage;
	CheckoutPage checkOutPage;

	@BeforeEach
	public void Setup() {
		homePage = new HomePage(driver);
		shopPage = new ShopPage(driver);
		cartPage = new CartPage(driver);
		checkOutPage = new CheckoutPage(driver);
		homePage.clickShop();

	}

	@Test
	public void TestCheckOut() throws Exception {
		var cardType = "Mastercard";
		var cardNumber = "2343234223422342";
		var contact = new Contact();
		
		contact.setForename("Ryan");
		contact.setSurname("Yusi");
		contact.setEmail("test@gmail.com");
		contact.setPhone("23423423");
		contact.setAddress("test message");

		shopPage.buyRandomNumberOfItems(3);
		shopPage.clickCart();
		shopPage.clickCheckoutButton();
		
		checkOutPage.fillUpContactForm(contact);
		checkOutPage.selectCardType(cardType);
		checkOutPage.fillInCardNumber(cardNumber);
		checkOutPage.clickSubmitButton();

		assertTrue(checkOutPage.getSuccessMessage().contains("your order has been accepted. Your order nuumber is"));
		assertTrue(checkOutPage.ShoppinAgainButtonExist(), "The Shopping Again button does not exist");

	}
}
