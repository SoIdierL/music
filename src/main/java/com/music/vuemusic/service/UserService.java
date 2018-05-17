package com.music.vuemusic.service;


import javax.annotation.Resource;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.music.vuemusic.entity.userinfo;
import com.music.vuemusic.mapper.UserMapper;


@SpringBootApplication
@ComponentScan({"com.music.vuemusic.mapper"})
@Service("userService")
public class UserService {
    @Resource
    private UserMapper userMapper;

    public userinfo insert(userinfo user) throws com.music.vuemusic.entity.UserException {


        userinfo name = userMapper.getByUsername(user.getUsername());

        userinfo userinfo;
        if (name != null) {
            throw new com.music.vuemusic.entity.UserException("该用户已存在");
        } else if (user.getPassword().length() < 6) {
            throw new com.music.vuemusic.entity.UserException("密码长度不得小于6位");
        } else {

            userMapper.insert(user);
            userinfo = userMapper.getByUsername(user.getUsername());
            if (userinfo == null) {
                throw new com.music.vuemusic.entity.UserException("创建用户失败");
            }
        }
        return userinfo;
    }

    public userinfo login(userinfo user) throws com.music.vuemusic.entity.UserException {


        userinfo name = userMapper.getByUsername(user.getUsername());
        if (name == null) {
            throw new com.music.vuemusic.entity.UserException("用户不存在");
        } else if (name.getPassword().equals(user.getPassword())==false) {
            throw new com.music.vuemusic.entity.UserException("密码不正确");
        } else {
           //此处为登录session
        }
        return name;
    }


    public void update(userinfo user) {
        userMapper.update(user);
    }

    public userinfo find(int id) {
        return userMapper.find(id);
    }

    public void delete(int id){
        userMapper.delete(id);
    }
}
