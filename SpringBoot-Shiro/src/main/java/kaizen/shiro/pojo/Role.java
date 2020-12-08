package kaizen.shiro.pojo;

import lombok.Data;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/12/7
 * @Github: https://github.com/weizujie
 */
@Data
public class Role {

    private Integer id;
    private String name;

    /**
     * 定义权限的集合
     */
    private List<Perms> perms;

}
