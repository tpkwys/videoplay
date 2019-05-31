package com.aaron.videoplay.service.impl;

import com.aaron.videoplay.entity.User;
import com.aaron.videoplay.mapper.UserMapper;
import com.aaron.videoplay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean isExistNickName(String nickName) {
        return userMapper.isExistNickName(nickName)>0?true:false;
    }

    @Override
    public User getByNickNameAndPass(String nickName, String userPass) {
        return userMapper.getByNickNameAndPass(nickName,userPass);
    }

    @Override
    public void updateUser(User user) {
        userMapper.update(user);

    }

    @Override
    public int registryUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public boolean isOn(String nickName) {
        return userMapper.isOn(nickName)>0?true:false;
    }
}
