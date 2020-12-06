package kaizen.shiro.service.impl;

import kaizen.shiro.mapper.UserMapper;
import kaizen.shiro.pojo.User;
import kaizen.shiro.service.IUserService;
import kaizen.shiro.utils.SaltUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
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

    @Override
    public void save(User user) throws Exception {
        // 判断数据库中是否存在该用户名
        if (!user.getUsername().equals(userMapper.findByUsername(user.getUsername()).getUsername())) {
            // 生成随机 salt
            String salt = SaltUtil.getSalt(8);
            // 将随机 salt 保存到数据库
            user.setSalt(salt);
            // 密码加密 (md5 + salt + hash散列)
            Md5Hash md5Hash = new Md5Hash(user.getPassword(), salt, 1024);
            user.setPassword(md5Hash.toHex());
            userMapper.save(user);
        }
        throw new Exception("该用户名已存在");
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
