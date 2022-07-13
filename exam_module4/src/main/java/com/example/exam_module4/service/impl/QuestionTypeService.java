package com.example.exam_module4.service.impl;

import com.example.exam_module4.model.QuestionType;
import com.example.exam_module4.repository.IQuestionTypeRepository;
import com.example.exam_module4.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeService implements IQuestionTypeService {

    @Autowired
    private IQuestionTypeRepository iQuestionTypeRepository;

    @Override
    public List<QuestionType> findAll() {
        return iQuestionTypeRepository.findAll();
    }

    @Override
    public QuestionType findById(int id) {
        return iQuestionTypeRepository.findById(id);
    }
}
