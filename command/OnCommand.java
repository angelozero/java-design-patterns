package br.com.angeloakm.command;

//Comando concreto
public class OnCommand implements Command {

	private Light light;

	public OnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
	}

}
