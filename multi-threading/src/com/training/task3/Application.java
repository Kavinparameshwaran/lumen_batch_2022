package com.training.task3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		ProductsServices service = new ProductsServices();

		int ch = 1;
		if (ch == 2) {
			Product dosa = new FoodProduct(101, "Dosa", 25, "Veg", "onemonth");
			Product idly = new FoodProduct(102, "idly", 15, "Veg", "onemonth");
			Product chicken = new FoodProduct(103, "chicken", 70, "Non-Veg", "onemonth");
			Product egg = new FoodProduct(104, "egg", 20, "Non-Veg", "onemonth");
			Product cake = new FoodProduct(105, "cake", 75, "Veg", "onemonth");
			Collection<Product> foodList = new ArrayList<>();
			System.out.println("-------------------------------------");
			System.out.println(service.add(dosa));
			System.out.println(service.add(idly));
			System.out.println(service.add(chicken));
			System.out.println(service.add(egg));
			System.out.println(service.add(cake));
			foodList = service.findTopThree();
			for (Product eachFood : foodList) {
				System.out.println(eachFood);
			}
			System.out.println("-------------------------------------");
		} else {
			Product shirt = new TextileProduct(106, "Shirt", 90, "NormalCloth", "Cotton");
			Product tshirt = new TextileProduct(107, "Tshirt", 125, "Knitted", "Jute");
			Product Pants = new TextileProduct(108, "Pants", 500, "tufted", "Nylon");
			Product Boxer = new TextileProduct(109, "Boxer", 400, "bonded", "Fibre");
			Product Saree = new TextileProduct(110, "Saree", 700, "Traditional", "Synthetic thread");
			Collection<Product> textileList = new ArrayList<>();
			System.out.println("-------------------------------------");
			System.out.println(service.add(shirt));
			System.out.println(service.add(tshirt));
			System.out.println(service.add(Pants));
			System.out.println(service.add(Boxer));
			System.out.println(service.add(Saree));
			System.out.println("-------------------------------------");
			textileList = service.findLeastThree();
			for (Product eachTextile : textileList) {
				System.out.println(eachTextile);
			}
		}

	}

}
