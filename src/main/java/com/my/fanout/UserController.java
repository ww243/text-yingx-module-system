package com.my.fanout;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:ljn
 * @Description:
 * @Date:2020/12/02 19:14
 */
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("login")
    public String login(String username,String password,String rememberme){
        System.out.println("用户名:"+username);
        System.out.println("记住我的名字:"+rememberme);

        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        //封装token
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //判断是否选中
        if (rememberme!=null && rememberme.equals("1")){
            token.setRememberMe(true);//开启记住我
        }
        String message=null;
        try {
            subject.login(token);//认证
            return "redirect:/main/main.jsp";
        } catch (UnknownAccountException e) {
            message = "用户名不正确!!!!!!";
            System.out.println("认证结果:"+message);
            return "redirect:/user/login.jsp";
        }catch (IncorrectCredentialsException e) {
            message = "密码不正确!!!!!!";
            System.out.println("认证结果:"+message);
            return "redirect:/user/login.jsp";
        }
    }

    @RequestMapping("logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();

        return "redirect:/user/login.jsp";
    }
    @RequestMapping("add")
    public String add(){

        System.out.println("===");

        return "redirect:/main/query.jsp";
    }
}
