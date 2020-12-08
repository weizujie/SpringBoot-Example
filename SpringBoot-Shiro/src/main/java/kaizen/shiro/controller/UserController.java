package kaizen.shiro.controller;

import kaizen.shiro.pojo.User;
import kaizen.shiro.service.IUserService;
import kaizen.shiro.utils.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 如果发现写了 @RequiresRoles 或 @RequiresPermissions 注解但是不进入 doGetAuthorizationInfo() 方法，
 * 去 shiro 配置里看看是否启用了 shiro 注解支持（需要配置两个类）
 *
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
     * 用户添加
     */
    @PostMapping("/add")
    @RequiresPermissions("sys:user:add")
    public ResultUtil saveUser(@RequestBody User user) {
        userService.save(user);
        return ResultUtil.success("用户添加成功");
    }

    /**
     * 根据用户 id 删除用户
     */
    @DeleteMapping("/delete/{id}")
    @RequiresPermissions("sys:user:delete")
    public ResultUtil deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
        return ResultUtil.success("删除成功");
    }


    /**
     * 查询用户信息列表
     */
    @GetMapping("/list")
    @RequiresPermissions("sys:user:list")
    public ResultUtil userList(User user) {
        List<User> userList = userService.userList(user);
        return ResultUtil.success(userList);
    }


}
