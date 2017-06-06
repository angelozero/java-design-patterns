package br.com.angeloakm.proxy;

public class TwiterServiceStub implements TwitterService {

	@Override
	public String getTimeLine(String screenName) {
		return "Minha linha do tempo";
	}

	@Override
	public void postToTimeline(String screenName, String message) {

	}

}
