package com.aaron.videoplay.mapper;

import com.aaron.videoplay.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    //用户插入
    int insert(@Param("user")User user);

    //根据用户昵称和密码查询用户信息
    User getByNickNameAndPass(@Param("nickName") String nickName, @Param("userPass") String userPass);

    //判断某昵称是否存在
    int isExistNickName(@Param("nickName")String nickName);

    //判断某用户是否在线
    int isOn(@Param("nickName")String nickName);

    //用户信息修改
    void update(@Param("user") User user);


}
