package com.aaron.videoplay.service;

import com.aaron.videoplay.entity.User;

public interface UserService {

    boolean isExistNickName(String nickName);

    User getByNickNameAndPass(String nickName,String userPass);

    void updateUser(User user);

    int registryUser(User user);

    boolean isOn(String nickName);
}
