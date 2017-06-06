package br.com.angeloakm.command;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {

		Light light = new Light();
		Light light1 = new Light();
		Light light2 = new Light();
		Light light3 = new Light();
		Light light4 = new Light();

		Switch lightSwitch = new Switch();

		Command onCommand = new ToggleCommand(light);

		lightSwitch.storeAndExecute(onCommand);

		List<Light> lights = new ArrayList<Light>();

		lights.add(light1);
		lights.add(light2);
		lights.add(light3);
		lights.add(light4);
		lights.add(light);

		Command allLightsCommand = new AllLightsCommand(lights);

		lightSwitch.storeAndExecute(allLightsCommand);
	}

}
