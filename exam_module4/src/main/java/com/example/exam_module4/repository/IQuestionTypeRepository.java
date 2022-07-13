package com.example.exam_module4.repository;


import com.example.exam_module4.model.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IQuestionTypeRepository extends JpaRepository<QuestionType, Integer> {

    @Query(value = "SELECT * FROM question_type WHERE id = :id", nativeQuery = true)
    QuestionType findById(@Param("id") int id);

}
