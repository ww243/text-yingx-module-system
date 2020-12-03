package com.my.service;

import com.my.entity.Admin;

public interface AdminService {

    Admin queryByUsername(String username);

    Admin queryByUsernames(String username);
}
