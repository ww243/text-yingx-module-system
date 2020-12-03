package com.my.dao;

import com.my.entity.Admin;

public interface AdminDao {


    Admin queryByUsername(String username);


    Admin queryByUsernames(String username);

}
