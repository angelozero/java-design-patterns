package br.com.angeloakm.bridge;

import java.util.List;

public class PrincipalMovie {

	public static void main(String[] args) {

		/**
		 * A ideia da ponte é que possamos unir um FILME e seus DETALHES e
		 * exibir suas informações sem precisar alterar as classes
		 * 
		 * No caso tenho uma interface chamada Formatter, aonde todos que a
		 * implementam deve escrever o metódo format recebendo como parametros
		 * uma String header e uma List<Detail> details
		 * 
		 * Para exbição dos detalhes eu tenho uma classe abstrata chamada
		 * Printer que recebe como parametro em seu construtor a interface
		 * Formater, e incluo os metodos de getHeader e getListDetails como
		 * metodos abstratos. Assim toda classe auxiliar de filme ( MoviePrinter
		 * por exemplo ) for criada , deve extender Printer.
		 * 
		 */

		Movie movie = new Movie();
		movie.setClassification("Action");
		movie.setTitle("Samurai X");
		movie.setRunTime("2:30");
		movie.setYear("2014");

		/**
		 * Instancio um MoviePrinter com os dados do Filme, MoviePrinter extende
		 * de Printer com seus métodos getItem() e getDetalhes()
		 */
		Printer moviePrint = new MoviePrinter(movie);

		/**
		 * Instancio um formatador , dentro de PrintFormatter tenho o método
		 * format(String header, List<Detail> details) sobreescrito para
		 * devolver os dados do filme
		 */
		Formatter printFormatter = new PrintFormatter();

		/**
		 * Com moviePrint eu invoco o método print() passando o formatador para
		 * receber os dados do filme conforme defini nos métodos sobrescritos de
		 * PrintFormatter
		 * 
		 */
		String printedMaterial = moviePrint.print(printFormatter);

		/**
		 * Exibo o retorno
		 */
		System.out.println(printedMaterial);

	}

}
