package com.example.music_plus.repository;

import com.example.music_plus.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
@Transactional
public interface IMusicRepository extends PagingAndSortingRepository<Music, Integer> {

    @Query(value = "select * from music_model",nativeQuery = true)
    Page<Music> findAll(Pageable pageable);

    @Modifying
    @Query(value = "INSERT INTO music_model (name, singer, type, path) VALUES (:name, :singer, :type, :path)",
            nativeQuery = true)
    void save(@Param("name") String name,
              @Param("singer") String singer,
              @Param("type") String type,
              @Param("path") String path);

    @Query(value = "SELECT * FROM music_model WHERE id = :id", nativeQuery = true)
    Music findById(@Param("id") int id);

    @Modifying
    @Query(value = "UPDATE music_model SET name = :name, singer = :singer, type = :type, path = :path WHERE id = :id",
            nativeQuery = true)
    void update(@Param("name") String name,
                @Param("singer") String singer,
                @Param("type") String type,
                @Param("path") String path,
                @Param("id") int id);

    @Query(value = "SELECT * FROM music_model WHERE name LIKE :name", nativeQuery = true)
    Page<Music> searchByName(@Param("name") String name,Pageable pageable);

    @Modifying
    @Query(value = "DELETE FROM music_model WHERE id = :id", nativeQuery = true)
    void remove(@Param("id") int id);

}
