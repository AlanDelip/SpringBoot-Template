# SpringBoot Template <img style="float:right;width:100px;padding-top:35px" src="https://img.shields.io/npm/l/vux.svg?style=flat-square" alt="">

[Project Plan](#project-plan)&nbsp;&nbsp;l&nbsp; 
[Features](#features)&nbsp;&nbsp;l&nbsp; 
[Dependencies](#dependencies)&nbsp;&nbsp;l&nbsp;  
[Configurations](#configurations)&nbsp;&nbsp;l&nbsp;
[Package Architecture](#package-architecture)&nbsp;&nbsp;l&nbsp; 
[Keep In Touch](#keep-in-touch)&nbsp;&nbsp;l&nbsp; 
[中文版](README-ZH.md) 

## :tada::tada::tada: Check Out Docker Features!
Docker features have been integrated into the helper scripts. 

Go to [Interactive Springboot Template](https://project.alan-zhufengxu.com/interactive-springboot-template/), 
get your installation script and get things done within 10 minutes. 

Helper scripts will help you install all the dependencies,  including *Maven*, *JDK*, *MySQL*, and *SonarQube*, and run your project.
[See Details](#features).


## Why & What & How
For a typical **CS student**, a **outsourcing manager** or a **personal developer**, it's always a nightmare to do the configuration work, even though you're using Springboot which aims at simplifying it.

It's a perfect choice to read through the official tutorial and docs to get started. **However, the tutorial and docs 
are just too detailed to work with.** 

In this scenario, what we actually need is a template, equipped with basic structure, common configs, 
and normal features, to start with immediately within minutes. It will be even better if several hints and examples, like 
how to set up database connections and how to resolve CORS config, are provided.

Here comes the **SpringBoot-Template**.
It is designed for: 
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
management and authentication features.\
\
Alan. Zhufeng Xu, 03/14/17.

## Project Plan
| #   |                      Content                     | Estimated Time |
|:---:|:------------------------------------------------:|:--------------:|
| 1   | add docker features for automatic build on a Linux server |:heavy_check_mark:|
| 2   |              add support for GraphQL             |    :heavy_check_mark:    |
| 3   |                add support for AOP               |       TBD      |
| 4   |        add support for user authentication       |       TBD      |
| 5   |       add support for Springboot2 features       |       TBD      |

## Features
- **[NEW FEATURE] Build using Docker without Any Configuration**

    Docker features have been integrated into the helper scripts. With this feature, 
    once you get a server, 
    **ALL YOU NEED TO DO:** 
    - install git
    - clone this project 
    - run the following script (and every feature below will be automatically installed and configured)
        ```
        cd SpringBoot-Template && bash tool/install-docker.sh -o ${YOUR_OS} && bash tool/start-docker.sh [-m <mode>]
        ```
        Replace *${YOUR_OS}* and optionally change the mode of running the docker container.
        
        *${YOUR_OS}: centos / ubuntu / debian*
        > currently, *CentOS 7 x86_64*, *Debian GNU/Linux 9 amd64*, *Ubuntu 18.04 LTS amd64* are supported.
        
        *-m: normal(default, logs on screen) / silent(running in background, no logs on screen)*
        
        it's an extra parameter for start-docker.sh, if you don't want to see the logs, you can use:
        ```
        bash tool/start-docker.sh -m silent
        ```
        
    - Furthermore, SonarQube is automatically up in the 9000 port. If you want to analyze the project for code quality,
      you can use:
      
      ```
      bash tool/docker-sonar-analyze.sh [-m <mode>]
      ```
      *-m:  normal(default, logs on screen) <br>
      silent(running in background, no logs on screen) <br>
      interactive(bash into springboot container, set for docker developers)*
     
- Features including receiving requests, redirecting logic, dependency injection, user authentication, aspect oriented programming(AOP),
 object relation mapping(ORM), data IO, and etc. 
 
- Detailed code examples and comments

- Unit testing, interface testing, and integration testing

- Swagger2 HTTP API management(can be accessed at *localhost:8080/swagger-ui.html* in default)
![swagger](https://c1.staticflickr.com/5/4915/31726275207_42bb23af9c_h.jpg)

- Code quality with SonarQube(can be accessed at *localhost:9000* in default)
![sonar management](http://mooctest.oss-cn-shanghai.aliyuncs.com/resources/springboot-tmpl/sonar-management.png)

## Dependencies
> If you're using docker features, you can just skip this part, because no dependency is required to be installed manually :smirk:.
- Compilation - [JDK:8+](https://www.java.com/)
- Dependency Management - [Maven:3+](https://maven.apache.org/download.cgi)
- Service Framework - [SpringBoot:2.1.1](http://projects.spring.io/spring-boot/)
- Database - [MySQL:8.0.11](https://www.mysql.com/)
- Testing - [Mockito:1.8.4](http://site.mockito.org/)
- API Management - [Swagger:2.4.0](http://swagger.io/)
- Code Quality - [SonarQube](https://www.sonarqube.org/)

## Configurations
> If you're using docker features, you can just skip this part, because no configuration is needed :smirk:.

> \* marks for compulsory configurations, and the others are optional

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