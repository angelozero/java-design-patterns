package br.com.angeloakm.chainofresponsibility;

public class Principal {

	public static void main(String[] args) {
		Director goku = new Director();
		VP crystal = new VP();
		CEO angelo = new CEO();

		goku.setSuccessor(crystal);
		crystal.setSuccessor(angelo);

		Request request = new Request(RequestType.CONFERENCE, 500);
		goku.handleRequest(request);

		request = new Request(RequestType.PURCHASE, 1000);
		goku.handleRequest(request);

		request = new Request(RequestType.PURCHASE, 2000);
		goku.handleRequest(request);

	}
}
