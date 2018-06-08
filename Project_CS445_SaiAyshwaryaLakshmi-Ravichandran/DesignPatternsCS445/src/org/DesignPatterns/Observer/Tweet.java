package org.DesignPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class Tweet implements Subject {

	List<Observer> listofAccounts;
	private boolean stateChange;

	public Tweet() {
		this.listofAccounts = new ArrayList<Observer>();
		stateChange = false;
	}

	public void GenuineTwitterAccount(Observer observer) {
		listofAccounts.add(observer);
	}

	public void AnonymousTwitterAccount(Observer observer) {
		listofAccounts.remove(observer);
	}

	public void notifyAllAccounts() {

		if (stateChange) {
			for (Observer observer : listofAccounts) {
				observer.update();
			}
		}
	}

	public Object getNewTweets() {
		Object changedState = null;
		// should have logic to send the
		// state change to querying observer
		if (stateChange) {
			changedState = "Alert! New Tweet!";
		}
		return changedState;
	}

	public void postNewTweet() {
		stateChange = true;
		notifyAllAccounts();
	}

}
