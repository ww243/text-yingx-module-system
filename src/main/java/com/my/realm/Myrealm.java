package com.my.realm;

import com.my.helloword.Admin;
import com.my.helloword.Authority;
import com.my.helloword.Role;
import com.my.routing.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:ljn
 * @Description:加盐加密
 * @Date:2020/12/02 19:13
 */
public class Myrealm extends AuthorizingRealm {

    @Autowired
    AdminService adminService;

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("===认证==");

        //强转
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;

        //获取身份信息
        String username = upToken.getUsername();

        //根据用户名查询数据库
        //User("1","xiaohei","c3f2b09474f65a0bb8eda78e3682955f","abcd")
        Admin admin = adminService.queryByUsername(username);


        SimpleAuthenticationInfo info =null;
        if(admin!=null){
            info = new SimpleAuthenticationInfo(
                    admin.getUsername(),  //用户名
                    admin.getPassword(),  //密码
                    ByteSource.Util.bytes(admin.getSalt()),  //随机盐
                    this.getName()  //当前类类名
            );
        }
        return info;
    }


    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("===授权===");

        //获取主身份
        String username = (String)principalCollection.getPrimaryPrincipal();

        //根据身份信息查询角色  角色集合
        //根据角色查询权限   权限集合

        // admin(user:query  user:update category:query category:delete category:update category:add)
        // sAdmin(admin:query admin:add admin:delete log:query)\
        Admin admin = adminService.queryByUsernames(username);

        ArrayList<String> roleLists = new ArrayList<>();

        ArrayList<String> permissiones = new ArrayList<>();

        //获取角色集合
        List<Role> roleList = admin.getRoleList();
        for (Role role : roleList) {

            //获取角色名
            String roleName = role.getRoleName();

            //添加角色
            roleLists.add(roleName);

            //获取权限集合
            List<Authority> authorityList = role.getAuthorityList();
            for (Authority authority : authorityList) {

                //获取权限名
                String authorityName = authority.getAuthorityName();

                //添加权限集合
                permissiones.add(authorityName);
            }

        }

        SimpleAuthorizationInfo info=null;
        if(admin!=null){
            //设置主体的角色和权限
            info=new SimpleAuthorizationInfo();

            //设置角色
            info.addRoles(roleLists);
            //设置权限
            info.addStringPermissions(permissiones);
        }
        return info;
    }
}
