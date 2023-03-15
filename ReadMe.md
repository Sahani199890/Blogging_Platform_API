# Blogging_Platform_API
### Requirements
* IntelliJIDEA
* ServerPort: 8080 (use: localhost:8080)
* Java version: 17
* Everything is present in the pom.xml (no need to download any library)
* Aws account to deploy project
* Termius to perform deployment process
### Steps to run the Project
* Download the source code and import in intellijIDEA.
* Go to localhost:8080/
* Put specific end_points besides the port accordingly to run the project to access and modify the data
* Download jar file of the project and push on GitHub
* Aws EC2 is needed to deploy project on it to get public IP address
* Termius is where I wrote few commands and deployed project, and it helped me access the project from any place
# Dependencies
## Validation
* Bean Validation with Hibernate validator.
## Spring Web
* Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.
## Spring Boot DevTools
* Provides fast application restarts, LiveReload, and configurations for enhanced development experience.
## Spring Data JPA
* Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.
## Lombok
* Java annotation library which helps to reduce boilerplate code.
## Swagger
* Helps user to ease access data in HTML format
## MySQL
* MySql Database,MySql JDBC driver

# Working
* This project consist of four models namely UserModel, PostModel, Follow, Comments along with their corresponding dao classes, controller classes and service classes
* SQl-Queries has been handled with native query in the post repository and user repository as per need of the queries
* Performed Annotation validation on all the Model class present in the MVC 
* Performed Manual validation too with the need of it, as an example we cannot have more than one user with same name
* Created Exception handler as the exceptions should be handled and whatever the output we want to show the user on screen is written 
* Relationship between Models or tables are given accordingly, relationship given as such of @ManyToOne for post model where more than one user can have more than one posts or many posts, In the model class of follow there is a @ManyToOne relationship between Users like one user follows other user if users are present in the database and parallel there are @ManyToOne relationship in between sender and receiver user and comment they sent to the post
* Swagger is added for the ease access of the project with link provided as follows : _**3.128.205.150/swagger-ui/index.html**_
* This project is deployed online with IP: _**3.128.205.150**_ using Termius along with the help AWS-EC2 using various linus commands so that the mysql database and commands works on it