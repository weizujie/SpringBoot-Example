package kaizen.shiro.controller;

import kaizen.shiro.pojo.User;
import kaizen.shiro.service.IUserService;
import kaizen.shiro.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/12/2
 * @Github: https://github.com/weizujie
 */

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 查询用户信息列表
     */
    @GetMapping("/list")
    public ResultUtil userList(User user) {
        try {
            List<User> userList = userService.userList(user);
            return ResultUtil.success(userList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.fail();
        }
    }



}
