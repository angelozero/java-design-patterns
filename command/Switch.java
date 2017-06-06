package br.com.angeloakm.command;

//Invocador
public class Switch {

	public void storeAndExecute(Command command) {
		command.execute();
	}

}
