package model;

public class Order {
	private String name;
	private int amount;
	private double total;
	private double price;
	
	public Order(String name, int amount, double total, double price) {
		this.name = name;
		this.amount = amount;
		this.total = total;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
