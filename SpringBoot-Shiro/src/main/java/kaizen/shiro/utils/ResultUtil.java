package kaizen.shiro.utils;

import lombok.Data;

/**
 * 统一返回 json 数据格式工具类
 *
 * @Author: weizujie
 * @Date: 2020/12/2
 * @Github: https://github.com/weizujie
 */

@Data
public class ResultUtil {

    private Integer code;
    private String msg;
    private Object data;

    public static ResultUtil success(String msg, Object data) {
        ResultUtil r = new ResultUtil();
        r.setCode(0);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static ResultUtil success(Object data) {
        ResultUtil r = new ResultUtil();
        r.setCode(0);
        r.setMsg("操作成功");
        r.setData(data);
        return r;
    }

    public static ResultUtil success(String msg) {
        ResultUtil r = new ResultUtil();
        r.setCode(0);
        r.setMsg(msg);
        r.setData(null);
        return r;
    }

    public static ResultUtil fail(String msg) {
        ResultUtil r = new ResultUtil();
        r.setCode(-1);
        r.setMsg(msg);
        r.setData(null);
        return r;
    }

    public static ResultUtil fail() {
        ResultUtil r = new ResultUtil();
        r.setCode(-1);
        r.setMsg("操作失败");
        r.setData(null);
        return r;
    }

}
