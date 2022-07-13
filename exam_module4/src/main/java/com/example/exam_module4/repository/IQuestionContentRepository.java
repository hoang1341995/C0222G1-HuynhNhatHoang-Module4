package com.example.exam_module4.repository;

import com.example.exam_module4.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IQuestionContentRepository extends JpaRepository<QuestionContent, Integer> {

    @Query(value = "select * from question_content",nativeQuery = true)
    Page<QuestionContent> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM question_content WHERE id = :id", nativeQuery = true)
    QuestionContent findById(@Param("id") int id);


    @Query(value = "SELECT * FROM question_content WHERE title LIKE :name AND id_question_type = :questionTypeSearch", nativeQuery = true)
    Page<QuestionContent> searchByTitle(@Param("name") String name,@Param("questionTypeSearch") int questionTypeSearch,Pageable pageable);


}
