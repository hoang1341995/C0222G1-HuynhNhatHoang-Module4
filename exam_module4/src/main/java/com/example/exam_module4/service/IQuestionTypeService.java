package com.example.exam_module4.service;

import com.example.exam_module4.model.QuestionType;

import java.util.List;

public interface IQuestionTypeService {

    List<QuestionType> findAll();

    QuestionType findById(int id);
}
