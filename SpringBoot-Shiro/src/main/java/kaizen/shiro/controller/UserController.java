package kaizen.shiro.controller;

import kaizen.shiro.pojo.User;
import kaizen.shiro.service.IUserService;
import kaizen.shiro.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/12/2
 * @Github: https://github.com/weizujie
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 查询用户信息列表
     */
    @GetMapping("/list")
    public Result userList(User user) {
        List<User> userList = userService.userList(user);
        return Result.success(userList);
    }

}
