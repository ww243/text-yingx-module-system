import com.my.ShiroTestBoot;
import com.my.entity.Shiro;
import com.my.service.ShiroService;
import com.my.util.Md5Utils;
import org.apache.shiro.crypto.hash.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author:ljn
 * @Description:
 * @Date:2020/12/02 20:19
 */
@SpringBootTest(classes = ShiroTestBoot.class)
@RunWith(SpringRunner.class)
public class ShiroTests {

    @Autowired
    private ShiroService shiroService;


    @Test
    public void main() {
        //MD5 SHA
        //创建加密算法  参数:明文密码
        Md5Hash md5Hash = new Md5Hash("123456");
        System.out.println("明文密码:"+md5Hash);
        //创建加密算法  参数:明文密码,随机盐
        Md5Hash md5Hash1 = new Md5Hash("123456","abcd");
        System.out.println("明文密码+盐:"+md5Hash1);
        //创建加密算法  参数:明文密码,随机盐,散列次数
        Md5Hash md5Hash2 = new Md5Hash("123456","abcd",1024);
        System.out.println("明文密码+盐+散列次数:"+md5Hash2);

        System.out.println("----------------------------");

        Md2Hash md2Hash = new Md2Hash("123456");
        System.out.println("MD2明文密码:"+md2Hash);
        Sha1Hash sha1Hash = new Sha1Hash("123456");
        System.out.println("Sha1:---"+sha1Hash);
        Sha256Hash sha256Hash = new Sha256Hash("123456");
        System.out.println("Sha256:---"+sha256Hash);
        Sha384Hash sha384Hash = new Sha384Hash("123456");
        System.out.println("Sha384:---"+sha384Hash);
        Sha512Hash sha512Hash = new Sha512Hash("123456");
        System.out.println("Sha512:---"+sha512Hash);

    }
    @Test
    public void add(){
        Shiro shiro = new Shiro();
        shiro.setUsername("小梦");
        String salt = Md5Utils.getSalt(4);
        shiro.setSalt(salt);
        String md5Code = Md5Utils.getMd5Code("123456");
        shiro.setPassword(md5Code+salt);
        shiroService.add(shiro);
        List<Shiro> aLl = shiroService.findALl();
        for (Shiro shiro1 : aLl) {
            System.out.println(shiro1);
        }


    }
}
