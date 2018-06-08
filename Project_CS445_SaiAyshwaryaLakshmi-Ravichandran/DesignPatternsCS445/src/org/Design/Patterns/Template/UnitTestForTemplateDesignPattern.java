package org.Design.Patterns.Template;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

public class UnitTestForTemplateDesignPattern {

	@Test
	public void testFTPServer()
	{
		//does not change state of object so testing not necessary
		Server server = new FTPServer();
		server.serverTemplate(); 
		server.initialize();
		server.startServer();
		server.stopServer();
	}
	
	@Test 
	public void testWebServer()
	{
		// does not change state of object so testing not necessary
		Server server = new WebServer();
		server.serverTemplate();
		server.startServer();
		server.stopServer();
		server.initialize();
	}
	
	@Test
	public void testNaiveWebserver()
	{
		NaiveWebServer nsrv = new NaiveWebServer();
		assertEquals("WebServer Server Initialized",nsrv.initialize());
		assertEquals("Starting WebServer Server",nsrv.startServer());
		assertEquals("Stopping WebServer Server",nsrv.stopServer());
	}
	
	@Test
	public void testNaiveFTPServer()
	{
		NaiveFTPServer ftp = new NaiveFTPServer();
		assertEquals("FTP Server Initialized",ftp.initialize());
		assertEquals("Starting FTP Server",ftp.startServer());
		assertEquals("Stopping FTP Server",ftp.stopServer());
		
	}

}
