package com.my.routing;

import com.my.helloword.Shiro;

import java.util.List;

/**
 * @author:ljn
 * @Description:
 * @Date:2020/12/02 20:57
 */
public interface ShiroService {

    List<Shiro> findALl();

    void add(Shiro shiro);
}
