# student_manager 学生信息管理系统（Java + MySQL版）
> 惠州学院计科课程练习项目，由本地文件IO版本重构为JDBC数据库版本

## 项目简介
使用Java语言实现控制台学生信息管理系统，基于JDBC连接MySQL数据库，实现学生数据持久化存储。配套DBeaver作为数据库可视化工具调试查看数据。
对比旧版本：不再读写本地txt文件，全部数据交由MySQL管理，支持事务预处理、防SQL注入。

## 功能清单
✅ 添加学生信息（学号唯一校验）
✅ 根据学号查询单个学生
✅ 修改学生信息
✅ 根据学号删除学生
✅ 查询展示全部学生信息

## 技术栈
- 开发语言：Java
- 数据库：MySQL 8.0
- 数据库连接：JDBC
- 可视化工具：DBeaver
- 开发IDE：IDEA

## 数据库表结构
数据库名：`student_manage`

表名：`student`
```sql
CREATE TABLE student (
    id VARCHAR(20) PRIMARY KEY COMMENT '学号',
    name VARCHAR(30) NOT NULL COMMENT '姓名',
    age INT COMMENT '年龄',
    gender VARCHAR(6) COMMENT '性别',
    phone VARCHAR(20) COMMENT '手机号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

student_manager
├── src/student_manage
│   ├── Student.java        // 学生实体类，封装属性与get/set
│   ├── DBUtil.java         // JDBC工具类：获取连接、关闭资源
│   ├── DBStudentUtil.java  // 数据库操作DAO层：增删改查方法
│   ├── FileUtil.java       // 旧版本文件读写工具（保留作为对比）
│   ├── TestDB.java         // 数据库连通性测试类
│   └── test.java           // 程序入口，控制台菜单交互
├── lib/
│   └── mysql-connector-java  // mysql驱动包
├── students.txt            // 旧版本地存储文件（存档）
└── README.md





##运行前置条件

1. 本地启动 MySQL 服务，创建`student_manage`库，执行上方建表语句
2. 修改`DBUtil.java`内的 url、user、password 为你自己数据库账号密码
3. IDEA 导入 mysql 驱动包
4. 运行 `test.java` 的 main 方法，进入控制台菜单




##版本说明

- V1：文件 IO 版本，读写 students.txt
- V2：MySQL JDBC 版本，当前版本，完整 CRUD



##补充说明

本项目为课程练习 Demo，仅用于学习 JDBC、MVC 简易分层思想，没有做复杂异常捕获、输入校验、事务高级处理。



### 提交Git命令
```bash
git add .
git commit -m "完成MySQL版学生管理系统，实现完整CRUD"
git push



##本学生信息管理系统采用 Java 语言开发，使用 JDBC 技术连接 MySQL 数据库，实现学生信息的增、删、改、查功能。项目分为实体层、数据库工具层、数据访问层和控制台交互层。
Student 类封装学生数据；DBUtil 封装数据库连接与资源关闭，减少代码冗余；DBStudentUtil 封装 SQL 操作，使用 PreparedStatement 预编译语句，避免 SQL 注入风险；test 类作为主程序，提供循环菜单供用户交互。
相较于最初的文件存储版本，数据库方案支持高效查询、数据稳定持久化，可借助 DBeaver 可视化查看底层数据，方便调试验证。