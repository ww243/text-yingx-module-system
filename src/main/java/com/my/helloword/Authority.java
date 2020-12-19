package com.my.helloword;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authority implements Serializable {

  private String authorityId;
  private String authorityName;


}
