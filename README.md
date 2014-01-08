Canvass
=======

Requirements
------------
- Java 7
- Maven 3

Build
------------
- From base directory
- Run ```mvn install```

Run Embedded Server
-------------------
- From base directory, or *canvass-web-main*
- Execute ```mvn tomcat7:run```
- Visit [http://localhost:9090/](http://localhost:9090/)

Run Executable WAR
----------------
- From base directory
- Run ```java -jar canvass-web-exec/target/canvass-web-exec-1.0-SNAPSHOT-war-exec.jar```
- Visit [http://localhost:8080/](http://localhost:8080/)

Run Integration Test
--------------------
- From base directory, or *canvass-web-test*
- Run ```mvn integration-test```
- This will start an embedded Tomcat server with Selenium and run integration tests in Surefire

Architecture
------------
&#x2713; **: Implemented,** &#x2717; **: Not Implemented**

&#x2713; Tomcat 7 (Web Host)

&#x2717; JBoss AS7 (Web Host)
  - After reading [the great java server app debate](http://zeroturnaround.com/rebellabs/the-great-java-application-server-debate-with-tomcat-jboss-glassfish-jetty-and-liberty-profile/) report, and discovering that Glassfish [has just been ditched](http://www.zdnet.com/oracle-abandons-commercial-support-for-glassfish-jee-server-7000022945/) by Oracle, I've decided to go with JBoss (recently renamed Wildfly).  It supports JavaEE, has a great management web console, and commercial support available.  Wildfly RC8 was released in december, and a stable version is coming soon but it is too early to use it.

&#x2713; Jersey (RESTful API)

&#x2713; Guice (Dependency Injection)

&#x2713; Maven (Java Build)

&#x2713; Hibernate (DAL)

&#x2713; MySQL (DB)

&#x2713; Bootstrap (Visuals)

&#x2717; Sass (Style)

&#x2713; AngularJS (Frontend)

&#x2713; Surefire/JUnit (Java/Server Testing)

&#x2713; Selenium/WebDriver (Integration Testing)

&#x2717; Protractor/Jasmine (Javascript/Client Testing)
- Use [Protractor](http://www.asgarddesigns.com.au/2013/11/end-to-end-testing-with-angularjs-protractor-grunt-and-maven/), which supplants Karma as the recommended test framework for AngularJS

&#x2717; Grunt (Javascript Build)

&#x2717; Logback (Logging)

Source File Locations
-----
- Static web (HTML, CSS, Javascript)
  - [canvass-web-main/src/main/webapp](canvass-web-main/src/main/webapp)
- API
  - [canvass-web-main/src/main/java/com/canvass/api](canvass-web-main/src/main/java/com/canvass/api)

Notes
-----
- ```mvn compile``` will not work on *canvass-web-test* and therefore not on *canvass-web*
- Use ```mvn install``` instead
