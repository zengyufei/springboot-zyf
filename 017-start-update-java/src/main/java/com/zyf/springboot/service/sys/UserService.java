package com.zyf.springboot.service.sys;

import com.baomidou.mybatisplus.service.IService;
import com.zyf.springboot.entity.sys.User;
import com.zyf.springboot.vo.sys.UserVo;

import java.util.List;

public interface UserService extends IService<User> {

    /**
     * 新增用户方法
     */
    boolean insertVo(UserVo userVo);


    /**
     * 修改用户方法
     */
    boolean updateVo(UserVo userVo);

    /**
     * 查找用户方法
     */
    UserVo getVo(Integer id);

    /**
     * 查找列表方法
     */
    List<UserVo> selectListVo(UserVo userVo);

    /**
     * 登录方法
     */
    UserVo login(String userName, String password);

    /**
     * 删除用户方法
     */
    int deleteByUserId(Integer userId);
}
