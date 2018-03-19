package com.zyf.springboot.service.sys;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zyf.springboot.entity.sys.User;
import com.zyf.springboot.entity.sys.UserLogin;
import com.zyf.springboot.mapper.sys.UserLoginMapper;
import com.zyf.springboot.mapper.sys.UserMapper;
import com.zyf.springboot.mapper.sys.UserVoMapper;
import com.zyf.springboot.utils.BeanUtils;
import com.zyf.springboot.vo.sys.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserLoginMapper userLoginMapper;
    @Autowired
    private UserVoMapper userVoMapper;

    @Override
    public boolean insertVo(UserVo userVo) {
        User user = BeanUtils.copy(userVo, User.class);
        UserLogin userLogin = BeanUtils.copy(userVo, UserLogin.class);
        boolean insertUser = user.insert();
        if (insertUser) {
            userLogin.setUserId(user.getId());
            userLogin.insert();
        }
        return insertUser;
    }

    @Override
    public int updateVo(UserVo userVo) {
        return 1;
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
    public List<UserVo> selectListVo(UserVo userVo) {
        return userVoMapper.selectList(userVo);
    }

    @Override
    public UserVo login(String userName, String password) {
        UserLogin search = new UserLogin();
        search.setUsername(userName);
        search.setPassword(password);
        UserLogin userLogin = userLoginMapper.selectOne(search);
        if (userLogin != null) {
            return userVoMapper.get(userLogin.getUserId());
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByUserId(Integer userId) {
        EntityWrapper<UserLogin> loginEntityWrapper = new EntityWrapper<>();
        loginEntityWrapper.eq("user_id", userId);
        userLoginMapper.delete(loginEntityWrapper);
        return baseMapper.deleteById(userId);
    }

}
