package br.com.angeloakm.command;

//Comando concreto
public class ToggleCommand implements Command {

	private Light light;

	public ToggleCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.toogle();
	}

}
