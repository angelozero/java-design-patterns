package br.com.angeloakm.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuComponent {

	String name;
	String url;
	List<MenuComponent> menuComponents = new ArrayList<MenuComponent>();

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public MenuComponent add(MenuComponent menuComponent) {
		throw new RuntimeException("Nada implementando até agora");
	}

	public MenuComponent remove(MenuComponent menuComponent) {
		throw new RuntimeException("Nada implementando até agora");
	}

	public abstract String toString();

	public String print(MenuComponent menuComponent) {

		StringBuilder builder = new StringBuilder(name);
		builder.append(": ");
		builder.append(url);
		builder.append("\n");

		return builder.toString();
	}

}
