package com.zyf.springboot.controller.sys;

import com.baomidou.mybatisplus.plugins.Page;
import com.zyf.springboot.base.mvc.AbstractControllerVo;
import com.zyf.springboot.entity.sys.User;
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
@RestController
@RequestMapping("user")
public class UserController extends AbstractControllerVo<User, UserVo, Integer> {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public UserVo getVo(@PathVariable("id") Integer id) {
        return userService.selectVoById(id);
    }

    @GetMapping
    public Page<UserVo> list(UserVo userVo) {
        List<UserVo> userVos = userService.selectVoList(getWrapper(userVo));
        return new Page<UserVo>(userVo.getPageIndex(), userVo.getPageSize())
                .setRecords(userVos);
    }

    @PostMapping
    public boolean add(@RequestBody UserVo userVo) {
        log.info("开始新增！");
        boolean effect = userService.insertVo(userVo);
        if (effect) {
            log.info("新增成功！");
        } else {
            log.info("新增失败！");
        }
        return effect;
    }

    @PutMapping
    public boolean update(@RequestBody UserVo userVo) {
        log.info("开始修改！");
        boolean effect = userService.updateVoById(userVo);
        if (effect) {
            log.info("修改成功！");
        } else {
            log.info("修改失败！");
        }
        return effect;
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") Integer id) {
        return userService.deleteById(id);
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
