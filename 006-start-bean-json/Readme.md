新增 com.zyf.springboot.base.BaseEntity 实体公共类

新增 com.zyf.springboot.base.BaseVoEntity 包装类公共类

新增 com.zyf.springboot.entity.sys.User 用户基础信息类

新增 com.zyf.springboot.entity.sys.UserLogin 用户登录类

新增 com.zyf.springboot.vo.sys.UserVo 用户所有包装类

重写 com.zyf.springboot.service.sys.UserService

重写 com.zyf.springboot.service.sys.UserServiceImpl

重写 com.zyf.springboot.controller.sys.UserController

统一了 controller -> service -> impl

请使用 com.zyf.springboot.controller.sys.UserControllerTest 来测试