package kaizen.shiro.config;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * 自定义 realm
 *
 * @Author: weizujie
 * @Date: 2020/12/5
 * @Github: https://github.com/weizujie
 */
public class CustomerRealm extends AuthorizingRealm {

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 在 token 中获取用户名(身份信息)
        String principal = (String) token.getPrincipal();
        // 根据用户名查询数据库
        // 在 CustomerMD5RealmAuthenticatorTest 进行认证
        if ("weizujie".equals(principal)) {
            String password = "09f6fa5e7e660065ab27fa27958b8349";
            String salt = "!Q@W#E";
            new SimpleAuthenticationInfo(
                    principal,
                    password,
                    ByteSource.Util.bytes(salt),
                    this.getName()
            );
        }
        return null;
    }
}
