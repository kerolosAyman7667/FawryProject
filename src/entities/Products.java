package entities;

import java.time.LocalDate;

/**
 * 
 * @author Kerolos
 * @implements IShippableItem, IExpiredItem
 *
 */
public class Products implements IShippableItem, IExpiredItem
{

	protected String name;
	
	protected double price;
	
	protected int quantity;
	
	protected LocalDate expireDate = null;
	
	protected Double weight = null;
	protected Double fees = null;

	/**
	 * Create Product without Expire or shipment
	 * @param {string} name
	 * @param {double} price 
	 * @param {int} quantity
	 * @throws IllegalStateException - if the quantity is or price less than zero
	 */
	public Products(String name,double price, int quantity) 
	{
		if(price < 0 || quantity < 0)
		{
			throw new IllegalStateException("Price and quantity cannot be less than zero");
		}
		
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	/**
	 * Create Product with ExpireDate
	 * @param {string} name
	 * @param {double} price 
	 * @param {int} quantity
	 * @param {LocalDate} expireDate
	 */
	public Products(String name,double price, int qunatity,LocalDate expireDate) 
	{
		this(name,price,qunatity);
		this.expireDate = expireDate;
	}
	
	/**
	 * Create Product with Shipment
	 * @param {string} name
	 * @param {double} price 
	 * @param {int} quantity
	 * @param {Double} fees
	 * @param {Double} weight in grams
	 */
	public Products(String name,double price, int qunatity,Double fees,Double weight) 
	{
		this(name,price,qunatity);
		this.weight = weight;
		this.fees = fees;
	}
	
	/**
	 * Create Product with Shipment and Expiration
	 * @param {string} name
	 * @param {double} price 
	 * @param {int} quantity
	 * @param {Double} fees
	 * @param {Double} weight in grams
	 * @param {LocalDate} expireDate
	 */
	public Products(String name,double price, int qunatity,Double fees,Double weight,LocalDate expireDate) 
	{
		this(name,price,qunatity,fees,weight);
		this.expireDate = expireDate;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Check if product is expired or not
	 * @summary if the expire date is not set then the product is **not** Expirable 
	 * @return {boolean}
	 */
	public boolean isExpirable() {
		return expireDate != null;
	}
	
	/**
	 * Check if product can be shipped or not
	 * @summary if either weight or fees not set then item is not Shippable and will be false
	 * @return {boolean}
	 */
	public boolean isShippable() {
		return this.weight != null && this.fees != null;
	}
	
	/**
	 * Check if product is expired
	 * @throws IllegalStateException - if the product is not expirable >> isExpirable = false
	 * @return {boolean}
	 */
	public boolean isExpired() {
		if(!isExpirable())
			throw new IllegalStateException("Product doesnt have expire date");
		return expireDate.isBefore(LocalDate.now());
	}

	public LocalDate getExpireDate() {
		return expireDate;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public double getFees() {
		return fees;
	}
	
	public double reduceQuantity() {
		return quantity -= 1;
	}
}
