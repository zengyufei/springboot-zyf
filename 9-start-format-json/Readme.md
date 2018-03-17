新增 com.zyf.springboot.config.JsonConfiguration

修改所有 @JsonIgnore 为   @JSONField(serialize = false)

运行 com.zyf.springboot.service.sys.UserServiceTest.login() 就可以看到效果