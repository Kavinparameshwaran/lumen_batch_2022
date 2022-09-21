package com.training.task3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ProductsServices {
	private Collection<Product> list;
	private Collection<Product> returnList;
	
	public ProductsServices() {
		super();
		this.list =new  ArrayList<Product>();
		this.returnList=new ArrayList<Product>();	
	}
	public boolean add(Product product) {
		return this.list.add(product);
	}
	public Collection<Product> findTopThree(){
		Collections.sort((List<Product>) list);
		int i=0;
		for(Product eachProduct:list) {
			returnList.add(eachProduct);
			i++;
			if(i==3) {
				break;
			}
		}
		return returnList;
	}
	public Collection<Product> findLeastThree(){
		Collections.sort((List<Product>) list);
		int lim=list.size()-3;
		for(int i=list.size()-1;i>=0;i--) {
		returnList.add(((ArrayList<Product>) list).get(i));
		if(i==lim) {
			break;
		}
		}
		return returnList;
		
		
	}



}
