package org.DesignPatterns.Observer;

public class NaiveObserver {
	
	private String post;
	private NaiveSubject tweet;

	public void setSubject(NaiveSubject tweet) {
		this.tweet = tweet;
		post = "No New Post!";
	}

	public void update() {
		System.out.println("Tweets Changed! Notified.");
		post = (String) tweet.getNewTweets();
	}

	public String getPost() {
		return post;
	}

}
