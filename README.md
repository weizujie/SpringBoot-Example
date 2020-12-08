
**给个 Star 吧！**

> 该仓库所有的例子**只有后端代码，没有前端代码**！请自行通过 Postman 等工具进行测试 :)

## 已整合的技术

- [SpringBoot-Shiro](https://github.com/weizujie/SpringBoot-Example/tree/main/SpringBoot-Shiro) ：SpringBoot 整合 Shiro
    - 实现功能：
      - 认证和授权

      - 密码加密 (MD5 + SALT + HASH散列)

      - Ehcache 本地缓存

    - 技术栈：
      - 后端：SpringBoot 2.x、Mybatis、Shiro
      - 数据库：MySQL 8

    - 测试用户：
    	| 登录名 | 密码   | 用户角色 | 权限 |
      | :---- | :----- | :------ |:------ |
      | admin  | admin | 管理员 | 所有 |
      | teacher  | teacher | 教师 |所有|
      | student  | student |  学生  |无|



- 项目启动：

  1. 导入数据库

  2. 修改 ```application.yml```的连接信息：

     ```yml
     spring:
       datasource:
         driver-class-name: com.mysql.cj.jdbc.Driver
         # 数据库连接 url，springboot-shiro 为导入的数据库名
         url: jdbc:mysql://localhost:3306/springboot-shiro?userUnicode=true&serverTimezone=Asia/Shanghai&characterEncoding=utf8
         username: xxx  # 数据库连接名
         password: xxx  # 数据库连接密码
         type: com.alibaba.druid.pool.DruidDataSource
     ```
  3. 启用即可


- 持续更新中...

