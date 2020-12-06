package kaizen.shiro.mapper;

import kaizen.shiro.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/12/2
 * @Github: https://github.com/weizujie
 */

public interface UserMapper {
    /**
     * 根据 id 查询用户
     *
     * @param id id
     * @return User
     */
    User findById(Long id);

    /**
     * 查询用户列表
     *
     * @param user user
     * @return List User
     */
    List<User> userList(User user);

    /**
     * 保存用户
     *
     * @param user
     */
    void save(User user);

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    User findByUsername(String username);
}
