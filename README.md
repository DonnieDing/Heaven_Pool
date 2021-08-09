# Heaven_Pool
## 1.项目介绍

Heaven_Pool是使用SpringCloud开发的在线视频课程平台，基于Spring Security实现的RBAC权限控制，是记录从最初慢慢开发到实现所有功能的项目，随着时间后续会扩展整合其他技术栈实现功能。

## 2.项目背景

项目名字来源于家乡长白山天池，很久没回去了，以表怀念。

首先介绍一下为什么会有Heaven_Pool项目，该项目是微服务架构的项目，是因为本人是自学Java开发，学习的过程中，可以说走了非常多的弯路，查询学习了很多资料，可仍觉得对使用的技术点和框架理解的不深，于是希望多多学习深入的理解这些知识，所以就想自己开发一个完整的项目，既是对自己掌握的技术点的一个梳理和巩固，同时也可以将开发的过程通过文章记录下来，可以帮助跟我一样自学的同学少走弯路，于是便有了该项目，对于大牛来说，可能这些东西都很浅显，但是对于跟本人一样想要学好的小白同学，希望能够有所帮助，业余时间码字，并且前端小白，所以更新可能会比较慢。

## 3.项目目标

从创建项目开始，一步一步实现包含后台管理和前台用户，可以上线的完整的在线视频课程平台。

## 4.环境配置

- JDK 1.8
- MySQL 5.7
- Maven 3.5.0

## 5.技术选型

- 注册中心与配置中心：nacos 1.4.1
- 核心框架：Spring Cloud Hoxton.SR8，spring cloud alibaba 2.2.5.RELEASE，Spring Boot 2.3.3.RELEASE
- 安全框架：Spring Security 5.3.3.RELEASE
- 缓存：Redis 3.0.504
- 持久层框架：MyBatis-Plus 3.0.5
- API文档生成：knife4j 2.0.5
## 6.项目结构

heaven_pool
├── common -- 公共模块

|    ├── common-base -- 通用处理

|    ├── common-security -- 权限框架

|    └── common-utils -- 通用工具类

├── gateway -- 网关服务【端口:8000】

├── picture -- github项目相关图片目录

├── service -- 服务模块

|    ├── service-acl -- 后台管理用户权限服务【端口:8001】

|    ├── service-cms -- 内容管理服务【端口:8002】

|    ├── service-edu -- 教育相关服务【端口:8003】

|    ├── service-file -- 文件上传服务【端口:8004】

|    ├── service-msm -- 短信服务【端口:8005】

|    ├── service-sta -- 统计分析服务【端口:8006】

|    ├── service-umc -- 前台用户服务【端口:8007】

|    └── service-vod -- 阿里云视频点播服务【端口:8008】

└── sql -- 数据库文件

## 7.数据库表

![MySQL数据表](https://gitee.com/Dcl_Snow/Heaven_Pool/blob/master/picture/heavenpool%E6%95%B0%E6%8D%AE%E5%BA%93.png)

## 8.本地部署

- git clone https://gitee.com/Dcl_Snow/Heaven_Pool.git 将项目代码克隆到本地。
- 本地安装启动Nacos和Redis。
启动Nacos服务：
![Nacos服务](https://gitee.com/Dcl_Snow/Heaven_Pool/blob/master/picture/%E6%B3%A8%E5%86%8C%E4%B8%AD%E5%BF%83.png)
启动Redis服务：
![Redis服务](https://gitee.com/Dcl_Snow/Heaven_Pool/blob/master/picture/Redis.png)
- MySQL数据库中创建数据库heavenpool，然后导入项目sql目录下的heavenpool.sql文件。
- 修改项目配置文件application.yml中的Nacos、Redis和MySql相关配置，先启动网关Gateway项目，再启动其他的各子服务即可，访问http://localhost:8000/doc.html 即可查看个服务接口文档，并进行接口调试。
接口文档：
![接口文档](https://gitee.com/Dcl_Snow/Heaven_Pool/blob/master/picture/%E6%8E%A5%E5%8F%A3%E6%96%87%E6%A1%A3.png)
