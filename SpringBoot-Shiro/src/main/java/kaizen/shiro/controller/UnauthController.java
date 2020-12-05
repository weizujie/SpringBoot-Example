package kaizen.shiro.controller;

import kaizen.shiro.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前后端分离项目中，登录界面跳转应该由前端控制，后端仅返回 json 数据
 *
 * @Author: weizujie
 * @Date: 2020/12/5
 * @Github: https://github.com/weizujie
 */

@RestController
public class UnauthController {
    @GetMapping("/unauth")
    public Result unauth() {
        Result result = new Result();
        result.setMsg("未登录");
        return result;
    }
}
