# SpringBoot Template <img style="float:right;width:100px;padding-top:35px" src="https://img.shields.io/npm/l/vux.svg?style=flat-square" alt="">
> 在ise实验室工作了8个月，一直想整理一套理想的后端即clone即用的模版。这套SpringBoot的模版也在不断的完善当中，从初始的简单框架逐渐加入了更多的管理和运维工具。

## Dependencies
- [【Server】SpringBoot](http://projects.spring.io/spring-boot/)
- [【Database】Mysql](https://www.mysql.com/)
- [【Testing】Mockito](http://site.mockito.org/)
- [【API Management】Swagger2](http://swagger.io/)
- [【Code Quality】Sonar](https://www.sonarqube.org/)

## Features
1. 请求接收，逻辑转发，对象映射，hibernate数据读写等主流功能
1. 微服务标准分包结构
1. 具体的使用样例，以示例代码的形式展示
1. 详细的单元测试，接口测试
1. Swagger2 HTTP API管理（默认启动服务器后在localhost:8080/swagger-ui.html即可访问）
![swagger](http://mooctest.oss-cn-shanghai.aliyuncs.com/resources/springboot-tmpl/swagger.png)

1. Sonar代码质量监测（默认启动Sonar本地服务器后在localhost:9000访问）
![sonar management](http://mooctest.oss-cn-shanghai.aliyuncs.com/resources/springboot-tmpl/sonar-management.png)
![sonar map](http://mooctest.oss-cn-shanghai.aliyuncs.com/resources/springboot-tmpl/sonar-map.png)

## Configurations
> *为必须配置，其余可选
- (*)创建sample数据库，或者在resources/application.yaml文件中修改数据库名称以及登录用户名和密码
- 下载Sonar本地服务器，由于是依赖Maven进行Sonar质量检测，请在./m2/settings.xml中进行Sonar的相关配置（如不使用Sonar可不进行配置）。在tool文件夹内有编写好的shell脚本帮助运行sonar指令。更多的Sonar配置请访问[Sonar官网](https://www.sonarqube.org/)
- 在相关标注的说明下Swagger会自动生成HTTP API的网页，对于Swagger的默认配置在configure/SwagConfig.java中（不进行配置也可使用Swagger的特性）。运行服务器后默认在localhost:8080/swagger-ui.html会有API的界面。更多配置选项请关注[Swagger官网](http://swagger.io/)

## Keep In Touch
- 欢迎clone/fork/star!
- 欢迎在issue中讨论
- 欢迎访问个人网站www.alandelip.cn