package example.repository;

import example.model.Music;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;
@Repository
public class MusicRepository implements IMusicRepository{

    @Override
    public List<Music> findAll() {
        List<Music> musicList = BaseRepository.entityManager.createQuery("select mm from music_model mm",
                Music.class).getResultList();
        return musicList;
    }

    @Override
    public void save(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }

    @Override
    public Music findById(Integer id) {
        Music music = BaseRepository.entityManager.createQuery("select mm from music_model mm where mm.id = :id",
                Music.class).setParameter("id", id).getSingleResult();

        return music;
    }

    @Override
    public void update(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }

    @Override
    public void remove(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(music);
        entityTransaction.commit();
    }

    @Override
    public List<Music> searchByName(String name) {
        List<Music> listSearchByName = BaseRepository.entityManager.createQuery(
                "select mm from music_model mm where mm.name like :name", Music.class).
                setParameter("name", "%" + name + "%").getResultList();
        return listSearchByName;
    }
}
