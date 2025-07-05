import java.time.LocalDate;

import entities.Customer;
import entities.Products;
import services.CheckoutService;

public class mian {

	public static void main(String[] args) {
		//eampleInTheChallenge();
		//noShip();
		//emptyCart();
		//expireProduct();
		//outOfStock();
		//outOfStock2();
		//insuFficientBalance();
	}
	
	static void eampleInTheChallenge() {
		Products cheese = new Products("Cheese",100,5,15.00,400.00);
		Products Biscuits = new Products("Biscutes",150,5,15.00,700.00);
		
		Customer cust = new Customer("kerolos",100000.00);
		cust.addProduct(cheese, 2);
		cust.addProduct(Biscuits, 1);

		CheckoutService.Checkout(cust);
	}
	
	
	static void noShip() {
		Products cheese = new Products("Cheese",100,5);
		Products Biscuits = new Products("Biscutes",150,5);
		
		Customer cust = new Customer("kerolos",100000.00);
		cust.addProduct(cheese, 2);
		cust.addProduct(Biscuits, 1);
		
		CheckoutService.Checkout(cust);
	}
	
	static void emptyCart() {
		Products cheese = new Products("Cheese",100,5,15.00,400.00);
		Products Biscuits = new Products("Biscutes",150,5,15.00,700.00);
		
		Customer cust = new Customer("kerolos",100000.00);
		
		CheckoutService.Checkout(cust);
	}
	
	static void expireProduct() {
		Products cheese = new Products("Cheese",100,5,LocalDate.now().minusDays(3));
		
		Customer cust = new Customer("kerolos",100000.00);
		cust.addProduct(cheese, 1);

		CheckoutService.Checkout(cust);
	}
	
	static void outOfStock() {
		Products cheese = new Products("Cheese",100,5);
		
		Customer cust = new Customer("kerolos",100000.00);
		cust.addProduct(cheese, 6);

		CheckoutService.Checkout(cust);
	}
	
	static void outOfStock2() {
		Products cheese = new Products("Cheese",100,5,15.00,400.00);
		Products Biscuits = new Products("Biscutes",150,5,15.00,700.00);
		
		Customer cust = new Customer("kerolos",100000.00);
		cust.addProduct(cheese, 2);
		cust.addProduct(Biscuits, 1);
		cust.addProduct(cheese, 2);
		cust.addProduct(cheese, 2);
		
		CheckoutService.Checkout(cust);
	}
	
	static void insuFficientBalance() {
		Products cheese = new Products("Cheese",100,5);
		
		Customer cust = new Customer("kerolos",10.00);
		cust.addProduct(cheese, 1);

		CheckoutService.Checkout(cust);
	}
}
