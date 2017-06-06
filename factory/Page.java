package br.com.angeloakm.factory;

public abstract class Page {
	
	@Override
	public String toString() {
		return "[" + getClass().getName() + "] \n";
	}

}
