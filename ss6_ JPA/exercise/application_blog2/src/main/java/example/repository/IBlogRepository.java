package example.repository;

import example.model.Blog;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IBlogRepository extends JpaAttributeConverter<Blog, Integer>{

    @Query(value = "SELECT * FROM blog_table", nativeQuery = true)
    List<Blog> findAll();

    @Modifying
    @Query(value = "INSERT INTO blog_table (title, content, posting_date) VALUES (:title, :content, :date)",
            nativeQuery = true)
    void save(@Param("title") String title,
                  @Param("content") String content,
                  @Param("date") String date);

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
    List<Blog> searchByName(@Param("title") String title);

    @Modifying
    @Query(value = "DELETE FROM blog_table WHERE id = :id", nativeQuery = true)
    void remove(@Param("id") int id);

}
