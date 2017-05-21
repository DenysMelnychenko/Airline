# Airline launching instruction:

To configure maven tomcat plugin you should add new user to  <strong>tomcat-users.xml</strong> in tomcat settings and configute server.xml.
The path to the settings is <strong>%TOMCAT_PATH%/conf/tomcat-users.xml</strong><br>
There you should insert the appropriate lines

	<tomcat-users>
		<role rolename="manager-gui"/>  
        <role rolename="manager-script"/>   
        <user username="admin" password="admin" roles="manager-gui,manager-script" />
	</tomcat-users>
	
Then you should edit Maven settings.xml<br>
Insert appropriate lines<br>

	<server>
       <id>TomcatServer</id>
       <username>admin</username>
       <password>admin</password>
    </server>	
To launch the program you should run Tomcat from command line with help of next command
	cd %TOMCAT_PATH%/bin
	startup.bat (if you use windows)
	 or 
	 startup.sh	(if you use linux or mac OS)
	 
After that you should deploy project to Tomcat server
use next command from project directory:
	%PROJECT_PATH% mvn tomcat7:depoy -Pstudent 	 (if you want to use Student profile)
or
	%PROJECT_PATH% mvn tomcat7:depoy -Pmentor 	 (if you want to use Mentor profile)
To open project launch browser and enter URL: your_tomcat_server_address/airline
	
