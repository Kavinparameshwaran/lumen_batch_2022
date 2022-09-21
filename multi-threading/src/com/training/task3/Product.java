package com.training.task3;

public class Product implements Comparable<Product>{
	private int productId;
	private String productName;
	private double ratePerUnit;

	public Product(int productId, String productName, double ratePerUnit) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.ratePerUnit = ratePerUnit;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getRatePerUnit() {
		return ratePerUnit;
	}
	public void setRatePerUnit(double ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", ratePerUnit=" + ratePerUnit
				+ "]";
	}
	@Override
	public int compareTo(Product other) {
		if(this.getRatePerUnit()<other.getRatePerUnit()) return 1;
		else if(this.getRatePerUnit()>other.getRatePerUnit()) return -1;
		return 0;
	}
	

}
