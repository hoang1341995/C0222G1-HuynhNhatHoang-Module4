package com.example.blog_application.repository;

import com.example.blog_application.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IBlogRepository extends PagingAndSortingRepository<Blog, Integer> {

    @Query(value = "select * from blog_table",nativeQuery = true)
    Page<Blog> findAll(Pageable pageable);

    @Modifying
    @Query(value = "INSERT INTO blog_table (title, content, posting_date,id_category) VALUES (:title, :content, :date, :category)",
            nativeQuery = true)
    void save(@Param("title") String title,
                  @Param("content") String content,
                  @Param("date") String date,
                    @Param("category") Integer category);

    @Query(value = "SELECT * FROM blog_table WHERE id = :id", nativeQuery = true)
    Blog findById(@Param("id") int id);

    @Modifying
    @Query(value = "UPDATE blog_table SET title = :title, content = :content, posting_date = :date WHERE id = :id",
            nativeQuery = true)
    void update(@Param("title") String title,
                @Param("content") String content,
                @Param("date") String date,
                @Param("id") int id);

    @Query(value = "SELECT * FROM blog_table WHERE title LIKE :title", nativeQuery = true)
    Page<Blog> searchByName(@Param("title") String title,Pageable pageable);

    @Modifying
    @Query(value = "DELETE FROM blog_table WHERE id = :id", nativeQuery = true)
    void remove(@Param("id") int id);

}
