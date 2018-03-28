修改 mybatis-config
 - 新增 mapUnderscoreToCamelCase 数据库表字段下划线自动转驼峰法，意味着 mapper.xml 可以少写很多配置
 - 新增全局 useGeneratedKeys，用来代替所有 add 方法中单独设置的 useGeneratedKeys

修改 mapper.xml
 - mapper/sys/UserMapper.xml
 - mapper/sys/UserVoMapper.xml
 - mapper/sys/UserLoginMapper.xml

测试
 - 运行 com.zyf.springboot.mapper.sys.UserMapperTest.add()
 - 运行 com.zyf.springboot.service.sys.UserServiceTest.list()

