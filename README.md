Canvass
=======

How to build
------------
From base directory, run ```mvn install```

How to Run
----------
- Embedded
From base directory (or from ```canvass-web-main```), execute ```mvn tomcat7:run```
Then visit [http://localhost:9090/](http://localhost:9090/)
- Executable WAR
Execute ```java -jar canvass-web-exec/target/canvass-web-exec-1.0-SNAPSHOT-war-exec.jar```
Then visit [http://localhost:8080/](http://localhost:8080/)
- Test
From base directory (or ```canvass-web-test```), execute ```mvn integration-test```
This will start an embedded Tomcat server with Selenium and run integration tests in Surefire

Architecture
------------
- Tomcat 7 (Web Host)
- Jersey (RESTful API)
- Guice (Dependency Injection)
- Maven (Build)
- Hibernate (DAO)
- MySQL (DB)
- Selenium/WebDriver (Testing)
- Bootstrap (Visuals)
- AngularJS (Frontend)

Notes
-----
```mvn compile``` will not work on canvass-web.
canvass-web-test requires the war for canvass-main to be in maven.
use ```mvn install``` instead.
