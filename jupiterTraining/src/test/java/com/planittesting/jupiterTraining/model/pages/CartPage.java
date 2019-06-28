package com.planittesting.jupiterTraining.model.pages;

import javax.sound.midi.Soundbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.planittesting.jupiter.model.ui.Table;
import com.planittesting.jupiterTraining.model.dialogs.RemoveItemDialog;

public class CartPage extends BasePage {

	private By cartItemsTable = By.className("table");
	private By removeItem = By.className("remove-item");
	private By removeItemDialog = By.className("popup");
	private By emptyCartMessage = By.className("alert");
	private By quantityField = By.name("quantity");
	
	private String ItemColumnName = "Item";
	private String PriceColumnName = "Price";
	private String ActionsColumnName = "Actions";


	private WebElement table;

	public CartPage(WebDriver driver) {
		super(driver);

	}

	public double getPriceOfItem(String itemName) throws Exception {
		table =  driver.findElement(cartItemsTable);
		var itemPriceCell = new Table(table).getCell("Item", itemName, "Price");
		var priceAsString = itemPriceCell.getText().replace("$","");
		return Double.parseDouble(priceAsString);
		
	}
	
	public void increaseProductQuantityPerRating(String productname, String rating) throws Exception {
		table =  driver.findElement(cartItemsTable);
		var itemInputCell = new Table(table).getCell("Item", productname, "Quantity");
		
		itemInputCell.findElement(quantityField).clear();
		itemInputCell.findElement(quantityField).sendKeys(rating);

		
	}

	public void removeItem(String itemName) throws Exception {
		var table = driver.findElement(cartItemsTable);
		var removeItemCell = new Table(table).getCell(ItemColumnName, itemName, ActionsColumnName);
		removeItemCell.findElement(removeItem).click();
		
		var dialog = new RemoveItemDialog(driver.findElement(removeItemDialog));
		dialog.clickYes();
		
	}

	public String getEmptyCartMessage() {
		return driver.findElement(emptyCartMessage).getText();
	}

	public Double getSubTotal(String productName) throws Exception {
		var table = driver.findElement(cartItemsTable);
		var removeItemCell = new Table(table).getCell("Item", productName , "Subtotal");
		var subtotal = removeItemCell.getText().replace("$", "");

		return Double.parseDouble(subtotal);
	}

	public int getProductQuantity(String name) throws Exception {
		table =  driver.findElement(cartItemsTable);
		var quantity = new Table(table).getCell("Item", name, "Quantity");
		
		var itemQuantity=quantity.findElement(quantityField).getAttribute("value");
		
		return Integer.parseInt(itemQuantity);
		
	}



}
