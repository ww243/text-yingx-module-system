package com.my.service.impl;


import com.my.dao.AdminDao;
import com.my.entity.Admin;
import com.my.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Resource
    AdminDao adminDao;

    @Override
    public Admin queryByUsername(String username) {
        return adminDao.queryByUsername(username);
    }

    @Override
    public Admin queryByUsernames(String username) {
        return adminDao.queryByUsernames(username);
    }
}
