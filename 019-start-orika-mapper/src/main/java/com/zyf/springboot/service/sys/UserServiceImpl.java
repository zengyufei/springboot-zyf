package com.zyf.springboot.service.sys;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zyf.springboot.base.mvc.AbstractServiceVoImpl;
import com.zyf.springboot.entity.sys.User;
import com.zyf.springboot.mapper.sys.UserMapper;
import com.zyf.springboot.utils.BeanUtils;
import com.zyf.springboot.vo.sys.UserVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends AbstractServiceVoImpl<UserMapper, User, UserVo, Integer> implements UserService {

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

}
