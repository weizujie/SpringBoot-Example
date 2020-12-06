package kaizen.shiro.controller;

import kaizen.shiro.pojo.User;
import kaizen.shiro.service.IUserService;
import kaizen.shiro.utils.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: weizujie
 * @Date: 2020/12/5
 * @Github: https://github.com/weizujie
 */

@RestController
@RequestMapping("/api/v1/")
public class AuthController {

    @Autowired
    private IUserService userService;

    /**
     * 处理用户注册
     */
    @PostMapping("/register")
    public ResultUtil saveUser(@RequestBody User user) {
        try {
            userService.save(user);
            return ResultUtil.success(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.fail(e.getMessage());
        }
    }

    /**
     * 处理用户登录
     * 使用 json 作为参数传递，则需要将数据转换为 Map，并且加上 @RequestBody 注解
     * RequestBody 主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)
     */
    @PostMapping("/login")
    public ResultUtil login(@RequestBody Map<String, String> map) {
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(map.get("username"), map.get("password")));
            return ResultUtil.success("登录成功", subject.getPrincipal());
        } catch (UnknownAccountException | IncorrectCredentialsException e) {
            e.printStackTrace();
            return ResultUtil.fail("用户名或密码错误");
        }
    }

    /**
     * 处理用户退出
     */
    @PostMapping("/logout")
    public ResultUtil logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResultUtil.success("退出成功");
    }
}
