package br.com.angeloakm.templatemethod;

public class Principal {
	
	public static void main(String[] args) {
		
		
		
		OrderTemplate webOrder = new WebOrder();
		OrderTemplate mobileOrder = new MobileOrder();
		
		webOrder.processOrder();
		mobileOrder.processOrder();
		
	}

}
