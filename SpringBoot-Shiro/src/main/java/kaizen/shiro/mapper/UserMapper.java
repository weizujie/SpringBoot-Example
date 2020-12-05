package kaizen.shiro.mapper;

import kaizen.shiro.pojo.User;

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
}
