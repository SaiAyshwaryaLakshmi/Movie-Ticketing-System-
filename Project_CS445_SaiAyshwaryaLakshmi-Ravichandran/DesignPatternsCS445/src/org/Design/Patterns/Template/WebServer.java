package org.Design.Patterns.Template;

public class WebServer extends Server {

	@Override
	void initialize() {
		// TODO Auto-generated method stub
		System.out.println("WebServer Server Initialized");
	}

	@Override
	void startServer() {
		// TODO Auto-generated method stub
		System.out.println("Starting WebServer Server");
	}

	@Override
	void stopServer() {
		// TODO Auto-generated method stub
		System.out.println("Stopping WebServer Server");
	}

}
