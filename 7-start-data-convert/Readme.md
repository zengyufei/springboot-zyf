新增 com.zyf.springboot.controller.test.TestControllerTest 消息转换测试，默认是好的
新增 com.zyf.springboot.config.DateConverConfiguration 自定义消息转换
新增 com.zyf.springboot.entity.test.Test 实体
新增 com.zyf.springboot.controller.test.TestController 控制层

com.zyf.springboot.controller.test.TestControllerTest 运行是正常的
如果需要验证，请把 test/java/ 下的 com.zyf.springboot.config.DateConverConfiguration 注释起来
再运行 com.zyf.springboot.controller.test.TestControllerTest 会报错

转换的新增类别在 com.zyf.springboot.config.converters 包下，
具体的用例看 com.zyf.springboot.entity.test.Test 实体