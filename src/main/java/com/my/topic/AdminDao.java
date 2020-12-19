package com.my.topic;

import com.my.helloword.Admin;

public interface AdminDao {


    Admin queryByUsername(String username);


    Admin queryByUsernames(String username);

}
