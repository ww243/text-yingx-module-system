package com.my.routing.impl;


import com.my.topic.AdminDao;
import com.my.helloword.Admin;
import com.my.routing.AdminService;
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
