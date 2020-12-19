package com.my.helloword;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin implements Serializable {

  private String adminId;
  private String username;
  private String password;
  private String salt;

  //关系字段  角色集合
  List<Role> roleList;

}
