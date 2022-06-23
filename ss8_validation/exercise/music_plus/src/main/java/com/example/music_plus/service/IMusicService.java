package com.example.music_plus.service;


import com.example.music_plus.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IMusicService {

    Page<Music> findAll(Pageable pageable);

    void save(Music music);

    Music findById(int id);

    void update(Music music);

    void remove(Integer id);

    Page<Music> searchByName(String name,Pageable pageable);

}
