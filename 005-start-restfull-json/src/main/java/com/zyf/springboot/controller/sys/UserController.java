package com.zyf.springboot.controller.sys;

import com.zyf.springboot.service.sys.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户控制层
 * @author zengyufei
 * @since 1.0.0
 */
@RestController // == @Controller + @ResponseBody
@RequestMapping("user")
public class UserController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @GetMapping("get/{id}")
    public Map get(@PathVariable("id") String id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("username", "admin");
        map.put("password", "admin");
        map.put("createTime", DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        return map;
    }

    @GetMapping("list/{username}")
    public Map list(@PathVariable("username") String username) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        return map;
    }

    @PostMapping("login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        log.info("开始登陆！");
        String result = userService.login(username, password);
        if (StringUtils.isNotBlank(result)) {
            log.info("登陆成功！");
        } else {
            log.info("登陆失败！");
        }
        return result;
    }

}
