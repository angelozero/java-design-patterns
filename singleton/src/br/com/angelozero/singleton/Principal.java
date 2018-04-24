package br.com.angelozero.singleton;

public class Principal {

	public static void main(String[] args) {

		Singleton singleton = Singleton.getInstance();

		singleton.metodoTeste1();

		// ou

		Singleton.getInstance().metodoTeste2();
	}

}
