package com.planittesting.jupiterTraining.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import com.planittesting.jupiterTraining.model.pages.CartPage;
import com.planittesting.jupiterTraining.model.pages.HomePage;
import com.planittesting.jupiterTraining.model.pages.ShopPage;
import com.planittesting.jupiterTraining.model.products.CompareByPrice;
import com.planittesting.jupiterTraining.model.products.CompareByRating;
import com.planittesting.jupiterTraining.model.products.CompareByTitle;
import com.planittesting.jupiterTraining.model.products.Product;
import com.planittesting.jupitertestingTraining.model.data.ProductWithNameAndRating;

public class ShopTest extends BaseTest {

	@Test
	public void VerifyProdcutPrice() throws Exception {
		var homePage = new HomePage(driver);
		homePage.clickShop();
		double productPrice = 9.99;
		var productTitle = "Handmade Doll";
		var shopPage = new ShopPage(driver);
		var comparison = new CompareByTitle(productTitle);

		var product = shopPage.getProduct(comparison);

		assertEquals(productPrice, product.getPrice(), "Product price for " + productTitle + " was Incorrect");

	}

	@Test
	public void VerifyProductsTitle() throws Exception {
		var homePage = new HomePage(driver);
		homePage.clickShop();
		var shopPage = new ShopPage(driver);

		var productTitle = "Valentine Bear";
		double productPrice = 14.99;

		var product = shopPage.getProductByTitle(productTitle);
		assertEquals(productTitle, product.getTitle(), "Product title for " + productPrice + " was Incorrect");

	}

	@Test
	public void FindProductBasedOnPrice() throws Exception {
		var homePage = new HomePage(driver);
		homePage.clickShop();
		var shopPage = new ShopPage(driver);
		double productPrice = 10.99;
		var comparison = new CompareByPrice(productPrice);
		var product = shopPage.getProduct(comparison);

		System.out.print(product.getTitle());
	}

	@Test
	public void FindProductsBasedOnPrice() throws Exception {
		var homePage = new HomePage(driver);
		homePage.clickShop();
		var shopPage = new ShopPage(driver);
		double productPrice = 10.99;
		var comparison = new CompareByPrice(productPrice);
		var products = shopPage.getProducts(comparison);

		for (var product : products) {
			System.out.print(product);
		}
	}

	@Test
	public void BuyAProductBasedOnPrice() throws Exception {
		var homePage = new HomePage(driver);
		homePage.clickShop();
		var shopPage = new ShopPage(driver);
		double productPrice = 10.99;
		var comparison = new CompareByPrice(productPrice);
		var product = shopPage.getProduct(comparison);

		assertEquals(product.getTitle() + " is now in the shopping cart", 
				shopPage.clickProductBuyButtonBasedOnPrice(productPrice));

	}

	@Test
	public void BuyAProductBasedOnRating() throws Exception {
		var homePage = new HomePage(driver);
		homePage.clickShop();
		var shopPage = new ShopPage(driver);
		var productRating = "2";
		var comparison = new CompareByRating(productRating);
		var product = shopPage.getProduct(comparison);
		
		assertEquals(product.getTitle() + " is now in the shopping cart", 
				shopPage.clickProductBuyButtonBasedOnRating(productRating));

	}
	
	@Test
	public void ValidateCartSizeForRandomAmountOfProducts() throws Exception {
		var homePage = new HomePage(driver);
		homePage.clickShop();
		var shopPage = new ShopPage(driver);
		Integer numberOfItems = (int) (Math.random() * shopPage.getNoOfProducts() + 1);
		
		assertEquals(numberOfItems.toString(), shopPage.buyRandomNumberOfItems(numberOfItems), 
				"Cart text is " + homePage.getCartText() + " while the expected is " + numberOfItems);
		
	}
	/*
	 * buy per rating first
	 * increased the rating in the cart page
	 * verifry
	 */
	@Test
	public void BuyXNumberOfProductsByXNumberOfRatings() throws Exception {
		var homePage = new HomePage(driver);
		homePage.clickShop();
		
		var shopPage = new ShopPage(driver);
		var cartPage = new CartPage(driver);
		var rating ="2";
		var nameOfProduct = shopPage.nameOfProductPerRating(rating);
		
		//ArrayList<ProductWithNameAndRating> productsWithRating = shopPage.getListOfAllProductsWithRating();
		//shopPage.buyRandomNumberOfItems(7);
		
		//cartPage.setProductNoByRating(rating);
		shopPage.clickCart();
		cartPage.increaseProductQuantityPerRating(nameOfProduct, rating);
		System.out.println(cartPage.getSubTotal(nameOfProduct));
		//assertEquals(cartPage.getSubTotal(nameOfProduct), cartPage.getPrice(String nameOfProduct) * Integer.parseInt(rating) );
		Thread.sleep(3000);
	}
	
	
	@Test
	
	public void BuyXNumberRating() throws Exception {
		var homePage = new HomePage(driver);
		homePage.clickShop();
		
		var shopPage = new ShopPage(driver);
		var cartPage = new CartPage(driver);
		var products = shopPage.getAllProducts();
		ArrayList<ProductWithNameAndRating> productsANDratings = new ArrayList<ProductWithNameAndRating>();
		
		for(int i = 0; i < products.size(); i ++) {
			var product = new ProductWithNameAndRating();
			
			product.setName(products.get(i).getTitle());
			product.setRating(Integer.parseInt(products.get(i).getRating()));
			product.setPrice(products.get(i).getPrice());

			productsANDratings.add(product);
			
		}
		
		shopPage.clickBuyButtonBasedRating(productsANDratings);
		
		shopPage.clickCart();
		for(int x = 0; x < productsANDratings.size(); x ++ ) {
			
			//System.out.println(productsANDratings.get(x).getRating());
			if(productsANDratings.get(x).getRating() != 0) {
				double priceOfItem = cartPage.getPriceOfItem(productsANDratings.get(x).getName());
				double productSubTotal = cartPage.getSubTotal(productsANDratings.get(x).getName());
				int productRating = cartPage.getProductQuantity(productsANDratings.get(x).getName());
				double subTotal = productsANDratings.get(x).getPrice() * productsANDratings.get(x).getRating();
				
				//price
				assertEquals(priceOfItem, productsANDratings.get(x).getPrice(), "Product price was:  " +  priceOfItem + " instead of "  + productsANDratings.get(x).getPrice());
				//quantity
				assertEquals(productRating, productsANDratings.get(x).getRating());
				//subtotal
				assertEquals(productSubTotal, subTotal, "Subtotal was: " + productSubTotal + " instead of " + subTotal);
				
			}
			
		}
		
		
		
		
	}
	

}
