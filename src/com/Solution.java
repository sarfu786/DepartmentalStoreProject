package com;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		System.out.println("welcome to xyz department");
		System.out.println("**************************");
		Scanner s = new Scanner(System.in);
		DepartmentalStore store = new DepartmentalStore();
		store.addproduct();
		
		int choice=1;
		while(choice==1) {
			store.displayproducts();
			store.buyproduct();
			System.out.println("--------");
			System.out.println("enter 1 to continue shopping or any other to chcekout");
			choice= s.nextInt();
			
		}
		store.checkout();
		
		
	}

}
