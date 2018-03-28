package com.zyf.springboot.service.sys;

import com.zyf.springboot.entity.sys.User;
import com.zyf.springboot.enums.UserType;
import com.zyf.springboot.mapper.sys.UserLoginMapper;
import com.zyf.springboot.mapper.sys.UserMapper;
import com.zyf.springboot.mapper.sys.UserVoMapper;
import com.zyf.springboot.vo.sys.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserLoginMapper userLoginMapper;
    @Autowired
    private UserVoMapper userVoMapper;

    @Override
    public int add(User user) {
        return 1;
    }

    @Override
    public int addVo(UserVo userVo) {
        return 1;
    }

    @Override
    public User get(Integer id) {
        boolean present = Optional.ofNullable(id).isPresent();
        if (present) {
            return userMapper.get(id);
        }
        return null;
    }

    @Override
    public UserVo getVo(Integer id) {
        boolean present = Optional.ofNullable(id).isPresent();
        if (present) {
            return userVoMapper.get(id);
        }
        return null;
    }

    @Override
    public List<User> list(User user) {
        return userMapper.list(user);
    }

    @Override
    public List<UserVo> listVo(UserVo userVo) {
        return userVoMapper.list(userVo);
    }

    @Override
    public UserVo login(String userName, String password) {
        UserVo userVo = new UserVo();
        userVo.setId(1);
        userVo.setUsername(userName);
        userVo.setPassword(password);
        userVo.setAge(11);
        userVo.setEnable(true);
        userVo.setUserId(1);
        userVo.setUserLoginId(1);
        userVo.setRealName(null);
        userVo.setType(UserType.SYSTEM_USER);
        return userVo;
    }

}
