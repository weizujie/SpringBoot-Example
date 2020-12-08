package kaizen.shiro.controller;

import kaizen.shiro.utils.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前后端分离项目中，登录界面跳转应该由前端控制，后端仅返回 json 数据
 *
 * @Author: weizujie
 * @Date: 2020/12/5
 * @Github: https://github.com/weizujie
 */

@RestController
@RequestMapping("/api/v1")
public class UnauthController {
    @GetMapping("/unauth")
    public ResultUtil unauth() {
        return ResultUtil.fail("未授权资源禁止访问");
    }
}
