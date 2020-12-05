package kaizen.shiro.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 * @Author: weizujie
 * @Date: 2020/12/2
 * @Github: https://github.com/weizujie
 */


@Data
public class User {

    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String salt;
    private Date createdTime;
    private Date updatedTime;



}
