package com.planittesting.jupiterTraining.model.products;

public class CompareByTitle implements CompareProduct{

	private String title;
	
	public CompareByTitle(String title) {
		this.title = title;
	}
	
	@Override
	public boolean Compare(Product product) {
		return product.getTitle().equals(title);
	}

}
