package org.DesignPatterns.Observer;

public class TwitterUser implements Observer {

	private String post;
	private Subject tweet;

	public void setSubject(Subject tweet) {
		this.tweet = tweet;
		post = "No New Post!";
	}

	@Override
	public void update() {
		System.out.println("Tweets Changed! Notified.");
		post = (String) tweet.getNewTweets();
	}

	public String getPost() {
		return post;
	}
}
