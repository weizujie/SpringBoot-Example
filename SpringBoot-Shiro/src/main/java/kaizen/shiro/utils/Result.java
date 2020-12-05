package kaizen.shiro.utils;

import lombok.Data;

/**
 * @Author: weizujie
 * @Date: 2020/12/2
 * @Github: https://github.com/weizujie
 */

@Data
public class Result {

    private Integer code;
    private String msg;
    private Object data;

    public static Result success(String msg, Object data) {
        Result r = new Result();
        r.setCode(0);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static Result success(Object data) {
        Result r = new Result();
        r.setCode(0);
        r.setMsg("操作成功");
        r.setData(data);
        return r;
    }

    public static Result success(String msg) {
        Result r = new Result();
        r.setCode(0);
        r.setMsg(msg);
        r.setData(null);
        return r;
    }

    public static Result fail(String msg) {
        Result r = new Result();
        r.setCode(-1);
        r.setMsg(msg);
        r.setData(null);
        return r;
    }

    public static Result fail() {
        Result r = new Result();
        r.setCode(-1);
        r.setMsg("操作失败");
        r.setData(null);
        return r;
    }

}
