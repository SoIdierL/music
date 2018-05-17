package com.music.vuemusic.mapper;


import org.apache.ibatis.annotations.Mapper;
import com.music.vuemusic.entity.song_list;

@Mapper
public interface SongListMapper {

    public void insert(song_list songlist);

    public void update(song_list songlist);

    public void delete(int id);

    public song_list find(int id);



}
