# SpringBoot Template
基于以下框架搭建的后端模版
- SpringBoot
- Mysql
- Mockito
- Swagger2
- Sonar

特性
1. 请求接收，逻辑转发，对象映射，hibernate数据读写等主流功能
1. 微服务标准分包结构
1. 具体的使用样例，以示例代码的形式展示
1. 详细的单元测试，接口测试
1. Swagger2 HTTP API管理
1. Sonar代码质量监测

>使用前配置
>* 建sample数据库，或者在resources/application.yaml文件中修改数据库名称以及登录用户名和密码
>* 下载Sonar本地服务器，由于是依赖Maven进行Sonar质量检测，请在./m2/settings.xml中进行Sonar的相关配置

<br>

下面是各个模块的主要功能介绍
## web
负责网络部分的处理<br>
1. ctrl包<br>
负责接收和返回请求
1. logic包<br>
主要负责service层交互，不涉及数据读写的逻辑处理
1. data包<br>
规定展示数据格式，其中的wrapper进行纯数据包装，不涉及逻辑

## service
主要负责与logic层和dao交互，处理IO相关的处理

## model
数据模型，利用JPA（Hibernate）实现ORM

## dao
数据读写，利用JPA进行读写操作

## constants
常量

## configure
过滤器

## <span style="color:green">test</span>
各个包内的测试代码
