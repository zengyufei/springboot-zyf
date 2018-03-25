package com.zyf.springboot.service.sys.impl;

import com.zyf.springboot.base.mvc.AbstractServiceVoImpl;
import com.zyf.springboot.entity.sys.Role;
import com.zyf.springboot.mapper.sys.RoleMapper;
import com.zyf.springboot.service.sys.RoleService;
import com.zyf.springboot.vo.sys.RoleVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl extends AbstractServiceVoImpl<RoleMapper, Role, RoleVo, Integer> implements RoleService {

}
