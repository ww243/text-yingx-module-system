package com.my.service.impl;

import com.my.dao.ShiroDao;
import com.my.entity.Shiro;
import com.my.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @author:ljn
 * @Description:
 * @Date:2020/12/02 20:59
 */
@Service
@Transactional
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    private ShiroDao shiroDao;

    @Override
    public List<Shiro> findALl() {
        return shiroDao.selectAll();
    }

    @Override
    public void add(Shiro shiro) {
        shiro.setId(UUID.randomUUID().toString());
        shiroDao.insert(shiro);
    }
}
