修改 pom.xml，新增 spring-boot-starter-logging 包

新增文件 logback-spring.xml，该文件会根据 spring-profile 选择不同的日志打印或文件写入
 - prod 打印控制台且写入文件
 - dev 只打印
 - local 只打印，目前没使用

修改 config/application-8081.yml、config/application-8082.yml 中的 logging
 - logging 的 level.root 会决定打印的级别。
    - 会决定 prod 写入什么文件

修改 com.zyf.springboot.controller.test.TestController 添加 error() 方法

新增 com.zyf.springboot.error.ErrorTest

运行 com.zyf.springboot.error.ErrorTest.get() 测试打印 error
   - 测试前先修改 yml 中的 spring.profiles.active 为 prod
   - 测试前先修改 yml 中的 logging.level.root 为 error

运行 com.zyf.springboot.Demo11Application.main() 访问 /test/error 测试打印 error
   - 测试前先修改 yml 中的 spring.profiles.active 为 prod
   - 测试前先修改 yml 中的 logging.level.root 为 error

