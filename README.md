# heavenpool
## 1.项目介绍

HeavenPool是使用SpringBoot开发的后台管理系统，基于Spring Security实现的RBAC权限控制，是记录从最初慢慢开发到实现所有功能的项目，随着时间后续会扩展整合其他技术栈实现功能。

## 2.项目背景

项目名字来源于家乡长白山天池，很久没回去了，聊表怀念。

首先介绍一下为什么会有HeavenPool项目，是因为微服务架构的项目，选取了Spring Security+OAuth2.0安全框架，但对于自身而言，对所使用的框架理解很浅，于是查询了很多资料，也看了很多教程，可仍觉得掌握的不深，于是希望多多学习深入的理解这些知识，于是便有了该项目，对于大牛来说，可能这些东西都很浅显，但是对于跟本人一样想要学好的菜鸟，希望能够有所帮助，业余时间码字，并且前端小白，所以更新可能会比较慢。

## 3.项目目标

从创建项目开始，一步一步实现完全自定义的，动态的权限控制功能。

## 4.环境配置

- JDK 1.8
- MySQL 5.7
- Maven 3.5.0

## 5.技术选型

- 核心框架：Spring Boot 2.3.1.RELEASE
- 安全框架：Spring Security 5.3.3.RELEASE
- 视图框架：Spring MVC 5.0
- 持久层框架：MyBatis 3.5.5
- 数据库连接池：Druid 1.1.14
## 6.数据库表

![image-20200819105840107](C:\Users\Dcl_Snow\AppData\Roaming\Typora\typora-user-images\image-20200819105840107.png)

## 7.本地部署

- git clone https://github.com/DonnieDing/heavenpool.git将项目代码克隆到本地。
- MySQL数据库中创建数据库heavenpool，然后导入项目sql目录下的heavenpool.sql文件。
- 修改项目配置文件application.yml中的数据库相关配置，启动项目，访问localhost:8080即可。

