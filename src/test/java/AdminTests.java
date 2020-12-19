import com.my.ShiroTestBoot;
import com.my.helloword.Admin;
import com.my.routing.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author:ljn
 * @Description:
 * @Date:2020/12/03 20:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShiroTestBoot.class)
public class AdminTests  {

    @Autowired
    AdminService adminService;

    @Test
    public void all(){
        Admin admin = adminService.queryByUsername("nanan");
        System.out.println(admin);
    }
    @Test
    public void All(){
        Admin admin = adminService.queryByUsernames("nanan");
        System.out.println(admin);
    }
    /*
        Admin(
            adminId=1,
            username=xiaohei,
            password=a2c9ec06b8c0a2be811dfd47be6e5f82,
            salt=asdfaf,
            roleList=[
                Role(
                    roleId=2,
                    roleName=superAdmin,
                    authorityList=[
                        Authority(authorityId=1, authorityName=admin:query),
                        Authority(authorityId=2, authorityName=admin:delete),
                        Authority(authorityId=3, authorityName=admin:update),
                        Authority(authorityId=4, authorityName=admin:insert)
                    ]
                ),
                Role(roleId=1, roleName=common, authorityList=[]),
                Role(roleId=4, roleName=user, authorityList=[]),
                Role(
                    roleId=3,
                    roleName=admin,
                    authorityList=[
                        Authority(authorityId=5, authorityName=user:select),
                        Authority(authorityId=6, authorityName=user:update)
                    ]
                )
            ]
        )
        */
}
