package br.com.angeloakm.command;

//Receptor
public class Light {

	private boolean isOn = false;
	
	public boolean isOn(){
		return isOn;
	}

	public void toogle() {
		if (isOn) {
			off();
			isOn = false;
		} else {
			on();
			isOn = true;
		}
	}

	public void on() {
		System.out.println("Luz ligada !");
	}

	public void off() {
		System.out.println("Luz apagada !");
	}

}
