package com.planittesting.jupiterTraining.model.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.planittesting.jupiterTraining.model.products.CompareProduct;
import com.planittesting.jupiterTraining.model.products.Product;
import com.planittesting.jupitertestingTraining.model.data.ProductWithNameAndRating;

public class ShopPage extends BasePage {

	By productTitle = By.className("product-title");
	By productPrice = By.className("product-price");
	By buyButton = By.className("btn-success");
	//By checkOutButton = By.xpath("//table[contains(@class,'table table-striped cart-items')]//a[contains(@class,'ng-scope')][contains(text(),'Checkout')]");
	By checkOutButton = By.partialLinkText("Checkout");
	By listId = By.id("product-1");
	By table = By.className("table");
	By rating = By.className("start-rating");
	By product = By.className("product");

	private JavascriptExecutor js = (JavascriptExecutor) driver;

	public ShopPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Product> getElements() {
		var elements = driver.findElements(product);
		ArrayList<Product> products = new ArrayList<Product>();
		for (var element : elements) {
			products.add((Product) element);
		
		}

		return products;

	}
	
	public ArrayList<Product> getAllProducts() throws Exception {
		// find all products
		var elements = driver.findElements(product);

		// find the particular product that matches my price
		ArrayList<Product> products = new ArrayList<Product>();
		for (var element : elements) {
		var product = new Product(element);
		products.add(product);
		}
		if (products.size() == 0) {
		throw new Exception("No products");
		}
		return products;
		}

	


	public Product getProduct(CompareProduct comparison) throws Exception {
		var products = getProducts(comparison);
		return products.get(0);
	}

	public ArrayList<Product> getProducts(CompareProduct comparison) throws Exception {

		var elements = driver.findElements(product);
		// find particular product that matches my title
		ArrayList<Product> products = new ArrayList<Product>();
		for (var element : elements) {
			var product = new Product(element);
			if (comparison.Compare(product)) {
				products.add(product);
			}
		}

		if (products.size() == 0) {
			throw new Exception("Could not find product ");
		}

		return products;
	}

	public void getPriceOf(String title) {
		List<WebElement> elements = driver.findElements(By.className("product"));
		for (WebElement element : elements) {

			System.out.println(element.getText());
		}
	}

	public String clickProductBuyButtonBasedOnPrice(Double price) throws Exception {
		var elements = driver.findElements(product);
		for (var element : elements) {
			var product = new Product(element);
			if (product.getPrice() == price) {

				element.findElement(buyButton).click();
				return (product.getTitle() + " is now in the shopping cart");

			}
		}

		throw new Exception("Could not find product ");

	}

	public String clickProductBuyButtonBasedOnTile(String title) throws Exception {
		var elements = driver.findElements(product);
		for (var element : elements) {
			var product = new Product(element);
			if (product.getTitle().equals(title)) {

				element.findElement(buyButton).click();
				return (product.getTitle() + " is now in the shopping cart");

			}
		}

		throw new Exception("Could not find product ");

	}

	public int buyRandomNumberOfItems(Integer numberOfItems) throws Exception {
		var elements = driver.findElements(product);
		ArrayList<WebElement> products = new ArrayList<WebElement>();
		List<String> list = new ArrayList<>();
		List<ProductWithNameAndRating> productList = new ArrayList<ProductWithNameAndRating>();
		for (var element : elements) {
			var productWithRating = new ProductWithNameAndRating();
			String prodID = element.getAttribute("id");
			String prodName = element.findElement(By.className("product-title")).getText();
			String productRating = element.findElement(By.className("rating")).getText();
			var rating = Integer.parseInt(productRating);
			
			
			
			
			products.add(element);
			productWithRating.setName(prodName);
			productWithRating.setRating(rating);
			var it = prodID;
			list.add(it);
			productList.add(productWithRating);
		}
		
		System.out.println(productList);
		Collections.shuffle(list);

		for (int i = 0; i < numberOfItems; i++) {

			for (var element : elements) {
				if (element.getAttribute("id").equals(list.get(i))) {

					element.findElement(buyButton).click();
					// System.out.println("product " + element.findElement(productTitle).getText() +
					// " has been clicked");
				}
			}
		}

		if (elements.size() > 0) {
			return Integer.parseInt(this.getCartText());
		} else {
			throw new Exception("No product located");
		}

	}

