package kaizen.shiro.controller;

import kaizen.shiro.utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: weizujie
 * @Date: 2020/12/5
 * @Github: https://github.com/weizujie
 */

@RestController
public class LoginController {

    /**
     * 处理用户登录
     * 使用 json 作为参数传递，则需要将数据转换为 Map，并且加上 @RequestBody 注解
     * RequestBody 主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)
     */
    @PostMapping("/login")
    public Result login(@RequestBody Map<String, String> map) {
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(map.get("username"), map.get("password")));
            return Result.success("登录成功", null);
        } catch (UnknownAccountException | IncorrectCredentialsException e) {
            return Result.fail("用户名或密码错误");
        }
    }

    /**
     * 处理用户推出
     */
    @PostMapping("/logout")
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
}
