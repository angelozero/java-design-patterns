package br.com.angeloakm.proxy;

public class Principal {

	public static void main(String[] args) {

		TwitterService service = (TwitterService) SecurityProxy.newInstance(new TwitterServiceImpl());

		System.out.println(service.getTimeLine("angelo_akm"));

		service.postToTimeline("angelo_akm", "Uma mensagem de teste");
		
	}

}
