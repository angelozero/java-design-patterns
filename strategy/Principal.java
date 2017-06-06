package br.com.angeloakm.strategy;

public class Principal {
	
	public static void main(String[] args) {
		
		CreditCard amexCard = new CreditCard(new AmexStrategy());
		
		amexCard.setNumber("379185883464283");
		amexCard.setDate("04/2010");
		amexCard.setCvv("123");
		
		System.out.println("O cartão da Amex é valido ? " + amexCard.isValid());
		
		
		
	}

}
