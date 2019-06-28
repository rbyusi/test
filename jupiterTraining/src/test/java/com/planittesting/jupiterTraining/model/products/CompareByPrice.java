package com.planittesting.jupiterTraining.model.products;

public class CompareByPrice implements CompareProduct {

	private double price;
	public CompareByPrice(double price) {
		this.price = price;
	}
	
	@Override
	public boolean Compare(Product product) {
		return product.getPrice() == this.price;

	}

}
