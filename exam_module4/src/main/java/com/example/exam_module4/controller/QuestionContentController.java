package com.example.exam_module4.controller;

import com.example.exam_module4.model.QuestionContent;
import com.example.exam_module4.model.QuestionType;
import com.example.exam_module4.service.IQuestionContentService;
import com.example.exam_module4.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class QuestionContentController {

    @Autowired
    private IQuestionContentService iQuestionContentService;

    @Autowired
    private IQuestionTypeService iQuestionTypeService;

    @GetMapping(value = "")
    public String showIndex(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("date_create").ascending();
        Page<QuestionContent> questionContentList = iQuestionContentService.findAll(PageRequest.of(page, 100, sort));
        List<QuestionType> questionTypeList = iQuestionTypeService.findAll();
        model.addAttribute("questionContentList",questionContentList);
        model.addAttribute("questionTypeList",questionTypeList);
        return "index";
    }



}
