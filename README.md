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
- Tomcat 7 (Web Host)
- Jersey (RESTful API)
- Guice (Dependency Injection)
- Maven (Build)
- Hibernate (DAL)
- MySQL (DB)
- Selenium/WebDriver/Surefire (Testing)
- Logback (Logging)
- Bootstrap (Visuals)
- AngularJS (Frontend)
- Sass (Style)

Source
-----
- Static web (HTML, CSS, Javascript)
  - [canvass-web-main/src/main/webapp](canvass-web-main/src/main/webapp)

Notes
-----
- ```mvn compile``` will not work on *canvass-web-test* and therefore not on *canvass-web*
- Use ```mvn install``` instead
