package example.repository;

import example.model.Music;

import java.util.List;

public interface IMusicRepository {

    List<Music> findAll();

    void save(Music music);

    Music findById(Integer id);

    void update(Music music);

    void remove(Music music);

    List<Music> searchByName(String name);

}
