package com.zyf.springboot.service.sys.impl;

import com.zyf.springboot.base.mvc.AbstractServiceVoImpl;
import com.zyf.springboot.entity.sys.Resource;
import com.zyf.springboot.mapper.sys.ResourceMapper;
import com.zyf.springboot.service.sys.ResourceService;
import com.zyf.springboot.vo.sys.ResourceVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ResourceServiceImpl extends AbstractServiceVoImpl<ResourceMapper, Resource, ResourceVo, Integer> implements ResourceService {

}
