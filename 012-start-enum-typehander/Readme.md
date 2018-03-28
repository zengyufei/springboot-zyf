mybatis 插入数据时转换枚举为数字：

修改 TypeHandler
 - com.zyf.springboot.config.typeHandlers.CalendarTypeHandler
 - com.zyf.springboot.config.typeHandlers.DateTypeHandler
 - com.zyf.springboot.config.typeHandlers.GenericEnumTypeHandler

新增 com.zyf.springboot.base.BaseEnum 公共枚举类

新增 com.zyf.springboot.enums.UserType 用户枚举类

修改 UserVo、UserLogin 的 type 字段为 UserType 枚举

修改 mybatis-conf.xml 的 typeHandlers 注册

新增 com.zyf.springboot.mapper.sys.UserLoginMapper

新增 mapper/sys/UserLoginMapper.xml

运行 com.zyf.springboot.mapper.sys.UserLoginMapperTest.add() 测试

----------------------------------------------------------------

修改 com.zyf.springboot.config.JsonConfiguration 输出枚举为数字

前端传入前转换数字为枚举：

修改 com.zyf.springboot.service.sys.UserService 新增 add() 方法
 - com.zyf.springboot.service.sys.UserServiceImpl 新增 add() 方法

新增 com.zyf.springboot.config.EnumConfiguration

新增 com.zyf.springboot.config.IndexToEnumConverterFactory

修改 com.zyf.springboot.controller.sys.UserController 新增 add 方法测试

运行 com.zyf.springboot.Demo12Application 访问 post /user/add?type=1 测试