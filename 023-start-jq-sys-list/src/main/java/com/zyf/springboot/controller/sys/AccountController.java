package com.zyf.springboot.controller.sys;

import com.zyf.springboot.base.Msg;
import com.zyf.springboot.service.sys.UserService;
import com.zyf.springboot.vo.sys.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * 登录
 * @author zengyufei
 * @since 1.0.0
 */
@RestController
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public Msg login(@RequestParam("username") String username,
                     @RequestParam("password") String password) {
        log.info("开始登陆！");
        String ok = "登陆成功！";
        String error = "登录失败！";
        UserVo userVo = userService.login(username, password);
        if (Optional.ofNullable(userVo).isPresent()) {
            log.info(ok);
            return Msg.ok(ok);
        } else {
            log.info(error);
            return Msg.ok(error);
        }
    }

}
