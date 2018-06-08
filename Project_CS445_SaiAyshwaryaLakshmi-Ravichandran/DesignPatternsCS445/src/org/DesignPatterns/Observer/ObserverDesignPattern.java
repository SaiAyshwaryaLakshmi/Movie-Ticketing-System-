package org.DesignPatterns.Observer;

public class ObserverDesignPattern {
	
	public static void main(String args[]) {
		
		Tweet twitter = new Tweet();
		TwitterUser TwitterUser1 = new TwitterUser();
		TwitterUser TwitterUser2 = new TwitterUser();
		
		twitter.GenuineTwitterAccount(TwitterUser1);
		twitter.GenuineTwitterAccount(TwitterUser2);
		TwitterUser1.setSubject(twitter);
		TwitterUser2.setSubject(twitter);
	
		System.out.println(TwitterUser1.getPost());		
		twitter.postNewTweet();
		System.out.println(TwitterUser2.getPost());
		
		// Observers are deeply coupled in the subject 
		System.out.println("Deeply coupled subject and observers without obeserver design pattern");
		NaiveSubject subject = new NaiveSubject();
		NaiveObserver observer1 = new NaiveObserver();
		NaiveObserver observer2 = new NaiveObserver();
		
		subject.GenuineTwitterAccount(observer1);
		subject.GenuineTwitterAccount(observer2);
		observer1.setSubject(subject);
		observer2.setSubject(subject);
		
		System.out.println(observer1.getPost());
		subject.postNewTweet();
		System.out.println(observer2.getPost());
		
	}

}
