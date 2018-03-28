package com.zyf.springboot.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试类
 * @author zengyufei
 * @since 1.0.0
 */
@Controller
@RequestMapping("user")
public class UserController {


    @RequestMapping("test")
    @ResponseBody
    public String test() {
        return "test";
    }

    @RequestMapping("login")
    @ResponseBody
    public String login(@RequestParam("id") String id) {
        return "hello " + id;
    }

    @RequestMapping("test2")
    public String test2() {
        // 请求成功会返回 404
        // return "test"; 会调用上面 test() 方法
        // return "test2"; 会调用自己，造成死循环
        return "test3";
    }

    @RequestMapping("login2")
    public String login2(@RequestParam("id") String id) {
        // 请求成功会返回 404
        return "hello2 " + id;
    }
}