	public String clickProductBuyButtonBasedOnRating(String rating) throws Exception {
		var elements = driver.findElements(product);

		for (var element : elements) {
			var product = new Product(element);
			System.out.println(product.getRating() + " : " + rating);
			if (product.getRating().equals(rating)) {

				element.findElement(buyButton).click();
				return (product.getTitle() + " is now in the shopping cart");

			}
		}

		throw new Exception("Could not find product");
	}
	
	public String nameOfProductPerRating(String rating) throws Exception {
		var elements = driver.findElements(product);

		for (var element : elements) {
			var product = new Product(element);
			System.out.println(product.getRating() + " : " + rating);
			if (product.getRating().equals(rating)) {

				element.findElement(buyButton).click();
				return (product.getTitle());

			}
		}

		throw new Exception("Could not find product");
	
	}


	public Product getProductByTitle(String productTitle) throws Exception {
		// find all products
		var elements = driver.findElements(product);
		// find particular product that matches my title
		for (var element : elements) {
			var product = new Product(element);
			if (product.getTitle().equals(productTitle)) {
				return product;
			}
		}

		throw new Exception("Could not find product " + productTitle);
	}

	public Product getProductByPrice(double productPrice) throws Exception {

		var elements = driver.findElements(product);
		for (var element : elements) {
			var product = new Product(element);
			if (product.getPrice() == productPrice) {

				return product;
			}
		}

		throw new Exception("Could not find product " + productPrice);
	}

	public Integer getNoOfProducts() throws Exception {
		var elements = driver.findElements(product);
		if (elements.size() != 0) {
			return elements.size();
		}
		throw new Exception("Could not find any product");
	}

	public void clickCheckoutButton() {
//		var tableCheckout = driver.findElement(table);
//		var checkOutButton = new Table(tableCheckout).getCell(, searchValue, resultColumn) 
		driver.findElement(checkOutButton).click();

	}

	public void Scroll() {
		js.executeScript("window.scrollBy(0,1000)");
	}

	
	
	public int buyRandomNumberOfItemsByRating(Integer numberOfItems) throws Exception {
		var elements = driver.findElements(product);
		ArrayList<WebElement> products = new ArrayList<WebElement>();
		List<String> list = new ArrayList<>();
		List<ProductWithNameAndRating> productList = new ArrayList<ProductWithNameAndRating>();
		for (var element : elements) {
			var productWithRating = new ProductWithNameAndRating();
			String prodID = element.getAttribute("id");
			String prodName = element.findElement(By.className("product-title")).getText();
			String productRating = element.findElement(By.className("rating")).getText();
			var rating = Integer.parseInt(productRating);
			

			products.add(element);
			productWithRating.setName(prodName);
			productWithRating.setRating(rating);
			var it = prodID;
			list.add(it);
			productList.add(productWithRating);
		}
		
	
		Collections.shuffle(list);

		for (int i = 0; i < numberOfItems; i++) {

			for (var element : elements) {
				if (element.getAttribute("id").equals(list.get(i))) {

					element.findElement(buyButton).click();
					// System.out.println("product " + element.findElement(productTitle).getText() +
					// " has been clicked");
				}
			}
		}

		if (elements.size() > 0) {
			return Integer.parseInt(this.getCartText());
		} else {
			throw new Exception("No product located");
		}

	}

	public void clickBuyButtonBasedRating(ArrayList<ProductWithNameAndRating> productsANDratings) {
		var elements = driver.findElements(product);
		// find particular product that matches my title
		
		for (int i = 0; i < elements.size(); i++ ) {
			var rating = productsANDratings.get(i).getRating();
				
			for(int x = 0; x < rating ; x ++) {
				elements.get(i).findElement(buyButton).click();
			}
			
		}
		
		
	}


}
