package com.my.conf;


import com.my.realm.Myrealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @author:ljn
 * @Description:
 * @Date:2020/12/02 19:12
 */
@Configuration
public class Myconf {


    /**
     *@return:将Shiro过滤器工厂对象交给Spring工厂管理
    */
    @Bean
    public ShiroFilterFactoryBean getShiroFilter(DefaultWebSecurityManager securityManager){

        //创建Shiro过滤器工厂对象
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();

        //将安全管理器对象交给过滤器工厂
        factoryBean.setSecurityManager(securityManager);

        //设置过滤规则的map
        HashMap<String, String> map = new HashMap<>();

        /**
         *@return:anon、匿名过滤器、配置的资源不用认证就可以访问
         *@return:eauthc认证过滤器、配置的所有资源必须要认证通过才能访问
        */
        //资源路径,过滤器简称
        map.put("/**","authc");
        map.put("/user/login","anon");
        map.put("/main/main.jsp","anon");

        //配置退出过滤器  具体的退出代码Shiro已经实现
        map.put("/logout","logout");
        //记住我管理器
        map.put("/**","user");

        /**
         *@return:配置过滤器链(多个过滤器)
        */
        factoryBean.setFilterChainDefinitionMap(map);
        /**
         *@return:指定登录页面的位置
         */
        factoryBean.setLoginUrl("/user/login.jsp");

        return factoryBean;
    }

    /**
     *@return:将安全管理器对象交给Spring工厂管理
    */
    //将安全管理器对象交给Spring工厂管理
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Myrealm myrealm, DefaultWebSessionManager sessionManager, CookieRememberMeManager rememberMeManager){
        //创建安全管理器对象
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();

        //将自定义Realm交给安全管理器
        securityManager.setRealm(myrealm);

        //将sessin管理器交给安全管理器
        securityManager.setSessionManager(sessionManager);

        //将记住我管理器交给安全管理器
        securityManager.setRememberMeManager(rememberMeManager);
        return securityManager;
    }


    /**
     *@return:将自定义Realm对象交给Spring工厂管理
     */
    @Bean
    public Myrealm getMyrealm(HashedCredentialsMatcher credentialsMatcher){
        //创建自定义的Realm对象
        Myrealm myrealm = new Myrealm();
        //将凭证匹配器给自定义的Realm
        myrealm.setCredentialsMatcher(credentialsMatcher);
        return myrealm;
    }

    /**
     *@return:将凭证匹配器对象交给Spring工厂管理
    */
    @Bean
    public HashedCredentialsMatcher getHashedCredentialsMatcher(){
        //创建凭证匹配器
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");//加密算法
        credentialsMatcher.setHashIterations(1024); //散列次数
        return credentialsMatcher;
    }
    /**
     *@return:将Session管理器对象交给Spring工厂管理
    */
    @Bean
    public DefaultWebSessionManager getDefaultWebSessionManager(){
        //创建Session管理器对象
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        //设置session过期时间  参数:long类型的过期时间单位时毫秒
        sessionManager.setGlobalSessionTimeout((1*1000)*60*2);

        return sessionManager;
    }

    /**
     *@return:将记住我管理器对象交给Spring工厂管理
    */
    @Bean
    public CookieRememberMeManager getCookieRememberMeManager(SimpleCookie cookie){
        //创建记住我管理器
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        //将Cookie对象交给记住我管理器
        rememberMeManager.setCookie(cookie);

        return rememberMeManager;
    }
    /**
     *@return:将Cookie对象交给Spring工厂管理
    */
    @Bean
    public SimpleCookie getSimpleCookie(){
        //创建Cookie对象
        SimpleCookie cookie = new SimpleCookie();
        //设置记住我的名字  登陆页面 checkbox 中name的名字
        cookie.setName("rememberme");
        //设置过期时间  单位秒
        cookie.setMaxAge(1*60*5);

        return cookie;
    }


}
