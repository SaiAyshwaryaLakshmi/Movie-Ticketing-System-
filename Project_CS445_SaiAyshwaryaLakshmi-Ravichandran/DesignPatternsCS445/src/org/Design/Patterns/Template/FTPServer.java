package org.Design.Patterns.Template;

public class FTPServer extends Server {

	@Override
	void initialize() {
		// TODO Auto-generated method stub
		System.out.println("FTP Server Initialized");
	}

	@Override
	void startServer() {
		// TODO Auto-generated method stub
		System.out.println("Starting FTP Server");
		
	}

	@Override
	void stopServer() {
		// TODO Auto-generated method stub
		System.out.println("Stopping FTP Server");
	}

}
