package com.my.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "shiro_boot")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Shiro {

    @Id
    private String id;

    private String username;

    private String password;

    private String salt;
}