package entities;

public class CartItem {
	protected int quantity;
	
	protected Products product;
	
	/**
	 * Create new Cart item
	 * @param product
	 * @param quantity
	 * @throws IllegalStateException if quantity = 0 or less than 0
	 * @throws IllegalStateException if product out of stock
	 * @throws IllegalStateException if quantity more that the stock
	 * @throws IllegalStateException if product is expired
	 */
	CartItem(Products product,int quantity)
	{
		if(quantity <= 0)
		{
			throw new IllegalStateException("quantity must be larger than zero");
		}
		if(product.getQuantity() == 0)
		{
			throw new IllegalStateException("Prodcut out of stock");
		}
		if(quantity > product.getQuantity())
		{
			throw new IllegalStateException("quantity is more the the available in the stock");
		}
		if(product.isExpirable() && product.isExpired())
		{
			throw new IllegalStateException("Product is expired");
		}
		this.quantity = quantity;
		this.product = product;
	}
	
	public Products getProduct()
	{
		return this.product;
	}
	
	public int getQuantity()
	{
		return this.quantity;
	}
}
