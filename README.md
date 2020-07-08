# Getting Started

### Guide

* To run this project you need to install Java 8 and Maven. You can find it here (https://maven.apache.org/download.cgi)

* After installing maven you can run this project with start.sh (Shell Script) with following command:
		    
		    > cd smart-host	
			> ./start.sh
			
	Note : This will create docker container and our application in that with port 8080.
	URL would be http://localhost:8080	
			    
* Or we can run the project manually as defined below:
	
	> cd smart-host
	
	> mvn clean install
	> java -jar target/smart-host-0.0.1-SNAPSHOT.jar
	
	OR
	
	> mvn spring-boot:run	
	
* If want to use DOCKER to run , you can try below commands
    
    > mvn clean install		
	> docker build -t smarthost/smart-host-api .
	> docker run -p 8080:8080 smarthost/smart-host-api
	
	Not: Please install and run docker before running these command
	
   

* Now after running the application you can view the api documentation also here(http://localhost:8080/swagger-ui.html).	
   I have used Swagger UI so that we can also test our API using Web GUI.

 						
 								#### Technology And Framework Used

* I have used Java 8 and SpringBoot Framework  for building Restfull API.
* This framework is very robust and scalable as well its's up to date with latest technologies.
* It provides very good support for maximum third party libraries out of the box, so ts very easy to integrate them.

### Test Cases
I have added some test cases for structure, we can write all combinations to have best coverage of code.

