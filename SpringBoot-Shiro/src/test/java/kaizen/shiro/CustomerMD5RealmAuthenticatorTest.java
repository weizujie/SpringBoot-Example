package kaizen.shiro;

/**
 * @Author: weizujie
 * @Date: 2020/12/5
 * @Github: https://github.com/weizujie
 */

import kaizen.shiro.config.CustomerRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * 使用自定义 realm
 */
public class CustomerMD5RealmAuthenticatorTest {

    public static void main(String[] args) {
        // 创建安全管理器
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        // 给安全管理器设置自定义 realm
        CustomerRealm realm = new CustomerRealm();
        // 设置 realm 使用 hash 凭证匹配器
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        // 使用加密算法
        credentialsMatcher.setHashAlgorithmName("md5");
        // 散列次数
        credentialsMatcher.setHashIterations(1024);
        realm.setCredentialsMatcher(credentialsMatcher);
        securityManager.setRealm(realm);
        // 给全局安全工具类设置安全管理器
        SecurityUtils.setSecurityManager(securityManager);
        // 通过安全工具类获取 subject
        Subject subject = SecurityUtils.getSubject();
        // 创建令牌
        UsernamePasswordToken token = new UsernamePasswordToken("weizujie", "123");
        // 进行认证
        try {
            subject.login(token);
            System.out.println("登录成功");
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误");
        }
    }

}
