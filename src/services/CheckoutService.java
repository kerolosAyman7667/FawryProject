package services;

import java.util.ArrayList;

import entities.CartItem;
import entities.Customer;
import entities.IShippableItem;
import entities.Products;

public class CheckoutService 
{
	/**
	 * Checkout products in cart
	 * @throws IllegalStateException - if cart is empty
	 * @param {Customer} customer
	 */
	public static void Checkout(Customer customer)
	{
		String printing = "** Checkout receipt **";
		String shipPrinting = "** Shipment receipt **";
		if(customer.getCart().isEmpty())
		{
			throw new IllegalStateException("Cart is empty, add items to cart");
		}
		
		double subTotalPrice = 0;
		double shipmentFees = 0;
		double packageWeight = 0;
		ArrayList<CartItem> cart = customer.getCart();
		ArrayList<IShippableItem> shipItems = new ArrayList<IShippableItem>();
		for(int i =0;i < cart.size(); i++)
		{
			double currentPrice = 0;

			CartItem currentCart  = cart.get(i);
			Products currentProduct  = currentCart.getProduct();

			currentPrice += currentProduct.getPrice() * currentCart.getQuantity();
			if(currentProduct.isShippable())
			{
				shipItems.add(currentProduct);
				shipmentFees += currentProduct.getFees();
				packageWeight += currentProduct.getWeight();
				shipPrinting += "\n " + currentCart.getQuantity() + "x  " + currentProduct.getName() + "       " + currentProduct.getWeight() + "g";
			}
			
			printing += "\n " + currentCart.getQuantity() + "x  " + currentProduct.getName() + "       " + currentPrice;
			subTotalPrice += currentPrice;
		}
		
		printing += "\n ---------------"; 
		double totalPrice = shipmentFees + subTotalPrice;

		if(totalPrice > customer.getbalance())
		{
			throw new IllegalStateException("You don't have enought money, poor");
		}
		printing += "\n SubTotal        " + subTotalPrice; 
		printing += "\n Shipping        " + shipmentFees; 
		printing += "\n Amount          " + totalPrice; 
		shipPrinting += "\n Total package weight" + packageWeight / 1000 +"kg";

		if(shipItems.size() > 0)
		{
			ShipmentService.Ship(shipItems);
			System.out.println(shipPrinting);
		}
		System.out.println(printing);
	}
}
