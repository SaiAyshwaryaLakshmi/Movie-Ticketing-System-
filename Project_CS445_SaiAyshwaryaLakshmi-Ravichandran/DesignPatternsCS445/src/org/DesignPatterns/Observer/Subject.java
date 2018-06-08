package org.DesignPatterns.Observer;

public interface Subject {

	public void GenuineTwitterAccount(Observer observer);

	public void notifyAllAccounts();

	public void AnonymousTwitterAccount(Observer observer);

	public Object getNewTweets();

}
