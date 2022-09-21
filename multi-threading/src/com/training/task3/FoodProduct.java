package com.training.task3;

public class FoodProduct extends Product{

	private String type;
	private String shellLife;
	public FoodProduct(int productId, String productName, double ratePerUnit, String type, String shellLife) {
		super(productId, productName, ratePerUnit);
		this.type = type;
		this.shellLife = shellLife;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getShellLife() {
		return shellLife;
	}
	public void setShellLife(String shellLife) {
		this.shellLife = shellLife;
	}
	@Override
	public String toString() {
		return "FoodProduct [type=" + type + ", shellLife=" + shellLife + ", getProductId()=" + getProductId()
				+ ", getProductName()=" + getProductName() + ", getRatePerUnit()=" + getRatePerUnit() + "]";
	}

	

	
	

}
