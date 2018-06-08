To run Thalia.war the following configuration is needed.

Steps for Running Thalia.war

1.Install JDK 
2.Install Apache Tomcat
3.Install maven.
4.Deploy the .war file
5.Run maven tests

If you have already done step1 and step2 and Step3 move to Step 4.

Step1 : Install JDK

                1.1 Check version of system
                      file /sbin/init

                 1.2 Check java version
                       java - version

                 1.3Completely remove the OpenJDK/JRE from your system and create a directory to hold your Oracle Java JDK/JRE binaries. 
                      To reomve the existing version of openjdk:
	    sudo apt-get purge openjdk-\*

	   To make a directory to hold the java binaries:
	   sudo mkdir -p /usr/local/java
              
	1.4 Downlod java jdk from their website.
                           cd Downloads
                           wget http://download.oracle.com/otn-pub/java/jdk/9.0.4+11/c2514751926b4512b076cc82f959763f/jdk-9.0.4_linux-x64_bin.tar.gz

                  This url might be different at your time of download, please visit the Oracle JDK download website for the appropriate download link. 

	Recommendation: Download through Oracle GUI because jdk downloaded using wget, misbehaves soemtimes.

	1.5 Copy the Oracle Java binaries into the /usr/local/java directory. 

	cd Downloads
                  sudo cp -r jdk-8u20-linux-x64.tar.gz /usr/local/java/
                   cd /usr/local/java
	
	1.6 Uncompress the jdk file
                  sudo tar xvzf jdk-8u20-linux-x64.tar.gz
                  
                   1.7 Check your directories
                    ls -a 
	 you should be getting 
	 jdk1.8.0_20
	 jre1.8.0_20.
	 Note: For JDK 9 only the jdk with version number will be seen.

	1.8 Set up System Variables
                        sudo gedit /etc/profile
            
                       Add the following lines in /etc/profile

                       JAVA_HOME=/usr/local/java/jdk1.8.0_20
	     JRE_HOME=/usr/local/java/jre1.8.0_20
	     PATH=$PATH:$JRE_HOME/bin:$JAVA_HOME/bin
	     export JAVA_HOME
	     export JRE_HOME
	     export PATH

Note: for JAVA 9 only jdk specification is sufficient example In JAVA_HOME and JRE_HOME =  /usr/local/jdk-9.0.4 - only an example, it is necesary to specify the appropriate version                      

	     Save the file and exit.

                    1.9 Inform your Ubuntu Linux system where your Oracle Java JDK/JRE is located.
                           
                           sudo update-alternatives --install "/usr/bin/java" "java" "/usr/local/java/jdk1.8.0_20/bin/java" 1

                              sudo update-alternatives --install "/usr/bin/javac" "javac" "/usr/local/java/jdk1.8.0_20/bin/javac" 1

sudo update-alternatives --install "/usr/bin/javaws" "javaws" "/usr/local/java/jdk1.8.0_20/bin/javaws" 1

	     1.10Inform your Ubuntu Linux system that Oracle Java JDK/JRE must be the default Java.

		sudo update-alternatives --set java /usr/local/java/jdk1.8.0_20/bin/java

		 sudo update-alternatives --set javac /usr/local/java/jdk1.8.0_20/bin/javac

		sudo update-alternatives --set javaws /usr/local/java/jdk1.8.0_20/bin/javaws

                           1.11 Restart Your System.

	         1.12 Reload your system wide PATH /etc/profile by typing the following command:

                                   source /etc/profile

	         1.13 Check if java version is installed correctly

		 java -version
		 javac -version

Step2: Install Apache Tomcat.- latest version


  $ cd ~/Downloads
  $ wget http://mirrors.gigenet.com/apache/tomcat/tomcat-8/v8.0.33/bin/apache-tomcat-8.0.33.zip
  $ unzip apache-tomcat-8.0.33.zip
  $ sudo mv apache-tomcat-8.0.33 /opt/tomcat
  $ cd /opt/tomcat/bin
  $ chmod 744 *sh
 
The latest version is 9 and the war file is designed using Tomcat 9 but also works with other tomcat servers.

The download url maybe different at the point of download and it is encouraged to get the url from the apache tomcat website.

Another Alternative way to install tomcat is
     
            2.1 Check for upgrades and updates
           apt-get update && apt-get upgrade
           
             2.2 Download the tomcat file
             cd /opt
             wget http://mirror.symnds.com/software/Apache/tomcat/tomcat-9/v9.0.0.M9/bin/apache-tomcat-9.0.0.M9.tar.gz
             
             2.3 Extract the Tomcat file
                   mkdir /opt/tomcat
                   cd /opt/tomcat
                    tar -zxf apache-tomcat-9.0.0.M6.tar.gz

               2.4 Set the environment variables
                    gedit /etc/systemd/system/tomcat.service

                   [Unit]
	Description=Tomcat9
	After=network.target

	[Service]
	Type=forking

	Environment=CATALINA_PID=/opt/tomcat-latest/tomcat9.pid
	Environment=JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64
	Environment=CATALINA_HOME=/opt/tomcat-latest
	Environment=CATALINA_BASE=/opt/tomcat-latest
	Environment="CATALINA_OPTS=-Xms512m -Xmx512m"
	Environment="JAVA_OPTS=-Dfile.encoding=UTF-8 -Dnet.sf.ehcache.skipUpdateCheck=true -XX:+UseConcMarkSweepGC -XX:+CMSClassUnloadingEnabled -XX:+UseParNewGC"

	ExecStart=/opt/tomcat-latest/bin/startup.sh
	ExecStop=/opt/tomcat-latest/bin/shutdown.sh

	Here tomcat-latest means the latest version of tomcat
	Save and exit.

            2.5 To enable Tomcat and start Service

	systemctl daemon-reload
	systemctl start tomcat
	systemctl enable tomcat

          2.6 Check the server 
 
                curl http://localhost:8080
               

Step 3: Install MAVEN

	cd ~
	sudo apt-get install maven

Step 4:  To Deploy the war file.

           
              4.1 Navigate to the path where the war file is located. eg: cd Downloads. and copy it to the webapps folder of tomcat.
              	  sudo cp -r thalia.war /opt/tomcat/webapps
                
              4.2 Start the tomcat service
                    cd /opt/tomcat
                    systemctl start tomcat

               4.3 Run the curl commands
                     curl http://localhost:8080/thalia/seating
                     
               4.4 Runt the automated test script

Step 5 :   Test the maven files

                   5.1 Navigate to the folder where thalia is located.
                          Eg: cd Downlods.
                          cd thalia
                          mvn clean test

                 5.2 The report for the test is available at /target/site/jacoco/index.html


                  
  

           

                  