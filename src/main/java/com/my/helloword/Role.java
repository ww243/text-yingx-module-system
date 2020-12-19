package com.my.helloword;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

  private String roleId;
  private String roleName;


  //关系字段   权限集合
  List<Authority> authorityList;

}
