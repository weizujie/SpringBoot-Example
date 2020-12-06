package kaizen.shiro.shiro;


import kaizen.shiro.pojo.User;
import kaizen.shiro.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义 realm
 *
 * @Author: weizujie
 * @Date: 2020/12/5
 * @Github: https://github.com/weizujie
 */
public class CustomerRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

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
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User dbUser = userService.findByUsername(token.getUsername());
        if (dbUser == null) {
            throw new UnknownAccountException("该用户名不存在");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(dbUser.getUsername(), dbUser.getPassword(), this.getName());
        info.setCredentialsSalt(ByteSource.Util.bytes(dbUser.getSalt()));
        return info;
    }
}
