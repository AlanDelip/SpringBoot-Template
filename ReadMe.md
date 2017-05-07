# SpringBoot Template
这是一个利用SpringBoot框架搭建的后端模版<br>
有如下主要特性:
1. 请求接收，逻辑转发，对象映射，hibernate数据读写等主流功能
1. 微服务标准分包结构
1. 具体的使用样例，以示例代码的形式展示

>* 使用前请新建sample数据库，或者在resources/application.yaml文件中修改数据库名称
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
利用SpringJUnit4ClassRunner进行测试
