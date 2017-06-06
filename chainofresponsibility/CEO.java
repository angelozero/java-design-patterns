package br.com.angeloakm.chainofresponsibility;

public class CEO extends Handler {

	@Override
	public void handleRequest(Request request) {
		System.out.println("Angelo pode aprovar tudo o que ele quiser");

	}

}
