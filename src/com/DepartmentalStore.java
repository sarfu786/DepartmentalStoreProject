package com;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class DepartmentalStore {

	Scanner s = new Scanner(System.in);
	LinkedHashMap<Integer, Product> db = new LinkedHashMap<>();
	int totalbill=0;
	public void addproduct() {
		db.put(1, new Product("chocolates", 10, 20));
		db.put(2, new Product("biscuits", 15, 10));
		db.put(3, new Product("ice-cream", 20, 30));
	}
	public void displayproducts() {
		       Set<Integer> keys= db.keySet();
		       for(int key:keys) {
		    	   Product p = db.get(key);
		    	   System.out.println("Enter "+key+ " to order "+ p.getName() );
		    	   System.out.println("Available Quantity:"+p.getQuantity());
		    	   System.out.println(" Cost  " +p.getCost());
		    	   System.out.println("-----------------");
		       }
		
	}
	public void buyproduct() {
		System.out.println("enter the choice");
		int choice = s.nextInt(); //choice ->key
		
		Product p = db.get(choice); // getting the product based on key
		
		if(p!=null) {
			
			System.out.println("enter Quantity");
			int qty = s.nextInt();
			if(qty <= p.getQuantity()) {
				int productCost = qty * p.getCost();// currentcost
				totalbill = totalbill +productCost; // totalbill += productcost
				p.setQuantity(p.getQuantity()-qty);
				System.out.println("Ordered "+qty+" "+p.getName()+" at the cost of Rs."+productCost);
				System.out.println("total Bill as of now:"+totalbill);
				
			}
			else {
				try {
				String message = "Invalid Quantity "+p.getName()+" are not available ";
				throw new InvalidQuantityException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
					
				}
			}
			
		}
		else {
			try {
			String message =" invalid choice,kindly enter valid choice";
			throw new InvalidChoiceException(message);
			}
			catch(Exception e) {
			System.out.println(e.getMessage())	;
			}
		}
		
	}
	public void checkout() {
		System.out.println("Total Bill: Rs " +totalbill);
		System.out.println("Thank you for Shopping");
	}
	
	
	
}
