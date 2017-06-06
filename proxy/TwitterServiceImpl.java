package br.com.angeloakm.proxy;

import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterServiceImpl implements TwitterService {

	private static final String TWITTER_CONSUMER_KEY = "CONSUMER_KEY";
	private static final String TWITTER_SECRET_KEY = "SECRET_KEY";
	private static final String TWITTER_ACCESS_TOKEN = "ACCESS_TOKEN";
	private static final String TWITTER_ACCESS_TOKEN_SECRET = "ACCESS_TOKEN_SECRET";

	@Override
	public String getTimeLine(String screenName) {

		ConfigurationBuilder cb = new ConfigurationBuilder();

		cb.setDebugEnabled(true).setOAuthConsumerKey(TWITTER_CONSUMER_KEY).setOAuthConsumerSecret(TWITTER_SECRET_KEY)
				.setOAuthAccessToken(TWITTER_ACCESS_TOKEN).setOAuthAccessTokenSecret(TWITTER_ACCESS_TOKEN_SECRET);

		TwitterFactory tf = new TwitterFactory(cb.build());

		Twitter twitter = tf.getInstance();

		StringBuilder builder = new StringBuilder();

		try {

			Query query = new Query(screenName);
			QueryResult result;

			do {
				result = twitter.search(query);
				List<Status> tweets = result.getTweets();

				for (Status tweet : tweets) {
					builder.append("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
					builder.append("\n");
				}
			} while ((query = result.nextQuery()) != null);

			
			//twitter.updateStatus("@thonrocha #top");
			
		} catch (Exception e) {
			throw new RuntimeException("Erro ao procurar pelos tweets: " + e.getMessage());
		}

		return builder.toString();
	}

	@Override
	public void postToTimeline(String screenName, String message) {
		System.out.println(message);
	}

}
