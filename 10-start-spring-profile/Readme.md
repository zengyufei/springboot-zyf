修改 application.yml，并制定需要启动的默认环境，在启动加入启动参数 -Dspring.profiles.active=dev 来命令行指定，这个优先级是最高的。

新增 application-dev.yml 、 application-prod.yml，根据 spring.profiles.active=dev 自动选择两者之一

新增 config/application-mapper.yml、config/application-8081.yml、config/application-8082.yml

springboot 寻找配置文件的规则是，在 resources 下面找，如果找不到，会去 resources/config 下面寻找