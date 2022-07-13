package com.example.exam_module4.service;

import com.example.exam_module4.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuestionContentService {

    Page<QuestionContent> findAll(Pageable pageable);

    void save(QuestionContent questionContent);

    QuestionContent findById(int id);

    void update(QuestionContent questionContent);

    void remove(Integer id);

    Page<QuestionContent> searchByTitle(String name,int questionTypeSearch ,Pageable pageable);
}
