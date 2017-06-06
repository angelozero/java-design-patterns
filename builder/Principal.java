package br.com.angeloakm.builder;

import br.com.angeloakm.builder.LunchOrder.Builder;

public class Principal {

	public static void main(String[] args) {

		/**
		 * Um builder auxilia na criação de um objeto sem criar um construtor
		 * gigantesco e nao precisamos nos preocupar com a ordem dos dados
		 * inseridos. Isso te da uma flexibilidade muito maior para criar os
		 * objetos
		 */

		LunchOrder.Builder builder = new Builder();

		builder.bread("Pao").condiments("Manteiga");

		LunchOrder lucnh = builder.build();

		System.out.println(lucnh.getBread());
		System.out.println(lucnh.getCondiments());

	}

}
