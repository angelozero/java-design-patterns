package br.com.angeloakm.chainofresponsibility;

public class VP extends Handler {

	@Override
	public void handleRequest(Request request) {
		if (request.getRequestType() == RequestType.PURCHASE) {
			if (request.getAmount() < 1500) {
				System.out.println("VP's pode aprovar a compra abaixo de 1500,00");
			
			} else {
				successor.handleRequest(request);

			}

		}
	}
}
