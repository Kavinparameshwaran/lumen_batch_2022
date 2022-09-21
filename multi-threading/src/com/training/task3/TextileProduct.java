package com.training.task3;

public class TextileProduct extends Product {

	private String type;
	private String material;
	public TextileProduct(int productId, String productName, double ratePerUnit, String type, String material) {
		super(productId, productName, ratePerUnit);
		this.type = type;
		this.material = material;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	@Override
	public String toString() {
		return "TextileProduct [type=" + type + ", material=" + material + ", getProductId()=" + getProductId()
				+ ", getProductName()=" + getProductName() + ", getRatePerUnit()=" + getRatePerUnit() + "]";
	}

	
	

}
