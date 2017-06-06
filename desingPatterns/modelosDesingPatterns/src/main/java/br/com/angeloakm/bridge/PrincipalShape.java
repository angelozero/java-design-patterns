package br.com.angeloakm.bridge;

public class PrincipalShape {

	public static void main(String[] args) {

		/**
		 * A ideia da ponte é que possamos informar uma COR para uma FORMA sem
		 * precisar alterar as classes
		 * 
		 * Color é uma interface aonde todos as cores que implementam dela ,
		 * precisa informa qual cor esta sendo usada
		 * 
		 * Shape é uma classe abstrata aonde toda forma que extende dela , em
		 * seu construtor é obrigado a passar uma Cor, com isso atribuindo
		 * automaticamente uma cor para a forma
		 * 
		 * O Desing Patterns " Bridge " tem como função unir as coisas sem
		 * modifica-las. No caso unimos as cores com as formas , usando uma
		 * Interface Cor e uma classe abstrata Forma
		 */

		/**
		 * Cores
		 */
		Color blue = new Blue();
		Color red = new Red();

		/**
		 * Formas
		 */
		Shape square = new Square(blue);
		Shape circle = new Square(red);

		circle.applyColor();
		square.applyColor();

	}

}
