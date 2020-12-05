package kaizen.shiro.config;

import kaizen.shiro.shiro.CustomerRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * shiro 配置
 *
 * @Author: weizujie
 * @Date: 2020/12/5
 * @Github: https://github.com/weizujie
 */
@Configuration
public class ShiroConfig {

    /**
     * Session 管理器
     */
    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        // 设置 session 过期时间为 1 小时
        sessionManager.setGlobalSessionTimeout(60 * 60 * 1000);
        // 删除过期的 session
        sessionManager.setDeleteInvalidSessions(true);
        // 是否定时检查 session
        sessionManager.setSessionValidationSchedulerEnabled(true);
        // 取消登录跳转 URL 后面的 jsessionid 参数
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }

    /**
     * 创建 shiroFilter，负责拦截所有请求
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 给 filter 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, String> map = new HashMap<>();
        // 配置系统受限资源(需要认证才能访问的资源)
        map.put("/api/v1/user/*", "authc");

        // 配置 shiro 默认登录界面地址。前后端分离项目中，登录界面跳转应该由前端控制，后端仅返回 json 数据
        shiroFilterFactoryBean.setLoginUrl("/api/v1/unauth");

        // 设置访问未授权地址时跳转的页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/api/v1/unauth");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    /**
     * 安全管理器
     */
    @Bean
    public DefaultWebSecurityManager securityManager(Realm realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 给安全管理器设置自定义 realm
        securityManager.setRealm(realm);
        return securityManager;
    }

    /**
     * 自定义 realm
     */
    @Bean
    public Realm realm() {
        return new CustomerRealm();
    }
}
