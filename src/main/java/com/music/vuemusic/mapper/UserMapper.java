package com.music.vuemusic.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.music.vuemusic.entity.userinfo;

@Mapper
public interface UserMapper {

    public void insert(userinfo user);

    public void update(userinfo user);

    public void delete(int id);

    public userinfo find(int id);

    public  userinfo getByUsername(String username);
}
