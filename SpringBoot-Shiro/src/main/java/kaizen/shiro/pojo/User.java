package kaizen.shiro.pojo;

import lombok.Data;

/**
 * @Author: weizujie
 * @Date: 2020/12/2
 * @Github: https://github.com/weizujie
 */


@Data
public class User {

    private Long id;
    private String username;
    private String password;
    private String salt;

}
