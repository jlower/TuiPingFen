package com.xiaozhaovip.demo.service.user;

import com.xiaozhaovip.demo.intf.entity.User;
import com.xiaozhaovip.demo.intf.mapper.UserMapper;
import com.xiaozhaovip.demo.intf.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User loadById(int id) {
        return userMapper.loadById(id);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return 0;
    }
}
