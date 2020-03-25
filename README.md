# yuxin-dubbo

#### 介绍
该项目是使用了 Spring-Boot 和 Dubbo 框架的学习项目，还包含 Mybatis-plus, lombok 知识。项目成功构建并启动后，可以通过访问 consumer 提供的接口，来使用 provider 所提供的服务。该项目提供两个服务：获取信息、查询数据库数据。可以通过该项目来学习相关知识。

#### 架构
项目包含 3 个子模块: provider, consumer, interface.  消费者与提供者通过中立接口相关联

interface 中定义了 User 实体类和中立接口 UserService

provider 提供了服务的具体实现 UserServiceImpl（通过 Mybatis-Plus 操作数据库）

consumer 提供了外界访问的 UserController

项目启动后，可以通过 consumer 提供的映射地址来访问 provider 的具体服务。两者通过 Dubbo 框架关联。provider 或 consumer 一经启动，会自动注册到 zookeeper 中，可以通过 dubbo-admin 可视化工具来查看具体的服务信息。

#### 构建

1. 将项目克隆至本地，等待maven下载好相关依赖

2. 在 yuxin-provider 提供者子模块中，找到 application.yml，修改 spring.datasource 中的数据源配置，连接到本地的 MySQL 数据库；修改 dubbo 配置，连接到 zookeeper （本人是连接 localhost 数据库，zookeeper 则安装在虚拟机上；具体设置依照各位开发者环境而定）

3. 中立接口 interface 中定义了 User 实体，可依照其结构创建表，并插入一些测试数据

4. 此时可在提供者的 UserServiceImpl 类上添加 Springframework 的 @Service，并启动该模块中的测试类，测试容器能否正常启动、数据库能否正常连接、zookeeper能否成功注册。若成功取到测试数据，则可删除 Springframework 的 @Service

5. 修改消费者中的 application.yml，配置 dubbo.registry.address 为本机 zookeeper 的地址

6. 可在启动提供者服务的情况下，启动消费者模块中的测试类，查看能否正常关联

7. 启动提供者和消费者，访问提供者 UserController 中映射的地址，查看两个服务能否正常运行

   http://localhost:9001/user/getMsg		显示文本信息

   http://localhost:9001/user/queryAll		取得测试数据

#### 知识点

* User 实体类中使用了 lombok，自动生成 getter, setter, toString() 方法，极大地简化了操作

  要使用 lombok，先在 pom.xml 中引入依赖，而后在 idea 的设置 Plugins 里添加 lombok 插件（可视化类结构），重启 idea，即可正常使用

* 该项目使用了 dubbo-admin 辅助，可在 GitHub 上下载。dubbo-admin 是 zookeeper 的可视化管理工具，一旦有服务注册到 zookeeper，刷新 dubbo-admin 会显示出服务的详细信息，可以直观地查看服务是否正常启动，十分好用

#### 拓展

好的开发者应当有足够的自学能力，阅读产品的官方文档对于快速上手有很大的帮助。想要更深入地了解 Dubbo 框架，建议阅读官方文档 http://dubbo.apache.org/zh-cn/docs/user/preface/background.html