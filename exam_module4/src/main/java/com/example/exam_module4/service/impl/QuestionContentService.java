package com.example.exam_module4.service.impl;

import com.example.exam_module4.model.QuestionContent;
import com.example.exam_module4.repository.IQuestionContentRepository;
import com.example.exam_module4.service.IQuestionContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class QuestionContentService implements IQuestionContentService {

    @Autowired
    private IQuestionContentRepository iQuestionContentRepository;

    @Override
    public Page<QuestionContent> findAll(Pageable pageable) {
        for (QuestionContent questionContents : iQuestionContentRepository.findAll(pageable)){
            if (questionContents.getAnswer() == null){
                questionContents.setAnswer("Chưa phản hồi");
            }
        }
        return iQuestionContentRepository.findAll(pageable);
    }

    @Override
    public void save(QuestionContent questionContent) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        System.out.println(formatter.format(date));
        questionContent.setDateCreate(formatter.format(date));
        iQuestionContentRepository.save(questionContent);
    }

    @Override
    public QuestionContent findById(int id) {
        return iQuestionContentRepository.findById(id);
    }

    @Override
    public void update(QuestionContent questionContent) {
        iQuestionContentRepository.save(questionContent);
    }

    @Override
    public void remove(Integer id) {
        iQuestionContentRepository.deleteById(id);
    }

    @Override
    public Page<QuestionContent> searchByTitle(String name, int questionTypeSearch, Pageable pageable) {
        return iQuestionContentRepository.searchByTitle("%"+name+"%",questionTypeSearch,pageable);
    }
}
