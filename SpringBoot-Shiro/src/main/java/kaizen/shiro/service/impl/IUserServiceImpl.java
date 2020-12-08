package kaizen.shiro.service.impl;

import kaizen.shiro.mapper.UserMapper;
import kaizen.shiro.pojo.Perms;
import kaizen.shiro.pojo.User;
import kaizen.shiro.service.IUserService;
import kaizen.shiro.utils.SaltUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/12/2
 * @Github: https://github.com/weizujie
 */

@Slf4j
@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public List<User> userList(User user) {
        return userMapper.userList(user);
    }

    @Override
    public void save(User user) {
        // 判断注册的用户名是否存在数据库中，不存在则直接注册
        if (userMapper.findByUsername(user.getUsername()) == null) {
            // 生成随机 salt
            String salt = SaltUtil.getSalt(8);
            // 将随机 salt 保存到数据库
            user.setSalt(salt);
            // 密码加密 (md5 + salt + hash散列)
            Md5Hash md5Hash = new Md5Hash(user.getPassword(), salt, 1024);
            user.setPassword(md5Hash.toHex());
            userMapper.save(user);
        } else {
            throw new UnknownAccountException("该用户名已存在，请重新输入");
        }
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public User findRolesByUsername(String username) {
        return userMapper.findRolesByUsername(username);
    }

    @Override
    public List<Perms> findPermsByRoleId(Integer id) {
        return userMapper.findPermsByRoleId(id);
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }
}
