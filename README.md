# SpringBoot Template <img style="float:right;width:100px;padding-top:35px" src="https://img.shields.io/npm/l/vux.svg?style=flat-square" alt="">

[Project Plan](#project-plan)&nbsp;&nbsp;l&nbsp; 
[Dependencies](#dependencies)&nbsp;&nbsp;l&nbsp; 
[Features](#features)&nbsp;&nbsp;l&nbsp; 
[Configurations](#configurations)&nbsp;&nbsp;l&nbsp; 
[Package Architecture](#package-architecture)&nbsp;&nbsp;l&nbsp; 
[Keep In Touch](#keep-in-touch)&nbsp;&nbsp;l&nbsp; 
[中文版](README-ZH.md) 

This project is a springboot template designed for: 
- **web related homework** 
- **outsourcing backend**
- **personal homepage backend**

The whole project consists of:
- **standard guiding architectures**
- **basic configurations**
- **detailed examples**

> I worked as undergraduate assistant at [ise lab](http://www.iselab.cn/) in Nanjing University during 2017 and 2018.
I was absorbing numbers of backend practices along with real-world and top-notch skills.
For a long time, I'm trying to build an ideal backend template to help easily handle web homework and here it is.
This SprinBoot Template is refining and growing from a simple project to a fancy setup equipped with testing, 
management and authentication features. 

## Project Plan
| #   |                      Content                     | Estimated Time |
|:---:|:------------------------------------------------:|:--------------:|
| 1   | add docker for automatic build on a Linux server |    01/20/19    |
| 2   |              add support for GraphQL             |    01/31/19    |
| 3   |                add support for AOP               |       TBD      |
| 4   |        add support for user authentication       |       TBD      |
| 5   |       add support for Springboot2 features       |       TBD      |

## Dependencies
- Service Framework - [SpringBoot:2.1.1](http://projects.spring.io/spring-boot/)
- Database - [MySQL:8.0.11](https://www.mysql.com/)
- Testing - [Mockito:1.8.4](http://site.mockito.org/)
- API Management - [Swagger:2.4.0](http://swagger.io/)
- Code Quality - [SonarQube](https://www.sonarqube.org/)

## Features
- features including receiving requests, redirecting logic, dependency injection, user authentication, aspect oriented programming(AOP),
 object relation mapping(ORM), data IO, and etc. 
- detailed code examples and comments
- unit testing, interface testing, and integration testing

- Swagger2 HTTP API management(can be accessed at localhost:8080/swagger-ui.html in default)
![swagger](https://c1.staticflickr.com/5/4915/31726275207_42bb23af9c_h.jpg)

- code quality with SonarQube(can be accessed at localhost:9000 in default)
![sonar management](http://mooctest.oss-cn-shanghai.aliyuncs.com/resources/springboot-tmpl/sonar-management.png)

## Configurations
> *marks for compulsory configurations, and the others are optional

- \* create database *sample*, and modify username and password in *resources/application.yaml*

- \* if you're using IDE like Eclipse and IntelliJ, lombok plugin is needed for *@Data* and related annotations

- download Sonar local server. There's a shell script helping run sonar operations in *tool/sonar.sh*. 
For more info, please visit [Sonar Website](https://www.sonarqube.org/)

- HTTP API management website will be automatically generated with Swagger annotation.  
Default configurations is in *configure/SwagConfig.java*. After starting the server, management page will be published
at *localhost:8080/swagger-ui.html*. For more info, please visit [Swagger Website](http://swagger.io/) 

## Package Architecture
> This project is using [Anemic Domain Model](https://martinfowler.com/bliki/AnemicDomainModel.html) and based on the IoC framework, 
decoupling services and highly recommendable for team work.\
Moreover, the architecture borrows ideas from micro-service, containing features like highly deployable, and extensible.
*marks for features under planning

- **web** \
    Receiving, handling, filtering, wrapping, redirecting requests. The connector between frontend and backend.
    - **ctrl**
        - receiving requests from the frontend, generating online documents using swagger annotations
        - potential session management
        - \* in a JWT solution, key info is extracted and filtered here
    - **model**
        - traditional value object and minimal object used for interaction with the frontend wrapped by wrappers
     
- **logic**\
    business logic, arranging service for the core business logic

- **service**\
    consist of IO, computational and persistence operations.
    services are independent.
    logic inference is required if multiple services are participating

- **entity**\
    entities that need to be persisted and correspond to repositories
    
- **repository**\
    a traditional DAO layer, exchanging data using JPA
    
- **exception**\
    exceptions can be defined with customized process
    
- **config**\
    configurations for the framework and third-party plugins

## Keep In Touch
- clone / fork / star are warmly welcomed
- discussion in issues are warmly welcomed
- visit my [homepage](https://www.alan-zhufengxu.com) for more top-notch projects