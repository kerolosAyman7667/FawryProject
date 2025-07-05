package entities;

import java.util.ArrayList;

public class Customer {

	protected String name;
	
	protected double balance;
	
	protected ArrayList<CartItem> cart = new ArrayList<CartItem>();
	
	public Customer(String name, double balance)
	{
		this.name = name;
		this.balance = balance;
	}
	
	//handle if user added product with same name to it to the quantity
	public void addProduct(Products product,int quantity)
	{
		boolean found = false;
		for (CartItem x : cart) {
		    if (product.getName().equals(x.product.name)) {
		        x.addQuantity(quantity);
		        found = true;
		        break;
		    }
		}
		
		if(!found)
		{
			cart.add(new CartItem(product,quantity));
		}
		product.reduceQuantity(quantity);
	}
	
	public ArrayList<CartItem> getCart()
	{
		return cart;
	}
	
	public double getbalance()
	{
		return balance;
	}
	
	public double reducebalance(double amount)
	{
		return balance -= amount;
	}
}
