package br.com.angeloakm.chainofresponsibility;

public class Director extends Handler {

	@Override
	public void handleRequest(Request request) {
		if (request.getRequestType() == RequestType.CONFERENCE) {
		
			System.out.println("O diretor pode aprovar esta compra");
		
		} else {
			successor.handleRequest(request);
		}

	}

}
