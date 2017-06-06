package br.com.angeloakm.abstractfactory.copy;

public class Principal {

	public static void main(String[] args) {

		/**
		 * AbstractFactory pattern -> neste exmplo temos uma fabrica de cartoes
		 * referente a pontuação do cliente. O cliente informa a pontuação que
		 * tem e qual cartão deseja ter, isso é enviado para uma fabrica e se
		 * atender os requisitos necessarios ele tera o cartao que pediu, se não
		 * terá o cartão que melhor se encaixa com sua pontuação
		 * 
		 * A fabrica não precisa saber qual bandeira ou qual modelo vai ser, ela so
		 * precisa da sua pontuação e qual modelo vc deseja
		 * 
		 */

		CreditCardFactory abstractFactory = CreditCardFactory.getCreditCardFactory(750);

		CreditCard card = abstractFactory.getCreditCard(CardType.SILVER);

		System.out.println(card.getClass().getName());

		System.out.println(" ");

		abstractFactory = CreditCardFactory.getCreditCardFactory(600);

		CreditCard card2 = abstractFactory.getCreditCard(CardType.GOLD);

		System.out.println(card2.getClass().getName());

	}

}
