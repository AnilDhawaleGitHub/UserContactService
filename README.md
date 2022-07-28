# user-contact-info-webapp
This micro service allows clients to perform below operation
- Save user contact (User Contact + Address) into H2 DB
- Fetch user contact info by ID
- Fetch user contact for multiple IDs eg : (1,2,3)
- Fetch all user contact info
- Update user contact info by ID
- Delete user contact info by ID

# Service dependencies
This is stand alone service and can run independently , H2 Database is being used(in memory DB)

# How to run
## Run as a Spring Boot local application
`mvn clean install` - to clean and build the application
`mvn test` - to run the test cases only 
`mvn clean install` - to run the application on default tomcat port no : 8080

# Technologies
- [Spring cloud microservices parent v2.5.2]
- Maven 3+
- Java 11
- SpringBoot
- Junit 4

# Running the Application

The application can be started with the command `mvn spring-boot:run` along with the desired environment profile, e.g: `mvn spring-boot:run -Dspring.profiles.active=local`
*Profile `local` disables most integration tools like Eureka and config-service, allowing it to run in isolation.*
To check the application below is the swagger link:
http://localhost:8080/swagger-ui.html


# Lombok
This application uses Lombok to reduce boilerplate code.

If you use IntelliJ, please install the Lombok plugin.

*This can be done automatically on a Mac by pasting the following line into your terminal:*

*`cd ~/Library/Application\ Support/Idea*;curl -L https://plugins.jetbrains.com/plugin/download?updateId=38691 -o z;unzip z;rm z;`*

Best Practices followed :
- used mvc design pattern
- used builder design pattern
- used FASAD pattern
- Followed SOLID design principle
    1. single responsibility
    2. interface segregation
- Exception handing:   
   - Global exception handling has been followed across the spring framework
   - Custom exceptions are being handled during run time
   - Run time exceptions are being handled 
 - Testing framework
   - Unit testing framework has been structured independently for Controller layer and service layer
   - Integration testing has been structured using Mock MVC framework
   - Unit testing framework has been created for all exceptions
    