package com.music.vuemusic.mapper;


import org.apache.ibatis.annotations.Mapper;
import com.music.vuemusic.entity.song_list_detail;

@Mapper
public interface SongListDetailMapper {


    public void insert(song_list_detail songlistdetail);

    public void update(song_list_detail songlistdetail);

    public void delete(int id);

    public song_list_detail find(int id);
}
