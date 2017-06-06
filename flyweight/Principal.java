package br.com.angeloakm.flyweight;

public class Principal {
	public static void main(String[] args) {

		/**
		 * Neste exemplo diminuimos o processamento de dados adicionando na
		 * nossa lista de Pedidos , apenas items que não existe. Fazemos uma
		 * lista apenas com items novos , items que ja foram não precisam ser
		 * processados novamente.
		 * Desempenho e velocidade.
		 */

		InventorySystem ims = new InventorySystem();

		ims.takeOrder("Samsung TV", 1);
		ims.takeOrder("Samsung Celular", 3);
		ims.takeOrder("Apple Celular", 2);

		ims.takeOrder("Samsung TV2", 9);
		ims.takeOrder("Samsung Celular2", 8);
		ims.takeOrder("Apple Celular2", 7);

		ims.takeOrder("Samsung TV", 15);
		ims.takeOrder("Samsung Celular", 6);
		ims.takeOrder("Apple Celular", 12);

		ims.process();

		System.out.println(ims.report());

	}
}
