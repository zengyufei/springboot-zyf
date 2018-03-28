新增几个包： mybatis 和相关的包

修改 application.yml 添加 mybatis 配置
 - ${MYSQL_USERNAME:root} 是指系统环境变量中设置 MYSQL_USERNAME

新增 mybatis-conf.xml 文件 mybatis 配置

新增 com.zyf.springboot.mapper.sys.UserMapper 和 mapper/sys/UserMapper.xml

修改 com.zyf.springboot.Demo11Application 增加扫描 Mapper 接口的注解

新增 static/sql/zyf.sql 数据库脚本

新增 com.zyf.springboot.mapper.sys.UserMapperTest 测试类，全部通过

修改 com.zyf.springboot.service.sys.UserServiceImpl.login() 返回对象 realName 为 null，

会造成 com.zyf.springboot.service.sys.UserServiceTest.login() 运行时不输出该字段，

而我的要求是即使为 null，要要输出。