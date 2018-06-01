   ----智慧社区平台系统-----
   
--系统入口文件:com.leelen   SmartApplication.java (springboot的入口类)

1、/src/main/java/  存放项目所有源代码目录
2、/src//main/resources/  存放项目所有资源文件以及配置文件目录
3、/src/test/  存放测试代码目录



4、使用Druid作为SpringBoot项目数据源（添加监控）
    
    --Druid是一个关系型数据库连接池，它是阿里巴巴的一个开源项目。Druid在监控、可扩展性、稳定性和性能方面具有明显的优势。
    包含了如下几个模块：数据源、SQL监控、SQL防火墙、Web应用、URI监控、Session监控、JSONAPI等。

   数据源

  可以看到项目中管理的所有数据源配置的详细情况，除了密码没有显示外其他都在。

 SQL监控
  可以查看所有的执行sql语句

 SQL防火墙
 druid提供了黑白名单的访问，可以清楚的看到sql防护情况。

 Web应用
  可以看到目前运行的web程序的详细信息。

 URI监控
  可以监控到所有的请求路径的请求次数、请求时间等其他参数。

 Session监控
  可以看到当前的session状况，创建时间、最后活跃时间、请求次数、请求时间等详细参数。

 JSONAPI
  通过api的形式访问Druid的监控接口，api接口返回Json形式数据。
  
  
  
  5、Token规则
  md5(user_id + password + 当前时间)
  
  
  Redis
第一步：添加spring-boot-starter-data-redis依赖
第二步：配置@EnableCaching开启缓存
第三步：在application.yml内配置Redis相关的信息
第四步：配置@Cacheable注解完成数据缓存

pom.xml
<dependencies>
        <!--spring data jpa依赖添加-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <!--redis依赖添加-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>
        <!--web相关依赖-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!--数据库依赖添加-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <!--druid依赖添加-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.8</version>
        </dependency>
        <!--lombok依赖添加-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.44</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!--性能测试依赖-->
        <dependency>
            <groupId>org.databene</groupId>
            <artifactId>contiperf</artifactId>
            <version>2.3.4</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>javax.xml.bind</groupId>
            <artifactId>jaxb-api</artifactId>
            <version>2.3.0</version>
        </dependency>
    </dependencies>
    
    
    application.yml
    
    spring:
  application:
    name: spring-boot-redis
  jpa:
    database: mysql
    show-sql: true
  datasource:
    druid:
      username: root
      password: 123456
      url: jdbc:mysql://localhost:3306/test
  # 配置Redis的连接密码
  redis:
    password: hengyuboy
    
    
    /**
 * spring-boot-redis集成项目启动类入口
 *
 * @author yuqiyu
 * @EnableCaching 注解配置启用缓存，自动配置配置文件的配置信息进行条件注入缓存所需实例
 */
@SpringBootApplication
@EnableCaching
public class SpringBootRedisApplication {
}


/**
     * 查询全部用户
     *
     * @return
     */
    @Cacheable(cacheNames = "user.service.all")
    public List<TestUserEntity> findAll() {
        return userRepository.findAll();
    }
    
    /**
     * 测试全部缓存
     */
    @Test
    public void findAll() {
        userService.findAll();
    }
    
    @Rule
    public ContiPerfRule i = new ContiPerfRule();

    /**
     * 性能测试
     * 10万次查询，100个线程同时操作findAll方法
     */
    @Test
    @PerfTest(invocations = 100000, threads = 100)
    public void contextLoads() {
        userService.findAll();
    }
  
  
  