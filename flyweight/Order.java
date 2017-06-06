package br.com.angeloakm.flyweight;

public class Order {

	private final int orderNumber;
	private final Item item;

	public Order(int orderNumber, Item item) {
		this.orderNumber = orderNumber;
		this.item = item;
	}

	public void processOrder() {
		System.out.println("Ordem: " + orderNumber + " para o item: " + item);
	}

}
