package br.com.angeloakm.decorator;

public class Principal {

	public static void main(String[] args) {

		Sandwich sandwich = new DressingDecorator(new MeatDecorator(new SimpleSandwich()));
		
		System.out.println(sandwich.make());

	}

}
