package com.my.routing;

import com.my.helloword.Admin;

public interface AdminService {

    Admin queryByUsername(String username);

    Admin queryByUsernames(String username);
}
