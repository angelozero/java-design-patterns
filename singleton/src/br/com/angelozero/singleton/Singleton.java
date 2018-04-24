package br.com.angelozero.singleton;

public final class Singleton {
	private static Singleton me = new Singleton();

	// construtor privado, impede que seja instânciado fora da própria classe
	private Singleton() {
	}

	public static Singleton getInstance() {
		return me;
	}

	/**
	 * métodos do objeto
	 */

	public void metodoTeste1() {
		System.out.println("Método unico usado por todos que istanciam Singleton --- 1");
	}
	
	public void metodoTeste2() {
		System.out.println("Método unico usado por todos que istanciam Singleton --- 2");
	}
}
