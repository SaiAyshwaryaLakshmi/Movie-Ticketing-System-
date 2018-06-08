package org.Design.Patterns.Template;

public class ServerTemplateImplementation {
	
	public static void main(String[] args)
	{
		Server ftpServer = new FTPServer();
		ftpServer.serverTemplate();
		System.out.println();
		Server webServer = new WebServer();
		webServer.serverTemplate();
		
		System.out.println("\nWithout using template method design pattern\n");
		
		
		NaiveFTPServer ftp = new NaiveFTPServer();
		String init = ftp.initialize();   
		String start =ftp.startServer();   
		String stop = ftp.stopServer();
		System.out.println(init+"\t"+start+"\t"+stop);
		
		// same code is being used in both the servers but they are not being re-used
		
		NaiveWebServer web = new NaiveWebServer();
		String webinit =web.initialize();
		String webstart = web.startServer();
		String webstop = web.stopServer();
		System.out.println(webinit+"\t"+webstart+"\t"+webstop);
	}

}
