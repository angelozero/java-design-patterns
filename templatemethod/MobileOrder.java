package br.com.angeloakm.templatemethod;

public class MobileOrder extends OrderTemplate {

	@Override
	public void doCheckout() {
		System.out.println("Fazendo o checkout - Mobile");

	}

	@Override
	public void doPayment() {
		System.out.println("Fazendo o pagamento - Mobile");

	}

	@Override
	public void doReceipt() {
		System.out.println("Gerando o recibo - Mobile");

	}

	@Override
	public void doDelivery() {
		System.out.println("Fazendo a entrega - Mobile");

	}

}
