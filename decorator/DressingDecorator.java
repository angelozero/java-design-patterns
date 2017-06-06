package br.com.angeloakm.decorator;

public class DressingDecorator extends SandwichDecorator {

	public DressingDecorator(Sandwich customSandwich) {
		super(customSandwich);
	}

	@Override
	public String make() {
		return customSandwich.make() + addDressing();
	}

	private String addDressing() {
		return "+ mostarda";
	}

}
