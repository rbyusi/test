package com.planittesting.jupiterTraining.model.products;

public class CompareByRating implements CompareProduct{

	private String rating;
	
	public CompareByRating(String rating) {
		this.rating = rating;
	}
	
	@Override
	public boolean Compare(Product product) {
		return product.getRating().equals(rating);
	}

}
