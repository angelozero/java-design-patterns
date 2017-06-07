package br.com.angeloakm.templatemethod;

public class WebOrder extends OrderTemplate {

	@Override
	public void doCheckout() {
		System.out.println("Fazendo o checkout - WEB");

	}

	@Override
	public void doPayment() {
		System.out.println("Fazendo o pagamento - WEB");

	}

	@Override
	public void doReceipt() {
		System.out.println("Gerando o recibo - WEB");

	}

	@Override
	public void doDelivery() {
		System.out.println("Fazendo a entrega - WEB");

	}

}
