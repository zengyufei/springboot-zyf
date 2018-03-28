因为每新增一个枚举应用到实体类中，新增数据库字段，需要在 mybatis-config.xml 中配置 枚举处理类，很是麻烦。

改造成自动扫描枚举路径，并自动注册枚举统一处理

首先去掉 mybatis-conf.xml 中枚举注册标签

修改 config/application-mapper.yml
 - 新增 mybatis.enum-scan-path 自定义的名称，指定枚举路径
 - 设置 type-handlers-package

复制 mybatis 的 SqlSessionFactory 源码
 - 新增成员变量 enumScanPath getter/setter
 - 修改 419 行代码 if (!isEmpty(this.typeHandlers))
 - 新增代码，扫描枚举包及注册枚举处理器

新增 com.zyf.springboot.config.MybatisConfiguration 配置

完善 User/UserVo/UserLogin 的 XML/Mapper

运行 com.zyf.springboot.mapper.sys.UserMapperTest.list() 测试方法

