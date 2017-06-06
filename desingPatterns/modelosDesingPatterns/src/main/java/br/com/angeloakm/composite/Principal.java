package br.com.angeloakm.composite;

public class Principal {

	public static void main(String[] args) {

		Menu menuPrincipal = new Menu("Main", "/main");
		Menu menuPrincipal2 = new Menu("Claims", "/claims");
		MenuItem subMenu = new MenuItem("Safety", "/safety");
		MenuItem subMenu2 = new MenuItem("Personal Claim", "/personalClaims");

		menuPrincipal2.add(subMenu2);
		menuPrincipal.add(menuPrincipal2);
		menuPrincipal.add(subMenu);

		System.out.println(menuPrincipal.toString() + "\n");

	}

}
