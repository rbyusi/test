package com.planittesting.jupiter.model.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Table {

	private By header = By.tagName("th");
	private By row = By.cssSelector("tbody tr");
	private By cell = By.tagName("td");
	private By footerRow = By.cssSelector("tfoot tr");
	private By table_Rows = By.tagName("tr");

	WebElement rootElement;

	public Table(WebElement rootElement) {
		this.rootElement = rootElement;

	}

	public WebElement getCell(String searchColumn, String searchValue, String resultColumn) throws Exception {
		int searchColumnIndex = -1;
		int resultColumnIndex = -1;

		// find all of the <th> -> table headers
		var tableHeaders = rootElement.findElements(header);
		// loop through each table header find our search column and result column and
		// store the index
		for (var i = 0; i < tableHeaders.size(); i++) {
			var columnText = tableHeaders.get(i).getText();

			if (columnText.equals(searchColumn)) {
				searchColumnIndex = i;
				continue;
			}

			if (columnText.equals(resultColumn)) {
				resultColumnIndex = i;
			}
		}

		if (searchColumnIndex == -1) {
			throw new Exception("Couldn't find  " + searchColumn);
		}
		if (resultColumnIndex == -1) {
			throw new Exception("Couldn't find  " + resultColumn);
		}
		// find all the table rows not including the header row

		var tableRows = rootElement.findElements(row);

		for (var tableRow : tableRows) {
			var cells = tableRow.findElements(cell);
			if (cells.get(searchColumnIndex).getText().equals(searchValue)) {
				return cells.get(resultColumnIndex);
			}
		}

		throw new Exception("Couldn't find item row containing" + searchValue + " in the table ");
	}
	
	
}
