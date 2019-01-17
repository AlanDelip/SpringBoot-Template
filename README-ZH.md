# SpringBoot Template <img style="float:right;width:100px;padding-top:35px" src="https://img.shields.io/npm/l/vux.svg?style=flat-square" alt="">

[项目计划](#2019项目计划)&nbsp;&nbsp;l&nbsp; 
[特性](#特性)&nbsp;&nbsp;l&nbsp; 
[主要依赖](#主要依赖)&nbsp;&nbsp;l&nbsp; 
[配置](#配置)&nbsp;&nbsp;l&nbsp; 
[包结构解析](#包结构解析)&nbsp;&nbsp;l&nbsp; 
[保持联系](#保持联系)&nbsp;&nbsp;l&nbsp; 
[English Version](README.md)

## :tada::tada::tada: Docker特性上线！
Docker特性已经集成进shell脚本中。新特性帮助你更快的建立服务器。

去[Interactive Springboot Template](https://project.alan-zhufengxu.com/interactive-springboot-template/)获取属于你服务器的脚本，
在5分钟内完成部署！

脚本会帮你安装所有的依赖，包括*Maven*，*JDK*，*MySQL*和*SonarQube*，并且运行你的项目。
[查看详情](#特性)。

## 这是什么项目？为什么要用？ 
对于CS学生，外包项目经理，或是个人开发者而言，配置项目始终是令人头疼的一件事情，即便你在用Springboot这样旨在简化配置的框架。

去阅读官方的教程和文档是一个绝佳的选择，但是那些文档太过详细，详细到包含了很多你根本不需要学习的东西。

这种场景下，我们实际需要的是一个，有基本代码分包结构的、有基础配置的、有常用功能特性、最好有部分示例代码（数据库，跨域配置等代码）的模版。

这就是**SpringBoot-Template**：

这是一个专门为**Web相关大作业**，**外包项目后端**和**个人网站后端**而设计的Springboot模版。
包含一套可以立即使用的**标准架构**和**配置**，还包含一组**实际代码示例**。

> 2017年 - 2018年间，我在南京大学的[ise实验室](http://www.iselab.cn/)工作了8个月，有了很多后端的实践。
一直想整理一套理想的后端即clone即用的模版，轻松的应对各种大作业。
这套SpringBoot的模版也在不断的完善当中，从初始的简单框架逐渐加入了更多的管理和运维工具。\
\
Alan. Zhufeng Xu, 03/14/17.

## 2019项目计划
|   #编号  	|         计划内容         	| 预计时间 	|
|:---------:|:-------------------------:|:---------:|
|   1   	| 添加Docker自动化构建过程 	| :heavy_check_mark:	|
|   2   	|      添加GraphQL支持     	| 01/31/19 	|
|   3   	|      添加AOP切面支持    	|    TBD   	|
|   4   	|      添加用户验证支持 	    |    TBD   	|
|   5   	|   添加Springboot2新特性   	|    TBD   	|


## 特性
- **新特性：用Docker更快的搭建服务**

    Docker特性已经集成进shell脚本中。新特性帮助你更快的建立服务器。
    
    当你有一台服务器时，**你只要：**
    - 安装Git
    - Clone这个项目 
    - 运行下面的脚本（接下来的所有特性和依赖都会自动配置）
        ```
        cd SpringBoot-Template && bash tool/install-docker.sh -o ${你的操作系统} && bash tool/start-docker.sh
        ```
        替换*${你的操作系统}*，也可以设置运行Docker的方式。
        
        *${你的操作系统}: centos / ubuntu / debian*
        > 目前支持*CentOS 7 x86_64*, *Debian GNU/Linux 9 amd64*, *Ubuntu 18.04 LTS amd64*。
        
        *-m: normal（默认，输出日志到屏幕） / silent(后台运行，不输出日志)*
        
        这是start-docker.sh的一个额外参数，如果你不想看日志输出的话，你可以用：    
         ```
         bash tool/start-docker.sh -m silent
         ```
            
    - 此外, SonarQube会自动启动在9000端口。如果你想分析项目的代码质量，你可以用：
      ```
      bash tool/docker-sonar-analyze.sh [-m <mode>]
      ```
      *-m:  normal（默认, 输出日志到屏幕） <br>
      silent（后台运行，不输出日志） <br>
      interactive（用bash登录到springboot的容器内，为docker开发者设计）*
         
- 请求接收，逻辑转发，依赖注入，用户验证，切面，对象映射，数据读写等主流功能

- 具体的使用样例，以示例代码的形式展示

- 详细的单元测试，接口测试，集成测试

- Swagger2 HTTP API管理（默认启动服务器后在8080端口的/swagger-ui.html访问）
![swagger](https://c1.staticflickr.com/5/4915/31726275207_42bb23af9c_h.jpg)

- Sonar代码质量监测（默认启动Sonar本地服务器后在9000端口访问）
![sonar management](http://mooctest.oss-cn-shanghai.aliyuncs.com/resources/springboot-tmpl/sonar-management.png)

## 主要依赖
> 如果你在使用Docker特性，你可以直接跳过这里，因为所有的依赖都会被自动安装:smirk:。
- 编译器 - [JDK:8+](https://www.java.com/)
- 依赖管理 - [Maven:3+](https://maven.apache.org/download.cgi)
- 服务框架 - [SpringBoot:2.1.1](http://projects.spring.io/spring-boot/)
- 数据库 - [MySQL:8.0.11](https://www.mysql.com/)
- 测试 - [Mockito:1.8.4](http://site.mockito.org/)
- API管理 - [Swagger:2.4.0](http://swagger.io/)
- 代码质量 - [SonarQube](https://www.sonarqube.org/)

## 配置
> 如果你在使用Docker特性，你可以直接跳过这里，因为所有配置都会被自动设置:smirk:。

> \* 为必须配置，其余可选
- \* 创建*sample*数据库，或者在*resources/application.yaml*文件中修改数据库名称以及登录用户名和密码
- \* 如果你在使用IntelliJ或者Eclipse等IDE的话，需要安装Lombok插件来保证 *@Data* 以及相关标注的运行
- 下载Sonar本地服务器，*tool/sonar.sh*中有编写好的shell脚本帮助运行sonar指令。更多的Sonar配置请访问[Sonar官网](https://www.sonarqube.org/)
- 在相关标注的说明下Swagger会自动生成HTTP API的网页，对于Swagger的默认配置在*configure/SwagConfig.java*中（不进行配置也可使用Swagger的特性）。
运行服务器后默认在*localhost:8080/swagger-ui.html*会有API的界面。更多配置选项请关注[Swagger官网](http://swagger.io/)

## 包结构解析
> 基于IoC框架的[贫血模型](https://martinfowler.com/bliki/AnemicDomainModel.html)，对服务进行解耦，适用于团队协作。\
此结构借鉴了部分微服务的思想，与微服务都有解耦，易部署，易伸缩，易扩展等特点，改成微服务的结构也非常方便。\
*表示在计划中的方案。

- **web** \
    请求处理，接收，转发，过滤，包装，职责偏向前后端交互
    - **ctrl**
        - 接收前端的请求，标注部分与swagger结合形成在线文档
        - 在过程需要短期持久化的部分解决方案中，用来管理session
        - \* JWT解决方案中，经过过滤器过滤后提取关键信息
    - **model**
        - 传统的value object，通过wrapper来将组成的持久化对象包装成与前端交互的最小化对象
     
- **logic**\
    主要业务逻辑，通过编排service来完成所需的业务操作

- **service**\
    主要IO、持久化、计算密集型操作，service之间互相没有依赖，如果需要多个service进行协作的部分应该在logic层进行编排完成

- **entity**\
    需要持久化的实体，与repository对应
    
- **repository**\
    传统DAO层，利用JPA进行单纯的Java与数据库的读写交换
    
- **exception**\
    过程中出现的异常，如需单独进行处理，可以新建exception进行自定义处理
    
- **config**\
    框架和第三发插件的配置

## 保持联系
- 欢迎clone / fork / star
- 欢迎在issue中讨论
- 欢迎访问我的[个人主页](https://www.alan-zhufengxu.com)，关注我的其他项目