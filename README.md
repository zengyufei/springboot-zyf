# springboot-zyf   

### 这是一个渐进搭建的学习项目，从零开始一步一步搭建出一套顺手的脚手架。

part.1 start.spring.io 网站下载最简单的空白模板，能启动   
part.2 添加 Controller 以及 UserControllerTest   
part.3 添加 Service 以及 UserServiceTest   
part.4 springboot 的最简单配置   
part.5 修改 UserController 为 restfull 返回方式   
part.6 新增实体封装数据，并通过 UserController 返回成 JSON   
part.7 接收前端日期型数据，并转换成实体的 Date 类型或其他类型   
part.8 集成 Mybatis   
part.9 将消息转换器换成 FastJson 即 @ResponseBody 采用 FastJson 来处理   
part.10 设置 Spring 的环境配置，根据不同的环境选择不同的配置   
part.11 设置日志配置，可控制打印控制台，控制写入文件，指定文件存放路径，指定日志级别   
part.12 手动处理枚举类型持久化时的转换问题   
part.13 自动处理前端、后端枚举类型持久化时的转换问题   
part.14 枚举类转换 JSON 时新增枚举名称后面加 Name 对应的 key/value 具体看 14 里面的 Readme.md   
part.15  修改 Mybatis-config 以及修改相关的 XXMapper.xml   
part.16-1  自定义 mybatis 增强注解，可以代替 mapper   
part.16-2  主分支。添加 mybatisPlus 框架，即代替 [part.12、part.13、part.15、part.16-1] 这几版东西。同时完善测试类 。  
part.17  一次大的重构，清除无用代码   
part.18  添加公共的基类，包括 Controller、Serivce 和 ServiceImpl，提供大量的复用基础 CURD 方法，区分 PO 和 VO   
part.19  PO 转 VO  或 VO 转 PO 使用 BeanUtils，性能不好且写法复杂，使用 Orika 替换 BeanUtils   
part.20  开始新增 rbac 相关实体 [user, role, resource]，并且完成关联关系查询，基本 CURD 完整   
part.21  开始添加静态资源，首先新增 login.html 一个页面，以及调整后台登录接口位置。   
part.22  针对 part.14 修复 addJSONKey 功能，解决多层嵌套无法添加 json key 的问题，同时删除 JSON.java   
part.23  添加用户 id 关联查询的 FastJson 注解属性。拥有基本的 web 列表页展示功能，添加主要核心输出类 Msg.java   
part.24  完整的 web 页面 跳转，新增，修改，删除，列表页，分页器等功能   


##### 目标
 - 基础设施
 - 权限管理
 - maven 模块化
 - 前后端分离
 - 多数据源
 - 丰富业务