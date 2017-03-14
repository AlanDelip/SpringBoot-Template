# SpringBoot Template
* SpringBoot框架的模版
* 包含:请求接收，逻辑转发，对象映射，hibernate数据读写
* 标准分包
<br>

>* 使用前请新建sample数据库，或者在resources/application.yaml文件中修改数据库名称
<br>
### web
其中logic层主要负责service层交互，逻辑处理；data规定展示数据格式，并且进行数据包装；ctrl负责接收和返回请求。
<br>
### service
主要负责与logic层和dao交互，获取数据并返回。
<br>
### model
数据模型，利用JPA（Hibernate）实现ORM
<br>
### dao
数据读写
<br>
### constants
常量
<br>
### configure
过滤器
<br>
### test
利用SpringJUnit4ClassRunner进行测试
