读取静态文件资源顺序应该是  resources  >   static  >   public    而且这几个文件夹访问不需要加前缀

新增 com.zyf.springboot.controller.sys.AccountController

修改 com.zyf.springboot.controller.sys.UserController 移除登录方法到 AccountController

新增 static/login.html 登录页面

修改 com.zyf.springboot.config.DateConverConfiguration 添加认真匹配模式
 - /login 和 /login.html 会默认进入 springmvc 控制的 /login 里面
 - 需要让分发器精确一些，起码区分出 /login 和 login.html

启动 com.zyf.springboot.Demo21Application

idea 需要设置启动的 Working directory

访问 http://localhost:8081/login.html

如果需要访问 jsp，在启动时默认是不将 resources 下或其他路径下的 jsp 文件打包，需要在 pom.xml 的 build 标签下加入如下代码
```
 <resources>
    <resource>
        <directory>src/main/java</directory>
        <includes>
            <include>**/*.xml</include>
        </includes>
    </resource>
    <!--指定资源的位置-->
    <resource>
        <directory>src/main/resources</directory>
        <includes>
            <include>**/**</include>
        </includes>
        <filtering>false</filtering>
    </resource>
    <!--指定资源的位置-->
    <resource>
        <directory>src/main/webapp</directory>
        <includes>
            <include>**/**</include>
        </includes>
        <filtering>false</filtering>
    </resource>
</resources>
```