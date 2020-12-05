package kaizen.shiro.service.impl;

import kaizen.shiro.mapper.UserMapper;
import kaizen.shiro.pojo.User;
import kaizen.shiro.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/12/2
 * @Github: https://github.com/weizujie
 */

@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public List<User> userList(User user) {
        return userMapper.userList(user);
    }
}
