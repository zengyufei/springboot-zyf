合并 User 、 UserLogin 成一个，修改 UserVo 做 User 的减法，输出 User 的部分可显字段。
 - 删除 UserLogin
 - 修改 User
 - 修改 UserVo

修改 BaseEntity 为 <T, PK> 泛型， T 为实体， PK 为 id 的类型。

修改 BaseVoEntity 为 <PK> 泛型， PK 为 id 的类型。

修改 com.zyf.springboot.controller.sys.UserController
 - 默认接收/返回的封装参数为 UserVo
 - 请求方式和 url 修改
   - get /user/{id} 查询单个
   - get /user 分页
   - post /user 新增
   - put /user 修改
   - delete /user/{id} 删除

修改 com.zyf.springboot.service.sys.UserServiceImpl 参数均为 UserVo
 - 修改相关测试类

删除 com.zyf.springboot.mapper.sys.UserLoginMapper
 - 删除相关测试类

删除 com.zyf.springboot.mapper.sys.UserVoMapper
 - 删除相关测试类
 - 删除 mapper/sys/UserVoMapper.xml

删除 com.zyf.springboot.base.PageRequest

合并 EnumConfiguration 和 DateConverConfiguration
 - 删除 EnumConfiguration
 
 新增 test com.zyf.springboot.utils 工具类 RestTemplateWithCookies 用来保存 cookies 并加入到下一次请求，可以用来登录后操作
 
 修改 test com/zyf/springboot/Demo17ApplicationTests.java
 
 修改 test com.zyf.springboot.controller.sys.UserControllerTest
 
 修改 com.zyf.springboot.config.MybatisPlusConfigiration
  - 打开乐观锁
  - 新增 xml 热刷新
  
 修改数据库表