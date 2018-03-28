package com.zyf.springboot.service.sys;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zyf.springboot.entity.sys.User;
import com.zyf.springboot.mapper.sys.UserMapper;
import com.zyf.springboot.utils.BeanUtils;
import com.zyf.springboot.vo.sys.UserVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public UserVo getVo(Integer id) {
        boolean present = Optional.ofNullable(id).isPresent();
        if (present) {
            User user = baseMapper.selectById(id);
            if (user == null) {
                return null;
            }
            return BeanUtils.copy(user, UserVo.class);
        }
        return null;
    }

    @Override
    public List<UserVo> selectListVo(UserVo userVo) {
        User user = BeanUtils.copy(userVo, User.class);
        List<User> users = baseMapper.selectList(new EntityWrapper<>(user));
        List<UserVo> userVos = new ArrayList<>();
        if (users == null || users.isEmpty()) {
            return userVos;
        }
        for (User temp : users) {
            UserVo copy = BeanUtils.copy(temp, UserVo.class);
            userVos.add(copy);
        }
        return userVos;
    }

    @Override
    public boolean insertVo(UserVo userVo) {
        User user = BeanUtils.copy(userVo, User.class);
        return user.insert();
    }

    @Override
    public boolean updateVo(UserVo userVo) {
        User user = BeanUtils.copy(userVo, User.class);
        return user != null && user.updateById();
    }

    @Override
    public UserVo login(String userName, String password) {
        User search = new User();
        search.setUsername(userName);
        search.setPassword(password);
        List<User> users = baseMapper.selectList(new EntityWrapper<>(search));
        if (users != null && !users.isEmpty()) {
            User user = baseMapper.selectById(users.get(0).getId());
            if (user == null) {
                return null;
            }
            return BeanUtils.copy(user, UserVo.class);
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByUserId(Integer userId) {
        return baseMapper.deleteById(userId);
    }

}
