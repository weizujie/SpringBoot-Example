package kaizen.shiro.service;

import kaizen.shiro.pojo.User;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/12/2
 * @Github: https://github.com/weizujie
 */
public interface IUserService {

    /**
     * 根据 id 查询用户信息
     *
     * @param id
     * @return
     */
    User findById(Long id);

    /**
     * 查询用户列表
     *
     * @param user
     * @return
     */
    List<User> userList(User user);

    /**
     * 保存用户
     *
     * @param user
     */
    void save(User user) throws Exception;

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    User findByUsername(String username);
}
