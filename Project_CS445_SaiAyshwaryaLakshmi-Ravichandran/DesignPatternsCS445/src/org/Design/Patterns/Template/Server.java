package org.Design.Patterns.Template;

public abstract class Server {
	
	abstract void initialize();
	abstract void startServer();
	abstract void stopServer();
	
	public final void serverTemplate()
	{
		initialize();
		startServer();
		stopServer();
	    
	}
}
