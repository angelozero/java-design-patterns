package br.com.angeloakm.flyweight;

public class Item {

	private final String name;

	public Item(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
