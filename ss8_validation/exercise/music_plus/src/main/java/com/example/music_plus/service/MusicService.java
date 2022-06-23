package com.example.music_plus.service;

import com.example.music_plus.model.Music;
import com.example.music_plus.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService{
    @Autowired
    private IMusicRepository iMusicRepository;

    @Override
    public Page<Music> findAll(Pageable pageable) {
        return iMusicRepository.findAll(pageable);
    }

    @Override
    public void save(Music music) {
        iMusicRepository.save(music.getName(),music.getSinger(),music.getType(),music.getPath());
    }

    @Override
    public Music findById(int id) {
        return iMusicRepository.findById(id);
    }

    @Override
    public void update(Music music) {
        iMusicRepository.update(music.getName(),music.getSinger(),music.getType(),music.getPath(),music.getId());
    }

    @Override
    public void remove(Integer id) {
        iMusicRepository.remove(id);
    }

    @Override
    public Page<Music> searchByName(String name, Pageable pageable) {
        return iMusicRepository.searchByName("%"+name+"%",pageable);
    }
}
