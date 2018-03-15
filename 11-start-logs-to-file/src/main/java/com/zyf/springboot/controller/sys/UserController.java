package com.zyf.springboot.controller.sys;

import com.zyf.springboot.service.sys.UserService;
import com.zyf.springboot.vo.sys.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public UserVo get(@PathVariable("id") Integer id) {
        return userService.get(id);
    }

    @GetMapping("list")
    public List<UserVo> list(UserVo userVo) {
        return userService.list(userVo);
    }

    @PostMapping("login")
    public UserVo login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        log.info("开始登陆！");
        UserVo userVo = userService.login(username, password);
        if (Optional.ofNullable(userVo).isPresent()) {
            log.info("登陆成功！");
        } else {
            log.info("登陆失败！");
        }
        return userVo;
    }

}
